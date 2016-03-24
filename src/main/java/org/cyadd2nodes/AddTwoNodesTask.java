package org.cyadd2nodes;

import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.vizmap.VisualStyle;

public class AddTwoNodesTask extends AbstractTask {
	
	private CyNetworkView netView;
	private final VisualMappingManager vmmServiceRef;
	
	public AddTwoNodesTask(final CyNetworkView netView, final VisualMappingManager vmmServiceRef){
		this.netView = netView;
		this.vmmServiceRef =vmmServiceRef;
	}
	
	public void run(TaskMonitor monitor) {
		
		CyNetwork network = netView.getModel();
		
		CyNode node1 = network.addNode();
		network.getDefaultNodeTable().getRow(node1.getSUID()).set("name", "Node1");
		
		CyNode node2 = network.addNode();
		network.getDefaultNodeTable().getRow(node2.getSUID()).set("name", "Node2");		
		
		// Apply the change to the view
		VisualStyle style = vmmServiceRef.getCurrentVisualStyle();
		style.apply(netView);
		netView.updateView();
	}
}
