package no.esito.genova.io.debug;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.LineBreakpoint;


public class PTM_Breakpoint extends LineBreakpoint {

    public PTM_Breakpoint() {
    }

    public PTM_Breakpoint(final IResource resource, final int lineNumber)  throws DebugException{
        IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
            public void run(IProgressMonitor monitor) throws CoreException {
                IMarker marker = resource.createMarker("no.esito.genova.ptm.breakpointmarker");
                setMarker(marker);
                marker.setAttribute(IBreakpoint.ENABLED, Boolean.TRUE);
                marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
                marker.setAttribute(IBreakpoint.ID, getModelIdentifier());
                marker.setAttribute(IMarker.MESSAGE, "Line Breakpoint: " + resource.getName() + " [line: " + lineNumber + "]");
            }
        };
        run(getMarkerRule(resource), runnable);
    }

    @Override
    public String getModelIdentifier() {
        return PTM_Constants.ID_PTM_DEBUG_MODEL;
    }

}
