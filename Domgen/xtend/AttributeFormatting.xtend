import GenovaBase

class AttributeFormatting extends GenovaBase{ 
	XClazz clazz
	override call(){
	 	// ----------------------------------------------------
	 	// Copyright (c) 2005-11 Esito AS. All rights reserved.
	 	// Version: 9.0.7-SNAPSHOT. September 23, 2011.
	 	// ----------------------------------------------------
	 	'''
	 	/** Maps attribute name to attribute info. */
	 	'''
	 	if(_DEFINED(clazz.SuperClassName)){
	 		'''
	 		  @SuppressWarnings("all")
	 		'''
	 	}
	 	'''
	 	protected static final Map<String, AttributeInfo> ATTRIBUTE_INFO =
	 	'''
	 	indent(8)
	 	'''
	 	new HashMap<String, AttributeInfo>();
	 	'''
	 	indent(8)
	 	'''
	 	
	 	/* Initialize the attribute map. */
	 	static { 
	 	'''
	 	indent(4)
	 	for(attribute:clazz.iterateAttribute){
	 		include("AttributeFormattingRecursive.ptm")
	 		if(attribute.IsPrimaryKey.toBool){
	 			attribute.KeyFound = "True"
	 		}
	 		//IsPrimaryKey
	 	}
	 	//Attribute
	 	for(group:clazz.iterateGroup){
	 		if(group.IsPrimaryKey.toBool){
	 			for(member:group.iterateMember){
	 				if(member.MemberType != "Attribute"){
	 					include("AttributeFormattingRecursive.ptm")
	 				}
	 			}
	 			// Member
	 		}
	 	}
	 	// Group
	 	indent(4)
	 	'''
	 	}
	 	
	 	/**
	 	'''
	 	indent(1)
	 	'''
	 	 * Get the attribute info for the specified attribute.
	 	 * @param attributeName the name of the attribute.
	 	 * @return the attribute's {@link no.genova.domain.AttributeInfo AttributeInfo}.
	 	'''
	 	indent(1)
	 	'''
	 	*/
	 	public static AttributeInfo getAttributeInfo(String attributeName) {
	 	'''
	 	indent(4)
	 	'''
	 	    return ATTRIBUTE_INFO.get(attributeName);
	 	'''
	 	indent(4)
	 	'''
	 	}
	 	'''
	 	'''«context.toString»'''
	 }
}