package org.digre.organizer.navigator;

import org.eclipse.ui.IStartup;


public class Startup implements IStartup {

    @Override
    public void earlyStartup() {
        System.out.println("hi");
    }

}
