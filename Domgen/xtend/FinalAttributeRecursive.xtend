import GenovaBase

class FinalAttributeRecursive extends GenovaBase{ 
	XGroup group
	override call(){
	 	// ----------------------------------------------------
	 	// Copyright (c) 2005-11 Esito AS. All rights reserved.
	 	// Version: 9.0.7-SNAPSHOT. September 23, 2011.
	 	// ----------------------------------------------------
	 	for(member:group.iterateMember){
	 		if(member.MemberType != "Attribute"){
	 			include("FinalAttributeRecursive.ptm")
	 		}else {
	 			'''
	 			    /** Attribute name */
	 			'''
	 			line
	 			if(member.Visibility == "Public"){
	 				'''
	 				        public 
	 				'''
	 			}else if(member.Visibility == "Private" || member.Visibility == "Protected" || !(_DEFINED(topparent.GenerateSingleClass))){
	 				'''
	 				        protected 
	 				'''
	 			}
	 			else if(!(_DEFINED(topparent.GenerateSingleClass))){
	 				'''
	 				        protected 
	 				'''
	 			}
	 			'''
	 			      static final String ATTR_
	 			'''
	 			str("UPPER")
	 			'''«macro("InheritAttrName")»
	 			'''
	 			strEnd
	 			''' = "
	 			«macro("InheritAttrNameFirstLower")»
	 			";
	 			'''
	 			endline
	 		}
	 	}
	 	// Member
	 	'''«context.toString»'''
	 }
}