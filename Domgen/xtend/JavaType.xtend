import GenovaBase

class JavaType extends GenovaBase{ 
	XDomain domain
	override call(){
	 	// ----------------------------------------------------
	 	// Copyright (c) 2005-11 Esito AS. All rights reserved.
	 	// Version: 9.0.7-SNAPSHOT. September 23, 2011.
	 	// ----------------------------------------------------
	 	if(isContext("MacroDef")){
	 		typedef("javaType",[c|{'''«if (domain.ModelType == "timestamp") "Date" else if (domain.ModelType == "Vartext" || domain.ModelType == "Text") "String" else domain.ModelType»'''
	 		}])
	 	}else {
	 		domain.javaType = if (domain.ModelType == "timestamp") "Date" else if (domain.ModelType == "Vartext" || domain.ModelType == "Text") "String" else domain.ModelType
	 	}
	 	'''«context.toString»'''
	 }
}