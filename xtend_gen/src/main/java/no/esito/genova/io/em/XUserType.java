package no.esito.genova.io.em;

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
