package mediautil.test;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import mediautil.image.jpeg.LLJTran;
import mediautil.image.jpeg.LLJTranException;

import org.junit.Test;

public class per_test {

    @Test
    public void test_Rotate() {
        try {
            File file = new File("C:/git/PersHomeProjects/album/100CANON/IMG_6564.JPG");
            LLJTran llj = new LLJTran(file);
            llj.read(LLJTran.READ_ALL, true);
            int options = LLJTran.OPT_DEFAULTS | LLJTran.OPT_XFORM_ORIENTATION;
            llj.transform(LLJTran.ROT_270, options);
            OutputStream out = new BufferedOutputStream(new FileOutputStream("vmirror.jpg"));
            options = LLJTran.OPT_DEFAULTS & ~LLJTran.OPT_WRITE_APPXS;
            llj.transform(out, LLJTran.FLIP_V, options);
            out.close();
            out = new BufferedOutputStream(new FileOutputStream(
                "C:/git/PersHomeProjects/album/100CANON/IMG_6564b.JPG"));
            llj.save(out, LLJTran.OPT_WRITE_ALL);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (LLJTranException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
