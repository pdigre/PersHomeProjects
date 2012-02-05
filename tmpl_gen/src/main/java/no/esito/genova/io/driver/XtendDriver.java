package no.esito.genova.io.driver;

import no.esito.genova.io.generator.IGeneratorEngine;
import no.esito.genova.io.sync.ISyncEngine;
import no.esito.genova.io.util.IModelUpdateEngine;
import no.esito.genova.model.core.ModelManager;

public class XtendDriver implements IDriver, IBuilder {

    private XtendEngine engine;

    public XtendDriver() {
        super();
    }

    @Override
    public IGeneratorEngine getGeneratorEngine(ModelManager mm) {
        return getPTMEngine(mm);
    }

    /**
     * @param mm
     * @return
     */
    private XtendEngine getPTMEngine(ModelManager mm) {
        if (engine == null){
            engine = new XtendEngine();
            engine.setModelManager(mm);
        }
        return engine;
    }

    @Override
    public IModelUpdateEngine getModelUpdateEngine(ModelManager mm) {
        return null;
    }

    @Override
    public ISyncEngine getSyncEngine(ModelManager mm) {
        return null;
    }

    @Override
    public void build(Object[] objarray) {
    }

    @Override
    public String getJarFolder() {
        return XtendPlugin.getDefault().getSystemArea();
    }

    @Override
    public void closeGeneratorEngine(ModelManager mm) {
        // TODO Auto-generated method stub
        
    }

}
