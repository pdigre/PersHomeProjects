package org.digre.organizer.navigator;

import java.util.ArrayList;

import org.digre.organizer.icons.ImageConst;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;


public class GCameras extends GFolder {

    public GCameras(Object parent) {
        super("Cameras",parent);
    }

    @Override
    public Object[] getChildren() {
        Object[] array = getPhotosAsArray(getProject());
        return array;
    }

    @Override
    public ImageConst getImage() {
        return ImageConst.IMAGES;
    }

    public static Object[] getPhotosAsArray(IProject project) {
        return getPhotos(project).toArray();
    }

    public static ArrayList<Object> getPhotos(IProject project) {
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
        return list;
    }
    
}
