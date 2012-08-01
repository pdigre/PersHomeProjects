/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package em.domain.util;

import em.domain.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see em.domain.DomainPackage
 * @generated
 */
public class DomainSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DomainPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainSwitch() {
		if (modelPackage == null) {
			modelPackage = DomainPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DomainPackage.XCLAZZ: {
				XClazz xClazz = (XClazz)theEObject;
				T result = caseXClazz(xClazz);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomainPackage.XCONVERTER: {
				XConverter xConverter = (XConverter)theEObject;
				T result = caseXConverter(xConverter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomainPackage.XINTERFAZE: {
				XInterfaze xInterfaze = (XInterfaze)theEObject;
				T result = caseXInterfaze(xInterfaze);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomainPackage.XGROUP: {
				XGroup xGroup = (XGroup)theEObject;
				T result = caseXGroup(xGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomainPackage.XASSOCIATION: {
				XAssociation xAssociation = (XAssociation)theEObject;
				T result = caseXAssociation(xAssociation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomainPackage.XMEMBER: {
				XMember xMember = (XMember)theEObject;
				T result = caseXMember(xMember);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomainPackage.XREALIZATION: {
				XRealization xRealization = (XRealization)theEObject;
				T result = caseXRealization(xRealization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomainPackage.XGENERALIZATION: {
				XGeneralization xGeneralization = (XGeneralization)theEObject;
				T result = caseXGeneralization(xGeneralization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomainPackage.XENUMERATOR: {
				XEnumerator xEnumerator = (XEnumerator)theEObject;
				T result = caseXEnumerator(xEnumerator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DomainPackage.XENUM_VALUE: {
				XEnumValue xEnumValue = (XEnumValue)theEObject;
				T result = caseXEnumValue(xEnumValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XClazz</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XClazz</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXClazz(XClazz object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XConverter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XConverter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXConverter(XConverter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XInterfaze</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XInterfaze</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXInterfaze(XInterfaze object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XGroup</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XGroup</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXGroup(XGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XAssociation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XAssociation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXAssociation(XAssociation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XMember</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XMember</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXMember(XMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XRealization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XRealization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXRealization(XRealization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XGeneralization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XGeneralization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXGeneralization(XGeneralization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XEnumerator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XEnumerator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXEnumerator(XEnumerator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XEnum Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XEnum Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXEnumValue(XEnumValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //DomainSwitch
