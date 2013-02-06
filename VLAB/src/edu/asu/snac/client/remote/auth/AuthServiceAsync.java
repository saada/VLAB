package edu.asu.snac.client.remote.auth;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.asu.snac.shared.web.AuthRequest;
import edu.asu.snac.shared.web.WebResponse;

public interface AuthServiceAsync {
	void onHandleRequest(AuthRequest request,
			AsyncCallback<WebResponse<String>> callback)
			throws IllegalArgumentException;
}
