import GenovaBase

class Method extends GenovaBase{ 
	XMethod method
	override call(){
	 	// ----------------------------------------------------
	 	// Copyright (c) 2005-11 Esito AS. All rights reserved.
	 	// Version: 9.0.7-SNAPSHOT. September 23, 2011.
	 	// ----------------------------------------------------
	 	// Note about abstract methods and abstract classes:
	 	// Code will be generated according to this table:
	 	//   Case    | Single class    | Default class   | Sub class
	 	//   --------|-----------------|-----------------|-----------------
	 	//   aC aM   | Declared        | Declared        | Skipped
	 	//   aC cM   | Dummy with TODO | Declared        | Dummy with TODO
	 	//   cC aM   | Warning         | Warning         | Warning
	 	//   cC cM   | Dummy with TODO | Declared        | Dummy with TODO
	 	// a = abstract, c = concrete, C = class, M = Method
	 	// thus, cC aM means abstract method in a concrete class
	 	// This behaviour is controleld in Class.ptm
	 	include("JavaType.ptm")
	 	method.returnType = if (method.ModelType == "") "void" else method.javaType
	 	method.parameterType = ""
	 	for(parameter:method.iterateParameter){
	 		include("JavaType.ptm")
	 		if(parameter.IsFirst.toBool){
	 			method.parameterType = parameter.javaType
	 		}else {
	 			method.parameterType = method.parameterType + "," + parameter.javaType
	 		}
	 	}
	 	// Parameter
	 	// Set #tmpIsAbstract if this is the superclass...
	 	if(isContext("Class")){
	 		if(!(_DEFINED(topparent.GenerateSingleClass))){
	 			method.tmpIsAbstract = "True"
	 		}
	 	}
	 	// Set tmpIsAbstract if method is abstract...
	 	if(method.Abstract.toBool){
	 		method.tmpIsAbstract = "True"
	 	}
	 	// Check if we want to generate for this method...
	 	if(_DEFINED(method.tmpIsAbstract) && method.Visibility == "Private"){
	 		// Abstract private... skip
	 		if(!(_DEFINED(clazz.Methods,method.Name,method.parameterType))){
	 			warning("Skipping generation of " + method.Name + ": Private and abstract.")
	 		}
	 		method.skip = "True"
	 	}
	 	if(_DEFINED(clazz.Methods,method.Name,method.parameterType)){
	 		debug("Skipping generation of " + method.Name + ": Method already exists.")
	 		method.skip = "True"
	 	}
	 	if(isContext("Subclass")){
	 		if(method.Abstract.toBool){
	 			// Already declared in default class. Skip...
	 			method.skip = "True"
	 		}
	 	}else {
	 		if(_DEFINED(method.tmpIsAbstract) && _DEFINED(clazz.Methods,method.Name,"*abstract*" + method.parameterType)){
	 			debug("Skipping generation of " + method.Name + ": Method already exists.")
	 			method.skip = "True"
	 		}
	 	}
	 	if(clazz.Name == method.Name && _DEFINED(clazz.Methods,method.Name,"*constructor*" + method.parameterType)){
	 		debug("Skipping generation of " + method.Name + ": Method already exists.")
	 		method.skip = "True"
	 	}
	 	if(isContext("Class")){
	 		if(clazz.Name == method.Name && !(_DEFINED(topparent.GenerateSingleClass))){
	 			debug("Skipping generation of " + method.Name + ": Constructor.")
	 			method.skip = "True"
	 		}
	 	}
	 	if(!(_DEFINED(method.skip))){
	 		if(clazz.Name == method.Name){
	 			clazz.Methods,method.Name,"*constructor*" + method.parameterType = "True"
	 		}else if(_DEFINED(method.tmpIsAbstract)){
	 			clazz.Methods,method.Name,"*abstract*" + method.parameterType = "True"
	 		}
	 		else {
	 			clazz.Methods,method.Name,method.parameterType = "True"
	 		}
	 		method.tmpAddJavaDoc = "True"
	 		if(isContext("Subclass")){
	 			if(method.Visibility != "Private" && clazz.Name != method.Name){
	 				method.tmpAddJavaDoc = "False"
	 			}
	 		}
	 		if(_DEFINED(method.tmpAddJavaDoc)){
	 			'''
	 			    /**
	 			'''
	 			// Note: Intended space at the end of next line (SUP-209 workaround)
	 			if(method.HasDescription.toBool){
	 				'''«macro("JavaDocDesc")»
	 				'''
	 			}
	 			indent(1)
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
	 		}else {
	 			'''
	 			    @Override
	 			'''
	 		}
	 		line
	 		'''«macro("Visibility")»
	 		'''
	 		if(_DEFINED(method.tmpIsAbstract)){
	 			'''abstract 
	 			'''
	 		}
	 		if(clazz.Name != method.Name){
	 			'''«method.returnType»'''
	 		}
	 		'''«method.Name»(
	 		'''
	 		for(parameter:method.iterateParameter){
	 			if(!(parameter.IsFirst.toBool)){
	 				''', 
	 				'''
	 			}
	 			'''«macro("javaType")»
	 			«parameter.Name»'''
	 		}
	 		'''
	 		    )
	 		'''
	 		if(_DEFINED(method.tmpIsAbstract)){
	 			''';
	 			'''
	 		}else {
	 			''' {
	 			'''
	 		}
	 		endline
	 		if(!(_DEFINED(method.tmpIsAbstract))){
	 			indent(4)
	 			'''
	 			      // TODO: Add implementation for this method
	 			'''
	 			if(method.returnType != "void"){
	 				if(method.ModelTypeIsJavaPrimitive.toBool){
	 					if(method.ModelType == "boolean"){
	 						'''
	 						            return false;
	 						'''
	 					}else if(method.ModelType == "char"){
	 						'''
	 						            return '\u0000';
	 						'''
	 					}
	 					else {
	 						'''
	 						            return 0;
	 						'''
	 					}
	 				}else {
	 					'''
	 					          return null;
	 					'''
	 				}
	 			}
	 			indent(4)
	 			'''
	 			    }
	 			'''
	 		}
	 	}
	 	// !DEFINED(#skip)
	 	'''«context.toString»'''
	 }
}