import GenovaBase

class Interface extends GenovaBase{ 
	XInterfaze interfaze
	override call(){
	 	// ----------------------------------------------------
	 	// Copyright (c) 2005-11 Esito AS. All rights reserved.
	 	// Version: 9.0.7-SNAPSHOT. September 23, 2011.
	 	// ----------------------------------------------------
	 	setContext("Interface")
	 	file(macro("DomainDirectory") + "/" + interfaze.Name + ".java")
	 	if(_DEFINED(interfaze.CommentFile)){
	 		include(interfaze.CommentFile)
	 	}else {
	 		'''
	 		  // 
	 		«interfaze.GeneratedWith»'''
	 	}
	 	'''
	 	
	 	package 
	 	'''
	 	str("SLASH_TO_DOT")
	 	str("LOWER")
	 	'''«interfaze.PackageName»'''
	 	strEnd
	 	strEnd
	 	''';
	 	'''
	 	// Imports...
	 	for(attribute:interfaze.iterateAttribute){
	 		include("ImportSingle.ptm")
	 	}
	 	for(method:interfaze.iterateMethod){
	 		include("ImportSingle.ptm")
	 		for(parameter:method.iterateParameter){
	 			include("ImportSingle.ptm")
	 		}
	 		// Parameter
	 	}
	 	for(generalization:interfaze.iterateGeneralization){
	 		if(interfaze.Name == generalization.subClass.Name){
	 			interfaze.Generalization = generalization.superClass.Name
	 			include("ImportSingle.ptm")
	 			breakLoop
	 		}
	 	}
	 	// Interface declaration...
	 	'''/**
	 	'''
	 	// Note: Intended space at the end of next line (SUP-209 workaround)
	 	if(interfaze.HasDescription.toBool){
	 		'''«macro("JavaDocDesc")»
	 		'''
	 	}
	 	indent(1)
	 	'''
	 	*/
	 	'''
	 	indent(1)
	 	'''«macro("suppressAllWarnings")»
	 	«macro("Visibility")»
	 	interface 
	 	«interfaze.Name»«if (_DEFINED(interfaze.Generalization)) " extends " + interfaze.Generalization else ""» {
	 	'''
	 	indent(4)
	 	for(attribute:interfaze.iterateAttribute){
	 		if(attribute.HasDescription.toBool){
	 			'''
	 			      /**
	 			'''
	 			// Note: Intended space at the end of next line (SUP-209 workaround)
	 			'''«macro("JavaDocDesc")»
	 			'''
	 			indent(1)
	 			'''
	 			       */
	 			'''
	 			indent(1)
	 		}
	 		'''«macro("Visibility")»
	 		final static 
	 		«macro("javaType")»
	 		«attribute.Name» = 
	 		«attribute.InitialValue»;
	 		
	 		'''
	 	}
	 	for(method:interfaze.iterateMethod){
	 		'''
	 		    /**
	 		'''
	 		// Note: Intended space at the end of next line (SUP-209 workaround)
	 		if(method.HasDescription.toBool){
	 			'''«macro("JavaDocDesc")»
	 			'''
	 		}
	 		indent(1)
	 		'''
	 		     *
	 		'''
	 		for(parameter:method.iterateParameter){
	 			'''
	 			     * @param 
	 			«parameter.Name»«parameter.Description»'''
	 		}
	 		// Parameter
	 		if(method.ModelType != "void" && method.ModelType != ""){
	 			'''
	 			     * @return 
	 			«macro("javaType")»
	 			'''
	 		}
	 		'''
	 		     */
	 		'''
	 		indent(1)
	 		line
	 		if(_DEFINED(method.ModelType)){
	 			'''«macro("javaType")»
	 			'''
	 		}else {
	 			'''
	 			      void 
	 			'''
	 		}
	 		'''«method.Name»(
	 		'''
	 		for(parameter:method.iterateParameter){
	 			if(parameter.IsLast.toBool){
	 				'''«macro("javaType")»
	 				«parameter.Name»'''
	 			}else {
	 				'''«macro("javaType")»
	 				«parameter.Name», 
	 				'''
	 			}
	 		}
	 		'''
	 		    );
	 		'''
	 		endline
	 	}
	 	// Method
	 	indent(4)
	 	'''
	 	}
	 	'''
	 	endfile
	 	endContext
	 	'''«context.toString»'''
	 }
}