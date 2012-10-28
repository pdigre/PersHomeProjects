
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
 * Data model for the tag table.
 *
 * You shouldn't need to use this class directly.
 */
public class TagTableModel implements TableModel
{
    private Vector<TagValue> m_data;
    private HashSet<TableModelListener> m_listeners
    = new HashSet<TableModelListener>();

    /**
     * Constructor from set of tags to display.
     *
     * @param data set of tags to display in the table.
     */
    public TagTableModel(SortedMap<Tag,TagValue> data)
    {
	loadData(data);
    }

    /**
     * Add a listener to changes in the table data.
     */
    public void addTableModelListener(TableModelListener l)
    {
	m_listeners.add(l);
    }
    
    /**
     * Returns the column class.
     *
     * Column 0 is String and column 1 is TagValue.
     *
     * @param columnIndex column index whose class to return.
     */
    public Class<?> getColumnClass(int columnIndex)
    {
	if (columnIndex == 0) return String.class;
	return TagValue.class;
    }

    /**
     * Always returns 2.
     *
     * @return the column count (2).
     */
    public int getColumnCount()
    {
	return 2;
    }

    /**
     * Returns the column names
     *
     * Column 0 is Tag and column 1 is Value.
     *
     * @param columnIndex the index of the column whose name to return.
     * @return the column name.
     */
    public String getColumnName(int columnIndex)
    {
	if (columnIndex == 0) return "Tag";
	return "Value";
    }

    /**
     * Returns the number of rows in the table.
     *
     * @return the number of rows.
     */
    public int getRowCount()
    {
	return m_data.size();
    }

    /**
     * Returns the value of the given table cell.
     *
     * If columnIndex is 0, this returns a String; if it is 1 it returns
     * a TagValue.
     *
     * @param rowIndex the row of the cell to return.
     * @param columnIndex the column of the cell to return.
     */
    public Object getValueAt(int rowIndex, int columnIndex)
    {
	if (columnIndex == 0)
	    return m_data.elementAt(rowIndex).getTag().name;
	return m_data.elementAt(rowIndex);
    }

    /**
     * Returns whether or not a cell is editable.
     *
     * Column 0 is not editable; column 1 is.
     *
     * @param rowIndex the row of the cell to return.
     * @param columnIndex the column of the cell to return.
     * @return whether or not the cell is editable.
     */
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
	if (columnIndex == 0) return false;
	return true;
    }
    
    /**
     * Remove a listener that received changes in the table data.
     */
    public void removeTableModelListener(TableModelListener l)
    {
	m_listeners.remove(l);
    }

    /**
     * Sets a cell's value.
     *
     * Does nothign unless columnIndex is 1.
     *
     * @param aValue value to set cell to.
     * @param rowIndex the row of the cell to set.
     * @param columnIndex the column of the cell to set.
     */
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
	if (columnIndex == 1)
	{
	    m_data.setElementAt((TagValue)aValue, rowIndex);
	    TableModelEvent evt = new TableModelEvent(this, rowIndex);
	    for (TableModelListener l : m_listeners)
		l.tableChanged(evt);
	}
    }

    /**
     * Loads the given data, notifying listeners.
     *
     * @param data the tags and values to load.
     */
    public void loadData(SortedMap<Tag,TagValue> data)
    {
	if (data == null)
	    m_data =  new Vector<TagValue>();
	else
	    m_data =  new Vector<TagValue>(data.size());
	if (data != null)
	    for (TagValue value : data.values())
		m_data.add(value);
	TableModelEvent evt = new TableModelEvent(this);
	for (TableModelListener l : m_listeners)
	    l.tableChanged(evt);
    }
    
}
