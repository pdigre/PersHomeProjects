package no.esito.genova.io.em;

import java.util.List;

import no.esito.genova.model.classmodel.QEnumValue;
import no.esito.genova.model.classmodel.QEnumerator;
import no.esito.genova.model.core.QObject;

public class XEnumerator extends XObject {

    public XEnumerator(QEnumerator go,XAbstract parent) {
        super(parent,go);
        this.go = go;
    }
    @SuppressWarnings("unchecked")
    @Override
    public <T extends QObject> List<T> iterate(String name) throws Exception {
        if ("EnumValue".equals(name)) {
            return (List<T>) go.getChildren(QEnumValue.class);
        }
        return null;
    }

}
