package edu.asu.snac.server;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import edu.asu.snac.server.chat.ChatRoom;
import edu.asu.snac.server.chat.ChatRoomMap;

public class ContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		context.setAttribute(ChatRoomMap.getName(), new ChatRoomMap());
//		ChatRoomMap map = context.getAttribute(ChatRoomMap.getName());
//		ChatRoom room = map.get("123");
//		room.join(userInfo);
//		room.getChat(uid);
//		room.addChat(uid, content);
//		room.exit(uid);
	}

}
