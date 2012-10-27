
/*
JHeader, a Java library and tools for reading and editing EXIF headers.
Copyright (C) 2005 Matthew Baker

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.

For further information, please contact Matthew Baker on msb@safe-mail.net.
Project home page: www.sourceforge.net/jheader
*/
package net.sourceforge.jheader.gui;

import java.util.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

/**
 * A JLabel that displays an image.
 */
public class ImagePanel extends JLabel implements ComponentListener
{
    Image m_origImage = null;
    Image m_image = null; // scaled image

    /**
     * Constructor.
     */
    public ImagePanel()
    {
	super();
	addComponentListener(this);
    }

    /**
     * Set the image to display.
     *
     * @param filename the image to display.
     */
    public void setImage(String filename)
    {
	ImageIcon icon = new ImageIcon(filename);
	m_origImage = icon.getImage();
	m_image = getScaledImage();
	if (m_image != m_origImage)
	    icon = new ImageIcon(m_image);
	setIcon(icon);
    }

    private Image getScaledImage()
    {
	if (m_origImage.getWidth(null) > getWidth()
	    || m_origImage.getHeight(null) > getHeight())
	{
	    float xscale = (float)getWidth()/m_origImage.getWidth(null);
	    float yscale = (float)getHeight()/m_origImage.getHeight(null);
	    int newWidth = getWidth();
	    int newHeight = getHeight();
	    if (xscale < yscale)
		newHeight = (int)(xscale * m_origImage.getHeight(null));
	    else if (yscale < xscale)
		newWidth = (int)(yscale * m_origImage.getWidth(null));
	    return m_origImage.getScaledInstance(newWidth, newHeight,
					    Image.SCALE_DEFAULT);
	}
	return m_origImage;
    }

    ////////////////////////////////////////////////////////////////////////
    // ComponentListener interface

    public void componentHidden(ComponentEvent e) {}
    public void componentMoved(ComponentEvent e) {}
    public void componentShown(ComponentEvent e) {}

    /**
     * Resize the image to fit the component boundaries.
     *
     * @param e the resize event.
     */
    public void componentResized(ComponentEvent e)
    {
	if (m_origImage == null) return;
	Image image = getScaledImage();
	ImageIcon icon = new ImageIcon(image);
	if (image.getWidth(null) != m_image.getWidth(null)
	    || image.getHeight(null) != m_image.getHeight(null))
	{
	    m_image = image;
	    setIcon(icon);
	    
	}
    }
}
