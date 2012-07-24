import GenovaBase

class PrimaryKeyRecursive extends GenovaBase{ 
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
	 		if(group.ModelTypeIsJavaPrimitive.toBool){
	 			'''
	 			    ret.put("
	 			«macro("InheritAttrNameFirstLower")»
	 			", new 
	 			«typed("ModelType")»
	 			(get
	 			«macro("InheritAttrName")»
	 			()));
	 			'''
	 		}else {
	 			'''
	 			    ret.put("
	 			«macro("InheritAttrNameFirstLower")»
	 			", get
	 			«macro("InheritAttrName")»
	 			());
	 			'''
	 		}
	 	}else {
	 		for(member:group.iterateMember){
	 			include("PrimaryKeyRecursive.ptm")
	 		}
	 		// Member
	 	}
	 	'''«context.toString»'''
	 }
}