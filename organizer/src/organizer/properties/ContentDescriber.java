package organizer.properties;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.content.IContentDescriber;
import org.eclipse.core.runtime.content.IContentDescription;


public class ContentDescriber implements IContentDescriber{

    public ContentDescriber() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public int describe(InputStream contents, IContentDescription description) throws IOException {
        return IContentDescriber.VALID;
    }

    @Override
    public QualifiedName[] getSupportedOptions() {
        return null;
    }

}
