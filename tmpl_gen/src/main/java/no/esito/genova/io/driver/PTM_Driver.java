package no.esito.genova.io.driver;

import no.esito.genova.io.generator.IGeneratorEngine;
import no.esito.genova.io.generator.TMPL_Engine;
import no.esito.genova.io.sync.ISyncEngine;
import no.esito.genova.io.util.IModelUpdateEngine;
import no.esito.genova.model.core.ModelManager;

public class PTM_Driver implements IDriver, IBuilder {

    private TMPL_Engine engine;

    public PTM_Driver() {
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
    private TMPL_Engine getPTMEngine(ModelManager mm) {
        if (engine == null){
            engine = new TMPL_Engine();
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
        return PTM_Plugin.getDefault().getSystemArea();
    }

    @Override
    public void closeGeneratorEngine(ModelManager mm) {
        // TODO Auto-generated method stub
        
    }

}
