
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
import java.awt.event.*;
import net.sourceforge.jheader.*;

/**
 * Interface for all components that edit tag values.
 */
public interface TagValueComponent
{
    /**
     * Return the user-entered tag value.
     *
     * @return the user-entered tag value.
     */
    public TagValue getTagValue() throws TagFormatException;

    /**
     * Return the user-entered tag value as a string.
     *
     * @return the user-entered tag value as a string.
     */
    public String getAsString();
}
