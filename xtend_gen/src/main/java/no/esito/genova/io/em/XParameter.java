package no.esito.genova.io.em;

import no.esito.genova.model.classmodel.QParameter;

public class XParameter extends XObject {

    public XParameter(QParameter go, XAbstract parent) {
        super(parent, go);
    }

    @Override
    public Object get(String name) {
        if ("ModelType".equals(name))
            return go.getProperty(QParameter.Property.MODEL_TYPE);
        if ("ModelTypeIsJavaPrimitive".equals(name))
            return isJavaPrimitive((String) go.getProperty(QParameter.Property.MODEL_TYPE));
        return super.get(name);
    }

}
