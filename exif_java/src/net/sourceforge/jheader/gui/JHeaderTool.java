
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
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import net.sourceforge.jheader.*;

/**
 * GUI tool for manipulating EXIF headers and EXIF and JFIF thumbnails.
 *
 * This is the top-level class for the GUI interface.
 */
public class JHeaderTool extends JFrame
    implements ActionListener, App1UpdateListener, WindowListener
{
    // GUI components
    private JSplitPane m_splitter;
    private ImagePanel m_imagePanel;
    private JTabbedPane m_infoPane;
    private TagTable m_tagsTable;
    private JpegInfoPanel m_jpegInfoPanel;

    // menu components
    private JMenuBar  m_menuBar      = new JMenuBar();
    private JMenu     m_fileMenu     = new JMenu("File");
    private JMenuItem m_fileOpenItem = new JMenuItem("Open...",KeyEvent.VK_O);
    private JMenuItem m_fileSaveItem = new JMenuItem("Save",KeyEvent.VK_S);
    private JMenuItem m_fileTCreateItem = new JMenuItem("Create Thumbnail...",
							KeyEvent.VK_C);
    private JMenuItem m_fileTSaveItem = new JMenuItem("Save Thumbnail...",
						      KeyEvent.VK_T);
    private JMenuItem m_fileExitItem = new JMenuItem("Exit",KeyEvent.VK_X);

    // data
    private JpegHeaders m_headers = null;
    private boolean m_dirty = false;
    private File m_filename = null;
    private File m_directory = null;

    /**
     * Constructor.
     *
     * Create window without loading any images.  Do not display.
     */
    public JHeaderTool()
    {
	super("JHeaderTool");

	addWindowListener(this);
	
	// image label
	FlowLayout imageBorder = new FlowLayout(FlowLayout.CENTER,10,10);
	JPanel imageParent = new JPanel(imageBorder);
	m_imagePanel = new ImagePanel();
	m_imagePanel.setPreferredSize(new Dimension(395,395));
	imageParent.add(BorderLayout.CENTER, m_imagePanel);
	imageParent.setBackground(Color.WHITE);

	// JPEG info panel
	m_jpegInfoPanel = new JpegInfoPanel();
	
	// tag table
	m_tagsTable = new TagTable(this, true);
	m_tagsTable.addApp1UpdateListener(this);
	JScrollPane scroller = new JScrollPane(m_tagsTable,
			  ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
			  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	scroller.setPreferredSize(new Dimension(395,395));

	// tabbed pane
	m_infoPane = new JTabbedPane();
	m_infoPane.add("JPEG", m_jpegInfoPanel);
	m_infoPane.add("EXIF", scroller);
	
	// splitter
	m_splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, imageParent,
				    m_infoPane);

	
	// create the menu
	setJMenuBar(m_menuBar);

	// file menu
	m_menuBar.add(m_fileMenu);
	m_fileMenu.setMnemonic(KeyEvent.VK_F);
	m_fileMenu.add(m_fileOpenItem);
	m_fileMenu.add(m_fileSaveItem);
	m_fileMenu.add(m_fileTCreateItem);
	m_fileMenu.add(m_fileTSaveItem);
	m_fileMenu.add(m_fileExitItem);
	m_fileOpenItem.addActionListener(this);
	m_fileSaveItem.addActionListener(this);
	m_fileTCreateItem.addActionListener(this);
	m_fileTSaveItem.addActionListener(this);
	m_fileExitItem.addActionListener(this);
	m_fileOpenItem.setAccelerator(KeyStroke.getKeyStroke(
				  KeyEvent.VK_O, ActionEvent.CTRL_MASK));
	m_fileSaveItem.setAccelerator(KeyStroke.getKeyStroke(
				  KeyEvent.VK_S, ActionEvent.CTRL_MASK));
	m_fileExitItem.setAccelerator(KeyStroke.getKeyStroke(
				  KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
	m_fileSaveItem.setEnabled(false);
	m_fileTSaveItem.setEnabled(false);
	m_fileTCreateItem.setEnabled(false);
	
	// top level
	setContentPane(m_splitter);
	pack();
    }

    /**
     * Returns the selected look and feel name.
     *
     * If swing.defaultlaf has been defined on the Java command line,
     * its value is used.  Otherwise the default one for the system is
     * used (GTKLookAndFeel is used for Linux by default).
     */
    static public String getLookAndFeelName()
    {
	if (System.getProperties().containsKey("swing.defaultlaf"))
	    return System.getProperty("swing.defaultlaf");
	if (System.getProperty("os.name").startsWith("Linux"))
	    return "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
	return UIManager.getSystemLookAndFeelClassName();
    }

    private void openFile()
    {
	JFileChooser chooser = new JFileChooser(m_directory);
	SimpleFileFilter filter = new SimpleFileFilter();
	filter.addExtension("jpg");
	filter.setDescription("JPG Images");
	chooser.setFileFilter(filter);
	int returnVal = chooser.showOpenDialog(this);
	if(returnVal == JFileChooser.APPROVE_OPTION)
	{
	    m_directory = chooser.getSelectedFile().getParentFile();
	    loadFile(chooser.getSelectedFile().toString());
	}	
    }

    private void loadFile(String filename)
    {
	m_imagePanel.setImage(filename); // XXX
	m_filename = new File(filename);
	setTitle("JHeaderTool: " + m_filename.getName());
	String errorMessage = "";
	m_fileTSaveItem.setEnabled(false);
	m_fileTCreateItem.setEnabled(false);
	m_fileSaveItem.setEnabled(false);
	try
	{
	    m_headers = new JpegHeaders(filename);
	    loadHeader(m_headers);
	    m_fileTCreateItem.setEnabled(true);
	}
	catch (TagFormatException e)
	{
	    e.printStackTrace();
	    errorMessage = "There is an error in one or more EXIF tags";
	}
	catch (ExifFormatException e)
	{
	    e.printStackTrace();
	    errorMessage = "There is an error in the EXIF headers";
	}
	catch (JpegFormatException e)
	{
	    e.printStackTrace();
	    errorMessage = "There is an error in the JPEG format";
	}
	catch (IOException e)
	{
	    e.printStackTrace();
	    errorMessage = "There was an error reading the file";
	}
	if (!errorMessage.equals(""))
	{
	    JOptionPane.showMessageDialog(this, errorMessage,
					  "Error",
					  JOptionPane.ERROR_MESSAGE);
	}
    }

    private void loadHeader(JpegHeaders header)
    {
	m_jpegInfoPanel.setHeader(m_headers);
	if (m_headers.getApp1Header() != null)
	    m_tagsTable.loadData(m_headers.getApp1Header());
	else
	    m_tagsTable.loadData(null);
	if ((m_headers.getApp0Header()!=null
	     && m_headers.getApp0Header().getThumbnailAsJpeg()!=null
	     && m_headers.getApp0Header().getThumbnailAsJpeg().length>0)
	    || (m_headers.getApp0ExtHeader()!=null
		&& m_headers.getApp0ExtHeader().getThumbnailAsJpeg()!=null
		&& m_headers.getApp0ExtHeader().getThumbnailAsJpeg().length>0)
	    || (m_headers.getApp1Header()!=null
		&& m_headers.getApp1Header().getThumbnailBytes()!=null
		&& m_headers.getApp1Header().getThumbnailBytes().length>0))
	{
	    m_fileTSaveItem.setEnabled(true);
	}
    }

    private void saveIfDirty()
    {
	if (m_headers == null || m_filename == null || !m_dirty)
	    return;
	
	String errorMessage = null;
	try
	{
	    m_headers.save(true);
	    m_dirty = false;
	    setTitle("JHeaderTool: " + m_filename.getName());
	    m_fileSaveItem.setEnabled(false); 
	    loadFile(m_filename.toString());
	}
	catch (FileNotFoundException e)
	{
	    e.printStackTrace();
	    errorMessage = "Original file has disappeared";
	}
	catch (IOException e)
	{
	    e.printStackTrace();
	    errorMessage = "Error writing to file";
	}
	catch (TagFormatException e)
	{
	    e.printStackTrace();
	    errorMessage = "Error in one or more EXIF tags";
	}
	catch (ExifFormatException e)
	{
	    e.printStackTrace();
	    errorMessage = "Error in EXIF header";
	}
	catch (JpegFormatException e)
	{
	    e.printStackTrace();
	    errorMessage = "Error in JPEG format";
	}
	if (errorMessage != null)
	{
	    JOptionPane.showMessageDialog(this, errorMessage,
					  "Error",
					  JOptionPane.ERROR_MESSAGE);
	}
    }

    private boolean querySave()
    {
	if (!m_dirty) return true;
	int opt 
	    = JOptionPane.showConfirmDialog(this,
					    "Save changed to "
					    + m_filename.getName(),
					    "Save",
					    JOptionPane.YES_NO_CANCEL_OPTION);
	if (opt == JOptionPane.YES_OPTION)
	{
	    saveIfDirty();
	    return true;
	}
	else if (opt == JOptionPane.NO_OPTION)
	{
	    m_dirty = false;
	    m_fileSaveItem.setEnabled(false);
	    return true;
	}
	return false;
    }

    private void saveThumbnail()
    {
	int[] thumbnailBytes = null;
	if (m_headers.getApp0ExtHeader() != null)
	    thumbnailBytes = m_headers.getApp0ExtHeader().getThumbnailAsJpeg();
	else if (m_headers.getApp0Header() != null)
	    thumbnailBytes = m_headers.getApp0Header().getThumbnailAsJpeg();
	else if (m_headers.getApp1Header() != null)
	    thumbnailBytes = m_headers.getApp1Header().getThumbnailBytes();

	if (thumbnailBytes == null || thumbnailBytes.length == 0)
	{
	    JOptionPane.showMessageDialog(this, "There is no thumbnail in"
					  + m_filename.getName(),
					  "Save Thumbnail",
					  JOptionPane.ERROR_MESSAGE);
	    return;
	}
	
	JFileChooser chooser = new JFileChooser(m_directory);
	SimpleFileFilter filter = new SimpleFileFilter();
	filter.addExtension("jpg");
	filter.setDescription("JPG Images");
	chooser.setFileFilter(filter);
	int returnVal = chooser.showSaveDialog(this);
	if (returnVal == JFileChooser.APPROVE_OPTION)
	{
	    m_directory = chooser.getSelectedFile().getParentFile();
	    try
	    {
		FileOutputStream out
		    = new FileOutputStream(chooser.getSelectedFile());
		BufferedOutputStream bout = new BufferedOutputStream(out);
		for (int i=0; i<thumbnailBytes.length; ++i)
		    out.write(thumbnailBytes[i]);
		bout.close();
		out.close();
	    }
	    catch (IOException e)
	    {
		e.printStackTrace();
		JOptionPane.showMessageDialog(this, "Couldn't write file",
					      "Error",
					      JOptionPane.ERROR_MESSAGE);
	    }
	}
    }
    
    private void createThumbnail()
    {
	ThumbnailSizeDialog dialog = new ThumbnailSizeDialog(this);
	if (dialog.getResponse())
	{
	    int width = dialog.getMaxWidth();
	    int height = dialog.getMaxHeight();
	    boolean rotate = dialog.getRotate();
	    if (width <= 0 || height <= 0)
	    {
		JOptionPane.showMessageDialog(this, "Invalid dimensions",
					      "Error",
					      JOptionPane.ERROR_MESSAGE);
		return;
	    }
	    String errorMessage = null;
	    try
	    {
		FileInputStream stream = new FileInputStream(m_filename);
		System.out.println("makeThumbnailWithMaxDimensions("+height+","+width+","+rotate+")");
		m_headers.makeThumbnailWithMaxDimensions(stream, height, width,
							 rotate);
		stream.close();
		loadHeader(m_headers);
		m_dirty = true;
		setTitle("JHeaderTool: " + m_filename.getName() + " (modified)");
		m_fileSaveItem.setEnabled(true);
		
	    }
	    catch (FileNotFoundException e)
	    {
		e.printStackTrace();
		errorMessage = "Original file has disappeared";
	    }
	    catch (Exception e)
	    {
		e.printStackTrace();
		errorMessage = "There was an error creating the thumbnail";
	    }
	    if (errorMessage != null)
		JOptionPane.showMessageDialog(this, errorMessage,
					      "Error",
					      JOptionPane.ERROR_MESSAGE);
	}
    }
    
    ////////////////////////////////////////////////////////////////////////
    // ActionListener methods

    /**
     * Handle menu events.
     *
     * @param evt the action event.
     */
    public void actionPerformed(ActionEvent evt)
    {
	if (evt.getSource() == m_fileExitItem)
	    dispose();
	else if (evt.getSource() == m_fileOpenItem)
	{
	    if (querySave())
		openFile();
	}
	else if (evt.getSource() == m_fileSaveItem)
	    saveIfDirty();
	else if (evt.getSource() == m_fileTSaveItem)
	    saveThumbnail();
	else if (evt.getSource() == m_fileTCreateItem)
	    createThumbnail();
    }

    ///////////////////////////////////////////////////////////////////////
    // App1UpdateListener

    /**
     * Handle updates to the APP1 header.
     *
     * @param source the component generating the event.
     * @param app1 the header that changed.
     */
    public void app1Updated(Object source, App1Header app1)
    {
	m_dirty = true;
	setTitle("JHeaderTool: " + m_filename.getName() + " (modified)");
	m_fileSaveItem.setEnabled(true);
    }

    /////////////////////////////////////////////////////////////////////
    // WindowListener methods

    /**
     * Confirm saving changes to the image before exiting.
     */
    public void windowClosing(WindowEvent e)
    {
	if (m_dirty)
	{
	    int opt 
		= JOptionPane.showConfirmDialog(this,
						"Save changed to "
						+ m_filename.getName(),
						"Save",
						JOptionPane.YES_NO_OPTION);
	    if (opt == JOptionPane.YES_OPTION)
		saveIfDirty();
	}
	dispose();
    }

    public void windowClosed(WindowEvent e) {}
    
    public void windowOpened(WindowEvent e) {}
    
    public void windowIconified(WindowEvent e) {}
    
    public void windowDeiconified(WindowEvent e) {}
    
    public void windowActivated(WindowEvent e) {}
    
    public void windowDeactivated(WindowEvent e) {}
    
    
    ///////////////////////////////////////////////////////////////////////
    // main
    
    /**
     * Main program.
     *
     * Usage: java net.sourceforge.jheader.gui.JHeaderTool [image-filename]
     */
    public static void main(String[] args)
    {
	// set look and feel
	try
	{
	    UIManager.setLookAndFeel(getLookAndFeelName());
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	}

	// preheat
	JpegHeaders.preheat();
	
	// create and display window
	String filename = null;
	if (args.length > 0) filename = args[0];
	JHeaderTool tool = new JHeaderTool();
        //tool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tool.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	tool.setVisible(true);
	if (filename != null)
	    tool.loadFile(filename);
	
	
    }

}
