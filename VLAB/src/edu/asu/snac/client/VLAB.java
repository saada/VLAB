package edu.asu.snac.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;

import edu.asu.snac.client.widget.ChatWidget;
import edu.asu.snac.client.widget.LoginWidget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class VLAB implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		// History handles all the page routing and back/forward button handling
		History.addValueChangeHandler(new ValueChangeHandler<String>() {
			public void onValueChange(ValueChangeEvent<String> event) {
				
				String historyToken = event.getValue();
				
				if (historyToken.equals("chat")) 
				{
					RootPanel.get().clear();
					RootPanel.get().add(new ChatWidget());
				}
				else if (historyToken.equals("login")){
					RootPanel.get().clear();
					RootPanel.get().add(new LoginWidget());
				}
				else {
					RootPanel.get().clear();
					RootPanel.get().add(new LoginWidget());
				}
			} 
		});
		
		History.newItem("login");
	}
}
