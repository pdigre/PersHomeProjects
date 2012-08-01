package no.esito.genova.io.ptm;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Stack;

import no.esito.genova.io.antlr.PtmParseUnit;
import no.esito.genova.io.convert.AbstractSupport;
import no.esito.genova.io.convert.Convert2XtendAction;
import no.esito.genova.io.convert.EStructure;
import no.esito.genova.io.driver.XtendEngine;

import org.antlr.runtime.tree.CommonTree;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;

public class ConvertPtmAction extends Convert2XtendAction {

	@Override
	public void run() {
		try {
			loadPtmFiles();
			analyzeUsage();
			saveXtendFiles();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	private void loadPtmFiles() {
		recurse(getGProject().getIProject());
		for (AbstractSupport base : set) {
			Ptm2Xtend xtend = (Ptm2Xtend) base;
			xtend.iterator_stack = new Stack<String>();
			xtend.iterator_stack.push("");
			xtend.scanMode = true;
			xtend._stat();
		}
	}

	private void analyzeUsage()
			throws MalformedURLException {
		IFolder folder_em = getGProject().getIProject()
				.getFolder(PATH_EM_INPUT);
		EStructure structure = new EStructure();
		structure.load(folder_em, XtendEngine.getTargetClassLoader(iproject));
		for (AbstractSupport base : set) {
			Ptm2Xtend xtend = (Ptm2Xtend) base;
			xtend.structure = structure;
			xtend.collect(set);
		}
		structure.print(getGProject().getIProject().getFolder(PATH_USAGE));
		for (AbstractSupport base : set) {
			Ptm2Xtend xtend = (Ptm2Xtend) base;
			xtend.printUsage(set);
		}
	}

	private void recurse(IContainer container) {
		try {
			for (IResource res : container.members()) {
				if (res instanceof IFile) {
					IFile ifile = (IFile) res;
					String fname = ifile.getName();

					if (fname.endsWith(".ptm")) {
						String templatedir = ifile.getParent().getLocation()
								.toPortableString()
								+ "/";
						PtmParseUnit unit = new PtmParseUnit(templatedir, fname);
						CommonTree tree = unit.getTree();
						Ptm2Xtend xtend = new Ptm2Xtend();
						xtend.clazzname = fname.replaceFirst("\\.ptm", "");
						xtend.node = tree;
						xtend.output = ifile;
						set.add(xtend);
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