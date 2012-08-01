import GenovaBase

class EqualsRecursive extends GenovaBase{ 
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
	 		// Handle float and double as special cases (to catch NaN and -0.0)
	 		if(group.ModelType == "float"){
	 			'''
	 			    if Float.floatToIntBits(this.get
	 			«macro("InheritAttrName")»
	 			()) != Float.floatToIntBits(that.get
	 			«macro("InheritAttrName")»
	 			()) {
	 			'''
	 			indent(4)
	 			'''
	 			        return false;
	 			'''
	 			indent(4)
	 			'''
	 			    }
	 			'''
	 		}else if(group.ModelType == "double"){
	 			'''
	 			    if Double.doubleToLongBits(this.get
	 			«macro("InheritAttrName")»
	 			()) != Double.doubleToLongBits(that.get
	 			«macro("InheritAttrName")»
	 			()) {
	 			'''
	 			indent(4)
	 			'''
	 			      return false;
	 			'''
	 			indent(4)
	 			'''
	 			    }
	 			'''
	 		}
	 		else if(group.ModelTypeIsJavaPrimitive.toBool){
	 			'''
	 			    if (this.get
	 			«macro("InheritAttrName")»
	 			() != that.get
	 			«macro("InheritAttrName")»
	 			()) {
	 			'''
	 			indent(4)
	 			'''
	 			      return false;
	 			'''
	 			indent(4)
	 			'''
	 			    }
	 			'''
	 		}
	 		else {
	 			'''
	 			    Object my
	 			«macro("InheritAttrName")»
	 			 = this.get
	 			«macro("InheritAttrName")»
	 			();
	 			    Object your
	 			«macro("InheritAttrName")»
	 			 = that.get
	 			«macro("InheritAttrName")»
	 			();
	 			    if (my
	 			«macro("InheritAttrName")»
	 			==null ? your
	 			«macro("InheritAttrName")»
	 			!=null : !my
	 			«macro("InheritAttrName")»
	 			.equals(your
	 			«macro("InheritAttrName")»
	 			)) {
	 			'''
	 			indent(4)
	 			'''
	 			      return false;
	 			'''
	 			indent(4)
	 			'''
	 			    }
	 			'''
	 		}
	 	}else {
	 		// Not an attribute... iterate members and recurse...
	 		for(member:group.iterateMember){
	 			include("EqualsRecursive.ptm")
	 		}
	 		// Member
	 	}
	 	'''«context.toString»'''
	 }
}