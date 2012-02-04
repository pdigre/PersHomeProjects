package no.esito.genova.io.classmodel;

import no.esito.genova.io.core.XAbstract;
import no.esito.genova.model.classmodel.QClass;
import no.esito.genova.model.classmodel.QInterface;
import no.esito.genova.model.classmodel.QRealization;

public class XRealization extends XObject {

    public XRealization(QRealization go, XAbstract parent) {
        super(parent, go);
    }

    @Override
    public XObject getScope(String name) {
        if ("Class".equals(name)) {
            QClass clazz = ((QRealization) go).getDomainClass();
            if (clazz != null) 
                return new XClass(clazz, this);
        }
        if ("Interface".equals(name)) {
            QInterface iface = ((QRealization) go).getInterface();
            if (iface != null)
                return new XInterface(iface, this);
        }
        return super.getScope(name);
    }

}
