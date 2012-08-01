/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package em.domain.impl;

import em.domain.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DomainFactoryImpl extends EFactoryImpl implements DomainFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DomainFactory init() {
		try {
			DomainFactory theDomainFactory = (DomainFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.esito.no/no/esito/genova/em/domain.ecore"); 
			if (theDomainFactory != null) {
				return theDomainFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DomainFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DomainPackage.XCLAZZ: return createXClazz();
			case DomainPackage.XCONVERTER: return createXConverter();
			case DomainPackage.XINTERFAZE: return createXInterfaze();
			case DomainPackage.XGROUP: return createXGroup();
			case DomainPackage.XASSOCIATION: return createXAssociation();
			case DomainPackage.XMEMBER: return createXMember();
			case DomainPackage.XREALIZATION: return createXRealization();
			case DomainPackage.XGENERALIZATION: return createXGeneralization();
			case DomainPackage.XENUMERATOR: return createXEnumerator();
			case DomainPackage.XENUM_VALUE: return createXEnumValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XClazz createXClazz() {
		XClazzImpl xClazz = new XClazzImpl();
		return xClazz;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XConverter createXConverter() {
		XConverterImpl xConverter = new XConverterImpl();
		return xConverter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XInterfaze createXInterfaze() {
		XInterfazeImpl xInterfaze = new XInterfazeImpl();
		return xInterfaze;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XGroup createXGroup() {
		XGroupImpl xGroup = new XGroupImpl();
		return xGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XAssociation createXAssociation() {
		XAssociationImpl xAssociation = new XAssociationImpl();
		return xAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMember createXMember() {
		XMemberImpl xMember = new XMemberImpl();
		return xMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XRealization createXRealization() {
		XRealizationImpl xRealization = new XRealizationImpl();
		return xRealization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XGeneralization createXGeneralization() {
		XGeneralizationImpl xGeneralization = new XGeneralizationImpl();
		return xGeneralization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XEnumerator createXEnumerator() {
		XEnumeratorImpl xEnumerator = new XEnumeratorImpl();
		return xEnumerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XEnumValue createXEnumValue() {
		XEnumValueImpl xEnumValue = new XEnumValueImpl();
		return xEnumValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainPackage getDomainPackage() {
		return (DomainPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DomainPackage getPackage() {
		return DomainPackage.eINSTANCE;
	}

} //DomainFactoryImpl
