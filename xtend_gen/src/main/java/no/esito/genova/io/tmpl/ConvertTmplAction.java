package no.esito.genova.io.tmpl;

import java.io.IOException;
import java.util.HashSet;

import no.esito.genova.io.driver.XtendEngine;
import no.esito.genova.io.driver.XtendEngine.GTreeUnit;
import no.esito.genova.ui.action.menubar.GMenuAction;

import org.antlr.runtime.tree.CommonTree;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;

public class ConvertTmplAction extends GMenuAction {

    public static final String PATH_EM_INPUT = "em";
    public static final String PATH_USAGE = "usage";
    public static final String PATH_XTEND_OUTPUT = "xtend";
	
    HashSet<Tmpl2Xtend> set = new HashSet<Tmpl2Xtend>();

	@Override
	public void run(IAction action) {
        try {
    		XtendEngine engine = new XtendEngine();
    		engine.setModelManager(getGProject());
    		loadPtmFiles(engine);
            saveXtendFiles();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

    private void saveXtendFiles() {
        for (Tmpl2Xtend xtend : set) {
            xtend.scanMode = false;
            xtend.isClosed = true;
            xtend.saveResource(PATH_XTEND_OUTPUT, xtend.clazzname + ".xtend", xtend._stat().toString());
        }
    }

    private void loadPtmFiles(XtendEngine ptm_Engine) {
        recurse(ptm_Engine, getGProject().getIProject());
        for (Tmpl2Xtend xtend : set) {
            xtend.scanMode = true;
            xtend._stat();
        }
    }

	private void recurse(XtendEngine engine, IContainer container) {
		try {
			for (IResource res : container.members()) {
				if (res instanceof IFile) {
					IFile ifile = (IFile) res;
					String fname = ifile.getName();
					Tmpl2Xtend xtend1 = new Tmpl2Xtend();
					if (fname.endsWith(".ptm")){
					    IContainer parent = ifile.getParent();
					    engine.templatedir = parent.getLocation().toPortableString() + "/";
					    engine.templatefile = fname;
					    final GTreeUnit unit = engine.getGTreeUnit(engine.templatedir, engine.templatefile);
					    CommonTree tree = unit.getTree();
					    xtend1.engine = engine;
					    xtend1.clazzname = fname.replaceFirst("\\.ptm", "");
					    xtend1.node = tree;
					    xtend1.output = ifile;
					}
					Tmpl2Xtend xtend = xtend1;
					if (xtend != null){
						set.add(xtend);
					}
				}
				if (res instanceof IContainer)
					recurse(engine, (IContainer) res);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    
}