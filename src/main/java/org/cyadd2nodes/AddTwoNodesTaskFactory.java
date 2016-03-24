package org.cyadd2nodes;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class AddTwoNodesTaskFactory extends AbstractTaskFactory {

	private final CyApplicationManager cyApplicationManagerServiceRef;
	private final VisualMappingManager vmmServiceRef;
	
	public AddTwoNodesTaskFactory(final CyApplicationManager cyApplicationManagerServiceRef, VisualMappingManager vmmServiceRef){
		this.cyApplicationManagerServiceRef = cyApplicationManagerServiceRef;
		this.vmmServiceRef = vmmServiceRef;
	}
	
	public TaskIterator createTaskIterator(){
		return new TaskIterator(new AddTwoNodesTask(cyApplicationManagerServiceRef.getCurrentNetworkView(), vmmServiceRef));
	}
}