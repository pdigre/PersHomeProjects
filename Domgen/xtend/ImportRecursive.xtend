import GenovaBase

class ImportRecursive extends GenovaBase{ 
	XGroup group
	override call(){ 
	 	// ----------------------------------------------------
	 	// Copyright (c) 2005-11 Esito AS. All rights reserved.
	 	// Version: 9.0.7-SNAPSHOT. September 23, 2011.
	 	// ----------------------------------------------------
	 	for(member:group.iterateMember){
	 		if(member.MemberType == "Attribute"){
	 			include("ImportSingle.ptm")
	 		}else {
	 			//!MemberType=="Attribute"
	 			include("ImportRecursive.ptm")
	 		}
	 		//MemberType=="Attribute"
	 	}
	 	//Member
	 	'''«context.toString»'''
	 }
}