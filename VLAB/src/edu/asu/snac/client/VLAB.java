package edu.asu.snac.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.asu.snac.client.auth.AuthRequest;
import edu.asu.snac.client.auth.AuthResponse;
import edu.asu.snac.client.auth.AuthService;
import edu.asu.snac.client.auth.AuthServiceAsync;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class VLAB implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	private final AuthServiceAsync authService = GWT.create(AuthService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final Button sendButton = new Button("Send");
		sendButton.setText("login");
		final TextBox usernameField = new TextBox();
		usernameField.setAlignment(TextAlignment.LEFT);
		final Label errorLabel = new Label();

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get("nameFieldContainer");
		rootPanel.add(usernameField, 120, 134);
		usernameField.setSize("146px", "14px");
		RootPanel.get("sendButtonContainer").add(sendButton, 120, 212);
		sendButton.setSize("156px", "40px");
		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Focus the cursor on the name field when the app loads
		usernameField.setFocus(true);

		final PasswordTextBox passwordTextBox = new PasswordTextBox();
		rootPanel.add(passwordTextBox, 120, 166);

		Label lblEmail = new Label("Email");
		rootPanel.add(lblEmail, 59, 140);

		Label lblPassword = new Label("Password");
		rootPanel.add(lblPassword, 60, 172);

		HTML htmlNewHtml = new HTML("<h1>Welcome to VLAB</h1>", true);
		rootPanel.add(htmlNewHtml, 59, 0);
		htmlNewHtml.setSize("279px", "109px");
		usernameField.selectAll();

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
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
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
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

			/**
			 * Send the name from the nameField to the server and wait for a
			 * response.
			 */
			private void login() {
				// First, we validate the input.
				errorLabel.setText("");
				String login = usernameField.getText();
				String pw = passwordTextBox.getText();

				// if (!FieldVerifier.isValidName(login)) {
				// errorLabel.setText("Please enter at least four characters");
				// return;
				// }

				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				AuthRequest authRequest = new AuthRequest();
				authRequest.setLogin(login);
				authRequest.setPW(pw);
				authService.doAuth(authRequest,
						new AsyncCallback<AuthResponse>() {

							@Override
							public void onFailure(Throwable caught) {
								dialogBox
										.setText("Remote Procedure Call - Failure");
								serverResponseLabel
										.addStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(SERVER_ERROR);
								dialogBox.center();
								closeButton.setFocus(true);
							}

							@Override
							public void onSuccess(AuthResponse result) {
								String uid = result.getInfo();
								dialogBox.setText("You are logged in sucker:"
										+ uid);
								serverResponseLabel
										.addStyleName("serverResponseLabelError");
								serverResponseLabel
										.setHTML("You are logged in sucker:"
												+ uid);
								dialogBox.center();
								closeButton.setFocus(true);
							}

						});
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		usernameField.addKeyUpHandler(handler);
	}
}
