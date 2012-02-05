package no.esito.genova.io.convert;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

public class EStructure {

	public EClass xroot;

	public HashSet<EClass> set = new HashSet<EClass>();

	public void load(IFolder folder,URLClassLoader cl) {
		try {
			IResource[] members = folder.members();
			for (IResource res : members) {
				String name = res.getName();
				if (name.endsWith("java") && name.startsWith("X")) {
					String clzname = name.substring(0, name.lastIndexOf("."));
					try {
						Class<?> clazz = cl.loadClass(clzname);
						Class<?> sc = clazz;
						while (sc != null) {
							if ("XObject".equals(sc.getSimpleName())) {
								EClass clz = new EClass(clazz);
								set.add(clz);
								if ("XRoot".equals(clzname))
									xroot = clz;
							}
							sc = sc.getSuperclass();
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			for (EClass ecl : new ArrayList<EClass>(set)) {
				Class<?> sc = ecl.clazz;
				while (sc != null) {
					for (EClass ecl2 : set) {
						if (ecl2.clazz == sc && ecl != ecl2)
							ecl2.addSubclass(ecl);
					}
					sc = sc.getSuperclass();
				}
				Method[] methods = ecl.clazz.getDeclaredMethods();
				for (Method method : methods) {
					Type generic = method.getGenericReturnType();
					if (generic instanceof ParameterizedType) {
						for (Type fieldArgType : ((ParameterizedType) generic)
								.getActualTypeArguments()) {
							Class<?> genericParam = (Class<?>) fieldArgType;
							for (EClass ecl2 : set) {
								if (ecl2.clazz == genericParam)
									ecl.addIterator(ecl2);
							}
						}
					} else {
						if(generic instanceof Class){
							Class<?> sub = ((Class)generic);
							String clazzname = sub.getSimpleName();
							String mname = method.getName();
							if(clazzname.startsWith("X") && mname.startsWith("get")){
								for (EClass ecl2 : set) {
									String name1 = ecl2.clazz.getSimpleName();
									if (name1.equals(clazzname))
										ecl.addLinks(mname,ecl2);
								}
							}
						}
					}
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public EClass getRoot(Collection<String> collection) {
		EClass found = null;
		for (EClass ecl : set) {
			if (ecl.isCompatible(collection)) {
				if (found == null
						|| ecl.iterators.size() < found.iterators.size())
					found = ecl;
			}
		}
		return found == null ? xroot : found;
	}

	public void saveResource(IFolder folder, String outputfile,
			CharSequence text) {
		InputStream source = new ByteArrayInputStream(text.toString()
				.getBytes());
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
			saveResource(folder, ecl.getName() + ".properties", ecl.print());
		}
	}

	public void recordVariable(EVariable var) {
		if (var.ctx != null) {
			for (EClass ecl : set) {
				if (var.ctx.equalsIgnoreCase(ecl.getName()))
					ecl.addVariable(var);
			}
		}
	}

	public void recordProperty(EProperty var) {
		if (var.ctx != null) {
			for (EClass ecl : set) {
				if (var.ctx.equalsIgnoreCase(ecl.getName()))
					ecl.addProperty(var);
			}
		}
	}

	public ELink getLink(String peek, String p1) {
		for (EClass ecl : set) {
			if (ecl.getName().equals(peek)){
				for (ELink  link: ecl.links) {
					if(link.name.equals(p1))
						return link;
				}
			}
		}
		return null;
	}

}
