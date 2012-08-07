package no.esito.genova.io.driver;

import java.io.File;

import no.esito.genova.io.xml.JarArchive;
import no.esito.genova.model.core.ModelManager;
import no.esito.genova.model.generator.GeneratorModel;
import no.esito.genova.model.util.Logger;
import no.esito.genova.ui.ide.GPlugin;
import no.esito.genova.ui.ide.GProject;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

public class XtendPlugin extends AbstractUIPlugin {

    private static XtendPlugin instance;

    public XtendPlugin() {
        instance = this;
    }

    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        Bundle bundle = getBundle();
        if (GPlugin.getDefault().checkUpdate(bundle))
            GPlugin.getDefault().installJars(bundle, GPlugin.JARS_TARGETS);
    }

    public static XtendPlugin getDefault() {
        return instance;
    }

    public String getSystemArea() {
        return Platform.getStateLocation(getBundle()).toFile().toString();
    }

    public String getTemplateLocation(GeneratorModel genmodel) {
        ModelManager mm = genmodel.getModelManager();
        if(mm instanceof GProject){
            return ((GProject) mm).getIProject().getLocation().toPortableString();
        }
        String location = genmodel.getResourceLocation();
        if (location.startsWith("Project:")) {
            GProject gpro = genmodel.getModelManager();
            IProject ipro = gpro.getIProject();
            return ipro.getLocation().toPortableString();
        } else {
            JarArchive archive = GPlugin.getDefault().getArchive(location);
            if (archive == null) {
                Logger.GSN.warning("How did I get here? Archive doesn't exist");
            } else {
                File destination = getStateLocation().toFile();
                archive.unpackTargetJar(destination);
                String maindir = location.split(":")[1] + "/";
                return maindir;
            }
        }
        return null;

    }


}
