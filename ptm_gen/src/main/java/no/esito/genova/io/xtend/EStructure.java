package no.esito.genova.io.xtend;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

public class EStructure {

    public URLClassLoader cl;

    public EClass xroot;

    public HashSet<EClass> set = new HashSet<EClass>();

    private Class<?> xobject;

    public EStructure(URLClassLoader cl) {
        this.cl = cl;
    }

    public void load(IFolder folder) {
        try {
            IResource[] members = folder.members();
            for (IResource res : members) {
                String name = res.getName();
                if (name.endsWith("java")) {
                    String clzname = name.substring(0, name.lastIndexOf("."));
                    Class<?> clazz = cl.loadClass(clzname);
                    if ("XObject".equals(clzname))
                        xobject = clazz;
                    Class<?> sc = clazz;
                    while(sc!=null){
                        if("XObject".equals(sc.getSimpleName())){
                            EClass clz = new EClass(clazz);
                            set.add(clz);
                            if ("XRoot".equals(clzname))
                                xroot = clz;
                        }
                        sc=sc.getSuperclass();
                    }
                }
            }
            for (EClass ecl : new ArrayList<EClass>(set)) {
                Class<?> sc = ecl.clazz;
                while(sc!=null){
                    for (EClass ecl2 : set) {
                        if (ecl2.clazz == sc && ecl!=ecl2)
                            ecl2.addSubclass(ecl);
                    }
                    sc=sc.getSuperclass();
                }
            }
            for (EClass ecl : new ArrayList<EClass>(set)) {
                Method[] methods = ecl.clazz.getDeclaredMethods();
                for (Method method : methods) {
                    Type generic = method.getGenericReturnType();
                    if(generic instanceof ParameterizedType){
                        for(Type fieldArgType : ((ParameterizedType)generic).getActualTypeArguments()){
                            Class<?> genericParam = (Class<?>) fieldArgType;
                            for (EClass ecl2 : set) {
                                if (ecl2.clazz == genericParam)
                                    ecl.addIterator(ecl2);
                            }
                        }                    
                    }
                }
            }
        } catch (CoreException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public EClass getRoot(Collection<String> collection) {
        EClass found = null;
        for (EClass ecl : set) {
            if (ecl.isCompatible(collection)) {
                if (found == null || ecl.iterators.size() < found.iterators.size())
                    found = ecl;
            }
        }
        return found==null?xroot:found;
    }
    
    
    
    public void saveResource(IFolder folder, String outputfile, CharSequence text) {
        InputStream source = new ByteArrayInputStream(text.toString().getBytes());
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

	public void print(IFolder folder) {
		for (EClass ecl : set) {
			saveResource(folder,ecl.getName()+".properties",ecl.print());
		}
	}

}
