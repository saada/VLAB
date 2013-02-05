package edu.asu.snac.client.api;

import java.io.Serializable;

public class ApiResponse implements Serializable {
	public final static int RESULT_FAILED = 0;
	public final static int RESULT_SUCCEEDED = 1;

	private String info;
	private int result;

	public ApiResponse setResult(int result) {
		this.result = result;
		return this;
	}

	public ApiResponse setInfo(String info) {
		this.info = info;
		return this;
	}

	public String getInfo() {
		return info;
	}

	public boolean hasSucceeded() {
		return result == RESULT_SUCCEEDED;
	}

	public static ApiResponse ofFailed() {
		return new ApiResponse().setResult(RESULT_FAILED);
	}

	public static ApiResponse ofSucceeded() {
		return new ApiResponse().setResult(RESULT_FAILED);
	}
}
