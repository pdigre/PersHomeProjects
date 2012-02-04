package no.esito.genova.io.driver;

import java.io.File;

import no.esito.genova.io.debug.PTMBreakpointAdapterFactory;
import no.esito.genova.io.xml.JarArchive;
import no.esito.genova.model.core.ModelManager;
import no.esito.genova.model.generator.GeneratorModel;
import no.esito.genova.model.util.Logger;
import no.esito.genova.ui.ide.GPlugin;
import no.esito.genova.ui.ide.GProject;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IBreakpointListener;
import org.eclipse.debug.core.IBreakpointManager;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.texteditor.ITextEditor;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

public class PTM_Plugin extends AbstractUIPlugin {

    private static PTM_Plugin instance;

    public PTM_Plugin() {
        instance = this;
    }

    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        Bundle bundle = getBundle();
        if (GPlugin.getDefault().checkUpdate(bundle))
            GPlugin.getDefault().installJars(bundle, GPlugin.JARS_TARGETS);
        DebugPlugin debug = DebugPlugin.getDefault();
        IBreakpointManager bpm = debug.getBreakpointManager();
        bpm.addBreakpointListener(new IBreakpointListener() {
            
            @Override
            public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
                System.out.println("breakpoint");
            }
            
            @Override
            public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
                System.out.println("breakpoint");
            }
            
            @Override
            public void breakpointAdded(IBreakpoint breakpoint) {
                System.out.println("breakpoint");
            }
        });
        debug.addDebugEventListener(new IDebugEventSetListener() {
            
            @Override
            public void handleDebugEvents(DebugEvent[] events) {
                System.out.println("debug event");
            }
        });
        Platform.getAdapterManager().registerAdapters(new PTMBreakpointAdapterFactory(), ITextEditor.class);
    }

    public static PTM_Plugin getDefault() {
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
