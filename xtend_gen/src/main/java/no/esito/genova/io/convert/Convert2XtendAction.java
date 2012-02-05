package no.esito.genova.io.convert;

import java.util.HashSet;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;

import no.esito.genova.io.ptm.Ptm2Xtend;
import no.esito.genova.ui.action.menubar.GMenuAction;
import no.esito.genova.ui.ide.GPlugin;
import no.esito.genova.ui.ide.GProject;

public abstract class Convert2XtendAction extends GMenuAction {

	public static final String PATH_EM_INPUT = "em";
	public static final String PATH_USAGE = "usage";
	public static final String PATH_XTEND_OUTPUT = "xtend";
	public IProject iproject;

    public HashSet<AbstractSupport> set = new HashSet<AbstractSupport>();

    public void saveXtendFiles() {
        for (AbstractSupport xtend : set) {
            xtend.scanMode = false;
            xtend.isClosed = true;
            if(!xtend.isEmpty()){
                String text = xtend._stat().toString();
    			xtend.saveResource(PATH_XTEND_OUTPUT, xtend.clazzname + ".xtend", text);
            }
        }
    }

	public Convert2XtendAction() {
		super();
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		super.selectionChanged(action, selection);
		if (selection instanceof TreeSelection) {
			TreeSelection sel = (TreeSelection) selection;
			Object el = sel.getFirstElement();
			if (el instanceof IProjectNature)
				iproject = ((IProjectNature) el).getProject();
		}
	}

	@Override
	public GProject getGProject() {
		GProject gpro = super.getGProject();
		if (gpro != null)
			return gpro;
		return GPlugin.getPM().getGProject(iproject);
	}

}