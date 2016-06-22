package org.cyadd2nodes;

import org.osgi.framework.BundleContext;

import netscape.javascript.JSObject;
import javafx.application.Platform;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import org.cyadd2nodes.AddTwoNodesTaskFactory;
import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.work.TaskFactory;

import java.util.Properties;


@SuppressWarnings("restriction")
public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}

	public void start(BundleContext bc) {
		
		try {
			
			// we have to be on JavaFX application thread
			Platform.runLater(new Runnable() {
                @Override
                public void run() {
                	WebView webView = new WebView();
        			WebEngine webEngine = webView.getEngine();
        			
                    JSObject win = (JSObject) webEngine.executeScript("window");        
                }
            });
			
			
            
		
            /*
			CyApplicationManager cyApplicationManager = getService(bc, CyApplicationManager.class);
			VisualMappingManager visualMappingManager = getService(bc, VisualMappingManager.class);
			
			AddTwoNodesTaskFactory addTwoNodesTaskFactory = new AddTwoNodesTaskFactory(cyApplicationManager, visualMappingManager);
			Properties addTwoNodesTaskFactoryProps = new Properties();
			addTwoNodesTaskFactoryProps.setProperty("preferredMenu","Apps.Samples");
			addTwoNodesTaskFactoryProps.setProperty("title","Add two nodes");
			registerService(bc,addTwoNodesTaskFactory,TaskFactory.class, addTwoNodesTaskFactoryProps);
			*/

		} catch (Throwable e){
			System.out.println("Could not start server!");
			e.printStackTrace();
		}
	}
}
