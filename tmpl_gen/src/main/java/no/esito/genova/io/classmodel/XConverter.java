package no.esito.genova.io.classmodel;

import no.esito.genova.io.core.XAbstract;
import no.esito.genova.model.classmodel.QConverter;

public class XConverter extends XObject {

    public XConverter(QConverter go, XAbstract parent) {
        super(parent, go);
    }

    @Override
    public Object get(String name) {
        if ("ModelType".equals(name))
            return go.getProperty(QConverter.Property.MODEL_TYPE);
        if ("ModelTypeIsJavaPrimitive".equals(name))
            return isJavaPrimitive((String) go.getProperty(QConverter.Property.MODEL_TYPE));
        return super.get(name);
    }

}
