
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
import javax.swing.event.*;
import net.sourceforge.jheader.*;

/**
 * Dialog for entering desired thumbnail dimensions.
 *
 * Call getResponse() to display.  If it returns true, the user pressed
 * the OK button and you can call getMaxHeight() etc.
 */
public class ThumbnailSizeDialog extends JDialog
    implements ActionListener, WindowListener
{
    private JCheckBox m_rotateCheck = new JCheckBox("Rotate to fit");
    private JButton m_okButton = new JButton("OK");
    private JButton m_cancelButton = new JButton("Cancel");
    private JTextField m_widthField = new JTextField("", 5);
    private JTextField m_heightField = new JTextField("", 5);

    private boolean m_okClicked = false;

    /**
     * Constructor.
     *
     * @param parent frame over which this will be centred.
     */
    public ThumbnailSizeDialog(JFrame parent)
    {
	super(parent, "Create Thumbnail", true);
	setLocationRelativeTo(parent);
	addWindowListener(this);

	m_rotateCheck.setSelected(true);

	GridBagLayout layout = new GridBagLayout();
	JPanel panel = new JPanel(layout);
	getContentPane().add(BorderLayout.CENTER, panel);
	panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

	GridBagConstraints constraints = new GridBagConstraints();
	constraints.anchor = GridBagConstraints.WEST;
	constraints.ipadx = 0;
	constraints.ipady = 0;
	constraints.weighty = 0.0;
	constraints.gridheight = 1;
	constraints.insets = new Insets(5,5,5,5);
	
	// width label
	JLabel widthLabel = new JLabel("Max width");
	constraints.gridx = 0;
	constraints.gridy = 0;
	constraints.gridwidth = 1;
	constraints.weightx = 1.0;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	layout.setConstraints(widthLabel, constraints);
	panel.add(widthLabel);
	
	// height label
	JLabel heightLabel = new JLabel("Max height");
	constraints.gridx = 0;
	constraints.gridy = 1;
	constraints.gridwidth = 1;
	constraints.weightx = 1.0;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	layout.setConstraints(heightLabel, constraints);
	panel.add(heightLabel);
	
	// width field
	constraints.gridx = 1;
	constraints.gridy = 0;
	constraints.gridwidth = 1;
	constraints.weightx = 1.0;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	layout.setConstraints(m_widthField, constraints);
	panel.add(m_widthField);
	
	// height field
	constraints.gridx = 1;
	constraints.gridy = 1;
	constraints.gridwidth = 1;
	constraints.weightx = 1.0;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	layout.setConstraints(m_heightField, constraints);
	panel.add(m_heightField);
	
	// rotate
	constraints.gridx = 0;
	constraints.gridy = 2;
	constraints.gridwidth = 2;
	constraints.weightx = 1.0;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	layout.setConstraints(m_rotateCheck, constraints);
	panel.add(m_rotateCheck);
	
	// ok and close buttons
	JPanel buttonPanel = new JPanel(new FlowLayout());
	getContentPane().add(BorderLayout.SOUTH, buttonPanel);
	buttonPanel.add(m_okButton);
	buttonPanel.add(m_cancelButton);
	m_okButton.addActionListener(this);
	m_cancelButton.addActionListener(this);
	
	pack();
    }

    /**
     * Display, blocking, and return whether or not the user pressed OK.
     *
     * @return true if the user pressed OK, false otherwise.
     */
    public boolean getResponse()
    {
	setVisible(true);
	return m_okClicked;
    }

    /**
     * Return the value the user entered into the Max Width field.
     *
     * @return the user-selected max width.
     */
    public int getMaxWidth()
    {
	int width = 0;
	try
	{
	    width = Integer.parseInt(m_widthField.getText());
	}
	catch (Exception e) {width = 0;}
	return width;
    }

    /**
     * Return the value the user entered into the Max Height field.
     *
     * @return the user-selected max height.
     */
    public int getMaxHeight()
    {
	int height = 0;
	try
	{
	    height = Integer.parseInt(m_heightField.getText());
	}
	catch (Exception e) {height = 0;}
	return height;
    }

    /**
     * Return the value the user entered into the rotate to fit checkbox
     *
     * @return the user-selected rotate to fit value.
     */
    public boolean getRotate()
    {
	return m_rotateCheck.isSelected();
    }

    /////////////////////////////////////////////////////////////////////
    // ActionListener methods
    
    /**
     * Handle button events
     */
    public void actionPerformed(ActionEvent evt)
    {
	if (evt.getSource() == m_cancelButton) dispose();
	else if (evt.getSource() == m_okButton)
	{
	    m_okClicked = true;
	    dispose();
	}
    }
  
    /////////////////////////////////////////////////////////////////////
    // WindowListener methods

    /**
     * Dispose when the window is closed.
     */
    public void windowClosing(WindowEvent e)
    {
	dispose();
    }

    public void windowClosed(WindowEvent e) {}
    
    public void windowOpened(WindowEvent e) {}
    
    public void windowIconified(WindowEvent e) {}
    
    public void windowDeiconified(WindowEvent e) {}
    
    public void windowActivated(WindowEvent e) {}
    
    public void windowDeactivated(WindowEvent e) {}
}
