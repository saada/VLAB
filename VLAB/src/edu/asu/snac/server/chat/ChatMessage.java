package edu.asu.snac.server.chat;

public class ChatMessage {
	private String uid;
	private String content;
	private long time;

	public ChatMessage(String uid, String content) {
		this.uid = uid;
		this.content = content;
		time = System.currentTimeMillis();
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
}
