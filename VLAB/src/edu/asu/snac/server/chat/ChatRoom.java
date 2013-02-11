package edu.asu.snac.server.chat;

import java.util.List;

import edu.asu.snac.server.auth.UserInfo;
import edu.asu.snac.shared.CircularList;
import edu.asu.snac.shared.Map;
import edu.asu.snac.shared.UUIDPool;

public class ChatRoom {
	public static final int Max_Chat = 100;

	private String id;
	private Map<String, ChatUser> users;
	private CircularList<ChatMessage> chats;

	public ChatRoom() {
		id = UUIDPool.getInstance().getId();
		users = new Map<String, ChatUser>();
		chats = new CircularList<ChatMessage>(Max_Chat);
	}

	public void join(UserInfo userInfo) {
		users.put(userInfo.getUid(), new ChatUser(userInfo));
	}

	public void exit(String uid) {
		users.remove(uid);
	}

	public void addChat(String uid, String content) {
		ChatUser chatUser = null;
		chatUser = users.get(uid);
		if (chatUser != null) {
			synchronized (chatUser) {
				chats.add(new ChatMessage(uid, content));
				chatUser.increasementStartIndex();
			}
		}
	}

	public List<ChatMessage> getChat(String uid) {
		ChatUser chatUser = null;
		chatUser = users.get(uid);
		if (chatUser != null) {
			synchronized (chatUser) {
				int start = chatUser.getStartIndex();
				List<ChatMessage> list = chats.getRange(start);
				chatUser.setStartIndex((start + list.size()) % Max_Chat);
				return list;
			}
		} else {
			throw new IllegalArgumentException("User not in chat room!");
		}
	}

	public String getId() {
		return id;
	}
}
