
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
 * Component for editing SRATIONAL and URATIONAL tag values.
 *
 * This is used by TagTable when a STRING tag value is editted.
 */
public class RationalTagValueComponent extends JPanel
    implements TagValueComponent
{
    private TagValue m_value;
    private JTextField m_numer;
    private JLabel m_divider;
    private JTextField m_denom;
    
    /**
     * Constructor.
     *
     * @param value the value to edit.
     * @throws TagFormatException if the tag value cannot be retrieved with
     * the expected type.
     */
    public RationalTagValueComponent(TagValue value) throws TagFormatException
    {
	super(new FlowLayout(FlowLayout.LEFT,0,0));
	m_value = value;
	Rational rational = m_value.getAsRational();
	m_numer = new JTextField(""+rational.numerator, 5);
	m_divider = new JLabel("/");
	m_denom = new JTextField(""+rational.denominator, 5);
	add(m_numer);
	add(m_divider);
	add(m_denom);
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
	try
	{
	    long numer = Long.parseLong(m_numer.getText());
	    long denom = Long.parseLong(m_denom.getText());
	    Rational rational = new Rational(numer, denom);
	    return new TagValue(m_value.getTag(), rational);
	}
	catch (NumberFormatException e)
	{
	    e.printStackTrace();
	    throw new TagFormatException(m_numer.getText()+"/"
					 +m_denom.getText()
					 + " is not a valid rational");
	}
    }
    
    /**
     * Returns the editted value as a string.
     *
     * @return the editted value as a string.
     */
    public String getAsString()
    {
	return m_numer.getText()+"/"+m_denom.getText();
    }

    /**
     * Sets the height of the table cell in which this is displayed
     *
     * @param h cell height
     */
    public void setHeight(int h)
    {
	setSize(getWidth(),h);
	m_numer.setSize(m_numer.getWidth(),h);
	m_divider.setSize(m_divider.getWidth(),h);
	m_denom.setSize(m_denom.getWidth(),h);
    }
    
}
