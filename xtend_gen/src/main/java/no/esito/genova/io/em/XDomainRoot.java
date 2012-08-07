package no.esito.genova.io.em;

import java.util.ArrayList;
import java.util.List;

import no.esito.genova.model.classmodel.QClassModelRoot;
import no.esito.genova.model.classmodel.QConverter;
import no.esito.genova.model.classmodel.QUserType;
import no.esito.genova.model.core.QObject;

public class XDomainRoot extends XObject {

    private ArrayList<QObject> clz;
    private ArrayList<QObject> ifc;
    private ArrayList<QObject> enm;

    public XDomainRoot(QClassModelRoot go, ArrayList<QObject> clz, ArrayList<QObject> ifc, ArrayList<QObject> enm) {
        super(null,go);
        this.clz=clz;
        this.ifc=ifc;
        this.enm=enm;
    }

    @Override
    public Object get(String name) {
        if("TransportDirectory".equals(name))
            return name;
        if("ConverterDirectory".equals(name))
            return name;
        if("CastorMappingDirectory".equals(name))
            return name;
        if("MappingDirectory".equals(name))
            return name;
        if("WebDirectory".equals(name))
            return name;
        if("PrintDirectory".equals(name))
            return name;
        if("ConfigDirectory".equals(name))
            return name;
        if("GeneratedPackage".equals(name))
            return name;
        if("SuppressAllWarnings".equals(name))
            return true;

        return super.get(name);
    }

    @Override
    public <T extends QObject> List<T> iterate(String name) throws Exception {
        if ("Class".equals(name))
            return (List<T>) clz;
        if ("Interface".equals(name))
            return (List<T>) ifc;
        if ("Enumerator".equals(name))
            return (List<T>) enm;
        if ("Domain".equals(name))
            return (List<T>) ((QClassModelRoot)go).getModelChildren(QUserType.class);
        if ("Converter".equals(name))
            return (List<T>) ((QClassModelRoot)go).getModelChildren(QConverter.class);
        return super.iterate(name);
    }
}
