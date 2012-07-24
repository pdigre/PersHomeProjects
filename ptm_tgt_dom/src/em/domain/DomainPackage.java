/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package em.domain;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see em.domain.DomainFactory
 * @model kind="package"
 * @generated
 */
public interface DomainPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "domain";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.esito.no/no/esito/genova/em/domain.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "no.esito.genova.em.domain";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DomainPackage eINSTANCE = em.domain.impl.DomainPackageImpl.init();

	/**
	 * The meta object id for the '{@link em.domain.impl.XClazzImpl <em>XClazz</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see em.domain.impl.XClazzImpl
	 * @see em.domain.impl.DomainPackageImpl#getXClazz()
	 * @generated
	 */
	int XCLAZZ = 0;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLAZZ__ABSTRACT = 0;

	/**
	 * The feature id for the '<em><b>Default Domain Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLAZZ__DEFAULT_DOMAIN_KEY = 1;

	/**
	 * The feature id for the '<em><b>Implement Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLAZZ__IMPLEMENT_SERIALIZABLE = 2;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLAZZ__IMPORTS = 3;

	/**
	 * The feature id for the '<em><b>Is Persistent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLAZZ__IS_PERSISTENT = 4;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLAZZ__METHODS = 5;

	/**
	 * The feature id for the '<em><b>Method Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLAZZ__METHOD_VISIBILITY = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLAZZ__NAME = 7;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLAZZ__PACKAGE_NAME = 8;

	/**
	 * The feature id for the '<em><b>Primary Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLAZZ__PRIMARY_KEY = 9;

	/**
	 * The feature id for the '<em><b>Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLAZZ__SERIALIZABLE = 10;

	/**
	 * The feature id for the '<em><b>Sub Imports</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLAZZ__SUB_IMPORTS = 11;

	/**
	 * The feature id for the '<em><b>Super Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLAZZ__SUPER_CLASS_NAME = 12;

	/**
	 * The feature id for the '<em><b>Super Class Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLAZZ__SUPER_CLASS_PACKAGE = 13;

	/**
	 * The number of structural features of the '<em>XClazz</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLAZZ_FEATURE_COUNT = 14;

	/**
	 * The meta object id for the '{@link em.domain.impl.XConverterImpl <em>XConverter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see em.domain.impl.XConverterImpl
	 * @see em.domain.impl.DomainPackageImpl#getXConverter()
	 * @generated
	 */
	int XCONVERTER = 1;

	/**
	 * The number of structural features of the '<em>XConverter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCONVERTER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link em.domain.impl.XInterfazeImpl <em>XInterfaze</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see em.domain.impl.XInterfazeImpl
	 * @see em.domain.impl.DomainPackageImpl#getXInterfaze()
	 * @generated
	 */
	int XINTERFAZE = 2;

	/**
	 * The number of structural features of the '<em>XInterfaze</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XINTERFAZE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link em.domain.impl.XGroupImpl <em>XGroup</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see em.domain.impl.XGroupImpl
	 * @see em.domain.impl.DomainPackageImpl#getXGroup()
	 * @generated
	 */
	int XGROUP = 3;

	/**
	 * The number of structural features of the '<em>XGroup</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XGROUP_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link em.domain.impl.XAssociationImpl <em>XAssociation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see em.domain.impl.XAssociationImpl
	 * @see em.domain.impl.DomainPackageImpl#getXAssociation()
	 * @generated
	 */
	int XASSOCIATION = 4;

	/**
	 * The number of structural features of the '<em>XAssociation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSOCIATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link em.domain.impl.XMemberImpl <em>XMember</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see em.domain.impl.XMemberImpl
	 * @see em.domain.impl.DomainPackageImpl#getXMember()
	 * @generated
	 */
	int XMEMBER = 5;

	/**
	 * The number of structural features of the '<em>XMember</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link em.domain.impl.XRealizationImpl <em>XRealization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see em.domain.impl.XRealizationImpl
	 * @see em.domain.impl.DomainPackageImpl#getXRealization()
	 * @generated
	 */
	int XREALIZATION = 6;

	/**
	 * The number of structural features of the '<em>XRealization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XREALIZATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link em.domain.impl.XGeneralizationImpl <em>XGeneralization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see em.domain.impl.XGeneralizationImpl
	 * @see em.domain.impl.DomainPackageImpl#getXGeneralization()
	 * @generated
	 */
	int XGENERALIZATION = 7;

	/**
	 * The number of structural features of the '<em>XGeneralization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XGENERALIZATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link em.domain.impl.XEnumeratorImpl <em>XEnumerator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see em.domain.impl.XEnumeratorImpl
	 * @see em.domain.impl.DomainPackageImpl#getXEnumerator()
	 * @generated
	 */
	int XENUMERATOR = 8;

	/**
	 * The number of structural features of the '<em>XEnumerator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XENUMERATOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link em.domain.impl.XEnumValueImpl <em>XEnum Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see em.domain.impl.XEnumValueImpl
	 * @see em.domain.impl.DomainPackageImpl#getXEnumValue()
	 * @generated
	 */
	int XENUM_VALUE = 9;

	/**
	 * The number of structural features of the '<em>XEnum Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XENUM_VALUE_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link em.domain.XClazz <em>XClazz</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XClazz</em>'.
	 * @see em.domain.XClazz
	 * @generated
	 */
	EClass getXClazz();

	/**
	 * Returns the meta object for the attribute '{@link em.domain.XClazz#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see em.domain.XClazz#isAbstract()
	 * @see #getXClazz()
	 * @generated
	 */
	EAttribute getXClazz_Abstract();

	/**
	 * Returns the meta object for the attribute '{@link em.domain.XClazz#getDefaultDomainKey <em>Default Domain Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Domain Key</em>'.
	 * @see em.domain.XClazz#getDefaultDomainKey()
	 * @see #getXClazz()
	 * @generated
	 */
	EAttribute getXClazz_DefaultDomainKey();

	/**
	 * Returns the meta object for the attribute '{@link em.domain.XClazz#isImplementSerializable <em>Implement Serializable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implement Serializable</em>'.
	 * @see em.domain.XClazz#isImplementSerializable()
	 * @see #getXClazz()
	 * @generated
	 */
	EAttribute getXClazz_ImplementSerializable();

	/**
	 * Returns the meta object for the attribute '{@link em.domain.XClazz#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Imports</em>'.
	 * @see em.domain.XClazz#getImports()
	 * @see #getXClazz()
	 * @generated
	 */
	EAttribute getXClazz_Imports();

	/**
	 * Returns the meta object for the attribute '{@link em.domain.XClazz#isIsPersistent <em>Is Persistent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Persistent</em>'.
	 * @see em.domain.XClazz#isIsPersistent()
	 * @see #getXClazz()
	 * @generated
	 */
	EAttribute getXClazz_IsPersistent();

	/**
	 * Returns the meta object for the attribute '{@link em.domain.XClazz#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Methods</em>'.
	 * @see em.domain.XClazz#getMethods()
	 * @see #getXClazz()
	 * @generated
	 */
	EAttribute getXClazz_Methods();

	/**
	 * Returns the meta object for the attribute '{@link em.domain.XClazz#isMethodVisibility <em>Method Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Visibility</em>'.
	 * @see em.domain.XClazz#isMethodVisibility()
	 * @see #getXClazz()
	 * @generated
	 */
	EAttribute getXClazz_MethodVisibility();

	/**
	 * Returns the meta object for the attribute '{@link em.domain.XClazz#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see em.domain.XClazz#getName()
	 * @see #getXClazz()
	 * @generated
	 */
	EAttribute getXClazz_Name();

	/**
	 * Returns the meta object for the attribute '{@link em.domain.XClazz#getPackageName <em>Package Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Name</em>'.
	 * @see em.domain.XClazz#getPackageName()
	 * @see #getXClazz()
	 * @generated
	 */
	EAttribute getXClazz_PackageName();

	/**
	 * Returns the meta object for the attribute '{@link em.domain.XClazz#getPrimaryKey <em>Primary Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primary Key</em>'.
	 * @see em.domain.XClazz#getPrimaryKey()
	 * @see #getXClazz()
	 * @generated
	 */
	EAttribute getXClazz_PrimaryKey();

	/**
	 * Returns the meta object for the attribute '{@link em.domain.XClazz#isSerializable <em>Serializable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Serializable</em>'.
	 * @see em.domain.XClazz#isSerializable()
	 * @see #getXClazz()
	 * @generated
	 */
	EAttribute getXClazz_Serializable();

	/**
	 * Returns the meta object for the attribute '{@link em.domain.XClazz#getSubImports <em>Sub Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Imports</em>'.
	 * @see em.domain.XClazz#getSubImports()
	 * @see #getXClazz()
	 * @generated
	 */
	EAttribute getXClazz_SubImports();

	/**
	 * Returns the meta object for the attribute '{@link em.domain.XClazz#getSuperClassName <em>Super Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Super Class Name</em>'.
	 * @see em.domain.XClazz#getSuperClassName()
	 * @see #getXClazz()
	 * @generated
	 */
	EAttribute getXClazz_SuperClassName();

	/**
	 * Returns the meta object for the attribute '{@link em.domain.XClazz#getSuperClassPackage <em>Super Class Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Super Class Package</em>'.
	 * @see em.domain.XClazz#getSuperClassPackage()
	 * @see #getXClazz()
	 * @generated
	 */
	EAttribute getXClazz_SuperClassPackage();

	/**
	 * Returns the meta object for class '{@link em.domain.XConverter <em>XConverter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XConverter</em>'.
	 * @see em.domain.XConverter
	 * @generated
	 */
	EClass getXConverter();

	/**
	 * Returns the meta object for class '{@link em.domain.XInterfaze <em>XInterfaze</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XInterfaze</em>'.
	 * @see em.domain.XInterfaze
	 * @generated
	 */
	EClass getXInterfaze();

	/**
	 * Returns the meta object for class '{@link em.domain.XGroup <em>XGroup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XGroup</em>'.
	 * @see em.domain.XGroup
	 * @generated
	 */
	EClass getXGroup();

	/**
	 * Returns the meta object for class '{@link em.domain.XAssociation <em>XAssociation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XAssociation</em>'.
	 * @see em.domain.XAssociation
	 * @generated
	 */
	EClass getXAssociation();

	/**
	 * Returns the meta object for class '{@link em.domain.XMember <em>XMember</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XMember</em>'.
	 * @see em.domain.XMember
	 * @generated
	 */
	EClass getXMember();

	/**
	 * Returns the meta object for class '{@link em.domain.XRealization <em>XRealization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XRealization</em>'.
	 * @see em.domain.XRealization
	 * @generated
	 */
	EClass getXRealization();

	/**
	 * Returns the meta object for class '{@link em.domain.XGeneralization <em>XGeneralization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XGeneralization</em>'.
	 * @see em.domain.XGeneralization
	 * @generated
	 */
	EClass getXGeneralization();

	/**
	 * Returns the meta object for class '{@link em.domain.XEnumerator <em>XEnumerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XEnumerator</em>'.
	 * @see em.domain.XEnumerator
	 * @generated
	 */
	EClass getXEnumerator();

	/**
	 * Returns the meta object for class '{@link em.domain.XEnumValue <em>XEnum Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XEnum Value</em>'.
	 * @see em.domain.XEnumValue
	 * @generated
	 */
	EClass getXEnumValue();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DomainFactory getDomainFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link em.domain.impl.XClazzImpl <em>XClazz</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see em.domain.impl.XClazzImpl
		 * @see em.domain.impl.DomainPackageImpl#getXClazz()
		 * @generated
		 */
		EClass XCLAZZ = eINSTANCE.getXClazz();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCLAZZ__ABSTRACT = eINSTANCE.getXClazz_Abstract();

		/**
		 * The meta object literal for the '<em><b>Default Domain Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCLAZZ__DEFAULT_DOMAIN_KEY = eINSTANCE.getXClazz_DefaultDomainKey();

		/**
		 * The meta object literal for the '<em><b>Implement Serializable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCLAZZ__IMPLEMENT_SERIALIZABLE = eINSTANCE.getXClazz_ImplementSerializable();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCLAZZ__IMPORTS = eINSTANCE.getXClazz_Imports();

		/**
		 * The meta object literal for the '<em><b>Is Persistent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCLAZZ__IS_PERSISTENT = eINSTANCE.getXClazz_IsPersistent();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCLAZZ__METHODS = eINSTANCE.getXClazz_Methods();

		/**
		 * The meta object literal for the '<em><b>Method Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCLAZZ__METHOD_VISIBILITY = eINSTANCE.getXClazz_MethodVisibility();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCLAZZ__NAME = eINSTANCE.getXClazz_Name();

		/**
		 * The meta object literal for the '<em><b>Package Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCLAZZ__PACKAGE_NAME = eINSTANCE.getXClazz_PackageName();

		/**
		 * The meta object literal for the '<em><b>Primary Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCLAZZ__PRIMARY_KEY = eINSTANCE.getXClazz_PrimaryKey();

		/**
		 * The meta object literal for the '<em><b>Serializable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCLAZZ__SERIALIZABLE = eINSTANCE.getXClazz_Serializable();

		/**
		 * The meta object literal for the '<em><b>Sub Imports</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCLAZZ__SUB_IMPORTS = eINSTANCE.getXClazz_SubImports();

		/**
		 * The meta object literal for the '<em><b>Super Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCLAZZ__SUPER_CLASS_NAME = eINSTANCE.getXClazz_SuperClassName();

		/**
		 * The meta object literal for the '<em><b>Super Class Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCLAZZ__SUPER_CLASS_PACKAGE = eINSTANCE.getXClazz_SuperClassPackage();

		/**
		 * The meta object literal for the '{@link em.domain.impl.XConverterImpl <em>XConverter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see em.domain.impl.XConverterImpl
		 * @see em.domain.impl.DomainPackageImpl#getXConverter()
		 * @generated
		 */
		EClass XCONVERTER = eINSTANCE.getXConverter();

		/**
		 * The meta object literal for the '{@link em.domain.impl.XInterfazeImpl <em>XInterfaze</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see em.domain.impl.XInterfazeImpl
		 * @see em.domain.impl.DomainPackageImpl#getXInterfaze()
		 * @generated
		 */
		EClass XINTERFAZE = eINSTANCE.getXInterfaze();

		/**
		 * The meta object literal for the '{@link em.domain.impl.XGroupImpl <em>XGroup</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see em.domain.impl.XGroupImpl
		 * @see em.domain.impl.DomainPackageImpl#getXGroup()
		 * @generated
		 */
		EClass XGROUP = eINSTANCE.getXGroup();

		/**
		 * The meta object literal for the '{@link em.domain.impl.XAssociationImpl <em>XAssociation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see em.domain.impl.XAssociationImpl
		 * @see em.domain.impl.DomainPackageImpl#getXAssociation()
		 * @generated
		 */
		EClass XASSOCIATION = eINSTANCE.getXAssociation();

		/**
		 * The meta object literal for the '{@link em.domain.impl.XMemberImpl <em>XMember</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see em.domain.impl.XMemberImpl
		 * @see em.domain.impl.DomainPackageImpl#getXMember()
		 * @generated
		 */
		EClass XMEMBER = eINSTANCE.getXMember();

		/**
		 * The meta object literal for the '{@link em.domain.impl.XRealizationImpl <em>XRealization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see em.domain.impl.XRealizationImpl
		 * @see em.domain.impl.DomainPackageImpl#getXRealization()
		 * @generated
		 */
		EClass XREALIZATION = eINSTANCE.getXRealization();

		/**
		 * The meta object literal for the '{@link em.domain.impl.XGeneralizationImpl <em>XGeneralization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see em.domain.impl.XGeneralizationImpl
		 * @see em.domain.impl.DomainPackageImpl#getXGeneralization()
		 * @generated
		 */
		EClass XGENERALIZATION = eINSTANCE.getXGeneralization();

		/**
		 * The meta object literal for the '{@link em.domain.impl.XEnumeratorImpl <em>XEnumerator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see em.domain.impl.XEnumeratorImpl
		 * @see em.domain.impl.DomainPackageImpl#getXEnumerator()
		 * @generated
		 */
		EClass XENUMERATOR = eINSTANCE.getXEnumerator();

		/**
		 * The meta object literal for the '{@link em.domain.impl.XEnumValueImpl <em>XEnum Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see em.domain.impl.XEnumValueImpl
		 * @see em.domain.impl.DomainPackageImpl#getXEnumValue()
		 * @generated
		 */
		EClass XENUM_VALUE = eINSTANCE.getXEnumValue();

	}

} //DomainPackage
