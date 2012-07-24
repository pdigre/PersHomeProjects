import GenovaBase

class Equals extends GenovaBase{ 
	XClazz clazz
	override call(){
	 	// ----------------------------------------------------
	 	// Copyright (c) 2005-11 Esito AS. All rights reserved.
	 	// Version: 9.0.7-SNAPSHOT. September 23, 2011.
	 	// ----------------------------------------------------
	 	clazz.instanceClass = clazz.Name + if (_DEFINED(topparent.GenerateSingleClass)) "" else "Default"
	 	if(_DEFINED(clazz.Methods,"equalKeys","Object")){
	 		warning("Skipping generation of equalKeys for " + clazz.Name + ": A method with that name is already defined")
	 	}else {
	 		// Generate method equalKeys(...)
	 		clazz.Methods,"equalKeys","Object" = "True"
	 		'''
	 		  /**
	 		'''
	 		indent(1)
	 		'''
	 		   * Compares the key for this instance with another 
	 		«clazz.Name».
	 		   *
	 		   * @param other The object to compare to
	 		   * @return True if other object is instance of class 
	 		«clazz.Name» and the key objects are equal.
	 		   */
	 		'''
	 		indent(1)
	 		'''
	 		  private boolean equalKeys(Object other) {
	 		'''
	 		indent(4)
	 		'''
	 		    if (this==other) {
	 		'''
	 		indent(4)
	 		'''
	 		      return true;
	 		'''
	 		indent(4)
	 		'''
	 		    }
	 		    if (!(other instanceof 
	 		«clazz.instanceClass»)) {
	 		'''
	 		indent(4)
	 		'''
	 		      return false;
	 		'''
	 		indent(4)
	 		'''
	 		    }
	 		«clazz.instanceClass» that = (
	 		«clazz.instanceClass») other;
	 		'''
	 		clazz.KeyFound = "False"
	 		for(attribute:clazz.iterateAttribute){
	 			if(attribute.IsDefaultDomainKey.toBool){
	 				include("EqualsRecursive.ptm")
	 				parent.KeyFound = "True"
	 				breakLoop
	 			}
	 		}
	 		// Attribute
	 		if(!(_DEFINED(clazz.KeyFound))){
	 			for(group:clazz.iterateGroup){
	 				if(group.IsDefaultDomainKey.toBool){
	 					for(member:group.iterateMember){
	 						include("EqualsRecursive.ptm")
	 					}
	 					// Member
	 					parent.KeyFound = "True"
	 					breakLoop
	 				}
	 			}
	 			// Group
	 		}
	 		if(!(_DEFINED(clazz.KeyFound))){
	 			for(attribute:clazz.iterateAttribute){
	 				if(attribute.IsPrimaryKey.toBool){
	 					include("EqualsRecursive.ptm")
	 					parent.KeyFound = "True"
	 					breakLoop
	 				}
	 			}
	 			// Attribute
	 		}
	 		if(!(_DEFINED(clazz.KeyFound))){
	 			for(group:clazz.iterateGroup){
	 				if(group.IsPrimaryKey.toBool){
	 					for(member:group.iterateMember){
	 						include("EqualsRecursive.ptm")
	 					}
	 					// Member
	 					breakLoop
	 				}
	 			}
	 			// Group
	 		}
	 		'''
	 		    return true;
	 		'''
	 		indent(4)
	 		'''
	 		  }
	 		'''
	 	}
	 	// Check for / generate equalKeys
	 	if(_DEFINED(clazz.Methods,"equals","Object")){
	 		warning("Skipping generation of equals for " + clazz.Name + ": A method with that name is already defined")
	 	}else {
	 		// Generate method equals(...)
	 		clazz.Methods,"equals","Object" = "True"
	 		'''
	 		  /**
	 		'''
	 		indent(1)
	 		'''
	 		   * Compares this instance with another 
	 		«clazz.Name».
	 		   *
	 		   * @param other The object to compare to
	 		   * @return True if the objects are the same
	 		   */
	 		'''
	 		indent(1)
	 		'''
	 		  @Override
	 		  public boolean equals(Object other) {
	 		'''
	 		indent(4)
	 		'''
	 		    return this.equalKeys(other) && ((
	 		«clazz.instanceClass»)other).equalKeys(this);
	 		'''
	 		indent(4)
	 		'''
	 		  }
	 		'''
	 	}
	 	// check for / generate equals
	 	'''«context.toString»'''
	 }
}