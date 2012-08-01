import GenovaBase

class HashCode extends GenovaBase{ 
	XClazz clazz
	override call(){
	 	// ----------------------------------------------------
	 	// Copyright (c) 2005-11 Esito AS. All rights reserved.
	 	// Version: 9.0.7-SNAPSHOT. September 23, 2011.
	 	// ----------------------------------------------------
	 	if(_DEFINED(clazz.Methods,"hashCode","")){
	 		warning("Skipping generation of hashCode for " + clazz.Name + ": A method with that name is already defined")
	 	}else {
	 		// Generate method hashCode(...)
	 		clazz.Methods,"hashCode","" = "True"
	 		'''
	 		  /**
	 		'''
	 		indent(1)
	 		'''
	 		   * Returns a hash code for this instance.
	 		   *
	 		   * @return Hash code
	 		   */
	 		'''
	 		indent(1)
	 		'''
	 		  @Override
	 		  public int hashCode() {
	 		'''
	 		indent(4)
	 		'''
	 		    int i;
	 		    int result = 17;
	 		'''
	 		clazz.KeyFound = "False"
	 		for(attribute:clazz.iterateAttribute){
	 			if(attribute.IsDefaultDomainKey.toBool){
	 				include("HashCodeRecursive.ptm")
	 				parent.KeyFound = "True"
	 				breakLoop
	 			}
	 			// IsDefaultDomainKey
	 		}
	 		// Attribute
	 		if(!(_DEFINED(clazz.KeyFound))){
	 			for(group:clazz.iterateGroup){
	 				if(group.IsDefaultDomainKey.toBool){
	 					for(member:group.iterateMember){
	 						include("HashCodeRecursive.ptm")
	 					}
	 					//Member
	 					parent.KeyFound = "True"
	 					breakLoop
	 				}
	 			}
	 			// Group
	 		}
	 		// !#KeyFound
	 		if(!(_DEFINED(clazz.KeyFound))){
	 			for(attribute:clazz.iterateAttribute){
	 				if(attribute.IsPrimaryKey.toBool){
	 					include("HashCodeRecursive.ptm")
	 					parent.KeyFound = "True"
	 					breakLoop
	 				}
	 				// IsPrimaryKey
	 			}
	 			// Attribute
	 		}
	 		// !#KeyFound
	 		if(!(_DEFINED(clazz.KeyFound))){
	 			for(group:clazz.iterateGroup){
	 				if(group.IsPrimaryKey.toBool){
	 					for(member:group.iterateMember){
	 						include("HashCodeRecursive.ptm")
	 					}
	 					//Member
	 					breakLoop
	 				}
	 			}
	 			// Group
	 		}
	 		// !#KeyFound
	 		'''
	 		    return result;
	 		'''
	 		indent(4)
	 		'''
	 		  }
	 		'''
	 	}
	 	// check for / generate hashCode
	 	'''«context.toString»'''
	 }
}