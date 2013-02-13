package edu.asu.snac.server.auth;

import edu.asu.snac.client.remote.auth.AuthService;
import edu.asu.snac.server.BaseRemoteServiceServlet;
import edu.asu.snac.shared.web.AuthRequest;
import edu.asu.snac.shared.web.WebResponse;

public class AuthServiceImpl extends
		BaseRemoteServiceServlet<AuthRequest, String> implements AuthService {
	private static final long serialVersionUID = 5996691942880246779L;
	
	@Override
	public WebResponse<String> onHandleRequest(AuthRequest request) {
		String login = request.getLogin();
		String pw = request.getPw();

		String uid = checkCredential(login, pw);
		UserInfo userInfo = getUserInfo(uid);

		if (userInfo == null) {
			return WebResponse.<String> ofFailed().setInfo("wrong");
		} else {
			return WebResponse.<String> ofSucceeded()
					.setInfo(userInfo.getUid());
		}
	}

	private String checkCredential(String login, String pw) {
		if (login.equals("admin") && pw.equals("admin")) {
			return "54321";
		} else {
			return null;
		}
	}

	private UserInfo getUserInfo(String uid) {
		if (uid == null) {
			return null;
		}
		return new UserInfo(uid);
	}
}
