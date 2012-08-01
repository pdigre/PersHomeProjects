import GenovaBase

class ImportSingle extends GenovaBase{ 
	XDomain domain
	override call(){
	 	// ----------------------------------------------------
	 	// Copyright (c) 2005-11 Esito AS. All rights reserved.
	 	// Version: 9.0.7-SNAPSHOT. September 23, 2011.
	 	// ----------------------------------------------------
	 	// ---------------------------------------------------------------------------
	 	// First determine what we want to import...
	 	// ---------------------------------------------------------------------------
	 	if(domain.NodeType == "Attribute" || domain.NodeType == "Member" || domain.NodeType == "Parameter" || domain.NodeType == "Method"){
	 		include("JavaType.ptm")
	 		domain.impSinType = if (_DEFINED(domain.impSinTypeOverridden)) domain.impSinTypeOverridden else if (_DEFINED(domain.appendTransportSuffix)) domain.javaType + classmodel.Suffix else domain.javaType
	 		domain.impSinPack = if (_DEFINED(domain.impSinPackOverridden)) domain.impSinPackOverridden else if (_DEFINED(domain.typePackageName)) domain.typePackageName else domain.TypePackageName
	 		if(!(_DEFINED(domain.impSinTypeOverridden)) && domain.NodeType == "Parameter" || domain.NodeType == "Method"){
	 			if(_DEFINED(domain.IsJavaContainer)){
	 				domain.impSinPackOverridden = if (_DEFINED(domain.TypePackageName)) domain.TypePackageName else "java.lang"
	 				domain.impSinTypeOverridden = domain.MappedJavaContainerType
	 				include("ImportSingle.ptm")
	 				domain.impSinType = _FIRST_UPPER(domain.JavaContainer)
	 				domain.impSinPack = "java.util"
	 			}
	 		}
	 	}else if(domain.NodeType == "Association"){
	 		// impSinType and impSinPack is set by caller...
	 	}
	 	else if(domain.NodeType == "Generalization"){
	 		domain.impSinType = if (_DEFINED(domain.appendTransportSuffix)) superclass.Name + classmodel.Suffix else superclass.Name
	 		domain.impSinPack = superclass.PackageName
	 	}
	 	else if(domain.NodeType == "Class"){
	 		// impSinType and impSinPack is set by caller...
	 	}
	 	else {
	 		error("NodeType " + domain.NodeType + " not handled by ImportSingle.ptm")
	 	}
	 	// NodeType
	 	// ---------------------------------------------------------------------------
	 	// Now see if we really want to import it...
	 	// ---------------------------------------------------------------------------
	 	domain.tmpSkip = "False"
	 	// -----------------------------------
	 	// Check if it has been imported before...
	 	// -----------------------------------
	 	if(isContext("Class")){
	 		if(_DEFINED(clazz.Imports,domain.impSinType)){
	 			domain.tmpSkip = "True"
	 		}
	 	}
	 	if(isContext("Subclass")){
	 		if(_DEFINED(clazz.SubImports,domain.impSinType)){
	 			domain.tmpSkip = "True"
	 		}
	 	}
	 	if(isContext("Interface")){
	 		if(_DEFINED(interfaze.Imports,domain.impSinType)){
	 			domain.tmpSkip = "True"
	 		}
	 	}
	 	if(isContext("Attribute")){
	 		// Special case for custom Date classes; have to use fully qualified name for those classes. 
	 		if(domain.impSinType == "Date" && _DEFINED(domain.impSinPack) && domain.impSinPack != "java.util"){
	 			domain.tmpSkip = "True"
	 		}
	 	}
	 	if(_DEFINED(domain.impSinPack) && domain.impSinPack == "java.lang"){
	 		domain.tmpSkip = "True"
	 	}
	 	// -----------------------------------
	 	// Check if it is in the same package...
	 	// -----------------------------------
	 	if(isContext("Interface")){
	 		if(_DEFINED(domain.impSinPack) && domain.impSinPack == interfaze.PackageName){
	 			domain.tmpSkip = "True"
	 		}
	 	}else {
	 		if(_DEFINED(domain.impSinPack) && domain.impSinPack == clazz.PackageName){
	 			domain.tmpSkip = "True"
	 		}
	 	}
	 	// ---------------------------------------------------------------------------
	 	// Now add import clause if we figured out we want this import...
	 	// ---------------------------------------------------------------------------
	 	if(domain.tmpSkip == "False"){
	 		if(domain.impSinType == "Date" || domain.impSinType == "Set" || domain.impSinType == "HashSet" || domain.impSinType == "List" || domain.impSinType == "Collection" || domain.impSinType == "SortedSet"){
	 			domain.impSinPack = "java.util"
	 		}else if(domain.impSinType == "Numeric"){
	 			domain.impSinPack = "no.genova.support"
	 		}
	 		if(domain.impSinType == "boolean" || domain.impSinType == "char" || domain.impSinType == "byte" || domain.impSinType == "short" || domain.impSinType == "int"){
	 		}else if(domain.impSinType == "long" || domain.impSinType == "float" || domain.impSinType == "double" || domain.impSinType == "String" || domain.impSinType == "void"){
	 		}
	 		else if(domain.impSinPack != ""){
	 			'''
	 			  	import 
	 			«_SLASH_TO_DOT(domain.impSinPack)».
	 			«domain.impSinType»;
	 			'''
	 		}
	 		if(isContext("Class")){
	 			clazz.Imports,domain.impSinType = "True"
	 		}
	 		if(isContext("Subclass")){
	 			clazz.SubImports,domain.impSinType = "True"
	 		}
	 		if(isContext("Interface")){
	 			interfaze.Imports,domain.impSinType = "True"
	 		}
	 	}
	 	'''«context.toString»'''
	 }
}