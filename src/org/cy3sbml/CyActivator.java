package org.cy3sbml;

import org.osgi.framework.BundleContext;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.work.TaskFactory;

import org.cy3sbml.AddTwoNodesTaskFactory;

import java.util.Properties;


public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}

	public void start(BundleContext bc) {
		CyApplicationManager cyApplicationManager = getService(bc, CyApplicationManager.class);
		VisualMappingManager visualMappingManager = getService(bc, VisualMappingManager.class);
		
		AddTwoNodesTaskFactory addTwoNodesTaskFactory = new AddTwoNodesTaskFactory(cyApplicationManager, visualMappingManager);
		Properties addTwoNodesTaskFactoryProps = new Properties();
		addTwoNodesTaskFactoryProps.setProperty("preferredMenu","Apps.Samples");
		addTwoNodesTaskFactoryProps.setProperty("title","Add two nodes");
		registerService(bc,addTwoNodesTaskFactory,TaskFactory.class, addTwoNodesTaskFactoryProps);

	}
}
