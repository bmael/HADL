/**
 * 
 */
package org.alma.hadl.sample.clientserver.configuration;

import org.alma.hadl.component.Configuration;
import org.alma.hadl.component.PrimitiveConnector;
import org.alma.hadl.sample.client.Client;
import org.alma.hadl.sample.client.port.SendRequestPort;
import org.alma.hadl.sample.connector.Called;
import org.alma.hadl.sample.connector.Caller;
import org.alma.hadl.sample.connector.RPC;
import org.alma.hadl.sample.connector.RPCGlue;
import org.alma.hadl.sample.link.ClientRPC;
import org.alma.hadl.sample.link.ServerRPC;
import org.alma.hadl.sample.server.component.Server;
import org.alma.hadl.sample.server.component.port.ReceiveRequestPort;

/**
 * @author Julien
 *
 */
public class ClientServerConfiguration extends Configuration {
	
	protected Client client;
	protected PrimitiveConnector rpc;
	protected ClientRPC clientRPC;
	protected Server server;
	protected ServerRPC serverRPC;
	

	public ClientServerConfiguration() {
		super("ClientServer");

		// Constructing Component Client with its Port and Service
		this.client = new Client();

		// Contructing PrimitiveConnector RPC, with its Glue and roles
		this.rpc = new RPC("RPC");

		// AttachmentLink ClientRPC
		this.clientRPC = new ClientRPC("ClientRPC", rpc.getGlueByType(RPCGlue.class).getCallerRoleByType(Caller.class), client.getProvidedPortByType(SendRequestPort.class));

		// Setting Observer Pattern for SendRequestPort(in Client) and the Role Caller in rpc
		this.client.getProvidedPortByType(SendRequestPort.class).addObserver(client);
		this.client.getProvidedPortByType(SendRequestPort.class).addObserver(clientRPC);
		rpc.getGlueByType(RPCGlue.class).getCallerRoleByType(Caller.class).addObserver(clientRPC);
		rpc.getGlueByType(RPCGlue.class).getCallerRoleByType(Caller.class).addObserver(rpc.getGlueByType(RPCGlue.class));


		// Constructing Component Client with its Port and Service
		this.server = new Server();

		// AttachmentLink ServerRPC
		this.serverRPC = new ServerRPC("ServerRPC", rpc.getGlueByType(RPCGlue.class).getCalledRoleByType(Called.class), server.getProvidedPortByType(ReceiveRequestPort.class));

		// Setting Observer Pattern for ReceiveRequestPort(in Server) and the Role Called in rpc
		this.server.getProvidedPortByType(ReceiveRequestPort.class).addObserver(server);
		this.server.getProvidedPortByType(ReceiveRequestPort.class).addObserver(serverRPC);
		rpc.getGlueByType(RPCGlue.class).getCalledRoleByType(Called.class).addObserver(serverRPC);
		rpc.getGlueByType(RPCGlue.class).getCalledRoleByType(Called.class).addObserver(rpc.getGlueByType(RPCGlue.class));
	}


	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}


	/**
	 * @return the rpc
	 */
	public PrimitiveConnector getRpc() {
		return rpc;
	}


	/**
	 * @return the clientRPC
	 */
	public ClientRPC getClientRPC() {
		return clientRPC;
	}


	/**
	 * @return the server
	 */
	public Server getServer() {
		return server;
	}


	/**
	 * @return the serverRPC
	 */
	public ServerRPC getServerRPC() {
		return serverRPC;
	}
}
