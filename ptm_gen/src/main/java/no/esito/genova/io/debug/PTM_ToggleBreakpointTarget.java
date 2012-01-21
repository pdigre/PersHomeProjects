package no.esito.genova.io.debug;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IBreakpointManager;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTargetExtension;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ITextEditor;

public class PTM_ToggleBreakpointTarget extends Object implements IToggleBreakpointsTargetExtension {

    @Override
    public boolean canToggleLineBreakpoints(IWorkbenchPart part, ISelection selection) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void toggleMethodBreakpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean canToggleMethodBreakpoints(IWorkbenchPart part, ISelection selection) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void toggleWatchpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean canToggleWatchpoints(IWorkbenchPart part, ISelection selection) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void toggleLineBreakpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
        ITextEditor textEditor = getEditor(part);
        if (textEditor != null) {
            IResource resource = (IResource) textEditor.getEditorInput().getAdapter(IResource.class);
            ITextSelection textSelection = (ITextSelection) selection;
            int lineNumber = textSelection.getStartLine();
            IBreakpointManager bpm = DebugPlugin.getDefault().getBreakpointManager();
            IBreakpoint[] breakpoints = bpm.getBreakpoints(PTM_Constants.ID_PTM_DEBUG_MODEL);
            for (int i = 0; i < breakpoints.length; i++) {
                IBreakpoint breakpoint = breakpoints[i];
                if (resource.equals(breakpoint.getMarker().getResource())) {
                    if (((ILineBreakpoint) breakpoint).getLineNumber() == (lineNumber + 1)) {
                        breakpoint.delete();
                        return;
                    }
                }
            }
            PTM_Breakpoint lineBreakpoint = new PTM_Breakpoint(resource, lineNumber + 1);
            bpm.addBreakpoint(lineBreakpoint);
        }
    }

    private ITextEditor getEditor(IWorkbenchPart part) {
        if (part instanceof TextEditor)
            return (ITextEditor) part;
        return null;
    }

    @Override
    public void toggleBreakpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean canToggleBreakpoints(IWorkbenchPart part, ISelection selection) {
        // TODO Auto-generated method stub
        return false;
    }
}
