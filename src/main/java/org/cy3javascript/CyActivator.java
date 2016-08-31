package org.cy3javascript;

import org.cytoscape.service.util.AbstractCyActivator;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import java.io.InputStream;
import java.net.URL;

public class CyActivator extends AbstractCyActivator {
    public CyActivator() {
        super();
    }

    public void start(BundleContext bc) {

        try {
            // Loading the extension bundle from resources
            System.out.println("----------------------------");
            System.out.println("Install extension bundle");
            Bundle bundle = bc.getBundle();
            URL jarUrl = bundle.getEntry("extension/org.cy3javascript.extension-0.0.1.jar");
            InputStream input = jarUrl.openStream();
            Bundle interfaces = bc.installBundle(jarUrl.getPath(), input);
            input.close();
            System.out.println("----------------------------");

            // now we should be able to access netscape.javascript
            System.out.println("Accessing netscape.javascript");
            WebViewSwing.launch();

        } catch (Throwable e) {
            System.out.println("Could not start server!");
            e.printStackTrace();
        }
    }
}
