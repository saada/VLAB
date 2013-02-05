package edu.asu.snac.client.auth;

public class AuthResponse {
	public final static int RESULT_FAILED = 0;
	public final static int RESULT_SUCCEEDED = 1;

	private String info;
	private int result;

	public AuthResponse(int result) {
		this.result = result;
	}

	public AuthResponse setInfo(String info) {
		this.info = info;
		return this;
	}

	public String getInfo() {
		return info;
	}

	public boolean hasSucceeded() {
		return result == RESULT_SUCCEEDED;
	}

	public static AuthResponse ofFailed() {
		return new AuthResponse(RESULT_FAILED);
	}

	public static AuthResponse ofSucceeded() {
		return new AuthResponse(RESULT_SUCCEEDED);
	}
}
