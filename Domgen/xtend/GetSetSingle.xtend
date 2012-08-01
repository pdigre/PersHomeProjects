import GenovaBase

class GetSetSingle extends GenovaBase{ 
	XDomain domain
	override call(){
	 	// ----------------------------------------------------
	 	// Copyright (c) 2005-11 Esito AS. All rights reserved.
	 	// Version: 9.0.7-SNAPSHOT. September 23, 2011.
	 	// ----------------------------------------------------
	 	// This template will generate one getter and one setter.
	 	// Parameters:
	 	// #pName Name of the field
	 	// #pType Type of the field
	 	// #pTypeStripGen Type of the parameter stripped of generics tag. Used only to keep track of generated methods
	 	// #pVisibility Visibility for the field, ending space included
	 	// Some locally used variables...
	 	domain.tmpGetName = if (domain.pType == "boolean" && _DEFINED(domain.GenerateIsAsBooleanPrefix)) "is" else "get" + _FIRST_UPPER(domain.pName)
	 	domain.tmpSetName = "set" + _FIRST_UPPER(domain.pName)
	 	if(_DEFINED(clazz.Methods,domain.tmpGetName,"")){
	 		warning("Skipping generation of " + domain.tmpGetName + "(): Already generated.")
	 	}else {
	 		// Generate getter...
	 		if(_DEFINED(clazz.MethodVisibility,domain.tmpGetName,"")){
	 			if(clazz.MethodVisibility,domain.tmpGetName,"" == "Package"){
	 				domain.tmpVisibility = ""
	 			}else {
	 				domain.tmpVisibility = _LOWER(clazz.MethodVisibility,domain.tmpGetName,"") + " "
	 			}
	 		}else {
	 			if(_DEFINED(topparent.GeneratePublicSetGet)){
	 				domain.tmpVisibility = "public "
	 			}else {
	 				domain.tmpVisibility = domain.pVisibility
	 			}
	 		}
	 		clazz.Methods,domain.tmpGetName,"" = "True"
	 		if(!(_DEFINED(topparent.GenerateSingleClass)) && domain.tmpVisibility == "private "){
	 			warning("Skipping generation of " + domain.tmpGetName + "(): Method is private.")
	 		}else {
	 			'''
	 			    /**
	 			'''
	 			indent(1)
	 			'''
	 			      * Access method for 
	 			«domain.pName».
	 			      *
	 			'''
	 			if(domain.pType == "boolean"){
	 				'''
	 				        * @return true if and only if 
	 				«domain.pName» is currently true
	 				'''
	 			}else {
	 				'''
	 				        * @return the current value of 
	 				«domain.pName»'''
	 			}
	 			'''
	 			      */
	 			'''
	 			indent(1)
	 			'''«domain.tmpVisibility»«domain.pType»«domain.tmpGetName»() {
	 			'''
	 			indent(4)
	 			if(_DEFINED(domain.pSkipGenerateSetter) && domain.pTypeStripGen == "Set"){
	 				'''
	 				      if(
	 				«domain.pName» == null) {
	 				'''
	 				indent(4)
	 				'''«domain.pName» = new Hash
	 				«domain.pType»();
	 				'''
	 				indent(4)
	 				'''
	 				      }	
	 				'''
	 			}
	 			'''
	 			      return 
	 			«domain.pName»;
	 			'''
	 			indent(4)
	 			'''
	 			    }
	 			
	 			'''
	 		}
	 	}
	 	if(_DEFINED(clazz.Methods,domain.tmpSetName,domain.pTypeStripGen)){
	 		warning("Skipping generation of " + domain.tmpSetName + "(" + domain.pTypeStripGen + "): Already generated.")
	 	}else {
	 		// Generate setter...
	 		if(_DEFINED(clazz.MethodVisibility,domain.tmpSetName,domain.pType)){
	 			if(clazz.MethodVisibility,domain.tmpSetName,domain.pType == "Package"){
	 				domain.tmpVisibility = ""
	 			}else {
	 				domain.tmpVisibility = _LOWER(clazz.MethodVisibility,domain.tmpSetName,domain.pType) + " "
	 			}
	 		}else {
	 			if(_DEFINED(topparent.GeneratePublicSetGet)){
	 				domain.tmpVisibility = "public "
	 			}else {
	 				domain.tmpVisibility = domain.pVisibility
	 			}
	 		}
	 		clazz.Methods,domain.tmpSetName,domain.pTypeStripGen = "True"
	 		if(!(_DEFINED(topparent.GenerateSingleClass)) && domain.tmpVisibility == "private "){
	 			warning("Skipping generation of " + domain.tmpSetName + "(" + domain.pType + "): Method is private.")
	 		}else if(_DEFINED(domain.pSkipGenerateSetter)){
	 		}
	 		else {
	 			'''
	 			    /**
	 			'''
	 			indent(1)
	 			'''
	 			      * Access method for 
	 			«domain.pName».
	 			      *
	 			      * @param a
	 			«_FIRST_UPPER(domain.pName)» the new value for 
	 			«domain.pName»
	 			      */
	 			'''
	 			indent(1)
	 			'''«domain.tmpVisibility»void 
	 			«domain.tmpSetName»(final 
	 			«domain.pType» a
	 			«_FIRST_UPPER(domain.pName)») {
	 			'''
	 			indent(4)
	 			'''«domain.pName» = a
	 			«_FIRST_UPPER(domain.pName)»;
	 			'''
	 			indent(4)
	 			'''
	 			    }
	 			
	 			'''
	 		}
	 	}
	 	'''«context.toString»'''
	 }
}