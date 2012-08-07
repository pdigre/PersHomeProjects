package no.esito.genova.io.em;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

import no.esito.genova.model.core.QObject;
import no.esito.genova.model.util.DelimitedList;

public class XAbstract {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    private XAbstract parent;

    private HashMap<String, Object> values = new HashMap<String, Object>();

    public QObject go;

    public XAbstract getParent() {
        return parent;
    }

    public XAbstract(XAbstract parent, QObject go) {
        this.parent = parent;
        this.go = go;
        if (go == null)
            System.out.println("Error");
    }

    public String getName() {
        return name;
    }

    public Object get(String name) {
        if (parent != null)
            return parent.get(name);
        return null;
    }

    public <T extends QObject> List<T> iterate(String name) throws Exception {
        return (List<T>) (parent == null ? new ArrayList<T>() : parent.iterate(name));
    }

    public void setVariable(String name, ArrayList<String> array, Object value) {
        if (array.size() == 0) {
            values.put(name, value);
            return;
        }
        String key = new DelimitedList(",", array).toString();
        Object object = values.get(name);
        if (!(object instanceof TreeMap)) {
            values.put(name, new TreeMap<String, Object>());
        }
        TreeMap<String, Object> hash = (TreeMap<String, Object>) values.get(name);
        hash.put(key, value);
    }

    public Object getVariable(String name, ArrayList<String> array) {
        Object val = values.get(name);
        if (val == null) {
            if (parent == null)
                return parent.getVariable(name, array);
            return null;

        }
        if (array.size() == 0)
            return val;
        String key = new DelimitedList(",", array).toString();
        TreeMap<String, Object> hash = (TreeMap<String, Object>) val;
        NavigableMap<String, Object> map = hash.subMap(key, true, key, true);
        if (map.size() == 0) {
//            System.out.println("null");
            return null;
        }
        return map.firstEntry().getValue();
    }

    public Object getAttribute(String name, List<String> list) throws Exception {
        if ("Name".equals(name))
            return getGO().getName();
        if ("IsLast".equals(name)) {
            List<QObject> bunch = getParent().iterate(getName());
            return bunch.get(0).equals(getGO());
        }
        if ("IsFirst".equals(name)) {
            List<QObject> bunch = getParent().iterate(getName());
            return bunch.get(bunch.size() - 1).equals(getGO());
        }
        Object object = get(name);
        // Process array options
        if (object != null)
            return object;
        return null;
    }

    public QObject getGO() {
        return go;
    }

    public XObject getScope(String name) {
        if (name == null)
            return (XObject) this;
        if ("TopParent".equals(name))
            return (XObject) (parent == null ? this : parent.getScope(name));
        if ("Parent".equals(name))
            return (XObject) parent;
        if (name.equals(getName()))
            return (XObject) this;
        if (parent != null)
            return parent.getScope(name);
        return null;
    }

}
