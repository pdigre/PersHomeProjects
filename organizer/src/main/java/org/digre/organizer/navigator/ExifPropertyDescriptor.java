package org.digre.organizer.navigator;

import java.util.Map.Entry;

import net.sourceforge.jheader.App1Header.Tag;
import net.sourceforge.jheader.TagValue;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.PropertyDescriptor;

public class ExifPropertyDescriptor extends PropertyDescriptor {

    public static Image MISSING_IMAGE=ImageDescriptor.getMissingImageDescriptor().createImage();
    public ILabelProvider iLabelProvider = new ILabelProvider() {
        

        @Override
        public void removeListener(ILabelProviderListener listener) {
            // TODO Auto-generated method stub
            
        }
        
        @Override
        public boolean isLabelProperty(Object element, String property) {
            // TODO Auto-generated method stub
            return false;
        }
        
        @Override
        public void dispose() {
            // TODO Auto-generated method stub
            
        }
        
        @Override
        public void addListener(ILabelProviderListener listener) {
            // TODO Auto-generated method stub
            
        }
        
        @Override
        public String getText(Object element) {
            return element.toString();
        }
        
        @Override
        public Image getImage(Object element) {
            return MISSING_IMAGE;
        }
    };

    public ExifPropertyDescriptor(Tag tag) {
        super(tag, tag.name);
    }
    
    @Override
    public String getCategory() {
        return ((Tag) getId()).getCategory();
    }

    @Override
    public CellEditor createPropertyEditor(Composite parent) {
        return super.createPropertyEditor(parent);
    }
    
    @Override
    public ILabelProvider getLabelProvider() {
        return iLabelProvider;
    }
    
    
}
