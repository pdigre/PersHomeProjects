import GenovaBase

class HashCodeRecursive extends GenovaBase{ 
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
	 		if(group.MappedModelType == "boolean"){
	 			'''
	 			    i = (get
	 			«macro("InheritAttrName")»
	 			() ? 0:1);
	 			'''
	 		}else if(group.MappedModelType == "int" || group.MappedModelType == "short" || group.MappedModelType == "byte" || group.MappedModelType == "char"){
	 			'''
	 			    i = get
	 			«macro("InheritAttrName")»
	 			();
	 			'''
	 		}
	 		else if(group.MappedModelType == "long"){
	 			'''
	 			    i = (int)(get
	 			«macro("InheritAttrName")»
	 			() ^ (get
	 			«macro("InheritAttrName")»
	 			()>>>32));
	 			'''
	 		}
	 		else if(group.MappedModelType == "float"){
	 			'''
	 			    i = Float.floatToIntBits(get
	 			«macro("InheritAttrName")»
	 			());
	 			'''
	 		}
	 		else if(group.MappedModelType == "double"){
	 			'''
	 			    i = (int) (Double.doubleToLongBits(get
	 			«macro("InheritAttrName")»
	 			()) ^ (Double.doubleToLongBits(get
	 			«macro("InheritAttrName")»
	 			())>>>32));
	 			'''
	 		}
	 		else {
	 			// We have an object reference...
	 			'''
	 			    if (get
	 			«macro("InheritAttrName")»
	 			() == null) {
	 			'''
	 			indent(4)
	 			'''
	 			        i = 0;
	 			'''
	 			indent(4)
	 			'''
	 			    } else {
	 			'''
	 			indent(4)
	 			'''
	 			        i = get
	 			«macro("InheritAttrName")»
	 			().hashCode();
	 			'''
	 			indent(4)
	 			'''
	 			    }
	 			'''
	 		}
	 		'''
	 		  result = 37*result + i;
	 		'''
	 	}else {
	 		// NodeType is "Group"
	 		for(member:group.iterateMember){
	 			include("HashCodeRecursive.ptm")
	 		}
	 		// Member
	 	}
	 	'''«context.toString»'''
	 }
}