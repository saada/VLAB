package edu.asu.snac.shared.web;

import java.io.Serializable;

public class WebResponse<T> implements Serializable {
	private static final long serialVersionUID = -443679452962222111L;
	public final static int RESULT_UNAUTH = -1;
	public final static int RESULT_FAILED = 0;
	public final static int RESULT_SUCCEEDED = 1;

	private T info;
	private int result;

	public WebResponse<T> setResult(int result) {
		this.result = result;
		return this;
	}

	public WebResponse<T> setInfo(T info) {
		this.info = info;
		return this;
	}

	public T getInfo() {
		return info;
	}

	public boolean hasSucceeded() {
		return result == RESULT_SUCCEEDED;
	}

	public static <T> WebResponse<T> ofUnauth() {
		return new WebResponse<T>().setResult(RESULT_UNAUTH);
	}

	public static <T> WebResponse<T> ofFailed() {
		return new WebResponse<T>().setResult(RESULT_FAILED);
	}

	public static <T> WebResponse<T> ofSucceeded() {
		return new WebResponse<T>().setResult(RESULT_FAILED);
	}
}
