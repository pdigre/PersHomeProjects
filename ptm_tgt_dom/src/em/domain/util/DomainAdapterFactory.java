/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package em.domain.util;

import em.domain.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see em.domain.DomainPackage
 * @generated
 */
public class DomainAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DomainPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DomainPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainSwitch<Adapter> modelSwitch =
		new DomainSwitch<Adapter>() {
			@Override
			public Adapter caseXClazz(XClazz object) {
				return createXClazzAdapter();
			}
			@Override
			public Adapter caseXConverter(XConverter object) {
				return createXConverterAdapter();
			}
			@Override
			public Adapter caseXInterfaze(XInterfaze object) {
				return createXInterfazeAdapter();
			}
			@Override
			public Adapter caseXGroup(XGroup object) {
				return createXGroupAdapter();
			}
			@Override
			public Adapter caseXAssociation(XAssociation object) {
				return createXAssociationAdapter();
			}
			@Override
			public Adapter caseXMember(XMember object) {
				return createXMemberAdapter();
			}
			@Override
			public Adapter caseXRealization(XRealization object) {
				return createXRealizationAdapter();
			}
			@Override
			public Adapter caseXGeneralization(XGeneralization object) {
				return createXGeneralizationAdapter();
			}
			@Override
			public Adapter caseXEnumerator(XEnumerator object) {
				return createXEnumeratorAdapter();
			}
			@Override
			public Adapter caseXEnumValue(XEnumValue object) {
				return createXEnumValueAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link em.domain.XClazz <em>XClazz</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see em.domain.XClazz
	 * @generated
	 */
	public Adapter createXClazzAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link em.domain.XConverter <em>XConverter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see em.domain.XConverter
	 * @generated
	 */
	public Adapter createXConverterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link em.domain.XInterfaze <em>XInterfaze</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see em.domain.XInterfaze
	 * @generated
	 */
	public Adapter createXInterfazeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link em.domain.XGroup <em>XGroup</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see em.domain.XGroup
	 * @generated
	 */
	public Adapter createXGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link em.domain.XAssociation <em>XAssociation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see em.domain.XAssociation
	 * @generated
	 */
	public Adapter createXAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link em.domain.XMember <em>XMember</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see em.domain.XMember
	 * @generated
	 */
	public Adapter createXMemberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link em.domain.XRealization <em>XRealization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see em.domain.XRealization
	 * @generated
	 */
	public Adapter createXRealizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link em.domain.XGeneralization <em>XGeneralization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see em.domain.XGeneralization
	 * @generated
	 */
	public Adapter createXGeneralizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link em.domain.XEnumerator <em>XEnumerator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see em.domain.XEnumerator
	 * @generated
	 */
	public Adapter createXEnumeratorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link em.domain.XEnumValue <em>XEnum Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see em.domain.XEnumValue
	 * @generated
	 */
	public Adapter createXEnumValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DomainAdapterFactory
