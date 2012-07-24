import GenovaBase

class GetSetGroup extends GenovaBase{ 
	XGroup group
	override call(){
	 	// ----------------------------------------------------
	 	// Copyright (c) 2005-11 Esito AS. All rights reserved.
	 	// Version: 9.0.7-SNAPSHOT. September 23, 2011.
	 	// ----------------------------------------------------
	 	// Note: Class.XXX in this file is not ClassModel.Class.XXX. It is ClassModel.Class.Group.Member...Class.XXX
	 	if(group.MemberType == "Attribute"){
	 		include("JavaType.ptm")
	 		if(group.StartRoleNamePath != ""){
	 			// Some locally used variables...
	 			group.tmpVarPostfix = group.StartRoleNamePath + _FIRST_UPPER(_NOSEP_CAMEL(group.RestRoleNamePath) + _FIRST_UPPER(group.Name))
	 			group.tmpGetName = "get" + _FIRST_UPPER(group.tmpVarPostfix)
	 			group.tmpSetName = "set" + _FIRST_UPPER(group.tmpVarPostfix)
	 			if(clazz.IsPersistent.toBool){
	 				'''
	 				      /** Temporary value holder for group key fragment 
	 				«group.tmpVarPostfix» */
	 				      private transient 
	 				«group.javaType» temp
	 				«_FIRST_UPPER(group.tmpVarPostfix)»;
	 				
	 				'''
	 			}else {
	 				warning("A field in transient Class " + clazz.Name + " is used as key fragment.")
	 			}
	 			if(_DEFINED(clazz.MethodVisibility,group.tmpGetName,"")){
	 				if(clazz.MethodVisibility,group.tmpGetName,"" == "Package"){
	 					group.tmpVisibility = ""
	 				}else {
	 					group.tmpVisibility = _LOWER(clazz.MethodVisibility,group.tmpGetName,"") + " "
	 				}
	 			}else {
	 				group.tmpVisibility = "public "
	 			}
	 			clazz.Methods,group.tmpGetName,"" = "True"
	 			if(!(_DEFINED(topparent.GenerateSingleClass)) && group.tmpVisibility == "private "){
	 				warning("Skipping generation of " + group.tmpGetName + "(): Method is private.")
	 			}else {
	 				'''
	 				      /**
	 				'''
	 				indent(1)
	 				'''
	 				       * Gets the key fragment 
	 				«group.Name» for member 
	 				«group.StartRoleNamePath».
	 				'''
	 				if(clazz.IsPersistent.toBool){
	 					'''
	 					       * If this.
	 					«group.StartRoleNamePath» is null, a temporary stored value for the key
	 					       * fragment will be returned. The temporary value is set by set
	 					«_FIRST_UPPER(group.tmpVarPostfix)». 
	 					       * This behavior is required by some persistence libraries to allow
	 					       * fetching of objects in arbitrary order.
	 					       * 
	 					       * @return Current (or temporary) value of the key fragment.
	 					'''
	 				}else {
	 					'''
	 					       * If this.
	 					«group.StartRoleNamePath» is null, an IllegalStateException will be thrown.
	 					       *
	 					       * @return Current value of the key fragment.
	 					       * @exception IllegalStateException if this.
	 					«group.StartRoleNamePath» is null
	 					'''
	 				}
	 				'''
	 				       * @see 
	 				«group.OwnerClassName»
	 				       */
	 				'''
	 				indent(1)
	 				'''«group.tmpVisibility»«group.javaType»«group.tmpGetName»() {
	 				'''
	 				indent(4)
	 				if(clazz.IsPersistent.toBool){
	 					'''
	 					          return (get
	 					«_FIRST_UPPER(group.StartRoleNamePath)»() == null ? temp
	 					«_FIRST_UPPER(group.tmpVarPostfix)» : get
	 					«_FIRST_UPPER(group.StartRoleNamePath)»().get
	 					«_FIRST_UPPER(_NOSEP_CAMEL(group.RestRoleNamePath + _FIRST_UPPER(group.Name)))»());
	 					'''
	 				}else {
	 					'''
	 					          if (get
	 					«_FIRST_UPPER(group.StartRoleNamePath)»() == null) {
	 					'''
	 					indent(4)
	 					'''
	 					              throw new IllegalStateException("Unable to access member 
	 					«group.StartRoleNamePath»");
	 					'''
	 					indent(4)
	 					'''
	 					          }
	 					          return get
	 					«_FIRST_UPPER(group.StartRoleNamePath)»().get
	 					«_FIRST_UPPER(_NOSEP_CAMEL(group.RestRoleNamePath + _FIRST_UPPER(group.Name)))»();
	 					'''
	 				}
	 				indent(4)
	 				'''
	 				      }
	 				
	 				'''
	 			}
	 			if(_DEFINED(clazz.MethodVisibility,group.tmpSetName,group.javaType)){
	 				if(clazz.MethodVisibility,group.tmpSetName,group.javaType == "Package"){
	 					group.tmpVisibility = ""
	 				}else {
	 					group.tmpVisibility = _LOWER(clazz.MethodVisibility,group.tmpSetName,group.javaType) + " "
	 				}
	 			}else {
	 				group.tmpVisibility = "public "
	 			}
	 			clazz.Methods,group.tmpSetName,group.javaType = "True"
	 			if(!(_DEFINED(topparent.GenerateSingleClass)) && group.tmpVisibility == "private "){
	 				warning("Skipping generation of " + group.tmpSetName + "(): Method is private.")
	 			}else {
	 				'''
	 				      /**
	 				'''
	 				indent(1)
	 				'''
	 				       * Sets the key fragment 
	 				«group.Name» from member 
	 				«group.StartRoleNamePath»'''
	 				if(clazz.IsPersistent.toBool){
	 					'''
	 					       * If this.
	 					«group.StartRoleNamePath» is null, the passed value will be temporary 
	 					       * stored, and returned by subsequent calls to get
	 					«_FIRST_UPPER(group.tmpVarPostfix)». 
	 					       * This behaviour is required by some persistence libraries to allow
	 					       * fetching of objects in arbitrary order.
	 					       * 
	 					       * @param a
	 					«_FIRST_UPPER(group.Name)» New value for the key fragment
	 					'''
	 				}else {
	 					'''
	 					       * If this.
	 					«group.StartRoleNamePath» is null, an IllegalStateException will be thrown.
	 					       *
	 					       * @param a
	 					«_FIRST_UPPER(group.Name)» New value for the key fragment
	 					       * @exception IllegalStateException if this.
	 					«group.StartRoleNamePath» is null
	 					'''
	 				}
	 				'''
	 				       * @see 
	 				«group.OwnerClassName»
	 				       */
	 				'''
	 				indent(1)
	 				'''«group.tmpVisibility»void 
	 				«group.tmpSetName»(final 
	 				«group.javaType» a
	 				«_FIRST_UPPER(group.Name)») {
	 				'''
	 				indent(4)
	 				if(clazz.IsPersistent.toBool){
	 					'''
	 					          if (get
	 					«_FIRST_UPPER(group.StartRoleNamePath)»() == null) {
	 					'''
	 					indent(4)
	 					'''
	 					              temp
	 					«_FIRST_UPPER(group.tmpVarPostfix)» = a
	 					«_FIRST_UPPER(group.Name)»;
	 					'''
	 					indent(4)
	 					'''
	 					          } else {
	 					'''
	 					indent(4)
	 					'''
	 					              get
	 					«_FIRST_UPPER(group.StartRoleNamePath)»().set
	 					«_FIRST_UPPER(_NOSEP_CAMEL(group.RestRoleNamePath + _FIRST_UPPER(group.Name)))»(a
	 					«_FIRST_UPPER(group.Name)»);
	 					'''
	 					indent(4)
	 					'''
	 					          }
	 					'''
	 				}else {
	 					'''
	 					          if (get
	 					«_FIRST_UPPER(group.StartRoleNamePath)»() == null) {
	 					'''
	 					indent(4)
	 					'''
	 					              throw new IllegalStateException("Unable to access member 
	 					«group.StartRoleNamePath»");
	 					'''
	 					indent(4)
	 					'''
	 					          }
	 					          get
	 					«_FIRST_UPPER(group.StartRoleNamePath)»().set
	 					«_FIRST_UPPER(_NOSEP_CAMEL(group.RestRoleNamePath + _FIRST_UPPER(group.Name)))»(a
	 					«_FIRST_UPPER(group.Name)»);
	 					'''
	 				}
	 				indent(4)
	 				'''
	 				      }
	 				
	 				'''
	 			}
	 		}
	 		// StartRoleNamePath!=""
	 	}else {
	 		// MemberType is "Group"
	 		for(member:group.iterateMember){
	 			include("GetSetGroup.ptm")
	 		}
	 	}
	 	'''«context.toString»'''
	 }
}