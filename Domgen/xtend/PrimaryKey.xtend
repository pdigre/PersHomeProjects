import GenovaBase

class PrimaryKey extends GenovaBase{ 
	XClazz clazz
	override call(){
	 	// ----------------------------------------------------
	 	// Copyright (c) 2005-11 Esito AS. All rights reserved.
	 	// Version: 9.0.7-SNAPSHOT. September 23, 2011.
	 	// ----------------------------------------------------
	 	if(_DEFINED(clazz.Methods,"getPrimaryKey","")){
	 		info("Skipping generation of getPrimaryKey() for " + clazz.Name + ": A method with that name is already defined")
	 	}else {
	 		// Generate method getPrimaryKey()
	 		clazz.Methods,"getPrimaryKey","" = "True"
	 		'''
	 		  /**
	 		'''
	 		indent(1)
	 		'''
	 		   * Return all elements of the primary key.
	 		   *
	 		   * @return Map of key names to values
	 		   */
	 		'''
	 		indent(1)
	 		'''
	 		  public Map<String, Object> getPrimaryKey() {
	 		'''
	 		indent(4)
	 		'''
	 		    Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
	 		'''
	 		clazz.KeyFound = "False"
	 		for(attribute:clazz.iterateAttribute){
	 			if(attribute.IsPrimaryKey.toBool){
	 				include("PrimaryKeyRecursive.ptm")
	 				parent.KeyFound = "True"
	 				breakLoop
	 			}
	 			// PrimaryKey
	 		}
	 		// Attribute
	 		if(!(clazz.KeyFound)){
	 			for(group:clazz.iterateGroup){
	 				if(group.IsPrimaryKey.toBool){
	 					for(member:group.iterateMember){
	 						include("PrimaryKeyRecursive.ptm")
	 					}
	 					// Member
	 					breakLoop
	 				}
	 				// PrimaryKey
	 			}
	 			// Group
	 		}
	 		// !#KeyFound
	 		'''
	 		    return ret;
	 		'''
	 		indent(4)
	 		'''
	 		  }
	 		'''
	 	}
	 	'''«context.toString»'''
	 }
}