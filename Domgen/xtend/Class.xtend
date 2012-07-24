import GenovaBase

class Class extends GenovaBase{ 
	XClazz clazz
	override call(){
	 	// ----------------------------------------------------
	 	// Copyright (c) 2005-11 Esito AS. All rights reserved.
	 	// Version: 9.0.7-SNAPSHOT. September 23, 2011.
	 	// ----------------------------------------------------
	 	// ---------------------------------------------------------------------------
	 	// Set some variables...
	 	// ---------------------------------------------------------------------------
	 	// Class#ImplementSerializable will be true if class implements Serializable
	 	// Will be set during generation of imports.
	 	// Class#PrimaryKey will be defined if the class has a primary key
	 	for(attribute:clazz.iterateAttribute){
	 		if(attribute.IsPrimaryKey.toBool){
	 			clazz.PrimaryKey = attribute.Name
	 			breakLoop
	 		}
	 	}
	 	// Attribute
	 	if(!(_DEFINED(clazz.PrimaryKey))){
	 		for(group:clazz.iterateGroup){
	 			if(group.IsPrimaryKey.toBool){
	 				clazz.PrimaryKey = group.Name
	 				breakLoop
	 			}
	 		}
	 		// Group
	 	}
	 	// Class#DefaultDomainKey will be defined if the class has a default domain key
	 	for(attribute:clazz.iterateAttribute){
	 		if(attribute.IsDefaultDomainKey.toBool){
	 			clazz.DefaultDomainKey = attribute.Name
	 			breakLoop
	 		}
	 	}
	 	// Attribute
	 	if(!(_DEFINED(clazz.DefaultDomainKey))){
	 		for(group:clazz.iterateGroup){
	 			if(group.IsDefaultDomainKey.toBool){
	 				clazz.DefaultDomainKey = group.Name
	 				breakLoop
	 			}
	 		}
	 		// Group
	 	}
	 	// Class#SuperClassName will hold the name of the super class (if any)
	 	// Class#SuperClassPackage will hold the name of the package of the super class (if any)
	 	for(generalization:clazz.iterateGeneralization){
	 		if(clazz.Name == generalization.subClass.Name){
	 			clazz.SuperClassName = generalization.superClass.Name
	 			clazz.SuperClassPackage = generalization.superClass.PackageName
	 			breakLoop
	 		}
	 	}
	 	// Generalization
	 	if(!(_DEFINED(clazz.SuperClassName))){
	 		if(clazz.IsPersistent.toBool && _DEFINED(clazz.PersistentClass)){
	 			clazz.SuperClassName = clazz.PersistentClass
	 		}else if(!(clazz.IsPersistent.toBool) && _DEFINED(clazz.TransientClass)){
	 			clazz.SuperClassName = clazz.TransientClass
	 		}
	 	}
	 	// Class#Method[ReturnType][ParameterList] will be true if the method with the
	 	// signature is already generated. Used to prevent multiple methods with the
	 	// same signature. 
	 	// The ParameterList will be a comma-separated string, and it will be prefixed
	 	// in the following cases: *abstract* if an abstract method is generated, and
	 	// "*constructor*" if a the method has no return type.
	 	// This array will be populated as methods are generated.
	 	// Class#MethodVisibility[name][args] will hold the visibility of methods in
	 	// the model. Used only when generating getters and setters.
	 	for(method:clazz.iterateMethod){
	 		method.parameters = ""
	 		for(parameter:method.iterateParameter){
	 			include("JavaType.ptm")
	 			if(parameter.IsFirst.toBool){
	 				method.parameters = parameter.javaType
	 			}else {
	 				method.parameters = method.parameters + "," + parameter.javaType
	 			}
	 		}
	 		// Parameter
	 		clazz.MethodVisibility,method.Name,method.parameters = method.Visibility
	 	}
	 	// Method
	 	// ---------------------------------------------------------------------------
	 	// Open source file, add head comment and package...
	 	// ---------------------------------------------------------------------------
	 	setContext("Class")
	 	if(_DEFINED(topparent.GenerateSingleClass)){
	 		if(clazz.SkipNewFiles.toBool){
	 			file(macro("DomainDirectory") + "/" + clazz.Name + ".java")
	 		}else {
	 			//SkipNewFiles
	 			newfile(macro("DomainDirectory") + "/" + clazz.Name + ".java")
	 		}
	 		//SkipNewFiles
	 	}else {
	 		// This is the generated super class
	 		file(macro("DomainDirectory") + "/" + clazz.Name + "Default.java")
	 	}
	 	// TopParent#GenerateSingleClass
	 	if(_DEFINED(clazz.CommentFile)){
	 		include(clazz.CommentFile)
	 	}else {
	 		// CommentFile
	 		'''
	 		  // 
	 		«clazz.GeneratedWith»'''
	 	}
	 	// CommentFile
	 	'''
	 	
	 	package 
	 	«_SLASH_TO_DOT(_LOWER(clazz.PackageName))»;
	 	'''
	 	// ---------------------------------------------------------------------------
	 	// Imports...
	 	// ---------------------------------------------------------------------------
	 	// Class#Imports["SomeClassName"] is set to prevent double imports.
	 	for(attribute:clazz.iterateAttribute){
	 		include("ImportSingle.ptm")
	 	}
	 	// Attribute
	 	for(group:clazz.iterateGroup){
	 		include("ImportRecursive.ptm")
	 	}
	 	// Group
	 	for(association:clazz.iterateAssociation){
	 		if(clazz.Name == association.ownerClass.Name && association.IsMemberNavigable.toBool){
	 			if(association.IsMemberMany.toBool){
	 				association.impSinType = "Set"
	 				include("ImportSingle.ptm")
	 			}
	 			// IsMemberMany
	 			association.impSinType = association.memberClass.Name
	 			association.impSinPack = association.memberClass.PackageName
	 			include("ImportSingle.ptm")
	 		}
	 		if(clazz.Name == association.memberClass.Name && association.IsOwnerNavigable.toBool){
	 			if(association.IsOwnerMany.toBool){
	 				association.impSinType = "Set"
	 				include("ImportSingle.ptm")
	 			}
	 			// IsOwnerMany
	 			association.impSinType = association.ownerClass.Name
	 			association.impSinPack = association.ownerClass.PackageName
	 			include("ImportSingle.ptm")
	 		}
	 	}
	 	// Association
	 	for(method:clazz.iterateMethod){
	 		if(_DEFINED(topparent.GenerateSingleClass) || !(method.Visibility == "Private" || clazz.Name == method.Name)){
	 			include("ImportSingle.ptm")
	 			for(parameter:method.iterateParameter){
	 				include("ImportSingle.ptm")
	 			}
	 			// Parameter
	 		}
	 	}
	 	// Method
	 	for(generalization:clazz.iterateGeneralization){
	 		if(clazz.Name == generalization.subClass.Name){
	 			include("ImportSingle.ptm")
	 			breakLoop
	 		}
	 	}
	 	// Generalization
	 	// Import realizations, and set Class#ImplementSerializable...
	 	for(realization:clazz.iterateRealization){
	 		realization.tmp = _SLASH_TO_DOT(_LOWER(realization.interfaze.PackageName)) + "." + realization.interfaze.Name
	 		if(realization.tmp == "java.io.Serializable"){
	 			clazz.Serializable = "True"
	 		}
	 		if(realization.interfaze.PackageName != realization.clazz.PackageName){
	 			'''
	 			    import 
	 			«realization.tmp»;
	 			'''
	 		}
	 	}
	 	// Realization
	 	if(!(_DEFINED(clazz.Serializable))){
	 		if(clazz.IsPersistent.toBool && !(_DEFINED(clazz.GeneralizationName)) && _DEFINED(clazz.PersistentSerializable)){
	 			clazz.ImplementSerializable = "True"
	 		}
	 	}
	 	// !DEFINED
	 	// Now, make sure we dont implement serializable if a superclass does...
	 	for(generalization:clazz.iterateGeneralization){
	 		if(clazz.Name == generalization.subClass.Name && clazz.IsPersistent.toBool){
	 			clazz.ImplementSerializable = "False"
	 			breakLoop
	 		}
	 	}
	 	// Generalization
	 	if(!(_DEFINED(clazz.GeneralizationName))){
	 		if(_DEFINED(clazz.PersistentClass) && clazz.IsPersistent.toBool){
	 			clazz.GeneralizationName = clazz.PersistentClass
	 		}else if(_DEFINED(clazz.TransientClass) && !(clazz.IsPersistent.toBool)){
	 			clazz.GeneralizationName = clazz.TransientClass
	 		}
	 	}
	 	if(_DEFINED(clazz.ImplementSerializable)){
	 		clazz.impSinPack = "java.io"
	 		clazz.impSinType = "Serializable"
	 		include("ImportSingle.ptm")
	 	}
	 	if(_DEFINED(clazz.SuperClassPackage)){
	 		clazz.impSinPack = clazz.SuperClassPackage
	 		clazz.impSinType = clazz.SuperClassName
	 		include("ImportSingle.ptm")
	 	}
	 	if(_DEFINED(clazz.PrimaryKey)){
	 		clazz.impSinPack = "java.util"
	 		clazz.impSinType = "LinkedHashMap"
	 		include("ImportSingle.ptm")
	 		clazz.impSinPack = "java.util"
	 		clazz.impSinType = "Map"
	 		include("ImportSingle.ptm")
	 	}
	 	if(_DEFINED(clazz.GenerateAttributeInfo)){
	 		clazz.impSinPack = "java.util"
	 		clazz.impSinType = "HashMap"
	 		include("ImportSingle.ptm")
	 		clazz.impSinPack = "java.util"
	 		clazz.impSinType = "Map"
	 		include("ImportSingle.ptm")
	 		clazz.impSinPack = "no.genova.domain"
	 		clazz.impSinType = "AttributeInfo"
	 		include("ImportSingle.ptm")
	 	}
	 	// ---------------------------------------------------------------------------
	 	// Class declaration...
	 	// ---------------------------------------------------------------------------
	 	'''/**
	 	'''
	 	// Note: Intended space at the end of next line (SUP-209 workaround)
	 	if(clazz.HasDescription.toBool){
	 		'''«macro("JavaDocDesc")»
	 		'''
	 	}
	 	indent(1)
	 	'''
	 	 */
	 	'''
	 	indent(1)
	 	if(!(_DEFINED(topparent.GenerateSingleClass))){
	 		'''«macro("suppressAllWarnings")»
	 		'''
	 	}
	 	line
	 	if(_DEFINED(topparent.GenerateSingleClass)){
	 		'''«macro("Visibility")»
	 		«if (clazz.Abstract.toBool) "abstract " else ""»class 
	 		«clazz.Name»'''
	 	}else {
	 		// This is the abstract base class
	 		'''
	 		  public abstract class 
	 		«clazz.Name»Default 
	 		'''
	 	}
	 	// TopParent#GenerateSingleClass
	 	if(_DEFINED(clazz.SuperClassName)){
	 		'''
	 		  extends 
	 		«clazz.SuperClassName»'''
	 	}
	 	if(_DEFINED(clazz.ImplementSerializable) || clazz.CountRealization.toInt > 0){
	 		'''
	 		  implements 
	 		'''
	 	}
	 	for(realization:clazz.iterateRealization){
	 		if(realization.IsLast.toBool && !(_DEFINED(clazz.ImplementSerializable))){
	 			'''«realization.interfaze.Name»'''
	 		}else {
	 			'''«realization.interfaze.Name», 
	 			'''
	 		}
	 	}
	 	// Realization
	 	if(_DEFINED(clazz.ImplementSerializable)){
	 		'''
	 		  Serializable 
	 		'''
	 	}
	 	'''
	 	{
	 	'''
	 	endline
	 	indent(4)
	 	// ---------------------------------------------------------------------------
	 	// Class attributes...
	 	// ---------------------------------------------------------------------------
	 	if(_DEFINED(topparent.GenerateSingleClass) && _DEFINED(clazz.SerialVersionUID)){
	 		'''
	 		  /** Serial Version UID. */
	 		  private static final long serialVersionUID = 
	 		«clazz.SerialVersionUID»;
	 		'''
	 	}
	 	if(_DEFINED(clazz.GenerateClassNameString)){
	 		'''
	 		  /** Class name. */
	 		  public static final String NAME = "
	 		«clazz.Name»";
	 		'''
	 	}
	 	if(_DEFINED(clazz.PrimaryKey)){
	 		'''
	 		  /** Primary key. */
	 		  protected static final String PK = "
	 		«clazz.PrimaryKey»";
	 		'''
	 	}
	 	if(_DEFINED(clazz.GenerateAttributeNameString)){
	 		for(attribute:clazz.iterateAttribute){
	 			'''
	 			    /** Attribute name. */
	 			    public static final String ATTR_
	 			«_UPPER(_UNCAMELIZE(attribute.Name))» = "
	 			«attribute.Name»";
	 			'''
	 		}
	 		// Attribute
	 		for(association:clazz.iterateAssociation){
	 			if(clazz.Name == association.OwnerClassName && association.IsMemberNavigable.toBool){
	 				'''
	 				      /** Association attribute name. */
	 				      public static final String ATTR_
	 				«_UPPER(_UNCAMELIZE(association.MemberRoleName))» = "
	 				«association.MemberRoleName»";
	 				'''
	 			}
	 			if(clazz.Name == association.MemberClassName && association.IsOwnerNavigable.toBool){
	 				'''
	 				      /** Association attribute name. */
	 				      public static final String ATTR_
	 				«_UPPER(_UNCAMELIZE(association.OwnerRoleName))» = "
	 				«association.OwnerRoleName»";
	 				'''
	 			}
	 		}
	 		// Association
	 		for(group:clazz.iterateGroup){
	 			if(group.IsPrimaryKey.toBool){
	 				for(member:group.iterateMember){
	 					if(member.MemberType != "Attribute"){
	 						include("FinalAttributeRecursive.ptm")
	 					}
	 				}
	 				// Member
	 			}
	 		}
	 		// Group
	 	}
	 	// DEFINED(GenerateAttributeNameString)
	 	if(_DEFINED(clazz.GenerateAttributeInfo)){
	 		include("AttributeFormatting.ptm")
	 	}
	 	// DEFINED(GenerateAttributeInfo)
	 	for(attribute:clazz.iterateAttribute){
	 		if(attribute.HasDescription.toBool){
	 			'''
	 			
	 			    /**
	 			«macro("JavaDocDesc")»
	 			'''
	 			indent(1)
	 			'''
	 			    */
	 			'''
	 			indent(1)
	 		}
	 		if(_DEFINED(topparent.GeneratePublicSetGet)){
	 			'''«macro("Visibility")»
	 			'''
	 			if(attribute.IsStatic.toBool){
	 				'''static 
	 				'''
	 			}
	 			'''«macro("javaType")»
	 			«attribute.Name»'''
	 			if(attribute.HasInitialValue.toBool){
	 				''' = 
	 				«attribute.InitialValue»'''
	 			}
	 			''';
	 			'''
	 		}else {
	 			'''
	 			    private 
	 			'''
	 			if(attribute.IsStatic.toBool){
	 				'''static 
	 				'''
	 			}
	 			'''«macro("javaType")»
	 			«attribute.Name»'''
	 			if(attribute.HasInitialValue.toBool){
	 				''' = 
	 				«attribute.InitialValue»'''
	 			}
	 			''';
	 			'''
	 		}
	 		// DEFINED(TopParent#GeneratePublicSetGet)
	 	}
	 	// Attribute
	 	for(association:clazz.iterateAssociation){
	 		if(clazz.Name == association.OwnerClassName){
	 			if(association.IsMemberNavigable.toBool){
	 				if(association.IsMemberMany.toBool){
	 					if(association.HasDescription.toBool){
	 						'''
	 						          /** 
	 						'''
	 						// Note: Intended space at the end of next line (SUP-209 workaround)
	 						'''«macro("JavaDocDesc")»
	 						'''
	 						indent(1)
	 						'''
	 						            */
	 						'''
	 						indent(1)
	 					}
	 					'''
	 					        private Set<
	 					«association.MemberClassName»> 
	 					«association.MemberRoleName»;
	 					'''
	 				}else {
	 					if(association.HasDescription.toBool){
	 						'''
	 						          /** 
	 						«association.Description» */
	 						'''
	 					}
	 					'''
	 					        private 
	 					«association.MemberClassName»«association.MemberRoleName»;
	 					'''
	 				}
	 				// IsMemberMany
	 			}
	 			// IsMemberNavigable
	 		}
	 		// Class.Name==OwnerClassName
	 		if(clazz.Name == association.MemberClassName){
	 			if(association.IsOwnerNavigable.toBool){
	 				if(association.IsOwnerMany.toBool){
	 					if(association.HasDescription.toBool){
	 						'''
	 						          /** 
	 						'''
	 						// Note: Intended space at the end of next line (SUP-209 workaround)
	 						'''«macro("JavaDocDesc")»
	 						'''
	 						indent(1)
	 						'''
	 						            */
	 						'''
	 						indent(1)
	 					}
	 					'''
	 					        private Set<
	 					«association.OwnerClassName»> 
	 					«association.OwnerRoleName»;
	 					'''
	 				}else {
	 					if(association.HasDescription.toBool){
	 						'''
	 						          /** 
	 						'''
	 						// Note: Intended space at the end of next line (SUP-209 workaround)
	 						'''«macro("JavaDocDesc")»
	 						'''
	 						indent(1)
	 						'''
	 						            */
	 						'''
	 						indent(1)
	 					}
	 					'''
	 					        private 
	 					«association.OwnerClassName»«association.OwnerRoleName»;
	 					'''
	 				}
	 				// IsOwnerMany
	 			}
	 			// IsOwnerNavigable
	 		}
	 		// Class.Name==MemberClassName
	 	}
	 	// Association
	 	// ---------------------------------------------------------------------------
	 	// Constructors, accessors and methods...
	 	// ---------------------------------------------------------------------------
	 	'''  /** Default constructor. */
	 	'''
	 	if(_DEFINED(topparent.GenerateSingleClass)){
	 		clazz.tmpVisibility = "public "
	 		if(_DEFINED(clazz.MethodVisibility,clazz.Name,"")){
	 			clazz.tmpVisibility = if (clazz.MethodVisibility,clazz.Name,"" == "Package") "" else _LOWER(clazz.MethodVisibility,clazz.Name,"") + " "
	 		}
	 		'''«clazz.tmpVisibility»«clazz.Name»() {
	 		'''
	 		clazz.Methods,clazz.Name,"*constructor*" = "True"
	 	}else {
	 		'''
	 		  protected 
	 		«clazz.Name»Default() {
	 		'''
	 		clazz.Methods,clazz.Name + "Default","*constructor*" = "True"
	 	}
	 	indent(4)
	 	'''
	 	  super();
	 	'''
	 	indent(4)
	 	'''
	 	}
	 	'''
	 	for(method:clazz.iterateMethod){
	 		// This iteration will take care of constructors
	 		if(clazz.Name == method.Name){
	 			include("Method.ptm")
	 		}
	 	}
	 	for(attribute:clazz.iterateAttribute){
	 		include("JavaType.ptm")
	 		attribute.pName = attribute.Name
	 		attribute.pType = attribute.javaType
	 		attribute.pTypeStripGen = attribute.javaType
	 		attribute.pVisibility = if (attribute.Visibility == "Package") "" else _LOWER(attribute.Visibility) + " "
	 		include("GetSetSingle.ptm")
	 	}
	 	for(association:clazz.iterateAssociation){
	 		if(clazz.Name == association.OwnerClassName){
	 			if(association.IsMemberNavigable.toBool){
	 				association.pName = association.MemberRoleName
	 				association.pType = if (association.IsMemberMany.toBool) "Set<" + association.MemberClassName + ">" else association.MemberClassName
	 				association.pTypeStripGen = if (association.IsMemberMany.toBool) "Set" else association.MemberClassName
	 				association.pVisibility = "public "
	 				include("GetSetSingle.ptm")
	 			}
	 		}
	 		if(clazz.Name == association.MemberClassName){
	 			if(association.IsOwnerNavigable.toBool){
	 				association.pName = association.OwnerRoleName
	 				association.pType = if (association.IsOwnerMany.toBool) "Set<" + association.OwnerClassName + ">" else association.OwnerClassName
	 				association.pTypeStripGen = if (association.IsOwnerMany.toBool) "Set" else association.OwnerClassName
	 				association.pVisibility = "public "
	 				include("GetSetSingle.ptm")
	 			}
	 		}
	 	}
	 	for(group:clazz.iterateGroup){
	 		if(group.IsPrimaryKey.toBool){
	 			for(member:group.iterateMember){
	 				include("GetSetGroup.ptm")
	 			}
	 			// Member
	 			breakLoop
	 		}
	 	}
	 	// Group
	 	for(method:clazz.iterateMethod){
	 		// This iteration will take care of non-constructor methods
	 		if(clazz.Name != method.Name){
	 			if(!(clazz.Abstract.toBool) && method.Abstract.toBool){
	 				warning("Non-abstract class " + clazz.Name + " contains abstract method " + method.Name + ".")
	 			}else {
	 				include("Method.ptm")
	 			}
	 		}
	 	}
	 	// ---------------------------------------------------------------------------
	 	// Misc...
	 	// ---------------------------------------------------------------------------
	 	if(_DEFINED(clazz.PrimaryKey) || _DEFINED(clazz.DefaultDomainKey)){
	 		include("Equals.ptm")
	 		include("HashCode.ptm")
	 		include("StringRep.ptm")
	 	}
	 	if(_DEFINED(clazz.PrimaryKey)){
	 		include("PrimaryKey.ptm")
	 	}
	 	if(_DEFINED(clazz.GenerateGetStaticClassNameMethod)){
	 		if(_DEFINED(clazz.Methods,"getStaticName","")){
	 			info("Skipping generation of getStaticName() for " + clazz.Name + ": A method with that name is already defined")
	 		}else {
	 			// Generate method getStaticName()...
	 			clazz.Methods,"getStaticName","" = "True"
	 			'''
	 			    /**
	 			'''
	 			indent(1)
	 			if(_DEFINED(topparent.GenerateSingleClass)){
	 				'''
	 				     * Return the name of this class.
	 				'''
	 			}else {
	 				'''
	 				     * Return the name of the (generated) subclass.
	 				'''
	 			}
	 			'''
	 			     *
	 			     * @return Class name
	 			     */
	 			'''
	 			indent(1)
	 			'''
	 			    public static String getStaticName() {
	 			'''
	 			indent(4)
	 			'''
	 			      return "
	 			«clazz.Name»";
	 			'''
	 			indent(4)
	 			'''
	 			    }
	 			'''
	 		}
	 		if(_DEFINED(clazz.Methods,"getDomainName","")){
	 			info("Skipping generation of getDomainName() for " + clazz.Name + ": A method with that name is already defined")
	 		}else {
	 			// Generate method getDomainName()...
	 			clazz.Methods,"getDomainName","" = "True"
	 			'''
	 			
	 			    /**
	 			'''
	 			indent(1)
	 			if(_DEFINED(topparent.GenerateSingleClass)){
	 				'''
	 				     * Return the full name of this class, including the package name.
	 				'''
	 			}else {
	 				'''
	 				     * Return the full name of the (generated) subclass, including the package name.
	 				'''
	 			}
	 			'''
	 			     *
	 			     * @return full Class name, including the package name
	 			     */
	 			'''
	 			indent(1)
	 			'''
	 			    public static String getDomainName() {
	 			'''
	 			indent(4)
	 			if(_DEFINED(clazz.PackageName)){
	 				'''
	 				      return "
	 				«_SLASH_TO_DOT(_LOWER(clazz.PackageName))»." + getStaticName();
	 				'''
	 			}else {
	 				'''
	 				      return getStaticName();
	 				'''
	 			}
	 			indent(4)
	 			'''
	 			    }
	 			'''
	 		}
	 	}
	 	// GenerateGetStaticClassNameMethod
	 	indent(4)
	 	'''
	 	}
	 	'''
	 	endfile
	 	endContext
	 	if(!(_DEFINED(topparent.GenerateSingleClass))){
	 		include("SubClass.ptm")
	 	}
	 	'''«context.toString»'''
	 }
}