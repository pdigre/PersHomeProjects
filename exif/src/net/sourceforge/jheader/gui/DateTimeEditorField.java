
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

public class DateTimeEditorField extends JPanel implements ActionListener
{
    private JLabel m_label;
    private JButton m_button;
    private DateTimeDialog m_dialog;
    private Calendar m_cal;
    
    public DateTimeEditorField(Calendar cal, int height, Frame parent)
    {
	super(new BorderLayout(5,5));
	m_cal = cal;
	m_label = new JLabel(new DateTimeTag(m_cal).toString());
	m_button = new JButton("Edit...");
	add(BorderLayout.CENTER, m_label);
	add(BorderLayout.EAST, m_button);
	if (height > 0)
	{
	    setSize(getWidth(),height);
	    m_label.setSize(m_label.getWidth(),height);
	    m_button.setSize(m_button.getWidth(),height);
	}
	m_button.addActionListener(this);

        m_dialog = new DateTimeDialog(parent, m_cal, "Edit Date/Time");
    }

    public void setText(String text)
    {
	m_label.setText(text);
    }

    public void setCalendar(Calendar cal)
    {
	m_cal = cal;
	m_label.setText(new DateTimeTag(cal).toString());
    }
    
    public Calendar getCalendar()
    {
	return m_cal;
    }

    public void actionPerformed(ActionEvent e)
    {
	if (e.getSource() == m_button)
	{
            if (m_dialog.getResponse())
		m_cal = m_dialog.getCalendar();
	}
    }
}
