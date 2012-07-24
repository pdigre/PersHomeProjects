package no.esito.genova.io.convert;

import java.util.HashSet;

import no.esito.genova.ui.action.menubar.AbstractMenuAction;
import no.esito.genova.ui.ide.GPlugin;
import no.esito.genova.ui.model.GProject;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;

public abstract class Convert2XtendAction extends AbstractMenuAction {

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
	public GProject getGProject() {
		GProject gpro = super.getGProject();
		if (gpro != null)
			return gpro;
		return GPlugin.getPM().getGProject(iproject);
	}

}