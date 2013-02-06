package edu.asu.snac.client.remote.auth;

import edu.asu.snac.shared.web.WebResponse;

public interface BaseRemoteService<T, K> {
	public abstract WebResponse<K> onHandleRequest(T request);
}
