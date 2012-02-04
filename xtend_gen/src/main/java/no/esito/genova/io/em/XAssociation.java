package no.esito.genova.io.em;

import java.util.ArrayList;
import java.util.List;

import no.esito.genova.model.classmodel.QAssociation;
import no.esito.genova.model.core.QObject;

public class XAssociation extends XMember {

    public XAssociation(QAssociation go, XAbstract parent) {
        super(parent, go);
    }

    @Override
    public Object get(String name) {
        if ("IsOwnerMany".equals(name))
            return ((QAssociation)go).isOwnerMany();
        if ("IsOwnerMandatory".equals(name))
            return ((QAssociation)go).isOwnerMandatory();
        if ("IsOwnerNavigable".equals(name))
            return go.getProperty(QAssociation.Property.OWNER_NAVIGABLE);
        if ("OwnerClassName".equals(name))
            return ((QAssociation)go).getOwnerClassName();
        if ("OwnerRoleName".equals(name))
            return go.getProperty(QAssociation.Property.OWNER_ROLE);
        
        if ("IsMemberMany".equals(name))
            return ((QAssociation)go).isMemberMany();
        if ("IsMemberMandatory".equals(name))
            return ((QAssociation)go).isMemberMandatory();
        if ("IsMemberNavigable".equals(name))
            return go.getProperty(QAssociation.Property.MEMBER_NAVIGABLE);
        if ("MemberClassName".equals(name))
            return ((QAssociation)go).getMemberClassName();
        if ("MemberRoleName".equals(name))
            return go.getProperty(QAssociation.Property.MEMBER_ROLE);

        return super.get(name);
    }

    @Override
    public <T extends QObject> List<T> iterate(String name) throws Exception {
        if ("Member".equals(name)) {
            ArrayList<QObject> list = new ArrayList<QObject>();
//            list.add(((QAssociation)go).getOwnerClass());
            return (List<T>) list;
        }
        return super.iterate(name);
    }
    @Override
    public XObject getScope(String name) {
        if("OwnerClass".equals(name))
            return new XClass(((QAssociation)go).getOwnerClass(),this);
        if("MemberClass".equals(name))
            return new XClass(((QAssociation)go).getMemberClass(),this);
        return super.getScope(name);
    }

}
