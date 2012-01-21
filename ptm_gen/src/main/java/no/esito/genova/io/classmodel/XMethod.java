package no.esito.genova.io.classmodel;

import java.util.List;

import no.esito.genova.io.core.XAbstract;
import no.esito.genova.model.classmodel.QMethod;
import no.esito.genova.model.core.QObject;

public class XMethod extends XObject {

    public XMethod(QMethod go, XAbstract parent) {
        super(parent, go);
    }

    @Override
    public Object get(String name) {
        if ("Abstract".equals(name))
            return go.getProperty(QMethod.Property.ABSTRACT);
        if ("ModelType".equals(name))
            return go.getProperty(QMethod.Property.MODEL_TYPE);
        if ("ModelTypeIsJavaPrimitive".equals(name))
            return isJavaPrimitive((String) go.getProperty(QMethod.Property.MODEL_TYPE));
        if ("Visibility".equals(name))
            return go.getProperty(QMethod.Property.VISIBILITY);
        if ("MappedJavaContainerType".equals(name))
            return go.getProperty(QMethod.Property.DB_PROCEDURE);
        
        return super.get(name);
    }



    @Override
    public <T extends QObject> List<T> iterate(String name) throws Exception {
        if ("Parameter".equals(name))
            return (List<T>) ((QMethod) go).getParameters();
        return super.iterate(name);
    }

}
