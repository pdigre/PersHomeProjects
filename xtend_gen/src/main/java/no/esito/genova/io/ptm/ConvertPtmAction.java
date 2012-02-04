package no.esito.genova.io.ptm;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Stack;

import no.esito.genova.io.driver.XtendEngine;
import no.esito.genova.io.driver.XtendEngine.GTreeUnit;
import no.esito.genova.ui.action.menubar.GMenuAction;

import org.antlr.runtime.tree.CommonTree;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;

public class ConvertPtmAction extends GMenuAction {

    public static final String PATH_EM_INPUT = "em";
    public static final String PATH_USAGE = "usage";
    public static final String PATH_XTEND_OUTPUT = "xtend";
	
    HashSet<Ptm2Xtend> set = new HashSet<Ptm2Xtend>();

	@Override
	public void run(IAction action) {
        try {
    		XtendEngine engine = new XtendEngine();
    		engine.setModelManager(getGProject());
    		loadPtmFiles(engine);
    		analyzeUsage(engine);
            saveXtendFiles();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
	}

    private void saveXtendFiles() {
        for (Ptm2Xtend xtend : set) {
            xtend.iterator_stack = new Stack<String>();
            xtend.iterator_stack.push("");
            xtend.scanMode = false;
            xtend.isClosed = true;
            xtend.saveResource(PATH_XTEND_OUTPUT, xtend.clazzname + ".xtend", xtend._stat().toString());
        }
    }

    private void loadPtmFiles(XtendEngine ptm_Engine) {
        recurse(ptm_Engine, getGProject().getIProject());
        for (Ptm2Xtend xtend : set) {
        	xtend.iterator_stack = new Stack<String>();
            xtend.iterator_stack.push("");
            xtend.scanMode = true;
            xtend._stat();
        }
    }

    private void analyzeUsage(XtendEngine ptm_Engine) throws MalformedURLException {
        IFolder folder_em = getGProject().getIProject().getFolder(PATH_EM_INPUT);
        EStructure structure = new EStructure();
        structure.load(folder_em,ptm_Engine.getTargetClassLoader());
        for (Ptm2Xtend xtend : set) {
        	xtend.structure=structure;
            xtend.collect(set);
        }
        structure.print(getGProject().getIProject().getFolder(PATH_USAGE));
        for (Ptm2Xtend xtend : set) {
            xtend.printUsage(set);
        }
    }

	private void recurse(XtendEngine engine, IContainer container) {
		try {
			for (IResource res : container.members()) {
				if (res instanceof IFile) {
					IFile ifile = (IFile) res;
					String fname = ifile.getName();
					Ptm2Xtend xtend1 = new Ptm2Xtend();
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
					Ptm2Xtend xtend = xtend1;
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