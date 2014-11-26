package websocket;

import java.util.HashSet;
import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

public class ServerApplicationConfigDemo implements ServerApplicationConfig{
	@Override
	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> arg0) {
		Set<ServerEndpointConfig> serverEndpointConfigSet = new HashSet<ServerEndpointConfig>();
		serverEndpointConfigSet.add(ServerEndpointConfig.Builder.create(EndpointServerDemo.class, "/endpointserverdemo").build());
		return serverEndpointConfigSet;
	}

	@Override
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> arg0) {
		
		return null;
	}
}
