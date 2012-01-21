package no.esito.genova.io.classmodel;

import no.esito.genova.io.core.XAbstract;
import no.esito.genova.model.classmodel.QClass;
import no.esito.genova.model.classmodel.QGeneralization;
import no.esito.genova.model.classmodel.QInheritObject;

public class XGeneralization extends XObject {

    public XGeneralization(QGeneralization go, XAbstract parent) {
        super(parent, go);
        this.go = go;
    }

    @Override
    public XObject getScope(String name) {
        if ("SuperClass".equals(name))
            return new XClass((QClass) ((QGeneralization) go).getSuperObject(), this);
        if ("SubClass".equals(name)) {
            QInheritObject subObject = ((QGeneralization) go).getSubObject();
            if (subObject != null)
                return new XClass((QClass) subObject, this);
        }
        return super.getScope(name);
    }

}
