package org.digre.organizer.navigator;

import java.util.ArrayList;

import org.digre.organizer.icons.ImageConst;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;


public class GMustRotate extends GFolder {

    public GMustRotate(Object parent) {
        super("Must rotate",parent);
    }

    @Override
    public Object[] getChildren() {
        IProject project = getProject();
        final ArrayList<Object> list=new ArrayList<Object>();
        try {
            project.accept(new IResourceVisitor() {
                
                @Override
                public boolean visit(IResource resource) throws CoreException {
                    String ext = resource.getFileExtension();
                    if(ext!=null && ext.equalsIgnoreCase("jpg"))
                        list.add(new GImage(resource));
                    return true;
                }
            });
        } catch (CoreException e) {
            e.printStackTrace();
        }
        return list.toArray();
    }
    
    @Override
    public ImageConst getImage() {
        return ImageConst.Rotate;
    }
}
