package edu.asu.snac.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.asu.snac.client.remote.auth.AuthService;
import edu.asu.snac.client.remote.auth.AuthServiceAsync;
import edu.asu.snac.shared.web.AuthRequest;
import edu.asu.snac.shared.web.WebResponse;

public class LoginWidget extends BaseWidget {

	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	private final AuthServiceAsync authService = GWT.create(AuthService.class);

	private TextBox usernameField;

	private PasswordTextBox passwordTextBox;

	private Button loginButton;

	private DialogBox dialogBox;

	private HTML serverResponseLabel;

	private Button closeButton;
	private AbsolutePanel panel;
	protected void onAttach(){
		Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand () {
	        public void execute () {
	            usernameField.setFocus(true);
	        }
	    });
		super.onAttach();
	}
	
	public LoginWidget() {
		panel = new AbsolutePanel();
		panel.getElement().getStyle().setOverflow(Overflow.VISIBLE);
		loginButton = new Button("login");
		
		// We can add style names to widgets
		loginButton.addStyleName("sendButton");

		Label lblEmail = new Label("Email");
		panel.add(lblEmail, 73, 134);
		usernameField = new TextBox();
		usernameField.setAlignment(TextAlignment.LEFT);

		panel.add(usernameField, 120, 132);
		usernameField.setSize("142px", "14px");

		// Focus the cursor on the name field when the app loads
		usernameField.getElement().focus();
		usernameField.selectAll();

		Label lblPassword = new Label("Password");
		panel.add(lblPassword, 54, 168);

		passwordTextBox = new PasswordTextBox();
		panel.add(passwordTextBox, 120, 164);
		passwordTextBox.setSize("142px", "16px");
		panel.add(loginButton, 120, 212);
		loginButton.setSize("156px", "40px");

		HTML htmlNewHtml = new HTML("<h1>Welcome to VLAB</h1>", true);
		panel.add(htmlNewHtml, 59, 51);
		htmlNewHtml.setSize("279px", "83px");

		dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		closeButton = new Button("Close");

		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				loginButton.setEnabled(true);
				loginButton.setFocus(true);
			}
		});

		// Add a handler to send the name to the server
		ClickAndKeyHandler handler = new ClickAndKeyHandler();
		usernameField.addKeyUpHandler(handler);
		passwordTextBox.addKeyUpHandler(handler);
		loginButton.addClickHandler(handler);

		super.buildPanel(panel);
	}

	/**
	 * Send the name from the nameField to the server and wait for a response.
	 */
	private void login() {
		// First, we validate the input.
		String login = usernameField.getText();
		String pw = passwordTextBox.getText();

		// Then, we send the input to the server.
		loginButton.setEnabled(false);
		AuthRequest authRequest = new AuthRequest();
		authRequest.setLogin(login);
		authRequest.setPW(pw);
		authService.onHandleRequest(authRequest,
				new AsyncCallback<WebResponse<String>>() {

					@Override
					public void onFailure(Throwable caught) {
						dialogBox.setText("Remote Procedure Call - Failure");
						serverResponseLabel
								.addStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML(SERVER_ERROR);
						dialogBox.center();
						closeButton.setFocus(true);
					}

					@Override
					public void onSuccess(WebResponse<String> result) {
						String uid = result.getInfo();
						dialogBox.setText("You are logged in sucker:" + uid);
						serverResponseLabel
								.addStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML("You are logged in sucker:"
								+ uid);
						dialogBox.center();
						closeButton.setFocus(true);
						if(uid.equals("54321"))
						{
							History.newItem("chat");
						}
					}
				});
	}

	// Create a handler for the sendButton and nameField
	class ClickAndKeyHandler implements ClickHandler, KeyUpHandler {
		/**
		 * Fired when the user clicks on the sendButton.
		 */
		public void onClick(ClickEvent event) {
			login();
		}

		/**
		 * Fired when the user types in the nameField.
		 */
		public void onKeyUp(KeyUpEvent event) {
			if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
				login();
			}
		}

	}
}
