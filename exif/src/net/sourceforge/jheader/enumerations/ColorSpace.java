
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
package net.sourceforge.jheader.enumerations;
import net.sourceforge.jheader.*;

import java.util.*;

public class ColorSpace extends EnumeratedTag
{
    public static final long RGB = 1;
    public static final long UNCALIBRATED = 65535;
    
    static private Object[] data = new Object[] {
	RGB, "RGB",
	UNCALIBRATED, "Uncalibrated"
    };

    static
    {
	populate(ColorSpace.class, data);
    }

    
    public ColorSpace(Long value) {super(value);}
    public ColorSpace(String value) throws TagFormatException {super(value);}
}
