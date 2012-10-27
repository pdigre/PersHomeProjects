
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
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import net.sourceforge.jheader.*;
import net.sourceforge.jheader.App1Header.*;

public class DateTimeTagValueComponent extends JButton
    implements ActionListener, TagValueComponent
{
    private TagValue m_value;
    private Frame m_parent;
    private DateTimeDialog m_dialog;
    private HashSet<CellEditorListener> m_listeners
        = new HashSet<CellEditorListener>();

    public DateTimeTagValueComponent(TagValue value, Frame parent,
				     Color color)
	throws TagFormatException
    {
	super(value.getAsString());
	setAlignmentX(LEFT_ALIGNMENT);
	m_value = value;
	m_parent = parent;
        addActionListener(this);
        setBorderPainted(false);
	setBackground(color);

        //Set up the dialog that the button brings up.
        m_dialog = new DateTimeDialog(parent,
				    value.getAsDateTimeTag().asCalendar(),
				    "Edit Date/Time");
    }

    /**
     * Handles events from the editor button and from
     * the dialog's OK button.
     */
    public void actionPerformed(ActionEvent evt)
    {
        if (evt.getSource() == this)
	{
            if (m_dialog.getResponse())
	    {
		try
		{
		    m_value  = new TagValue(m_value.getTag(),
					    new DateTimeTag(m_dialog.getCalendar()));
		    ChangeEvent evt1 = new ChangeEvent(this);
		    for (CellEditorListener l : m_listeners)
			l.editingStopped(evt1);
		}
		catch (TagFormatException e)
		{
		    // shouldn't happen as we validated this before
		    e.printStackTrace();
		    JOptionPane.showMessageDialog(m_parent,
						  "Couldn't set tag value",
						  "Error",
						  JOptionPane.ERROR_MESSAGE);
		    ChangeEvent evt1 = new ChangeEvent(this);
		    for (CellEditorListener l : m_listeners)
			l.editingCanceled(evt1);
		}
	    }
	    else
	    {
		ChangeEvent evt1 = new ChangeEvent(this);
		for (CellEditorListener l : m_listeners)
		    l.editingCanceled(evt1);
	    }
        }
    }

    public TagValue getTagValue() throws TagFormatException
    {
	return m_value;
    }
    
    public String getAsString()
    {
	return m_value.getAsString();
    }

    public DateTimeDialog getDialog()
    {
	return m_dialog;
    }

    public void addCellEditorListener(CellEditorListener l)
    {
	m_listeners.add(l);
    }

    public void removeCellEditorListener(CellEditorListener l)
    {
	m_listeners.remove(l);
    }
}

