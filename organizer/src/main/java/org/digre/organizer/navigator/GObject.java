package org.digre.organizer.navigator;

import java.util.ArrayList;

import org.digre.organizer.icons.ImageConst;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

public class GObject implements IPropertySource, IObject {

    String name;

    Object parent;

    public GObject(String name, Object parent) {
        super();
        this.name = name;
        this.parent = parent;
    }

    public GObject() {
    }

    @Override
    public Object getEditableValue() {
        return this;
    }

    @Override
    public IPropertyDescriptor[] getPropertyDescriptors() {
        ArrayList<IPropertyDescriptor> list = new ArrayList<IPropertyDescriptor>();
        for (int i = 0; i < 10; i++) {
            list.add(new PropertyDescriptor("" + i, "" + i));
        }
        return list.toArray(new IPropertyDescriptor[list.size()]);
    }

    @Override
    public Object getPropertyValue(Object id) {
        return id;
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

    public String getName() {
        return name;
    }

    @Override
    public <T extends Object> T getParentNode() {
        return (T) parent;
    }

    public IProject getProject() {
        if (parent instanceof IProject)
            return (IProject) parent;
        return ((GObject) getParentNode()).getProject();
    }

    public ImageConst getImage() {
        return ImageConst.MISSING;
    }

}
