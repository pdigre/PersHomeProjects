import GenovaBase

class SubClass extends GenovaBase{ 
	XInterfaze interfaze
	override call(){
	 	// ----------------------------------------------------
	 	// Copyright (c) 2005-11 Esito AS. All rights reserved.
	 	// Version: 9.0.7-SNAPSHOT. September 23, 2011.
	 	// ----------------------------------------------------
	 	setContext("Subclass")
	 	newfile(macro("DomainDirectory") + "/" + interfaze.Name + ".java")
	 	if(_DEFINED(interfaze.CommentFile)){
	 		include(interfaze.CommentFile)
	 	}else {
	 		'''
	 		  // 
	 		«interfaze.GeneratedWith»'''
	 	}
	 	'''
	 	
	 	package 
	 	«_SLASH_TO_DOT(_LOWER(interfaze.PackageName))»;
	 	'''
	 	for(method:interfaze.iterateMethod){
	 		include("ImportSingle.ptm")
	 		for(parameter:method.iterateParameter){
	 			include("ImportSingle.ptm")
	 		}
	 		// Parameter
	 	}
	 	// Method
	 	'''
	 	
	 	/**
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
	 	'''«macro("Visibility")»
	 	«if (interfaze.Abstract.toBool) "abstract " else ""»class 
	 	«interfaze.Name» extends 
	 	«interfaze.Name»Default {
	 	'''
	 	indent(4)
	 	if(_DEFINED(interfaze.SerialVersionUID)){
	 		'''
	 		  /** Serial Version UID. */
	 		  private static final long serialVersionUID = 
	 		«interfaze.SerialVersionUID»;
	 		
	 		'''
	 	}
	 	'''
	 	
	 	  /** Default constructor. */
	 	'''
	 	interfaze.tmpVisibility = "public "
	 	if(_DEFINED(clazz.MethodVisibility,interfaze.Name,"")){
	 		interfaze.tmpVisibility = if (clazz.MethodVisibility,interfaze.Name,"" == "Package") "" else _LOWER(clazz.MethodVisibility,interfaze.Name,"") + " "
	 	}
	 	'''«interfaze.tmpVisibility»«interfaze.Name»() {
	 	'''
	 	indent(4)
	 	'''
	 	    super();
	 	'''
	 	indent(4)
	 	'''
	 	  }
	 	'''
	 	clazz.Methods,interfaze.Name,"*constructor*" = "True"
	 	for(method:interfaze.iterateMethod){
	 		// This iteration will take care of constructors
	 		if(clazz.Name == method.Name){
	 			include("Method.ptm")
	 		}
	 	}
	 	for(method:interfaze.iterateMethod){
	 		// This iteration will take care of non-constructor methods
	 		if(clazz.Name != method.Name && !(!(clazz.Abstract.toBool) && method.Abstract.toBool)){
	 			include("Method.ptm")
	 		}
	 	}
	 	indent(4)
	 	'''
	 	}
	 	'''
	 	endfile
	 	endContext
	 	'''«context.toString»'''
	 }
}