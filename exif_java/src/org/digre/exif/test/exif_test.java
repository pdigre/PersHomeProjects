package org.digre.exif.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

import net.sourceforge.jheader.App1Header;
import net.sourceforge.jheader.App1Header.Tag;
import net.sourceforge.jheader.App1Header.TagFormat;
import net.sourceforge.jheader.ExifFormatException;
import net.sourceforge.jheader.JpegFormatException;
import net.sourceforge.jheader.JpegHeaders;
import net.sourceforge.jheader.TagFormatException;
import net.sourceforge.jheader.TagValue;
import net.sourceforge.jheader.gui.JHeaderTool;

import org.junit.Test;


public class exif_test {

    @Test
    public void test() {
        try {
            JpegHeaders hdrs = new JpegHeaders("C:/git/PersHomeProjects/album/100CANON/IMG_6550.JPG");
            App1Header app1Header = hdrs.getApp1Header();
            SortedMap<Tag, TagValue> tags = app1Header.getTags();
            Set<Entry<Tag, TagValue>> entrySet = tags.entrySet();
            for (Entry<Tag, TagValue> entry : entrySet) {
                TagValue val = entry.getValue();
                Tag key = entry.getKey();
                Tag tag = val.getTag();
                TagFormat format = tag.format;
                System.out.println(key+"="+val);
            }
        } catch (IOException
            | JpegFormatException e) {
            e.printStackTrace();
        }
        fail("Not yet implemented");
    }

}
