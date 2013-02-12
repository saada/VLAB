package edu.asu.snac.client.widget;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class ChatWidget extends BaseWidget {
	TextBox messageBox;
	
	@Override
	protected void onAttach() {
		Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand () {
	        public void execute () {
	            messageBox.setFocus(true);
	        }
	    });
		super.onAttach();
	}
	
	public ChatWidget() {
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("737px", "378px");
		
		Button sendButton = new Button("Send");
		absolutePanel.add(sendButton, 656, 338);
		sendButton.setSize("81px", "40px");
		
		TextArea chatArea = new TextArea();
		chatArea.setText("Chat messages appear here...");
		absolutePanel.add(chatArea, 0, 0);
		chatArea.setSize("727px", "329px");
		chatArea.setReadOnly(true);
		chatArea.getElement().getStyle().setProperty("resize","none");
		
		messageBox = new TextBox();
		
		absolutePanel.add(messageBox, 0, 338);
		messageBox.setSize("643px", "28px");
	}
}
