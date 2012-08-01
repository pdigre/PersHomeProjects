/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package em.domain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XClazz</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link em.domain.XClazz#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link em.domain.XClazz#getDefaultDomainKey <em>Default Domain Key</em>}</li>
 *   <li>{@link em.domain.XClazz#isImplementSerializable <em>Implement Serializable</em>}</li>
 *   <li>{@link em.domain.XClazz#getImports <em>Imports</em>}</li>
 *   <li>{@link em.domain.XClazz#isIsPersistent <em>Is Persistent</em>}</li>
 *   <li>{@link em.domain.XClazz#getMethods <em>Methods</em>}</li>
 *   <li>{@link em.domain.XClazz#isMethodVisibility <em>Method Visibility</em>}</li>
 *   <li>{@link em.domain.XClazz#getName <em>Name</em>}</li>
 *   <li>{@link em.domain.XClazz#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link em.domain.XClazz#getPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link em.domain.XClazz#isSerializable <em>Serializable</em>}</li>
 *   <li>{@link em.domain.XClazz#getSubImports <em>Sub Imports</em>}</li>
 *   <li>{@link em.domain.XClazz#getSuperClassName <em>Super Class Name</em>}</li>
 *   <li>{@link em.domain.XClazz#getSuperClassPackage <em>Super Class Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see em.domain.DomainPackage#getXClazz()
 * @model
 * @generated
 */
public interface XClazz extends EObject {
	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see em.domain.DomainPackage#getXClazz_Abstract()
	 * @model
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link em.domain.XClazz#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Default Domain Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Domain Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Domain Key</em>' attribute.
	 * @see #setDefaultDomainKey(String)
	 * @see em.domain.DomainPackage#getXClazz_DefaultDomainKey()
	 * @model
	 * @generated
	 */
	String getDefaultDomainKey();

	/**
	 * Sets the value of the '{@link em.domain.XClazz#getDefaultDomainKey <em>Default Domain Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Domain Key</em>' attribute.
	 * @see #getDefaultDomainKey()
	 * @generated
	 */
	void setDefaultDomainKey(String value);

	/**
	 * Returns the value of the '<em><b>Implement Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implement Serializable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implement Serializable</em>' attribute.
	 * @see #setImplementSerializable(boolean)
	 * @see em.domain.DomainPackage#getXClazz_ImplementSerializable()
	 * @model
	 * @generated
	 */
	boolean isImplementSerializable();

	/**
	 * Sets the value of the '{@link em.domain.XClazz#isImplementSerializable <em>Implement Serializable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implement Serializable</em>' attribute.
	 * @see #isImplementSerializable()
	 * @generated
	 */
	void setImplementSerializable(boolean value);

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' attribute.
	 * @see #setImports(String)
	 * @see em.domain.DomainPackage#getXClazz_Imports()
	 * @model
	 * @generated
	 */
	String getImports();

	/**
	 * Sets the value of the '{@link em.domain.XClazz#getImports <em>Imports</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imports</em>' attribute.
	 * @see #getImports()
	 * @generated
	 */
	void setImports(String value);

	/**
	 * Returns the value of the '<em><b>Is Persistent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Persistent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Persistent</em>' attribute.
	 * @see #setIsPersistent(boolean)
	 * @see em.domain.DomainPackage#getXClazz_IsPersistent()
	 * @model
	 * @generated
	 */
	boolean isIsPersistent();

	/**
	 * Sets the value of the '{@link em.domain.XClazz#isIsPersistent <em>Is Persistent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Persistent</em>' attribute.
	 * @see #isIsPersistent()
	 * @generated
	 */
	void setIsPersistent(boolean value);

	/**
	 * Returns the value of the '<em><b>Methods</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' attribute.
	 * @see #setMethods(String)
	 * @see em.domain.DomainPackage#getXClazz_Methods()
	 * @model
	 * @generated
	 */
	String getMethods();

	/**
	 * Sets the value of the '{@link em.domain.XClazz#getMethods <em>Methods</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Methods</em>' attribute.
	 * @see #getMethods()
	 * @generated
	 */
	void setMethods(String value);

	/**
	 * Returns the value of the '<em><b>Method Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method Visibility</em>' attribute.
	 * @see #setMethodVisibility(boolean)
	 * @see em.domain.DomainPackage#getXClazz_MethodVisibility()
	 * @model
	 * @generated
	 */
	boolean isMethodVisibility();

	/**
	 * Sets the value of the '{@link em.domain.XClazz#isMethodVisibility <em>Method Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method Visibility</em>' attribute.
	 * @see #isMethodVisibility()
	 * @generated
	 */
	void setMethodVisibility(boolean value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see em.domain.DomainPackage#getXClazz_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link em.domain.XClazz#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Name</em>' attribute.
	 * @see #setPackageName(String)
	 * @see em.domain.DomainPackage#getXClazz_PackageName()
	 * @model
	 * @generated
	 */
	String getPackageName();

	/**
	 * Sets the value of the '{@link em.domain.XClazz#getPackageName <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Name</em>' attribute.
	 * @see #getPackageName()
	 * @generated
	 */
	void setPackageName(String value);

	/**
	 * Returns the value of the '<em><b>Primary Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Key</em>' attribute.
	 * @see #setPrimaryKey(String)
	 * @see em.domain.DomainPackage#getXClazz_PrimaryKey()
	 * @model
	 * @generated
	 */
	String getPrimaryKey();

	/**
	 * Sets the value of the '{@link em.domain.XClazz#getPrimaryKey <em>Primary Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Key</em>' attribute.
	 * @see #getPrimaryKey()
	 * @generated
	 */
	void setPrimaryKey(String value);

	/**
	 * Returns the value of the '<em><b>Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serializable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serializable</em>' attribute.
	 * @see #setSerializable(boolean)
	 * @see em.domain.DomainPackage#getXClazz_Serializable()
	 * @model
	 * @generated
	 */
	boolean isSerializable();

	/**
	 * Sets the value of the '{@link em.domain.XClazz#isSerializable <em>Serializable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Serializable</em>' attribute.
	 * @see #isSerializable()
	 * @generated
	 */
	void setSerializable(boolean value);

	/**
	 * Returns the value of the '<em><b>Sub Imports</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Imports</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Imports</em>' attribute.
	 * @see #setSubImports(String)
	 * @see em.domain.DomainPackage#getXClazz_SubImports()
	 * @model
	 * @generated
	 */
	String getSubImports();

	/**
	 * Sets the value of the '{@link em.domain.XClazz#getSubImports <em>Sub Imports</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Imports</em>' attribute.
	 * @see #getSubImports()
	 * @generated
	 */
	void setSubImports(String value);

	/**
	 * Returns the value of the '<em><b>Super Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Class Name</em>' attribute.
	 * @see #setSuperClassName(String)
	 * @see em.domain.DomainPackage#getXClazz_SuperClassName()
	 * @model
	 * @generated
	 */
	String getSuperClassName();

	/**
	 * Sets the value of the '{@link em.domain.XClazz#getSuperClassName <em>Super Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Class Name</em>' attribute.
	 * @see #getSuperClassName()
	 * @generated
	 */
	void setSuperClassName(String value);

	/**
	 * Returns the value of the '<em><b>Super Class Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class Package</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Class Package</em>' attribute.
	 * @see #setSuperClassPackage(String)
	 * @see em.domain.DomainPackage#getXClazz_SuperClassPackage()
	 * @model
	 * @generated
	 */
	String getSuperClassPackage();

	/**
	 * Sets the value of the '{@link em.domain.XClazz#getSuperClassPackage <em>Super Class Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Class Package</em>' attribute.
	 * @see #getSuperClassPackage()
	 * @generated
	 */
	void setSuperClassPackage(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model many="false"
	 * @generated
	 */
	EList<?> iterateAssociation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model many="false"
	 * @generated
	 */
	EList<?> iterateAttribute();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model many="false"
	 * @generated
	 */
	EList<?> iterateGeneralization();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model many="false"
	 * @generated
	 */
	EList<?> iterateGroup();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model many="false"
	 * @generated
	 */
	EList<?> iterateMethod();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model many="false"
	 * @generated
	 */
	EList<?> iterateRealization();

} // XClazz
