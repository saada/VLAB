package edu.asu.snac.client.api;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ApiServiceAsync {
	void doAuth(ApiRequest request, AsyncCallback<ApiResponse> callback)
			throws IllegalArgumentException;
}
