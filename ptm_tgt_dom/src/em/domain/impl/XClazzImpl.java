/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package em.domain.impl;

import em.domain.DomainPackage;
import em.domain.XClazz;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XClazz</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link em.domain.impl.XClazzImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link em.domain.impl.XClazzImpl#getDefaultDomainKey <em>Default Domain Key</em>}</li>
 *   <li>{@link em.domain.impl.XClazzImpl#isImplementSerializable <em>Implement Serializable</em>}</li>
 *   <li>{@link em.domain.impl.XClazzImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link em.domain.impl.XClazzImpl#isIsPersistent <em>Is Persistent</em>}</li>
 *   <li>{@link em.domain.impl.XClazzImpl#getMethods <em>Methods</em>}</li>
 *   <li>{@link em.domain.impl.XClazzImpl#isMethodVisibility <em>Method Visibility</em>}</li>
 *   <li>{@link em.domain.impl.XClazzImpl#getName <em>Name</em>}</li>
 *   <li>{@link em.domain.impl.XClazzImpl#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link em.domain.impl.XClazzImpl#getPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link em.domain.impl.XClazzImpl#isSerializable <em>Serializable</em>}</li>
 *   <li>{@link em.domain.impl.XClazzImpl#getSubImports <em>Sub Imports</em>}</li>
 *   <li>{@link em.domain.impl.XClazzImpl#getSuperClassName <em>Super Class Name</em>}</li>
 *   <li>{@link em.domain.impl.XClazzImpl#getSuperClassPackage <em>Super Class Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XClazzImpl extends EObjectImpl implements XClazz {
	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultDomainKey() <em>Default Domain Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultDomainKey()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_DOMAIN_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultDomainKey() <em>Default Domain Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultDomainKey()
	 * @generated
	 * @ordered
	 */
	protected String defaultDomainKey = DEFAULT_DOMAIN_KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #isImplementSerializable() <em>Implement Serializable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImplementSerializable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IMPLEMENT_SERIALIZABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isImplementSerializable() <em>Implement Serializable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImplementSerializable()
	 * @generated
	 * @ordered
	 */
	protected boolean implementSerializable = IMPLEMENT_SERIALIZABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getImports() <em>Imports</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPORTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected String imports = IMPORTS_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsPersistent() <em>Is Persistent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPersistent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PERSISTENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsPersistent() <em>Is Persistent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPersistent()
	 * @generated
	 * @ordered
	 */
	protected boolean isPersistent = IS_PERSISTENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMethods() <em>Methods</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
	protected static final String METHODS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMethods() <em>Methods</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
	protected String methods = METHODS_EDEFAULT;

	/**
	 * The default value of the '{@link #isMethodVisibility() <em>Method Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMethodVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final boolean METHOD_VISIBILITY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMethodVisibility() <em>Method Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMethodVisibility()
	 * @generated
	 * @ordered
	 */
	protected boolean methodVisibility = METHOD_VISIBILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageName()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageName()
	 * @generated
	 * @ordered
	 */
	protected String packageName = PACKAGE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrimaryKey() <em>Primary Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryKey()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMARY_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimaryKey() <em>Primary Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryKey()
	 * @generated
	 * @ordered
	 */
	protected String primaryKey = PRIMARY_KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #isSerializable() <em>Serializable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSerializable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SERIALIZABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSerializable() <em>Serializable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSerializable()
	 * @generated
	 * @ordered
	 */
	protected boolean serializable = SERIALIZABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubImports() <em>Sub Imports</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubImports()
	 * @generated
	 * @ordered
	 */
	protected static final String SUB_IMPORTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubImports() <em>Sub Imports</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubImports()
	 * @generated
	 * @ordered
	 */
	protected String subImports = SUB_IMPORTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuperClassName() <em>Super Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String SUPER_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuperClassName() <em>Super Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperClassName()
	 * @generated
	 * @ordered
	 */
	protected String superClassName = SUPER_CLASS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuperClassPackage() <em>Super Class Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperClassPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String SUPER_CLASS_PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuperClassPackage() <em>Super Class Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperClassPackage()
	 * @generated
	 * @ordered
	 */
	protected String superClassPackage = SUPER_CLASS_PACKAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XClazzImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomainPackage.Literals.XCLAZZ;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.XCLAZZ__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultDomainKey() {
		return defaultDomainKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultDomainKey(String newDefaultDomainKey) {
		String oldDefaultDomainKey = defaultDomainKey;
		defaultDomainKey = newDefaultDomainKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.XCLAZZ__DEFAULT_DOMAIN_KEY, oldDefaultDomainKey, defaultDomainKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImplementSerializable() {
		return implementSerializable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementSerializable(boolean newImplementSerializable) {
		boolean oldImplementSerializable = implementSerializable;
		implementSerializable = newImplementSerializable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.XCLAZZ__IMPLEMENT_SERIALIZABLE, oldImplementSerializable, implementSerializable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImports() {
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImports(String newImports) {
		String oldImports = imports;
		imports = newImports;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.XCLAZZ__IMPORTS, oldImports, imports));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsPersistent() {
		return isPersistent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsPersistent(boolean newIsPersistent) {
		boolean oldIsPersistent = isPersistent;
		isPersistent = newIsPersistent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.XCLAZZ__IS_PERSISTENT, oldIsPersistent, isPersistent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMethods() {
		return methods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethods(String newMethods) {
		String oldMethods = methods;
		methods = newMethods;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.XCLAZZ__METHODS, oldMethods, methods));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMethodVisibility() {
		return methodVisibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodVisibility(boolean newMethodVisibility) {
		boolean oldMethodVisibility = methodVisibility;
		methodVisibility = newMethodVisibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.XCLAZZ__METHOD_VISIBILITY, oldMethodVisibility, methodVisibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.XCLAZZ__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackageName(String newPackageName) {
		String oldPackageName = packageName;
		packageName = newPackageName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.XCLAZZ__PACKAGE_NAME, oldPackageName, packageName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrimaryKey() {
		return primaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryKey(String newPrimaryKey) {
		String oldPrimaryKey = primaryKey;
		primaryKey = newPrimaryKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.XCLAZZ__PRIMARY_KEY, oldPrimaryKey, primaryKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSerializable() {
		return serializable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSerializable(boolean newSerializable) {
		boolean oldSerializable = serializable;
		serializable = newSerializable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.XCLAZZ__SERIALIZABLE, oldSerializable, serializable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubImports() {
		return subImports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubImports(String newSubImports) {
		String oldSubImports = subImports;
		subImports = newSubImports;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.XCLAZZ__SUB_IMPORTS, oldSubImports, subImports));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSuperClassName() {
		return superClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperClassName(String newSuperClassName) {
		String oldSuperClassName = superClassName;
		superClassName = newSuperClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.XCLAZZ__SUPER_CLASS_NAME, oldSuperClassName, superClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSuperClassPackage() {
		return superClassPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperClassPackage(String newSuperClassPackage) {
		String oldSuperClassPackage = superClassPackage;
		superClassPackage = newSuperClassPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainPackage.XCLAZZ__SUPER_CLASS_PACKAGE, oldSuperClassPackage, superClassPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<?> iterateAssociation() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<?> iterateAttribute() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<?> iterateGeneralization() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<?> iterateGroup() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<?> iterateMethod() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<?> iterateRealization() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DomainPackage.XCLAZZ__ABSTRACT:
				return isAbstract();
			case DomainPackage.XCLAZZ__DEFAULT_DOMAIN_KEY:
				return getDefaultDomainKey();
			case DomainPackage.XCLAZZ__IMPLEMENT_SERIALIZABLE:
				return isImplementSerializable();
			case DomainPackage.XCLAZZ__IMPORTS:
				return getImports();
			case DomainPackage.XCLAZZ__IS_PERSISTENT:
				return isIsPersistent();
			case DomainPackage.XCLAZZ__METHODS:
				return getMethods();
			case DomainPackage.XCLAZZ__METHOD_VISIBILITY:
				return isMethodVisibility();
			case DomainPackage.XCLAZZ__NAME:
				return getName();
			case DomainPackage.XCLAZZ__PACKAGE_NAME:
				return getPackageName();
			case DomainPackage.XCLAZZ__PRIMARY_KEY:
				return getPrimaryKey();
			case DomainPackage.XCLAZZ__SERIALIZABLE:
				return isSerializable();
			case DomainPackage.XCLAZZ__SUB_IMPORTS:
				return getSubImports();
			case DomainPackage.XCLAZZ__SUPER_CLASS_NAME:
				return getSuperClassName();
			case DomainPackage.XCLAZZ__SUPER_CLASS_PACKAGE:
				return getSuperClassPackage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DomainPackage.XCLAZZ__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case DomainPackage.XCLAZZ__DEFAULT_DOMAIN_KEY:
				setDefaultDomainKey((String)newValue);
				return;
			case DomainPackage.XCLAZZ__IMPLEMENT_SERIALIZABLE:
				setImplementSerializable((Boolean)newValue);
				return;
			case DomainPackage.XCLAZZ__IMPORTS:
				setImports((String)newValue);
				return;
			case DomainPackage.XCLAZZ__IS_PERSISTENT:
				setIsPersistent((Boolean)newValue);
				return;
			case DomainPackage.XCLAZZ__METHODS:
				setMethods((String)newValue);
				return;
			case DomainPackage.XCLAZZ__METHOD_VISIBILITY:
				setMethodVisibility((Boolean)newValue);
				return;
			case DomainPackage.XCLAZZ__NAME:
				setName((String)newValue);
				return;
			case DomainPackage.XCLAZZ__PACKAGE_NAME:
				setPackageName((String)newValue);
				return;
			case DomainPackage.XCLAZZ__PRIMARY_KEY:
				setPrimaryKey((String)newValue);
				return;
			case DomainPackage.XCLAZZ__SERIALIZABLE:
				setSerializable((Boolean)newValue);
				return;
			case DomainPackage.XCLAZZ__SUB_IMPORTS:
				setSubImports((String)newValue);
				return;
			case DomainPackage.XCLAZZ__SUPER_CLASS_NAME:
				setSuperClassName((String)newValue);
				return;
			case DomainPackage.XCLAZZ__SUPER_CLASS_PACKAGE:
				setSuperClassPackage((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DomainPackage.XCLAZZ__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case DomainPackage.XCLAZZ__DEFAULT_DOMAIN_KEY:
				setDefaultDomainKey(DEFAULT_DOMAIN_KEY_EDEFAULT);
				return;
			case DomainPackage.XCLAZZ__IMPLEMENT_SERIALIZABLE:
				setImplementSerializable(IMPLEMENT_SERIALIZABLE_EDEFAULT);
				return;
			case DomainPackage.XCLAZZ__IMPORTS:
				setImports(IMPORTS_EDEFAULT);
				return;
			case DomainPackage.XCLAZZ__IS_PERSISTENT:
				setIsPersistent(IS_PERSISTENT_EDEFAULT);
				return;
			case DomainPackage.XCLAZZ__METHODS:
				setMethods(METHODS_EDEFAULT);
				return;
			case DomainPackage.XCLAZZ__METHOD_VISIBILITY:
				setMethodVisibility(METHOD_VISIBILITY_EDEFAULT);
				return;
			case DomainPackage.XCLAZZ__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DomainPackage.XCLAZZ__PACKAGE_NAME:
				setPackageName(PACKAGE_NAME_EDEFAULT);
				return;
			case DomainPackage.XCLAZZ__PRIMARY_KEY:
				setPrimaryKey(PRIMARY_KEY_EDEFAULT);
				return;
			case DomainPackage.XCLAZZ__SERIALIZABLE:
				setSerializable(SERIALIZABLE_EDEFAULT);
				return;
			case DomainPackage.XCLAZZ__SUB_IMPORTS:
				setSubImports(SUB_IMPORTS_EDEFAULT);
				return;
			case DomainPackage.XCLAZZ__SUPER_CLASS_NAME:
				setSuperClassName(SUPER_CLASS_NAME_EDEFAULT);
				return;
			case DomainPackage.XCLAZZ__SUPER_CLASS_PACKAGE:
				setSuperClassPackage(SUPER_CLASS_PACKAGE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DomainPackage.XCLAZZ__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case DomainPackage.XCLAZZ__DEFAULT_DOMAIN_KEY:
				return DEFAULT_DOMAIN_KEY_EDEFAULT == null ? defaultDomainKey != null : !DEFAULT_DOMAIN_KEY_EDEFAULT.equals(defaultDomainKey);
			case DomainPackage.XCLAZZ__IMPLEMENT_SERIALIZABLE:
				return implementSerializable != IMPLEMENT_SERIALIZABLE_EDEFAULT;
			case DomainPackage.XCLAZZ__IMPORTS:
				return IMPORTS_EDEFAULT == null ? imports != null : !IMPORTS_EDEFAULT.equals(imports);
			case DomainPackage.XCLAZZ__IS_PERSISTENT:
				return isPersistent != IS_PERSISTENT_EDEFAULT;
			case DomainPackage.XCLAZZ__METHODS:
				return METHODS_EDEFAULT == null ? methods != null : !METHODS_EDEFAULT.equals(methods);
			case DomainPackage.XCLAZZ__METHOD_VISIBILITY:
				return methodVisibility != METHOD_VISIBILITY_EDEFAULT;
			case DomainPackage.XCLAZZ__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DomainPackage.XCLAZZ__PACKAGE_NAME:
				return PACKAGE_NAME_EDEFAULT == null ? packageName != null : !PACKAGE_NAME_EDEFAULT.equals(packageName);
			case DomainPackage.XCLAZZ__PRIMARY_KEY:
				return PRIMARY_KEY_EDEFAULT == null ? primaryKey != null : !PRIMARY_KEY_EDEFAULT.equals(primaryKey);
			case DomainPackage.XCLAZZ__SERIALIZABLE:
				return serializable != SERIALIZABLE_EDEFAULT;
			case DomainPackage.XCLAZZ__SUB_IMPORTS:
				return SUB_IMPORTS_EDEFAULT == null ? subImports != null : !SUB_IMPORTS_EDEFAULT.equals(subImports);
			case DomainPackage.XCLAZZ__SUPER_CLASS_NAME:
				return SUPER_CLASS_NAME_EDEFAULT == null ? superClassName != null : !SUPER_CLASS_NAME_EDEFAULT.equals(superClassName);
			case DomainPackage.XCLAZZ__SUPER_CLASS_PACKAGE:
				return SUPER_CLASS_PACKAGE_EDEFAULT == null ? superClassPackage != null : !SUPER_CLASS_PACKAGE_EDEFAULT.equals(superClassPackage);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (Abstract: ");
		result.append(abstract_);
		result.append(", DefaultDomainKey: ");
		result.append(defaultDomainKey);
		result.append(", ImplementSerializable: ");
		result.append(implementSerializable);
		result.append(", Imports: ");
		result.append(imports);
		result.append(", IsPersistent: ");
		result.append(isPersistent);
		result.append(", Methods: ");
		result.append(methods);
		result.append(", MethodVisibility: ");
		result.append(methodVisibility);
		result.append(", Name: ");
		result.append(name);
		result.append(", PackageName: ");
		result.append(packageName);
		result.append(", PrimaryKey: ");
		result.append(primaryKey);
		result.append(", Serializable: ");
		result.append(serializable);
		result.append(", SubImports: ");
		result.append(subImports);
		result.append(", SuperClassName: ");
		result.append(superClassName);
		result.append(", SuperClassPackage: ");
		result.append(superClassPackage);
		result.append(')');
		return result.toString();
	}

} //XClazzImpl
