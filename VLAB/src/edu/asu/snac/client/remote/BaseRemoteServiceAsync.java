package edu.asu.snac.client.remote;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.asu.snac.shared.web.WebResponse;

public interface BaseRemoteServiceAsync<T, K> {
	public void onHandleRequest(T request,
			AsyncCallback<WebResponse<K>> callback)
			throws IllegalArgumentException;
}
