package org.digre.organizer.icons;

import org.digre.organizer.navigator.ExifPropertyDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;


public enum ImageConst {
    IMAGES("photos.png"), MISSING(""), Rotate("rotate90.png");
    
    final String path;
    ImageConst(String path){
        this.path=path;
    }
    
    public Image getImage(){
        if(this == ImageConst.MISSING)
            return ExifPropertyDescriptor.MISSING_IMAGE;
        return getImageDescriptor().createImage();
    }

    public ImageDescriptor getImageDescriptor(){
        return ImageDescriptor.createFromURL(getClass().getResource(path));
    }
    
}
