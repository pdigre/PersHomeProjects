
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
import javax.swing.*;
import javax.swing.table.*;
import net.sourceforge.jheader.*;
import net.sourceforge.jheader.App1Header.*;

/**
 * Component for editing STRING tag values.
 *
 * This is used by TagTable when a STRING tag value is editted. 
*/
public class StringTagValueComponent extends JTextField
    implements TagValueComponent
{
    private TagValue m_value;
    private String m_origValue;
    
    /**
     * Constructor.
     *
     * @param value the value to edit.
     * @throws TagFormatException if the tag value cannot be retrieved with
     * the expected type.
     */
    public StringTagValueComponent(TagValue value)
    {
	super(value.getAsString());
	m_value = value;
	m_origValue = new String(m_value.getAsString());
    }

    /**
     * Returns the editted value.
     *
     * @return the editted value.
     * @throws TagFormatException if the tag value cannot be retrieved with
     * the expected type.
     */
    public TagValue getTagValue() throws TagFormatException
    {
	if (m_origValue.equals(getText())) return m_value;
	return new TagValue(m_value.getTag(), getText());
    }

    /**
     * Returns the editted value as a string.
     *
     * @return the editted value as a string.
     */
    public String getAsString()
    {
	return getText();
    }
    
}
