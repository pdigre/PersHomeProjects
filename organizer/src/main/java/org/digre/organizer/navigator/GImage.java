package org.digre.organizer.navigator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.Map.Entry;

import net.sourceforge.jheader.App1Header;
import net.sourceforge.jheader.JpegFormatException;
import net.sourceforge.jheader.JpegHeaders;
import net.sourceforge.jheader.TagValue;
import net.sourceforge.jheader.App1Header.Tag;
import net.sourceforge.jheader.App1Header.TagFormat;

import org.digre.organizer.navigator.ExifPropertyDescriptor;
import org.digre.organizer.navigator.IObject;
import org.eclipse.core.internal.resources.Resource;
import org.eclipse.core.internal.resources.Workspace;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

@SuppressWarnings("restriction")
public class GImage extends Resource implements IObject, IPropertySource {

    public IResource res;

    public App1Header header;

    public GImage(IResource res) {
        super(res.getFullPath(), (Workspace) res.getWorkspace());
        this.res = res;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Object getAdapter(Class adapter) {
        Object a = res.getAdapter(adapter);
        return a;
    }

    @Override
    public IProject getProject() {
        return res.getProject();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Object> T getParentNode() {
        return (T) res.getProject();
    }

    @Override
    public String getName() {
        return res.getName();
    }

    @Override
    public int hashCode() {
        return res.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GImage)
            return res.equals(((GImage) obj).res);
        return res.equals(obj);
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public IPropertyDescriptor[] getPropertyDescriptors() {
        ArrayList<IPropertyDescriptor> list = new ArrayList<IPropertyDescriptor>();
        for (IPropertyDescriptor desc : ((IPropertySource) res.getAdapter(IPropertySource.class))
            .getPropertyDescriptors())
            list.add(desc);

        App1Header exif = getExif();
        if (exif != null)
            for (Tag tag : exif.getTags().keySet())
                list.add(new ExifPropertyDescriptor(tag));
        return list.toArray(new IPropertyDescriptor[list.size()]);
    }

    public App1Header getExif() {
        if (header == null)
            try {
                JpegHeaders hdrs = new JpegHeaders(((IFile) res).getContents());
                header = hdrs.getApp1Header();
            } catch (IOException | JpegFormatException e) {
                e.printStackTrace();
            } catch (CoreException e) {
                e.printStackTrace();
            }
        return header;
    }

    @Override
    public Object getEditableValue() {
        return this;
    }

    @Override
    public Object getPropertyValue(Object id) {
        if (id instanceof String && ((String) id).startsWith("org.eclipse"))
            return ((IPropertySource) res.getAdapter(IPropertySource.class)).getPropertyValue(id);
        return getExif().getValue((Tag) id).getAsString();
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

}
