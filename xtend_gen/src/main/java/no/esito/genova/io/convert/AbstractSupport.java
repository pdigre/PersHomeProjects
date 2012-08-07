package no.esito.genova.io.convert;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;

public class AbstractSupport {

    public String clazzname;

    public IFile output;
	public boolean scanMode = false;
	public EXPSTATE exprtype = EXPSTATE.Output;
	public boolean isClosed = true;

    public void saveResource(String outputdir, String outputfile, CharSequence text) {
        InputStream source = new ByteArrayInputStream(text.toString().getBytes());
        IFolder folder = output.getProject().getFolder(outputdir);
        try {
            IFile file = folder.getFile(outputfile);
            if (file.exists())
                file.setContents(source, true, true, null);
            else
                file.create(source, true, null);
        } catch (CoreException e) {
            e.printStackTrace();
        }
    }

	public Object _stat() {
		return null;
	}

	public boolean isEmpty() {
		return false;
	}


}
