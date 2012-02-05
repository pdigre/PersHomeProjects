package no.esito.genova.io.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

import no.esito.genova.io.generator.IGeneratorEngine;
import no.esito.genova.model.core.ModelManager;
import no.esito.genova.model.core.QObject;
import no.esito.genova.model.generator.QGeneratorTarget;
import no.esito.genova.model.util.Logger;
import no.esito.genova.ui.ide.GProject;

import org.eclipse.core.resources.IProject;

public class XtendEngine implements IGeneratorEngine {

    QGeneratorTarget gt;

    private GProject gpro;

    public String templatedir;

    public String templatefile;

    private String outputdir;

    public XtendEngine() {
        super();
    }

    public void generateApplications(QGeneratorTarget target, List<QObject> list) {
        // TODO Auto-generated method stub

    }

    public GProject getGproject() {
        return gpro;
    }

    @Override
    public void setModelManager(ModelManager modelManager) {
        this.gpro = (GProject) modelManager;
        Logger.GSN.fine("Velocity initializing");
    }

    @Override
    public void setTarget(QGeneratorTarget gt) {
        this.gt = gt;
        templatedir = XtendPlugin.getDefault().getTemplateLocation(gt.getGeneratorModel()) + "/";
        templatefile = gt.getTemplateFile().replace('/', '\\');
        outputdir = gpro.getTargetPath(gt) + "/";
    }

    @Override
    public void createBuildScript(HashMap<QGeneratorTarget, ArrayList<QObject>> organized) {
    }

    @Override
    public void generateObjects(Collection<QObject> list, boolean doApplication, boolean doChildren)
        throws Exception {
        String tplfile = templatefile.replaceAll("\\.xtend", "");
        try {
            Class<?> c = getTargetClassLoader().loadClass(tplfile);
            @SuppressWarnings("unchecked")
            Callable<CharSequence> callable = (Callable<CharSequence>) c.newInstance();
            for (QObject go : list) {
                c.getField("context").set(callable, go);
                c.getField("outputdir").set(callable, outputdir);
                c.getField("target").set(callable, gt);
                CharSequence output = callable.call();
                System.out.println("Reply:" + output);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public URLClassLoader getTargetClassLoader(){
        GProject gpro2 = gpro;
        if(gt!=null){
            GProject modelManager = gt.getGeneratorModel().getModelManager();
            gpro2=modelManager;
        }
        return getTargetClassLoader(gpro2.getIProject());
    }

	public static URLClassLoader getTargetClassLoader(IProject ipro){
		String string = ipro.getLocation().toPortableString();
        try {
			URL url = new URL("file:/" + string + "/bin/");
			return URLClassLoader.newInstance(new URL[] { url }, ipro.getClass().getClassLoader());
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}

    @Override
    public void close() {
        // TODO Auto-generated method stub

    }

    @Override
    public void createBuildArea(WorkspaceType type) {
        // TODO Auto-generated method stub

    }

}
