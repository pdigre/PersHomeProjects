
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

/**
 * A table for displaying EXIF tags.
 *
 * <p>The table displays tag names in the left column and their values in
 * the right.  Clicking on a value allows it to be edited (if the table
 * has been configured this way - see below).  Right-clicking on any row
 * pops up a menu allowing the selected tag to be deleted or a new tag
 * to be created.</p>
 *
 * <p>If the table is set to be editable, the APP1 header is written
 * to directly, though the data are not saved back to the file.  To
 * receive notification of tag changes, implement the
 * App1UpdateListener interface and register to this table.</p>
 *
 * @see App1UpdateListener
 */
public class TagTable extends JTable implements MouseListener, ActionListener
{
    private TagTableModel m_model;
    private Frame m_parent;
    private App1Header m_app1 = null;
    private HashSet<App1UpdateListener> m_listeners
        = new HashSet<App1UpdateListener>();
    private boolean m_editable;

    // popup menu
    private JPopupMenu m_popup;
    private JMenuItem m_addMenuItem;
    private JMenuItem m_deleteMenuItem;

    /**
     * Constructor.
     *
     * @param parent parent frame.  Used for centering popups.
     * @param editable whether or not to make the table editable.
     */
    public TagTable(Frame parent, boolean editable)
    {
	super(new TagTableModel(null));
	m_parent = parent;
	m_model = (TagTableModel)dataModel;
	m_model.addTableModelListener(this);
	setCellSelectionEnabled(true);
	m_editable = editable;

	m_popup = new JPopupMenu();
	m_addMenuItem = new JMenuItem("Add tag...");
	m_addMenuItem.addActionListener(this);
	m_popup.add(m_addMenuItem);
	m_deleteMenuItem = new JMenuItem("Delete selected tag");
	m_deleteMenuItem.addActionListener(this);
	m_popup.add(m_deleteMenuItem);
	addMouseListener(this);
    }

    /**
     * Returns the appropriate cell renderer for the given cell.
     *
     * This is always the default renderer as TagValues can always be returned
     * as strings (which is therefore how they are displayed).
     *
     * @param row the row of the cell
     * @param column the column of the cell
     */
    public TableCellRenderer getCellRenderer(int row,
					     int column)
    {
	// as TagValue has a good toString() method, this is sensible.
	return super.getCellRenderer(row,column); 
    }

    /**
     * Returns the appropriate cell editor for the given cell.
     *
     * Only the values are editable, not the tags.  Returns
     * a TagTableCellRenderer instance.
     *
     * @param row the row of the cell
     * @param column the column of the cell
     */
    public TableCellEditor getCellEditor(int row,
					 int column)
    {
	if (column == 0) return super.getCellEditor(row,column);
	TagValue value = (TagValue)m_model.getValueAt(row, 1);
	if (value == null) return super.getCellEditor(row,column);
	TagValueCellEditor editor = new TagValueCellEditor(value, m_app1, m_parent, rowHeight, getBackground());
	editor.addCellEditorListener(this);
	return editor;
    }

    /**
     * Returns whether or not a cell is editable.
     *
     * If the table was constructed with editable set to false, this will
     * return false.  It returns false for column 0 and for rows whose value
     * is of type ArrayList or UndefinedTag.
     *
     * @param row the row of the cell
     * @param column the column of the cell
     */
    public boolean isCellEditable(int row, int column)
    {
	if (!m_editable) return false;
	if (column == 0) return false;
	TagValue value = (TagValue)m_model.getValueAt(row, 1);
	Tag tag = value.getTag();
	if (tag.format == TagFormat.UNDEFINED) return false;
	if (ArrayList.class.isAssignableFrom(tag.implementingClass))
	    return false;
	return true;
    }

    /**
     * Load the given APP1 data and update the table.
     *
     * @param app1 the data to load.
     */
    public void loadData(App1Header app1)
    {
	m_app1 = app1;
	m_model.loadData(app1==null ? null : app1.getTags(true));
    }

