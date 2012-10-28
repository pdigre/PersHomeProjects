
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
import java.lang.reflect.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import net.sourceforge.jheader.*;
import net.sourceforge.jheader.App1Header.*;
import net.sourceforge.jheader.JpegHeaders.ByteOrder;
import net.sourceforge.jheader.enumerations.*;

/**
 * Implementation of TableCellEditor for TagValue.
 *
 * This has a different appearance for each TagValue type.  It cannot
 * edit TagValues whose type is UNDEFINED or ArrayList types.  Upon
 * successful editing, the App1Header passed to the constructor is updated
 * and listeners are notified.
 */
public class TagValueCellEditor
    implements TableCellEditor, CellEditorListener
{
    private TagValue m_value;
    private HashSet<CellEditorListener> m_listeners
        = new HashSet<CellEditorListener>();
    private App1Header m_app1;
    private TagValueComponent m_component = null;
    private Frame m_parent;
    private int m_rowHeight;
    private DateTimeTagValueComponent m_dateTimeComponent;
    private Color m_color;

    /**
     * Constructor.
     *
     * @param value value to edit.
     * @param app1 the header to update.
     * @param parent the parent frame on which dialogs will be centred.
     * @param rowHeight height of a row in the table.
     * @param color background colour of the table.
     */
    public TagValueCellEditor(TagValue value, App1Header app1,
			      Frame parent, int rowHeight,
			      Color color)
    {
	m_value = value;
	m_app1 = app1;
	m_parent = parent;
	m_rowHeight = rowHeight;
	m_color = color;
    }
    
    /**
     * Returns an instance of an appropriate editing component for the given
     * TagValue type.
     *
     * @param table the table that is being edited.
     * @param value the value to edit.
     * @param isSelected whether or not the value has been selected.
     * @param row the row of the cell.
     * @param column the column of the cell.
     */
    public Component getTableCellEditorComponent(JTable table,
						 Object value,
						 boolean isSelected,
						 int row,
						 int column)
    {
	m_value = (TagValue)value;
	m_component = null;
	if (m_value == null) return null;
	Tag tag = m_value.getTag();
	if (tag.format == TagFormat.UNDEFINED) return null;
	if (ArrayList.class.isAssignableFrom(tag.implementingClass))
	    return null;
	try
	{
	    if (EnumeratedTag.class.isAssignableFrom(tag.implementingClass))
		m_component = new EnumeratedTagValueComponent(m_value);
	    else if (DateTimeTag.class.isAssignableFrom(tag.implementingClass))
	    {
		m_dateTimeComponent
		    = new DateTimeTagValueComponent(m_value, m_parent,
						    m_color);
		m_component = m_dateTimeComponent;
		m_dateTimeComponent.addCellEditorListener(this);
	    }
	    else if (tag.format == TagFormat.STRING)
		m_component = new StringTagValueComponent(m_value);
	    else if (tag.format == TagFormat.SRATIONAL
		|| tag.format == TagFormat.URATIONAL)
	    {
		RationalTagValueComponent c
		    = new RationalTagValueComponent(m_value);
		c.setHeight(m_rowHeight);
		c.setBackground(Color.WHITE);
		m_component = c;
	    }
	    else
		m_component = new LongTagValueComponent(m_value);
	}
	catch (TagFormatException e)
	{
	    JOptionPane.showMessageDialog(m_parent, "Couldn't create editor "
					  + "for " + tag.name,
					  "Error",
					  JOptionPane.ERROR_MESSAGE);
	}
	return (JComponent)m_component;
    }

    /**
     * Adds a listener to edit events.
     *
     * @param l the listener.
     */
    public void addCellEditorListener(CellEditorListener l)
    {
	m_listeners.add(l);
    }

    /**
     * Tells listeners that cell editing has been canceled.
     */
    public void cancelCellEditing()
    {
	ChangeEvent evt = new ChangeEvent(this);
	for (CellEditorListener l : m_listeners)
	    l.editingCanceled(evt);
    }
    
    /**
     * Returns the TagValue.
     *
     * @return a TagValue instance.  If the editing was cancelled, this is
     * the same object that was passed in.
     */
    public Object getCellEditorValue()
    {
	try
	{
	    return m_component.getTagValue();
	}
	catch (TagFormatException e)
	{
	    e.printStackTrace();
	    JOptionPane.showMessageDialog(m_parent, "Couldn't set "
					  + m_value.getTag().name
					  + " to " + m_component.getAsString(),
					  "Error",
					  JOptionPane.ERROR_MESSAGE);
	    return null;
	}
    }

    /**
     * Returns whether or not the cell is editable
     *
     * @return see class documentation for what is and is not editable.
     */
    public boolean isCellEditable(EventObject anEvent)
    {
	Tag tag = m_value.getTag();
	if (tag.format == TagFormat.UNDEFINED) return false;
	if (ArrayList.class.isAssignableFrom(tag.implementingClass))
	    return false;
	return true;
    }

    /**
     * Removes a listener of edit events.
     *
     * @param l the listener.
     */
    public void removeCellEditorListener(CellEditorListener l)
    {
	m_listeners.remove(l);
    }

    /**
     * Always returns true.
     *
     * @return true.
     */
    public boolean shouldSelectCell(EventObject anEvent)
    {
	return true;
    }

    /**
     * Notifies listners that editing has finished and updates the App1Header.
     *
     * @return true if the App1Header has been updated, false otherwise.
     * It would not be updated, for example, if the user entered an invalid
     * value.
     */
    public boolean stopCellEditing()
    {
	try
	{
	    TagValue oldValue = m_value;
	    m_value = m_component.getTagValue();
	    if (oldValue == m_value)
	    {
		ChangeEvent evt = new ChangeEvent(this);
		for (CellEditorListener l : m_listeners)
		    l.editingCanceled(evt);
	    }
	    m_app1.setValue(m_value);
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	    JOptionPane.showMessageDialog(m_parent, "Couldn't set "
					  + m_value.getTag().name
					  + " to " + m_component.getAsString(),
					  "Error",
					  JOptionPane.ERROR_MESSAGE);
	    return false;
	}
	ChangeEvent evt = new ChangeEvent(this);
	for (CellEditorListener l : m_listeners)
	    l.editingStopped(evt);
	return true;
    }

    ////////////////////////////////////////////////////////////////////////
    // CellEditorListener methods

    /**
     * Do nothing, except JTable default behaviour
     *
     * @param e the event
     */
    public void editingCanceled(ChangeEvent e)
    {
	cancelCellEditing();
    }
    
    /**
     * Notify listeners
     *
     * @param e the event
     */
    public void editingStopped(ChangeEvent e)
    {
	stopCellEditing();
    }
}
