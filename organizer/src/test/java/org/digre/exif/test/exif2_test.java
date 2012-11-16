package org.digre.exif.test;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.SortedMap;

import mediautil.image.jpeg.Exif;
import mediautil.image.jpeg.LLJTran;
import mediautil.image.jpeg.LLJTranException;
import net.sourceforge.jheader.App1Header;
import net.sourceforge.jheader.App1Header.Tag;
import net.sourceforge.jheader.App1Header.TagFormat;
import net.sourceforge.jheader.JpegFormatException;
import net.sourceforge.jheader.JpegHeaders;
import net.sourceforge.jheader.TagValue;

import mediautil.gen.directio.*;
import mediautil.image.ImageResources;
import mediautil.image.jpeg.AbstractImageInfo;
import mediautil.image.jpeg.LLJTran;
import mediautil.image.jpeg.Exif;
import mediautil.image.jpeg.Entry;
import mediautil.image.jpeg.LLJTranException;

import org.junit.Test;

public class exif2_test {

    @Test
    public void test_exif() {
        String fname = "C:/git/PersHomeProjects/album/100CANON/IMG_6563.JPG";

        try {
            LLJTran llj = new LLJTran(new File(fname));
            readImage(llj, true, LLJTran.READ_INFO, 0, 0);
            AbstractImageInfo obj = llj.getImageInfo();
            Exif exif = (Exif) obj;


            JpegHeaders hdrs = new JpegHeaders(fname);
            App1Header app1Header = hdrs.getApp1Header();
        } catch (Exception e) {
            e.printStackTrace();
        }

        fail("Not yet implemented");
    }

    public static void readImage(LLJTran llj, boolean keep_appxs, int stage1, int stage2, int stage3)
        throws LLJTranException {
        if (stage1 != 0)
            llj.read(stage1, keep_appxs);
        if (stage2 != 0)
            llj.read(stage2, keep_appxs);
        System.out.println("frm_x = " + llj.getWidth() + " frm_y = " + llj.getHeight() + " maxHi = "
            + llj.getMaxHSamplingFactor() + " maxVi = " + llj.getMaxVSamplingFactor() + " widthMCU = "
            + llj.getWidthInMCU() + " heightMCU = " + llj.getHeightInMCU());
        if (stage3 != 0)
            llj.read(stage3, keep_appxs);
        System.out.println("Info = " + llj.getImageInfo());
        System.out.println("Successfully Read Image");
    }

}
