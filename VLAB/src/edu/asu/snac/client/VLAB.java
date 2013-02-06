package edu.asu.snac.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;

import edu.asu.snac.client.widget.LoginWidget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class VLAB implements EntryPoint {
	
	LoginWidget login;
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		login = new LoginWidget();

		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get("pageContainer");
		Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand () {
	        public void execute () {
	            login.usernameField.setFocus(true);
	        }
	    });
	    rootPanel.add(login);
	}
}
