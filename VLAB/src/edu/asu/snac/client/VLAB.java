package edu.asu.snac.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import edu.asu.snac.client.widget.LoginWidget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class VLAB implements EntryPoint {
	

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		LoginWidget lw = new LoginWidget();

		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get("pageContainer");
		rootPanel.add(lw);
	}
}
