package edu.asu.snac.server.chat;

import edu.asu.snac.shared.Map;

public class ChatRoomMap extends Map<String, ChatRoom> {
	public static String getName() {
		return ChatRoomMap.class.getSimpleName();
	}
}
