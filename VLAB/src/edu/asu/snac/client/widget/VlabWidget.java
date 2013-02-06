package edu.asu.snac.client.widget;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Panel;

public class VlabWidget extends Composite {

	@Override
	protected void onAttach() {
		super.onAttach();
	}

	@Override
	protected void onDetach() {
		super.onDetach();
	}

	@Override
	protected void onLoad() {
		super.onLoad();
	}

	@Override
	protected void onUnload() {
		super.onUnload();
	}

	public VlabWidget() {
	}

	// Constructor that takes a panel have all the GWT widgets (buttons, labels,
	// etc...)
	public void buildPanel(Panel panel) {
		initWidget(panel); // initWidget is a Composite function that creates
							// this instance's Widget properties
	}

	public void buildPanel(Panel panel, String style) {
		initWidget(panel); // initWidget is a Composite function that creates
							// this instance's Widget properties
		setStyleName(style); // Any name for the style of this panel
	}

}
