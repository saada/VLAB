package edu.asu.snac.server;

public enum SessionState {
	UnAuth, Authed;

	public static String getName() {
		return SessionState.class.getSimpleName();
	}

}
