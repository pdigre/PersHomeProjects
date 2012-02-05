package no.esito.genova.io.tmpl;

import java.io.IOException;
import java.util.HashSet;

import no.esito.genova.io.driver.XtendEngine;
import no.esito.genova.ui.action.menubar.GMenuAction;

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

	private void recurse(XtendEngine tmpl_Engine, IContainer container) {
		try {
			for (IResource res : container.members()) {
				if (res instanceof IFile) {
					Tmpl2Xtend xtend = tmpl_Engine.convertXtend((IFile) res);
					if (xtend != null){
						set.add(xtend);
					}
				}
				if (res instanceof IContainer)
					recurse(tmpl_Engine, (IContainer) res);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    
}