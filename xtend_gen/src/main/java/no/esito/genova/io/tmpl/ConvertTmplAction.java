package no.esito.genova.io.tmpl;

import java.io.IOException;

import no.esito.genova.io.antlr.TmplParseUnit;
import no.esito.genova.io.convert.AbstractSupport;
import no.esito.genova.io.convert.Convert2XtendAction;
import no.esito.genova.io.driver.XtendEngine;

import org.antlr.runtime.tree.CommonTree;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;

public class ConvertTmplAction extends Convert2XtendAction {

	@Override
	public void run(IAction action) {
		try {
//			XtendEngine engine = new XtendEngine();
//			engine.setModelManager(getGProject());
			loadTmplFiles();
			saveXtendFiles();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadTmplFiles() {
		recurse(getGProject().getIProject());
//		for (AbstractSupport xtend : set) {
//			xtend.scanMode = true;
//			if (!xtend.isEmpty()) {
//				((Tmpl2Xtend) xtend)._stat();
//			} else {
//				System.out.println("Missing template file:");
//			}
//		}
	}

	private void recurse(IContainer container) {
		try {
			for (IResource res : container.members()) {
				if (res instanceof IFile) {
					IFile ifile = (IFile) res;
					String fname = ifile.getName();
					Tmpl2Xtend xtend = new Tmpl2Xtend();
					if (fname.endsWith(".tmpl")) {
						String templatedir = ifile.getParent().getLocation()
								.toPortableString()
								+ "/";
						TmplParseUnit unit = new TmplParseUnit(templatedir, fname);
						CommonTree tree = unit.getTree();
						xtend.clazzname = fname.replaceFirst("\\.tmpl", "");
						xtend.node = tree;
						xtend.output = ifile;
						set.add(xtend);
						
						if (!xtend.isEmpty()) {
				            xtend.scanMode = false;
				            xtend.isClosed = true;
				            if(!xtend.isEmpty()){
				                String text = xtend._stat().toString();
				    			xtend.saveResource(PATH_XTEND_OUTPUT, xtend.clazzname + ".xtend", text);
				            }
						} else {
							System.out.println("Missing template file:");
						}
					}
				}
				if (res instanceof IContainer)
					recurse((IContainer) res);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}