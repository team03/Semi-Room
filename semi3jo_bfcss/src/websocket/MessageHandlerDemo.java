package websocket;

import java.io.IOException;
import java.util.Iterator;

import javax.websocket.MessageHandler;
import javax.websocket.Session;


public class MessageHandlerDemo implements MessageHandler.Whole<String>{
	private Session userSession = null;
	
	public MessageHandlerDemo(Session session){
		this.userSession=session;		
	}
	
	public void onMessage(String message) {
		String username = (String)userSession.getUserProperties().get("username");
		if(username == null){
			userSession.getUserProperties().put("username", message);
			try{
				userSession.getBasicRemote().sendText(EndpointServerDemo.buildJsonMessageData("★", message + "님이 입장했습니다."));
				Iterator<Session> iterator = EndpointServerDemo.chatroomUsers.iterator();
				while(iterator.hasNext())
					(iterator.next()).getBasicRemote().sendText(EndpointServerDemo.buildJsonUsersData());
			}
			catch(IOException e){
				e.printStackTrace();
				
			}
		}
		else{
			Iterator<Session> iterator = EndpointServerDemo.chatroomUsers.iterator();
			while(iterator.hasNext())
				try {
					(iterator.next()).getBasicRemote().sendText(EndpointServerDemo.buildJsonMessageData(username, message));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	}
}
