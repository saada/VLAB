package edu.asu.snac.shared.web;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AuthRequest implements Serializable {
	private String login;
	private String pw;

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPW(String pw) {
		this.pw = pw;
	}

	public String getLogin() {
		return login;
	}

	public String getPw() {
		return pw;
	}
}
