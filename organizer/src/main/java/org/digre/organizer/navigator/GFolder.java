package org.digre.organizer.navigator;

import org.digre.organizer.navigator.GObject;
import org.eclipse.core.resources.IProject;


public class GFolder extends GObject{

    public GFolder(String name,Object parent) {
        super(name,parent);
    }

    public Object[] getChildren() {
        return new Object[0];
    }

    public static Object[] getProjectRoot(IProject project) {
        return new Object[]{new GCameras(project),new GMustRotate(project)};
    }
    
}
