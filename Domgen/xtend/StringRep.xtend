import GenovaBase

class StringRep extends GenovaBase{ 
	XClazz clazz
	override call(){
	 	// ----------------------------------------------------
	 	// Copyright (c) 2005-11 Esito AS. All rights reserved.
	 	// Version: 9.0.7-SNAPSHOT. September 23, 2011.
	 	// ----------------------------------------------------
	 	if(_DEFINED(clazz.Methods,"toString","")){
	 		info("Skipping generation of toString() for " + clazz.Name + ": A method with that name is already defined")
	 	}else {
	 		// Generate method toString()
	 		clazz.Methods,"toString","" = "True"
	 		'''
	 		  /**
	 		'''
	 		indent(1)
	 		'''
	 		   * Returns a debug-friendly String representation of this instance
	 		   *
	 		   * @return String representation of this instance
	 		   */
	 		'''
	 		indent(1)
	 		'''
	 		  @Override
	 		  public String toString() {
	 		'''
	 		indent(4)
	 		'''
	 		    StringBuffer sb = new StringBuffer("[
	 		«clazz.Name» |");
	 		'''
	 		clazz.KeyFound = "False"
	 		for(attribute:clazz.iterateAttribute){
	 			if(attribute.IsDefaultDomainKey.toBool){
	 				include("StringRepRecursive.ptm")
	 				parent.KeyFound = "True"
	 				breakLoop
	 			}
	 		}
	 		if(!(clazz.KeyFound)){
	 			for(group:clazz.iterateGroup){
	 				if(group.IsDefaultDomainKey.toBool){
	 					for(member:group.iterateMember){
	 						include("StringRepRecursive.ptm")
	 					}
	 					parent.KeyFound = "True"
	 					breakLoop
	 				}
	 			}
	 		}
	 		if(!(clazz.KeyFound)){
	 			for(attribute:clazz.iterateAttribute){
	 				if(attribute.IsPrimaryKey.toBool){
	 					include("StringRepRecursive.ptm")
	 					parent.KeyFound = "True"
	 					breakLoop
	 				}
	 			}
	 		}
	 		if(!(clazz.KeyFound)){
	 			for(group:clazz.iterateGroup){
	 				if(group.IsPrimaryKey.toBool){
	 					for(member:group.iterateMember){
	 						include("StringRepRecursive.ptm")
	 					}
	 					breakLoop
	 				}
	 			}
	 		}
	 		'''
	 		    sb.append("]");
	 		    return sb.toString();
	 		'''
	 		indent(4)
	 		'''
	 		  }
	 		'''
	 	}
	 	'''«context.toString»'''
	 }
}