/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package em.domain;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see em.domain.DomainPackage
 * @generated
 */
public interface DomainFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DomainFactory eINSTANCE = em.domain.impl.DomainFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>XClazz</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XClazz</em>'.
	 * @generated
	 */
	XClazz createXClazz();

	/**
	 * Returns a new object of class '<em>XConverter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XConverter</em>'.
	 * @generated
	 */
	XConverter createXConverter();

	/**
	 * Returns a new object of class '<em>XInterfaze</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XInterfaze</em>'.
	 * @generated
	 */
	XInterfaze createXInterfaze();

	/**
	 * Returns a new object of class '<em>XGroup</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XGroup</em>'.
	 * @generated
	 */
	XGroup createXGroup();

	/**
	 * Returns a new object of class '<em>XAssociation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XAssociation</em>'.
	 * @generated
	 */
	XAssociation createXAssociation();

	/**
	 * Returns a new object of class '<em>XMember</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XMember</em>'.
	 * @generated
	 */
	XMember createXMember();

	/**
	 * Returns a new object of class '<em>XRealization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XRealization</em>'.
	 * @generated
	 */
	XRealization createXRealization();

	/**
	 * Returns a new object of class '<em>XGeneralization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XGeneralization</em>'.
	 * @generated
	 */
	XGeneralization createXGeneralization();

	/**
	 * Returns a new object of class '<em>XEnumerator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XEnumerator</em>'.
	 * @generated
	 */
	XEnumerator createXEnumerator();

	/**
	 * Returns a new object of class '<em>XEnum Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XEnum Value</em>'.
	 * @generated
	 */
	XEnumValue createXEnumValue();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DomainPackage getDomainPackage();

} //DomainFactory
