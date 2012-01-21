package no.esito.genova.io.debug;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.texteditor.ITextEditor;


public class PTMBreakpointAdapterFactory implements IAdapterFactory {

    @Override
    public Object getAdapter(Object adaptableObject, Class adapterType) {
        if (adaptableObject instanceof ITextEditor) {
            ITextEditor editorPart = (ITextEditor) adaptableObject;
            IResource resource = (IResource) editorPart.getEditorInput().getAdapter(IResource.class);
            if (resource != null) {
               String extension = resource.getFileExtension();
               if (extension != null && extension.equals("ptm")) {
               return new PTM_ToggleBreakpointTarget();
               }
            } 
         }
         return null;
    }

    @Override
    public Class[] getAdapterList() {
        return new Class[]{PTM_ToggleBreakpointTarget.class};
    }

}
