import java.util.concurrent.Callable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


public class Activator implements BundleActivator, Callable<String> {

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("hi");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
	}

	@Override
	public String call() throws Exception {
		return null;
	}

}
