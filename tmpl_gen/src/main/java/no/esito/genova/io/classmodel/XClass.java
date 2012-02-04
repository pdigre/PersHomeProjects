package no.esito.genova.io.classmodel;

import java.util.ArrayList;
import java.util.List;

import no.esito.genova.io.core.XAbstract;
import no.esito.genova.model.classmodel.QAttribute;
import no.esito.genova.model.classmodel.QClass;
import no.esito.genova.model.classmodel.QEnumerator;
import no.esito.genova.model.classmodel.QMethod;
import no.esito.genova.model.core.QObject;

public class XClass extends XObject {

    public XClass(QClass go, XAbstract parent) {
        super(parent, go);
    }

    @Override
    public Object get(String name) {
        if("IsPersistent".equals(name))
            return go.getProperty(QClass.Property.PERSISTENT);
        if ("Abstract".equals(name))
            return go.getProperty(QClass.Property.ABSTRACT);
        if ("ModelType".equals(name))
            return go.getProperty(QMethod.Property.MODEL_TYPE);
        if ("Visibility".equals(name))
            return go.getProperty(QClass.Property.VISIBILITY);
        return super.get(name);
    }

    @Override
    public <T extends QObject> List<T> iterate(String name) throws Exception {
        if ("Attribute".equals(name))
            return (List<T>) ((QClass) go).getAttributes();
        if ("Enumerator".equals(name)) {
            ArrayList<QEnumerator> list = new ArrayList<QEnumerator>();
            for (QAttribute att : ((QClass) go).getAttributes()) {
                QEnumerator enumerator = att.getEnumerator();
                if(enumerator!=null)
                    list.add(enumerator);
            }
            return (List<T>) list;
        }
        if ("Group".equals(name))
            return (List<T>) ((QClass) go).getGroups();
        if ("Method".equals(name))
            return (List<T>) ((QClass) go).getMethods();
        if ("Association".equals(name))
            return (List<T>) ((QClass) go).getAssociations();
        if ("Generalization".equals(name))
            return (List<T>) ((QClass) go).getGeneralizations();
        if ("Realization".equals(name))
            return (List<T>) ((QClass) go).getRealizations();
        return super.iterate(name);
    }
}
