package edu.asu.snac.client.auth;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AuthServiceAsync {
	void doAuth(AuthRequest request, AsyncCallback<AuthResponse> callback)
			throws IllegalArgumentException;
}
