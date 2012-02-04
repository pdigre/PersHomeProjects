package no.esito.genova.io.classmodel;

import no.esito.genova.io.core.XAbstract;
import no.esito.genova.model.classmodel.QUserType;

public class XUserType extends XObject {

    public XUserType(QUserType go, XAbstract parent) {
        super(parent, go);
    }

    @Override
    public XObject getScope(String name) {
        if ("Converter".equals(name)) {
            return this;
//            return ((QUserType) go).getcon;
        }
        return super.getScope(name);
    }
}
