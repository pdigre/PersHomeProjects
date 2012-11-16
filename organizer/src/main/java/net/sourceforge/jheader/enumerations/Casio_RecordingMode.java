
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

public class Casio_RecordingMode extends EnumeratedTag
{
    public static final long SINGLE_SHUTTER = 1;
    public static final long PANORAMA = 2;
    public static final long NIGHT_SCENE = 3;
    public static final long PORTRAIT = 4;
    public static final long LANDSCAPE = 5;
    
    static private Object[] data = new Object[] {
	SINGLE_SHUTTER, "Single Shutter",
	PANORAMA, "Panorama",
	NIGHT_SCENE, "Night Scene",
	PORTRAIT, "Portrait",
	LANDSCAPE, "Landscape"
    };

    static
    {
	populate(Casio_RecordingMode.class, data);
    }

    
    public Casio_RecordingMode(Long value) {super(value);}
    public Casio_RecordingMode(String value) throws TagFormatException {super(value);}
}
