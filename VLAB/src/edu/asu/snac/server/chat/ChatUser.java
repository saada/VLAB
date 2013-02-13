package edu.asu.snac.server.chat;

import edu.asu.snac.server.auth.UserInfo;

public class ChatUser {
	private UserInfo userInfo;
	private int startIndex;

	public ChatUser(UserInfo info) {
		userInfo = info;
		startIndex = 0;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void increasementStartIndex() {
		startIndex++;
		if (startIndex >= ChatRoom.Max_Chat) {
			startIndex = 0;
		}
	}

	public int getStartIndex() {
		return this.startIndex;
	}

	public void setStartIndex(int i) {
		startIndex = i;
	}
}
