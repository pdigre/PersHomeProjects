package no.esito.genova.io.generator;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

import no.esito.genova.io.antlr.GParser.prog_return;
import no.esito.genova.io.driver.PTM_Plugin;
import no.esito.genova.io.xtend.Ptm2Xtend;
import no.esito.genova.model.core.ModelManager;
import no.esito.genova.model.core.PObject;
import no.esito.genova.model.core.QObject;
import no.esito.genova.model.generator.QGeneratorTarget;
import no.esito.genova.model.util.Logger;
import no.esito.genova.ui.ide.GProject;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.dynamichelpers.IExtensionTracker;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.eclipse.xtext.xbase.lib.*;

public class TMPL_Engine implements IGeneratorEngine {

    QGeneratorTarget gt;

    private GProject gpro;

    private String templatedir;

    private String templatefile;

    private String outputdir;

    public TMPL_Engine() {
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
        templatedir = PTM_Plugin.getDefault().getTemplateLocation(gt.getGeneratorModel()) + "/";
        templatefile = gt.getTemplateFile().replace('/', '\\');
        outputdir = gpro.getTargetPath(gt) + "/";
        globals = gt.getPropertyKeys();

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

    public URLClassLoader getTargetClassLoader() throws MalformedURLException {
        GProject gpro2 = gpro;
        if(gt!=null){
            GProject modelManager = gt.getGeneratorModel().getModelManager();
            gpro2=modelManager;
        }
        IPath location = gpro2.getIProject().getLocation();
        String string = location.toPortableString();
        URL url = new URL("file:/" + string + "/bin/");
        return URLClassLoader.newInstance(new URL[] { url }, getClass().getClassLoader());
    }

    public class GTreeUnit {

        private GParserSub parser;

        private CommonTree tree;

        private GLexerSub lexer;

        private String templatedir;

        private String templatefile;

        public GTreeUnit(String templatedir, String templatefile) {
            this.templatedir = templatedir;
            this.templatefile = templatefile;
        }

        public GParserSub getParser() {
            return parser;
        }

        public CommonTree getTree() throws IOException {
            if (tree == null) {
                parse();
            }
            return tree;
        }

        private void parse() throws IOException {
            System.out.print("Parser:" + templatefile);
            Date start = new Date();
            try {
                lexer = new GLexerSub(new ANTLRFileStream(templatedir + templatefile));
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                // lexer.lexerPrint(outputdir, templatefile, tokens);
                parser = new GParserSub(tokens);
                prog_return r = parser.prog();
                tree = (CommonTree) r.getTree();
                tree.toStringTree();
            } catch (RecognitionException re) {
                parser.reportError(re);
                parser.recover(parser.input, re);
            }
            Date end = new Date();
            System.out.println(" (" + Math.round(end.getTime() - start.getTime()) + "ms)");
        }

        public boolean isReserved(String text) {
            return lexer.isReserved(text);
        }

        @Override
        public String toString() {
            return templatefile;
        }
    }

    HashMap<String, GTreeUnit> units = new HashMap<String, TMPL_Engine.GTreeUnit>();

    private LinkedList<PObject> globals;

    public GTreeUnit getGTreeUnit(String templatedir, String templatefile) {
        GTreeUnit unit = units.get(templatedir + templatefile);
        if (unit == null) {
            unit = new GTreeUnit(templatedir, templatefile);
            units.put(templatedir + templatefile, unit);
        }
        return unit;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub

    }

    public Ptm2Xtend convertXtend(IFile ifile) throws IOException, CoreException {
        String fname = ifile.getName();
        if (!fname.endsWith(".tmpl"))
            return null;
        IContainer parent = ifile.getParent();
        templatedir = parent.getLocation().toPortableString() + "/";
        templatefile = fname;
        final GTreeUnit unit = getGTreeUnit(templatedir, templatefile);
        CommonTree tree = unit.getTree();
        Ptm2Xtend xtend = new Ptm2Xtend();
        xtend.engine = this;
        xtend.clazzname = fname.replaceFirst("\\.tmpl", "");
        xtend.node = tree;
        xtend.output = ifile;
        return xtend;
    }

    @Override
    public void createBuildArea(WorkspaceType type) {
        // TODO Auto-generated method stub

    }

}
