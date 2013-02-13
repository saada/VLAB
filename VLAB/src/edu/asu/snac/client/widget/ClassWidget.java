package edu.asu.snac.client.widget;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;

public class ClassWidget extends BaseWidget {
	public ClassWidget() {
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.getElement().getStyle().setOverflow(Overflow.VISIBLE);
		
		
//		Image image = new Image((String) null);
//		absolutePanel.add(image, 0, 0);
//		image.setSize("254px", "75px");
		
		Hyperlink hplink = new Hyperlink("CSE412", "");
		hplink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
			}
		});
		absolutePanel.add(hplink, 83, 89);
		
		Label lblDescription = new Label("Description");
		absolutePanel.add(lblDescription, 10, 120);
		lblDescription.setSize("234px", "49px");
		
		initWidget(absolutePanel);
		
		

	}
	
}
