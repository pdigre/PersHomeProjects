package no.esito.genova.io.xtend;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.Stack;

import no.esito.genova.io.generator.PTM_Engine;
import no.esito.genova.ui.action.menubar.GMenuAction;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;

public class CreateXtendAction extends GMenuAction {

	HashSet<Ptm2Xtend> set = new HashSet<Ptm2Xtend>();

	@Override
	public void run(IAction action) {
		PTM_Engine ptm_Engine = new PTM_Engine();
		recurse(ptm_Engine, getGProject().getIProject());

		for (Ptm2Xtend xtend : set) {
			xtend.iterator_stack = new Stack<String>();
            xtend.iterator_stack.push("");
            xtend.scanMode = true;
            xtend._stat();
		}
        try {
            EStructure structure = new EStructure(ptm_Engine.getTargetClassLoader());
            IFolder folder = getGProject().getIProject().getFolder("src");
			structure.load(folder);
            structure.print(folder);
            for (Ptm2Xtend xtend : set) {
                xtend.printUsage(structure,set);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        for (Ptm2Xtend xtend : set) {
            xtend.iterator_stack = new Stack<String>();
            xtend.iterator_stack.push("");
            xtend.scanMode = false;
            xtend.isClosed = true;
            xtend.saveResource("src", xtend.clazzname + ".xtend", xtend._stat().toString());
        }
	}

	private void recurse(PTM_Engine ptm_Engine, IContainer container) {
		try {
			for (IResource res : container.members()) {
				if (res instanceof IFile) {
					Ptm2Xtend xtend = ptm_Engine.convertXtend((IFile) res);
					if (xtend != null)
						set.add(xtend);
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