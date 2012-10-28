package organizer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;


public class AdapterFactory implements IAdapterFactory {

    @Override
    public Object getAdapter(Object o, Class adapterType) {
        if (adapterType.isInstance(o)) {
            return o;
        }
        if (adapterType == IPropertySource.class) {
            if (o instanceof IResource) {
                IResource resource = (IResource) o;
                if(!resource.getName().toLowerCase().endsWith("jpg"))
                    return null;
                return new IPropertySource(){

                    @Override
                    public Object getEditableValue() {
                        // TODO Auto-generated method stub
                        return null;
                    }

                    @Override
                    public IPropertyDescriptor[] getPropertyDescriptors() {
                        // TODO Auto-generated method stub
                        return null;
                    }

                    @Override
                    public Object getPropertyValue(Object id) {
                        // TODO Auto-generated method stub
                        return null;
                    }

                    @Override
                    public boolean isPropertySet(Object id) {
                        // TODO Auto-generated method stub
                        return false;
                    }

                    @Override
                    public void resetPropertyValue(Object id) {
                        // TODO Auto-generated method stub
                        
                    }

                    @Override
                    public void setPropertyValue(Object id, Object value) {
                        // TODO Auto-generated method stub
                        
                    }
                    
                };
            }
        }
        return null;
    }

    /* (non-Javadoc)
     * Method declared on IAdapterFactory.
     */
    @Override
    public Class[] getAdapterList() {
        return new Class[] { IPropertySource.class };
    }

}
