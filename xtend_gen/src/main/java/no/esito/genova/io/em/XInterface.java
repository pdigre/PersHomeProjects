package no.esito.genova.io.em;

import java.util.List;

import no.esito.genova.model.classmodel.QInterface;
import no.esito.genova.model.core.QObject;

public class XInterface extends XObject {

    public XInterface(QInterface go, XAbstract parent) {
        super(parent,go);
    }

    @Override
    public Object get(String name) {
        if ("Visibility".equals(name))
            return go.getProperty(QInterface.Property.VISIBILITY);
        return super.get(name);
    }

    @Override
    public <T extends QObject> List<T> iterate(String name) throws Exception {
        if ("Attribute".equals(name))
            return (List<T>) ((QInterface) go).getAttributes();
        if ("Method".equals(name))
            return (List<T>) ((QInterface) go).getMethods();
        if ("Generalization".equals(name))
            return (List<T>) ((QInterface) go).getGeneralizations();
        return super.iterate(name);
    }
}
