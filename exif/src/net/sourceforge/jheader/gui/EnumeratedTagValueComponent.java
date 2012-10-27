
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
 * Component for editing enumerated tag values.
 *
 * This is used by TagTable when an enumerated  tag value is editted.
 */
public class EnumeratedTagValueComponent extends JComboBox
    implements TagValueComponent
{
    private TagValue m_value;
    private boolean m_lastIsNumeric = false;
    private HashMap<String,Long> m_strToLong = new HashMap<String,Long>();
    private String m_origValue;

    /**
     * Constructor.
     *
     * @param value the value to edit.
     * @throws TagFormatException if the tag value cannot be retrieved with
     * the expected type.
     */
    public EnumeratedTagValueComponent(TagValue value)
	throws TagFormatException
    {
	super();
	setEditable(false);
	m_value = value;
	m_origValue = new String(m_value.getAsString());
	EnumeratedTag etag = m_value.getAsEnumeration();
	SortedMap<Long, String> values = etag.getAll();
	boolean currValueFound = false;
	long currValue = etag.asLong();
	for (Long l : values.keySet())
	{
	    String s = values.get(l);
	    addItem(s);
	    m_strToLong.put(s,l);
	    if (l.longValue() == currValue)
	    {
		currValueFound = true;
		setSelectedItem(s);
	    }
	}
	if (!currValueFound)
	{
	    String item = "\""+currValue+"\"";
	    addItem(item);
	    m_lastIsNumeric = true;
	    setSelectedItem(item);
	}
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
	if (getSelectedItem().equals(m_origValue)) return m_value;
	if (m_lastIsNumeric && getSelectedIndex() == getItemCount()-1)
	    return new TagValue(m_value.getTag(), m_value.getAsLong());
	return new TagValue(m_value.getTag(),
			    m_strToLong.get((String)getSelectedItem()));
    }
    
    /**
     * Returns the editted value as a string.
     *
     * @return the editted value as a string.
     */
    public String getAsString()
    {
	return (String)getSelectedItem();
    }
    
}
