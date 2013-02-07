package edu.asu.snac.client.remote;

import com.google.gwt.user.client.rpc.RemoteService;

import edu.asu.snac.shared.web.WebResponse;

public interface BaseRemoteService<T, K> extends RemoteService {
	public WebResponse<K> onHandleRequest(T request);
}
