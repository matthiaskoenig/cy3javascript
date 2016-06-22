package org.cyadd2nodes;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

// !!! Impossible to access in OSGI !!!
import netscape.javascript.JSObject;


@SuppressWarnings("restriction")
public class WebViewSwing {
	
	private static void initAndShowGUI() {
        // This method is invoked on the EDT thread
		
        JDialog dialog = new JDialog();
        dialog.setTitle("WebView Test");
        
        // use values from Scene Builder
        int width = 500;
        int height = 500;
        
        final JFXPanel fxPanel = new JFXPanel();
        
        dialog.add(fxPanel);
        dialog.setSize(width, height);
        dialog.setVisible(true);
        dialog.setBackground(new Color(255, 255, 255));
        dialog.setResizable(false);
        
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
       });
    }

    private static void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        
			WebView webView = new WebView();
	    	Scene scene = new Scene(webView);
	        fxPanel.setScene(scene);
	        
	        WebEngine webEngine = webView.getEngine();
	        webEngine.load("http://www.google.com");
			
			// How can I get access to JSObject in OSGI ?????
	        // No problem running this via main
            JSObject win = (JSObject) webEngine.executeScript("window"); 
    }
	
    /** 
     * Start the JFXPanel. 
     * Main entry point to open the GUI.
     */
    public static void launch(){
    	
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initAndShowGUI();
            }
        });
    }
    
    /** Testing the GUI without Cytoscape specific functionality. */
    public static void main(String[] args) {
    	// GUI launch without Cytoscape
    	launch();
    }
}