    /**
     * Register a listener to receive updates on APP1 edits.
     *
     * @param l the listener
     */
    public void addApp1UpdateListener(App1UpdateListener l)
    {
	m_listeners.add(l);
    }

    /**
     * Deregister a listener that receives updates on APP1 edits.
     *
     * @param l the listener
     */
    public void removeApp1UpdateListener(App1UpdateListener l)
    {
	m_listeners.remove(l);
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
	super.editingCanceled(e);
    }
    
    /**
     * Notify listeners
     *
     * @param e the event
     */
    public void editingStopped(ChangeEvent e)
    {
	if (e.getSource() instanceof TagValueCellEditor)
	{
	    for (App1UpdateListener l : m_listeners)
		l.app1Updated(this, m_app1);
	}
	super.editingStopped(e);
    }

    ///////////////////////////////////////////////////////////////////////
    // MouseListener methods

    public void mouseClicked(MouseEvent e)
    {
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
    }

    /**
     * Implemented to pop up the menu.
     */
    public void mousePressed(MouseEvent e)
    {
	if (m_editable && e.isPopupTrigger())
	{
	    int rowIndex = rowAtPoint(e.getPoint());
	    int columnIndex = columnAtPoint(e.getPoint());
	    if (rowIndex >= 0 && rowIndex < getRowCount()
		&& columnIndex >= 0 && columnIndex < 2)
	    {
		clearSelection();
		changeSelection(rowIndex, columnIndex, true, false);
		m_popup.show(e.getComponent(), e.getX(), e.getY());
	    }
	}
    }

    /**
     * Implemented to pop up the menu.
     */
    public void mouseReleased(MouseEvent e)
    {
	if (m_editable && e.isPopupTrigger())
	{
	    int rowIndex = rowAtPoint(e.getPoint());
	    int columnIndex = columnAtPoint(e.getPoint());
	    if (rowIndex >= 0 && rowIndex < getRowCount()
		&& columnIndex >= 0 && columnIndex < 2)
	    {
		clearSelection();
		changeSelection(rowIndex, columnIndex, true, false);
		m_popup.show(e.getComponent(), e.getX(), e.getY());
	    }
	}
    }

    ///////////////////////////////////////////////////////////////////////
    // ActionListener interface

    /**
     * Implemented to process menu actions.
     */
    public void actionPerformed(ActionEvent evt)
    {
	if (evt.getSource() == m_deleteMenuItem)
	{
	    if (m_app1 != null)
	    {
		int row = getSelectedRow();
		TagValue value = (TagValue)m_model.getValueAt(row, 1);
		if (value != null)
		{
		    m_app1.removeTag(value.getTag());
		    m_model.loadData(m_app1.getTags(true));
		    for (App1UpdateListener l : m_listeners)
			l.app1Updated(this, m_app1);
		}
	    }
	}
	else if (evt.getSource() == m_addMenuItem)
	{
	    SortedMap<Tag,TagValue> pairs = m_app1.getTags(true);
	    SortedSet<Tag> available
		= m_app1.getAvailableTags(m_app1.getCameraType());
	    TreeSet<Tag> tags
		= new TreeSet<Tag>(new TagLocationIdComparator());
	    for (Tag tag : available)
	    {
		if (!pairs.keySet().contains(tag)
		    && tag.format != TagFormat.UNDEFINED
		    && !ArrayList.class.isAssignableFrom(tag.implementingClass))
		    tags.add(tag);
	    }
	    AddTagDialog dialog = new AddTagDialog(m_parent, tags);
	    if (dialog.getResponse())
	    {
		try
		{
		    TagValue newValue = dialog.getTagValue();
		    m_app1.setValue(newValue);
		    for (App1UpdateListener l : m_listeners)
			l.app1Updated(this, m_app1);
		    m_model.loadData(m_app1.getTags(true));
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		    JOptionPane.showMessageDialog(m_parent,
						  "Couldn't add value",
						  "Error",
						  JOptionPane.ERROR_MESSAGE);
		}
		// editted
	    }
	}
    }
}
