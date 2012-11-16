package org.digre.organizer.navigator;

import java.util.ArrayList;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class GContentProvider implements ITreeContentProvider {

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        // TODO Auto-generated method stub
    }

    @Override
    public Object[] getElements(Object inputElement) {
        if (inputElement instanceof IWorkspaceRoot)
            return ((IWorkspaceRoot) inputElement).getProjects();
        return null;
    }

    @Override
    public Object[] getChildren(Object element) {
        if (element instanceof IAdaptable){
            Object adapter = ((IAdaptable) element).getAdapter(IResource.class);
            if(adapter != null)
                element = adapter;
        }
        if(element instanceof IProject)
            return GFolder.getProjectRoot((IProject)element);
//        if (element instanceof IContainer)
//            try {
//                return insertproxies(((IContainer) element).members());
//            } catch (CoreException e) {
//                e.printStackTrace();
//            }
        if(element instanceof GFolder){
            return ((GFolder)element).getChildren();
        }
        return new Object[0];
    }

    private static Object[] insertproxies(IResource[] members) {
        ArrayList<Object> list = new ArrayList<Object>();
        for (IResource res : members) {
            String lowerCase = res.getName().toLowerCase();
            if(lowerCase.endsWith(".jpg"))
                list.add(new GImage(res));
            else
                list.add(res);
        }
        return list.toArray();
    }

    @Override
    public Object getParent(Object element) {
        if (element instanceof IAdaptable){
            Object adapter = ((IAdaptable) element).getAdapter(IResource.class);
            if(adapter != null)
                element = adapter;
        }
        if (element instanceof IResource)
            return ((IResource) element).getParent();
        if (element instanceof GObject)
            return ((GObject) element).getParentNode();
        return null;
    }

    @Override
    public boolean hasChildren(Object element) {
        return getChildren(element).length>0;
    }

    
}
