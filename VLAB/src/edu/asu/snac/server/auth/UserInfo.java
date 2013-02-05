package edu.asu.snac.server.auth;

public class UserInfo {
	private String uid;
	private String login;
	private String display;
	private UserRoleMap roles;

	public UserInfo(String uid) {
		this.uid = uid;
		// TODO read data from db...
		this.display = "Admin";
	}

	public String getUid() {
		return uid;
	}
}
