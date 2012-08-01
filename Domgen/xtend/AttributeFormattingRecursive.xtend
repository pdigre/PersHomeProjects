import GenovaBase

class AttributeFormattingRecursive extends GenovaBase{ 
	XGroup group
	override call(){
	 	// ----------------------------------------------------
	 	// Copyright (c) 2005-11 Esito AS. All rights reserved.
	 	// Version: 9.0.7-SNAPSHOT. September 23, 2011.
	 	// ----------------------------------------------------
	 	if(group.NodeType == "Attribute" || group.MemberType == "Attribute"){
	 		if(_DEFINED(group.GenerateAttributeNameString)){
	 			'''
	 			    ATTRIBUTE_INFO.put(ATTR_
	 			'''
	 			if(group.NodeType == "Attribute"){
	 				'''«_UPPER(_UNCAMELIZE(group.Name))»'''
	 			}else {
	 				str("UPPER")
	 				'''«macro("InheritAttrName")»
	 				'''
	 				strEnd
	 			}
	 			''',
	 			'''
	 		}else {
	 			'''
	 			    ATTRIBUTE_INFO.put("
	 			«group.Name»",
	 			'''
	 		}
	 		indent(4)
	 		'''
	 		        new AttributeInfo("
	 		«group.Displayrule»", 
	 		«if (group.IsBlankWhenZero.toBool) "true" else "false"»,
	 		'''
	 		indent(8)
	 		'''
	 		            AttributeInfo.JUSTIFICATION.
	 		«_UPPER(group.InputJustification)»,
	 		            AttributeInfo.JUSTIFICATION.
	 		«_UPPER(group.OutputJustification)»));
	 		'''
	 		indent(8)
	 		indent(4)
	 	}else {
	 		for(member:group.iterateMember){
	 			include("AttributeFormattingRecursive.ptm")
	 		}
	 	}
	 	'''«context.toString»'''
	 }
}