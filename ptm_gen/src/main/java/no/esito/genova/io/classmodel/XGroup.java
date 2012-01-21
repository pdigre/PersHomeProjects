package no.esito.genova.io.classmodel;

import java.util.List;

import no.esito.genova.io.core.XAbstract;
import no.esito.genova.model.classmodel.QGroup;
import no.esito.genova.model.core.QObject;

public class XGroup extends XMember {

    public XGroup(QGroup go, XAbstract parent) {
        super(parent, go);
    }

    @Override
    public Object get(String name) {
        if ("IsPrimaryKey".equals(name))
            return go.getProperty(QGroup.Property.PRIMARY_KEY);
        if("IsDefaultDomainKey".equals(name))
            return go.getProperty(QGroup.Property.DEFAULT_DOMAIN_KEY);
        
        return super.get(name);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends QObject> List<T> iterate(String name) throws Exception {
        if ("Member".equals(name))
            return (List<T>) ((QGroup) go).getMembers();
        return super.iterate(name);
    }
}
