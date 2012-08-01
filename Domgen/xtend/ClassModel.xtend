import GenovaBase

class ClassModel extends GenovaBase{ 
	XObject object
	override call(){
	 	// ----------------------------------------------------
	 	// Copyright (c) 2005-11 Esito AS. All rights reserved.
	 	// Version: 9.0.7-SNAPSHOT. September 23, 2011.
	 	// ----------------------------------------------------
	 	// ---------------------------------------------------------------------------------------------------
	 	// This template set generates java classes for a target domain model
	 	// OPTIONAL TEMPLATE PARAMETERS
	 	// JavaDirecotory: The directory (below "Target directory") for generated code 
	 	// TransientClass: If set, the super class for transient classes
	 	// PersistentClass: Set to override default no.genova.domain.PersistentClass
	 	// PersistentSerializable: Set to true if persistent classes should implement Serializable
	 	// CommentFile: Set a filename to include as a comment file.
	 	// GenerateSingleClass: Set to true if no XxxDefault class should be generated
	 	// GenerateJavaStyleEnums: If true, enumerations will be proper java 1.5 enums, rather than subclasses of GenovaEnumerator
	 	// GenerateIsAsBooleanPrefix: Set to true to use "is" as accessor prefix for booleans (default is "get")
	 	// GenerateAttributeInfo: Set to true to generate model info (display rule, justification etc) for attributes
	 	// TopParent#GeneratePublicSetGet: Set to true to always generate public getters and setters for attributes
	 	// GenerateClassNameString: Set to true to generate final string NAME
	 	// GenerateAttributeNameString: Set to true to generate final string ATTR_SOMEATTR
	 	// GenerateGetStaticClassNameMethod: Set to true to generate static methods that returns class name, getStaticName/getDomainName
	 	// SerialVersionUID: Set to a numeric to generate UID for classes
	 	// ---------------------------------------------------------------------------------------------------
	 	typedef("boolean",[c|{'''Boolean
	 	'''
	 	}])
	 	typedef("char",[c|{'''Character
	 	'''
	 	}])
	 	typedef("byte",[c|{'''Byte
	 	'''
	 	}])
	 	typedef("short",[c|{'''Short
	 	'''
	 	}])
	 	typedef("int",[c|{'''Integer
	 	'''
	 	}])
	 	typedef("long",[c|{'''Long
	 	'''
	 	}])
	 	typedef("float",[c|{'''Float
	 	'''
	 	}])
	 	typedef("double",[c|{'''Double
	 	'''
	 	}])
	 	// Substitutes with correct visibility
	 	typedef("Visibility",[c|{if(object.Visibility != "Package"){
	 		'''«_LOWER(object.Visibility)»'''
	 	}
	 	}])
	 	typedef("UpperMemberRole",[c|{'''«_FIRST_UPPER(object.MemberRoleName)»'''
	 	}])
	 	typedef("UpperOwnerRole",[c|{'''«_FIRST_UPPER(object.OwnerRoleName)»'''
	 	}])
	 	typedef("InheritAttr",[c|{'''«_FIRST_UPPER(object.StartRoleNamePath) + _FIRST_UPPER(_NOSEP_CAMEL(object.RestRoleNamePath))»'''
	 	}])
	 	typedef("InheritAttrName",[c|{'''«_FIRST_UPPER(object.StartRoleNamePath) + _FIRST_UPPER(_NOSEP_CAMEL(object.RestRoleNamePath)) + _FIRST_UPPER(object.Name)»'''
	 	}])
	 	typedef("InheritAttrNameFirstLower",[c|{'''«_NOSEP_CAMEL(if (_DEFINED(object.StartRoleNamePath)) object.StartRoleNamePath + "/" else "" + if (_DEFINED(object.RestRoleNamePath)) object.RestRoleNamePath + "/" else "" + object.Name)»'''
	 	}])
	 	typedef("JavaDocDesc",[c|{'''«_JAVADOC(object.Description)»'''
	 	}])
	 	include("JavaUtility.ptm")
	 	setContext("MacroDef")
	 	include("JavaType.ptm")
	 	endContext
	 	// Path for a class relative to target directory
	 	typedef("DomainDirectory",[c|{'''«topparent.JavaDirectory»'''
	 	str("BSLASH_TO_SLASH")
	 	if(_DEFINED(object.PackageName)){
	 		'''«object.PackageName»'''
	 	}
	 	strEnd
	 	}])
	 	for(clazz:object.iterateClass){
	 		include("Class.ptm")
	 	}
	 	//Class
	 	for(interfaze:object.iterateInterface){
	 		include("Interface.ptm")
	 	}
	 	//Interface
	 	for(enumerator:object.iterateEnumerator){
	 		include("Enumerator.ptm")
	 	}
	 	//Enumerator
	 	'''«context.toString»'''
	 }
}