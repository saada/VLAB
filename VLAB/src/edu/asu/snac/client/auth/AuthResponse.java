package edu.asu.snac.client.auth;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AuthResponse implements Serializable {
	public final static int RESULT_FAILED = 0;
	public final static int RESULT_SUCCEEDED = 1;

	private String info;
	private int result;

	public AuthResponse setResult(int result) {
		this.result = result;
		return this;
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
		return new AuthResponse().setResult(RESULT_FAILED);
	}

	public static AuthResponse ofSucceeded() {
		return new AuthResponse().setResult(RESULT_FAILED);
	}
}
