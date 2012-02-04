package no.esito.genova.io.xtend;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Stack;

import no.esito.genova.io.generator.TMPL_Engine;
import no.esito.genova.ui.action.menubar.GMenuAction;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;

public class CreateXtendAction extends GMenuAction {

    public static final String PATH_EM_INPUT = "em";
    public static final String PATH_USAGE = "usage";
    public static final String PATH_XTEND_OUTPUT = "xtend";
	
    HashSet<Ptm2Xtend> set = new HashSet<Ptm2Xtend>();

	@Override
	public void run(IAction action) {
        try {
    		TMPL_Engine engine = new TMPL_Engine();
    		engine.setModelManager(getGProject());
    		loadPtmFiles(engine);
            saveXtendFiles();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

    private void saveXtendFiles() {
        for (Ptm2Xtend xtend : set) {
            xtend.scanMode = false;
            xtend.isClosed = true;
            xtend.saveResource(PATH_XTEND_OUTPUT, xtend.clazzname + ".xtend", xtend._stat().toString());
        }
    }

    private void loadPtmFiles(TMPL_Engine ptm_Engine) {
        recurse(ptm_Engine, getGProject().getIProject());
        for (Ptm2Xtend xtend : set) {
            xtend.scanMode = true;
            xtend._stat();
        }
    }

	private void recurse(TMPL_Engine ptm_Engine, IContainer container) {
		try {
			for (IResource res : container.members()) {
				if (res instanceof IFile) {
					Ptm2Xtend xtend = ptm_Engine.convertXtend((IFile) res);
					if (xtend != null){
						set.add(xtend);
					}
				}
				if (res instanceof IContainer)
					recurse(ptm_Engine, (IContainer) res);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    
}