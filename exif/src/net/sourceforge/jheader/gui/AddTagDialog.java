
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
import net.sourceforge.jheader.App1Header.*;

/**
 * A dialog for setting a value for a tag which presently has no value.
 *
 * Call getResponse() to pop the dialog up.  If this returns true,
 * call getTagValue() to get the new tag value.
 */
public class AddTagDialog extends JDialog
    implements ActionListener, WindowListener
{
    private JComboBox m_tagBox;
    private JTextField m_textField;
    private JComboBox m_comboBox;
    private JLabel m_dummy;
    private DateTimeEditorField m_dateTimeField;
    private JButton m_okButton = new JButton("OK");
    private JButton m_cancelButton = new JButton("Cancel");
    private Vector<Tag> m_tags = new Vector<Tag>();
    private GridBagLayout m_layout;
    private JPanel m_panel;
    private GridBagConstraints m_constraints;
    private TagValue m_value = null;
    private boolean m_okClicked = false;
    private JComponent m_component = null;
    private Vector<Long> m_comboBoxLongValues
	= new Vector<Long>();

    /**
     * Constructor.
     *
     * @param parent the parent frame on which this will be centred.
     * @param tags set of tags to display.  This should only contain those
     * that presently have no value and should not contain those whose
     * type is UNDEFINED, ArrayList or is marked as uneditable.
     */
    public AddTagDialog(Frame parent, SortedSet<Tag> tags)
    {
	super(parent, "Add Tag", true);

	String[] tagNames = new String[tags.size()];
	{
	    int i = 0;
	    for (Tag tag : tags)
	    {
		m_tags.add(tag);
		tagNames[i++] = tag.name;
	    }
	}
	m_tagBox = new JComboBox(tagNames);
	m_tagBox.addActionListener(this);

	m_textField = new JTextField("");
	m_comboBox = new JComboBox();
	m_dateTimeField = new DateTimeEditorField(new GregorianCalendar(), 0,
						  parent);
	m_dummy = new JLabel("                                         ");

	setLocationRelativeTo(parent);
	addWindowListener(this);

	m_layout = new GridBagLayout();
	m_panel = new JPanel(m_layout);
	getContentPane().add(BorderLayout.CENTER, m_panel);
	m_panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

	m_constraints = new GridBagConstraints();
	m_constraints.anchor = GridBagConstraints.WEST;
	m_constraints.ipadx = 0;
	m_constraints.ipady = 0;
	m_constraints.weighty = 0.0;
	m_constraints.gridheight = 1;
	m_constraints.insets = new Insets(5,5,5,5);
	
	// tag label
	JLabel tagLabel = new JLabel("Tag");
	m_constraints.gridx = 0;
	m_constraints.gridy = 0;
	m_constraints.gridwidth = 1;
	m_constraints.weightx = 1.0;
	m_constraints.fill = GridBagConstraints.HORIZONTAL;
	m_layout.setConstraints(tagLabel, m_constraints);
	m_panel.add(tagLabel);
	
	// value label
	JLabel valueLabel = new JLabel("Value");
	m_constraints.gridx = 0;
	m_constraints.gridy = 1;
	m_constraints.gridwidth = 1;
	m_constraints.weightx = 1.0;
	m_constraints.fill = GridBagConstraints.HORIZONTAL;
	m_layout.setConstraints(valueLabel, m_constraints);
	m_panel.add(valueLabel);
	
	// tag box
	m_constraints.gridx = 1;
	m_constraints.gridy = 0;
	m_constraints.gridwidth = 1;
	m_constraints.weightx = 1.0;
	m_constraints.fill = GridBagConstraints.HORIZONTAL;
	m_layout.setConstraints(m_tagBox, m_constraints);
	m_panel.add(m_tagBox);
	
	// tag value (dummy)
	m_constraints.gridx = 1;
	m_constraints.gridy = 1;
	m_constraints.gridwidth = 1;
	m_constraints.weightx = 1.0;
	m_constraints.fill = GridBagConstraints.HORIZONTAL;
	m_layout.setConstraints(m_dummy, m_constraints);
	m_panel.add(m_dummy);
	m_component = m_dummy;
	
	// ok and close buttons
	JPanel buttonPanel = new JPanel(new FlowLayout());
	getContentPane().add(BorderLayout.SOUTH, buttonPanel);
	buttonPanel.add(m_okButton);
	buttonPanel.add(m_cancelButton);
	m_okButton.addActionListener(this);
	m_cancelButton.addActionListener(this);

	selectComponent();
    }

    /**
     * Pops up the dialog (blocking) and returns true if the user clicked
     * OK.
     *
     * @return true if the user pressed OK, false otherwise
     */
    public boolean getResponse()
    {
	setVisible(true);
	return m_okClicked;
    }

    /**
     * Returns the entered tag value.
     *
     * Returns null if for some reason an uneditable tag was passed in
     * and it was the one selected.
     *
     * @throws TagFormatException if the data entered cannot be set into the
     * selected tag.
     */
    public TagValue getTagValue() throws TagFormatException
    {
	int idx = m_tagBox.getSelectedIndex();
	Tag tag = m_tags.elementAt(idx);
	if (EnumeratedTag.class.isAssignableFrom(tag.implementingClass))
	{
	    int vidx = m_comboBox.getSelectedIndex();
	    Long l = m_comboBoxLongValues.elementAt(vidx);
	    return new TagValue(tag, l);
	}
	else if (DateTimeTag.class.isAssignableFrom(tag.implementingClass))
	{
	    return new TagValue(tag,
			new DateTimeTag(m_dateTimeField.getCalendar()));
	}
	else if (ArrayList.class.isAssignableFrom(tag.implementingClass))
	{
	    return null;
	}
	else if (tag.format == TagFormat.UNDEFINED)
	{
	    return null;
	}
	else if (tag.format == TagFormat.STRING)
	    return new TagValue(tag, m_textField.getText());
	else
	{
	    try
	    {
		return new TagValue(tag, new Long(m_textField.getText()));
	    }
	    catch (NumberFormatException e)
	    {
		e.printStackTrace();
		throw new TagFormatException("Cannot convert "
					     + m_textField.getText()
					     + " to integer");
	    }
	}
    }

    private void selectComponent()
    {
	int idx = m_tagBox.getSelectedIndex();
	Tag tag = m_tags.elementAt(idx);
	JComponent component = null;
	if (EnumeratedTag.class.isAssignableFrom(tag.implementingClass))
	{
	    try
	    {
		EnumeratedTag etag
		   = EnumeratedTag.instantiate(tag.implementingClass, (long)0);
		SortedMap<Long,String> values
		    = etag.getAll(true);
		m_comboBox.removeAllItems();
		m_comboBoxLongValues.clear();
		for (Long l : values.keySet())
		{
		    String s = values.get(l);
		    m_comboBox.addItem(s);
		    m_comboBoxLongValues.add(l);
		}
		component = m_comboBox;
	    }
	    catch (Exception e)
	    {
		e.printStackTrace();
		component = m_dummy;
	    }
	}
	else if (DateTimeTag.class.isAssignableFrom(tag.implementingClass))
	{
	    m_dateTimeField.setCalendar(new GregorianCalendar());
	    component = m_dateTimeField;
	}
	else if (ArrayList.class.isAssignableFrom(tag.implementingClass))
	{
	    component = m_dummy;
	}
	else if (tag.format == TagFormat.UNDEFINED)
	{
	    component = m_dummy;
	}
	else
	{
	    m_textField.setText("");
	    component = m_textField;
	}
	
	if (m_component != null)
	    m_panel.remove(m_component);
	
	m_component = component;
	m_constraints.gridx = 1;
	m_constraints.gridy = 1;
	m_constraints.gridwidth = 1;
	m_constraints.weightx = 1.0;
	m_constraints.fill = GridBagConstraints.HORIZONTAL;
	m_layout.setConstraints(m_component, m_constraints);
	m_panel.add(m_component);
	
	m_panel.doLayout();
	pack();
    }
    
    /////////////////////////////////////////////////////////////////////
    // ActionListener methods

    /**
     * Handle button clicks and tag selection.
     */
    public void actionPerformed(ActionEvent evt)
    {
	if (evt.getSource() == m_cancelButton) dispose();
	else if (evt.getSource() == m_okButton)
	{
	    m_okClicked = true;
	    dispose();
	}
	else if (evt.getSource() == m_tagBox)
	{
	    selectComponent();
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
