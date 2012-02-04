package no.esito.genova.io.classmodel;

import no.esito.genova.io.core.XAbstract;
import no.esito.genova.model.classmodel.QAttribute;
import no.esito.genova.model.classmodel.QConverter;

public class XAttribute extends XMember {

    public XAttribute(QAttribute go, XAbstract parent) {
        super(parent, go);
    }

    @Override
    public Object get(String name) {
        if ("StartRoleNamePath".equals(name))
            return ((QAttribute)go).getDomainClass().getName();
        if ("RestRoleNamePath".equals(name))
            return ((QAttribute)go).getDomainClass().getName();
        if("IsPrimaryKey".equals(name))
            return go.getProperty(QAttribute.Property.PRIMARY_KEY);
        if("IsDefaultDomainKey".equals(name))
            return go.getProperty(QAttribute.Property.DEFAULT_DOMAIN_KEY);
        if("Visibility".equals(name))
            return go.getProperty(QAttribute.Property.VISIBILITY);
        if("IsStatic".equals(name))
            return go.getProperty(QAttribute.Property.STATIC);
        if ("ModelTypeIsJavaPrimitive".equals(name))
            return isJavaPrimitive((String) go.getProperty(QAttribute.Property.MODEL_TYPE));
        if("ModelType".equals(name))
            return go.getProperty(QAttribute.Property.MODEL_TYPE);
        if("MappedModelType".equals(name))
            return go.getProperty(QAttribute.Property.MODEL_TYPE);
        if("HasInitialValue".equals(name))
            return go.hasLocalProperty(QAttribute.Property.INITIAL_VALUE);
        if("InitialValue".equals(name))
            return go.getLocalProperty(QAttribute.Property.INITIAL_VALUE);

        return super.get(name);
    }

    @Override
    public XObject getScope(String name) {
        if ("Converter".equals(name))
            return new XConverter((QConverter) ((QAttribute) go).getConverter(), this);
        return super.getScope(name);
    }

}
