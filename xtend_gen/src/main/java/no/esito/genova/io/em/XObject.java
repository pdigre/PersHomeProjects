package no.esito.genova.io.em;

import java.util.ArrayList;
import java.util.List;
import no.esito.genova.model.classmodel.QClass;
import no.esito.genova.model.classmodel.QClassModelObject;
import no.esito.genova.model.classmodel.QEnumValue;
import no.esito.genova.model.classmodel.QEnumerator;
import no.esito.genova.model.core.PObject;
import no.esito.genova.model.core.QObject;
import no.esito.genova.model.util.DelimitedList;

public abstract class XObject extends XAbstract {

    public XObject(XAbstract parent, QObject go) {
        super(parent, go);
    }

    @Override
    public Object get(String name) {
        if ("GeneratedWith".equals(name))
            return "Generated with Genova 9 - Fast PTM";
        // if ("HasDescription".equals(name))
        // return go.hasLocalProperty(QObject.Property.DESCRIPTION);
        // if ("Description".equals(name))
        // return go.getLocalProperty(QObject.Property.DESCRIPTION);
        // if ("LogicalPackage".equals(name))
        // return go.getProperty(QClass.Property.LOGICAL_PACKAGE);
        // if ("ComponentPackage".equals(name))
        // return go.getProperty(QClass.Property.COMPONENT_PACKAGE);
        if ("PackageName".equals(name))
            return getModelCategory();
        if ("TypePackageName".equals(name))
            return getModelCategory();
        if ("ModelCategory".equals(name))
            return getModelCategory();
        if ("MemberType".equals(name))
            return go.getMetaObjectName();
        if ("NodeType".equals(name))
            return getName();

        if ("JavaContainer".equals(name))
            return "Trygve";
        if ("IsJavaContainer".equals(name))
            return true;

        if (name.startsWith("Count"))
            try {
                return iterate(name.substring(5)).size();
            } catch (Exception e) {
                e.printStackTrace();
            }

        PObject gp = go.getPropertyKey(name);
        if (gp != null)
            return go.getProperty(gp);
        if (name.startsWith("Has")) {
            gp = go.getPropertyKey(name.substring(3));
            if (gp != null) {
                String val = go.getLocalProperty(gp);
                return val!=null && !val.isEmpty();
            }
        }
        if (name.startsWith("Is")) {
            gp = go.getPropertyKey(name.substring(2));
            if (gp != null)
                return go.getProperty(gp);
        }
        return super.get(name);
    }

    public boolean isJavaPrimitive(String name) {
        return new DelimitedList(",", "boolean,byte,short,int,long,char,float,double").contains(name);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends QObject> List<T> iterate(String name) throws Exception {
        if ("EnumValue".equals(name)) {
            QEnumerator enumerator = ((QClassModelObject) go).getEnumerator();
            if (enumerator == null)
                return new ArrayList<T>();
            return (List<T>) enumerator.getChildren(QEnumValue.class);
        }
        if ("Member".equals(name))
            return new ArrayList<T>();
        return null;
    }

    public Object getModelCategory() {
        PObject gp = go.getPropertyKey(QClass.Property.LOGICAL_PACKAGE);
        if (gp != null)
            return go.getProperty(gp);
        return ((XObject) getParent()).getModelCategory();
    }

}
