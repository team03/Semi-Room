package websocket;


import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;

public class EndpointServerDemo extends Endpoint {
	static Set<Session> chatroomUsers = Collections.synchronizedSet(new HashSet<Session>());
	
	public void onOpen(Session session, EndpointConfig endpointConfig) {
		chatroomUsers.add(session);
		session.addMessageHandler(new MessageHandlerDemo(session));
	}
	
	public void onClose(Session session, CloseReason closeReason){
		chatroomUsers.remove(session);
		try{
			Iterator<Session> iterator = chatroomUsers.iterator();
			while(iterator.hasNext())
				(iterator.next()).getBasicRemote().sendText(EndpointServerDemo.buildJsonUsersData());
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void onError(Session session, Throwable thr){
		thr.printStackTrace();
		
	}
	
	public static String buildJsonUsersData(){
		Iterator<String> iterator = getUserNames().iterator();
		JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
		while(iterator.hasNext()) jsonArrayBuilder.add((String)iterator.next());
		return Json.createObjectBuilder().add("users", jsonArrayBuilder).build().toString();
	}
	
	public static String buildJsonMessageData(String username, String message) {
		JsonObject jsonObject = Json.createObjectBuilder().add("message", username + ": " + message).build();
		StringWriter stringWriter = new StringWriter();
		try (JsonWriter jsonWriter = Json.createWriter(stringWriter)) {jsonWriter.write(jsonObject);}
		
		return stringWriter.toString();
	}
	public static Set<String> getUserNames(){
		HashSet<String> returnSet = new HashSet<String>();
		Iterator<Session> iterator = chatroomUsers.iterator();
		while(iterator.hasNext()) returnSet.add(iterator.next().getUserProperties().get("username").toString());
		return returnSet;
	}
}
