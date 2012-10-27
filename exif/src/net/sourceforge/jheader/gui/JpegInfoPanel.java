
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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.sourceforge.jheader.*;
import net.sourceforge.jheader.App1Header.*;
import net.sourceforge.jheader.JpegHeaders.ByteOrder;

/**
 * Component that displays information about the JPEG file.
 *
 * Displays width, height, file type (EXIF or JFIF) and thumbnail dimensions
 * and encoding.
 */
public class JpegInfoPanel extends JPanel
{
    private JLabel m_fileTypeLabel;
    private JLabel m_widthLabel;
    private JLabel m_heightLabel;
    private JLabel m_bppLabel;
    private JLabel m_thumbTypeLabel;
    private JLabel m_thumbWidthLabel;
    private JLabel m_thumbHeightLabel;

    /**
     * Constructor.
     */
    public JpegInfoPanel()
    {
	super(new FlowLayout(FlowLayout.CENTER,10,10));

	setBackground(Color.WHITE);
	JPanel topPanel = new JPanel(new GridLayout(7, 2, 10, 10));
	topPanel.setBackground(Color.WHITE);
	add(topPanel);

	JLabel fileTypeTitle = new JLabel("File Type", JLabel.RIGHT);
	JLabel widthTitle = new JLabel("Image Width", JLabel.RIGHT);
	JLabel heightTitle = new JLabel("Image Height", JLabel.RIGHT);
	JLabel bppTitle = new JLabel("Bits Per Pixel", JLabel.RIGHT);
	JLabel thumbTypeTitle = new JLabel("Thumbnail Encoding", JLabel.RIGHT);
	JLabel thumbWidthTitle = new JLabel("Thumbnail Width", JLabel.RIGHT);
	JLabel thumbHeightTitle = new JLabel("Thumbnail Height", JLabel.RIGHT);

	m_fileTypeLabel = new JLabel("", JLabel.LEFT);
	m_widthLabel = new JLabel("", JLabel.LEFT);
	m_heightLabel = new JLabel("", JLabel.LEFT);
	m_bppLabel = new JLabel("", JLabel.LEFT);
	m_thumbTypeLabel = new JLabel("", JLabel.LEFT);
	m_thumbWidthLabel = new JLabel("", JLabel.LEFT);
	m_thumbHeightLabel = new JLabel("", JLabel.LEFT);

	topPanel.add(fileTypeTitle);    topPanel.add(m_fileTypeLabel);
	topPanel.add(widthTitle);       topPanel.add(m_widthLabel);
	topPanel.add(heightTitle);      topPanel.add(m_heightLabel);
	topPanel.add(bppTitle);         topPanel.add(m_bppLabel);
	topPanel.add(thumbTypeTitle);   topPanel.add(m_thumbTypeLabel);
	topPanel.add(thumbWidthTitle);  topPanel.add(m_thumbWidthLabel);
	topPanel.add(thumbHeightTitle); topPanel.add(m_thumbHeightLabel);
    }

    /**
     * Sets the JPEG header and causes the component to update its displayed
     * info.
     *
     * @param header the data to display.
     */
    public void setHeader(JpegHeaders header)
    {
	m_fileTypeLabel.setText(header.getFileType().toString());
	m_widthLabel.setText(""+header.getWidth());
	m_heightLabel.setText(""+header.getHeight());
	m_bppLabel.setText(""+header.getBitsPerPixel());

	App0Header app0 = header.getApp0Header();
	App0Header app0Ext = header.getApp0ExtHeader();
	App1Header app1 = header.getApp1Header();

	if (app1 != null)
	{
	    TagValue thumbWidthValue = app1.getValue(Tag.IFD1_IMAGEWIDTH);
	    TagValue thumbHeightValue = app1.getValue(Tag.IFD1_IMAGELENGTH);
	    TagValue thumbCompressionValue
		= app1.getValue(Tag.IFD1_COMPRESSION);
	    int width = 0;
	    int height = 0;
	    String encoding = "None";
	    if (thumbWidthValue == null || thumbHeightValue == null)
	    {
		if (thumbCompressionValue != null)
		{
		    encoding = thumbCompressionValue.getAsString();
		    if (encoding.equals("JPEG"))
		    {
			int[] thumbBytes = app1.getThumbnailBytes();
			if (thumbBytes != null)
			{
			    try
			    {
				IntArrayInputStream in
				    = new IntArrayInputStream(thumbBytes);
				JpegHeaders thumbHeader = new JpegHeaders(in);
				width = thumbHeader.getWidth();
				height = thumbHeader.getHeight();
			    }
			    catch (Exception e)
			    {
				System.err.println("Couldn't decode thumbnail");
			    }
			}
		    }
		}
		if (width == 0 || height == 0)
		{
		    m_thumbTypeLabel.setText("None");
		    m_thumbWidthLabel.setText("");
		    m_thumbHeightLabel.setText("");
		}
		else
		{
		    m_thumbTypeLabel.setText(encoding);
		    m_thumbWidthLabel.setText(""+width);
		    m_thumbHeightLabel.setText(""+height);
		}
	    }
	    else
	    {
		m_thumbTypeLabel.setText("JPEG");
		m_thumbWidthLabel.setText(thumbWidthValue.getAsString());
		m_thumbHeightLabel.setText(thumbHeightValue.getAsString());
	    }
	}
	else if (app0Ext != null)
	{
	    int xthumb = app0Ext.getXThumbnail();
	    int ythumb = app0Ext.getYThumbnail();
	    int thumbType = app0Ext.getThumbnailType();
	    if (xthumb > 0 && ythumb > 0)
	    {
		m_thumbWidthLabel.setText(""+xthumb);
		m_thumbHeightLabel.setText(""+ythumb);
		if (thumbType == App0Header.THUMB_TYPE_JPEG)
		    m_thumbTypeLabel.setText("JPEG");
		else if (thumbType == App0Header.THUMB_TYPE_GREY)
		    m_thumbTypeLabel.setText("Greyscale");
		else if (thumbType == App0Header.THUMB_TYPE_RGB)
		    m_thumbTypeLabel.setText("RGB");
		else
		    m_thumbTypeLabel.setText("Unknown");
	    }
	    else
	    {
		m_thumbTypeLabel.setText("None");
		m_thumbWidthLabel.setText("");
		m_thumbHeightLabel.setText("");
	    }
	    
	}
	else if (app0 != null)
	{
	    int xthumb = app0Ext.getXThumbnail();
	    int ythumb = app0Ext.getYThumbnail();
	    if (xthumb > 0 && ythumb > 0)
	    {
		m_thumbWidthLabel.setText(""+xthumb);
		m_thumbHeightLabel.setText(""+ythumb);
		m_thumbTypeLabel.setText("RGB");
	    }
	    else
	    {
		m_thumbTypeLabel.setText("None");
		m_thumbWidthLabel.setText("");
		m_thumbHeightLabel.setText("");
	    }
	}
	else
	{
	    m_thumbTypeLabel.setText("None");
	    m_thumbWidthLabel.setText("");
	    m_thumbHeightLabel.setText("");
	}
    }
}
