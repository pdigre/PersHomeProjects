import GenovaBase

class StringRepRecursive extends GenovaBase{ 
	XGroup group
	override call(){
	 	// ----------------------------------------------------
	 	// Copyright (c) 2005-11 Esito AS. All rights reserved.
	 	// Version: 9.0.7-SNAPSHOT. September 23, 2011.
	 	// ----------------------------------------------------
	 	if(group.NodeType == "Attribute" || group.MemberType == "Attribute"){
	 		if(group.StartRoleNamePath != "" && !(clazz.IsPersistent.toBool)){
	 			'''
	 			    /* The following line may cause an IllegalStateException */
	 			'''
	 		}
	 		'''
	 		  sb.append(" 
	 		«macro("InheritAttrNameFirstLower")»
	 		=").append(get
	 		«macro("InheritAttrName")»
	 		());
	 		'''
	 	}else {
	 		for(member:group.iterateMember){
	 			include("StringRepRecursive.ptm")
	 		}
	 		//Member
	 	}
	 	'''«context.toString»'''
	 }
}