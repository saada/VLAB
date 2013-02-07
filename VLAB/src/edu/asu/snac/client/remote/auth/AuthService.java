package edu.asu.snac.client.remote.auth;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.asu.snac.client.remote.BaseRemoteService;
import edu.asu.snac.shared.web.AuthRequest;

@RemoteServiceRelativePath("AuthService")
public interface AuthService extends BaseRemoteService<AuthRequest, String> {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static AuthServiceAsync instance;

		public static AuthServiceAsync getInstance() {
			if (instance == null) {
				instance = GWT.create(AuthService.class);
			}
			return instance;
		}
	}
}
