package edu.asu.snac.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.asu.snac.shared.web.WebResponse;

public abstract class BaseRemoteServiceServlet<T, K> extends
		RemoteServiceServlet {
	private static final long serialVersionUID = 231251893624780487L;

	public WebResponse<K> handleRequest(T request) {
		SessionState state = getSessionState();
		if (state == SessionState.UnAuth) {
			return WebResponse.ofUnauth();
		} else {
			return onHandleRequest(request);
		}
	}

	protected SessionState getSessionState() {
		SessionState state = (SessionState) getSession().getAttribute(
				SessionState.getName());
		return state;
	}

	protected HttpSession getSession() {
		HttpServletRequest request = this.getThreadLocalRequest();
		return request.getSession();
	}

	public abstract WebResponse<K> onHandleRequest(T request);
}
