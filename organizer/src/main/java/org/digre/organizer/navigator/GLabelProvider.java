package org.digre.organizer.navigator;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;


public class GLabelProvider implements ILabelProvider {

    @Override
    public void addListener(ILabelProviderListener listener) {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isLabelProperty(Object element, String property) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void removeListener(ILabelProviderListener listener) {
        // TODO Auto-generated method stub

    }

    @Override
    public Image getImage(Object element) {
        if(element instanceof GObject)
            return ((GObject)element).getImage().getImage();
        return null;
    }

    @Override
    public String getText(Object element) {
        if(element instanceof GImage)
            return ((GImage)element).res.getName();
        if(element instanceof GObject)
            return ((GObject)element).getName();
        return null;
    }

}
