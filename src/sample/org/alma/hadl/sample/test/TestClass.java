/**
 * 
 */
package org.alma.hadl.sample.test;

import org.alma.hadl.component.PrimitiveConnector;
import org.alma.hadl.interfaces.role.Glue;
import org.alma.hadl.interfaces.role.Role;
import org.alma.hadl.sample.client.Client;
import org.alma.hadl.sample.client.port.SendRequest;
import org.alma.hadl.sample.connector.Called;
import org.alma.hadl.sample.connector.Caller;
import org.alma.hadl.sample.connector.RPC;
import org.alma.hadl.sample.connector.RPCGlue;
import org.alma.hadl.sample.link.ClientRPC;
import org.alma.hadl.sample.link.ServerRPC;
import org.alma.hadl.sample.server.component.ServerComponent;
import org.alma.hadl.sample.server.component.port.ReceiveRequest;

/**
 * @author Julien
 *
 */
public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Constructing Component Client
		Client client = new Client();
		
		// Constructing ProvidedPort SendRequest
		SendRequest sendRequest = new SendRequest("SendRequest");
		client.addProvidedPort(sendRequest);
		
		// PrimitiveConnector RPC and Glue RPCGlue
		PrimitiveConnector rpc = new RPC("RPC");
		Glue rpcGlue = new RPCGlue("RPCGlue");
		
		Role called = new Called("Called");
		Role caller = new Caller("Caller");
		
		// Adding roles in rpcGlue
		rpcGlue.addCalledRole(called);
		rpcGlue.addCallerRole(caller);
		
		rpc.addGlue(rpcGlue);
		
		// AttachmentLink ClientRPC
		ClientRPC clientRPC = new ClientRPC("ClientRPC", caller, sendRequest);
		
		// Observer Pattern
		sendRequest.addObserver(client);
		sendRequest.addObserver(clientRPC);
		caller.addObserver(clientRPC);
		caller.addObserver(rpcGlue);
		
		
		
		ServerComponent server = new ServerComponent("ServerComponent");
		
		ReceiveRequest receiveRequest = new ReceiveRequest("ReceiveRequest");
		server.addProvidedPort(receiveRequest);
		
		ServerRPC serverRPC = new ServerRPC("ServerRPC", called, receiveRequest);
				
		receiveRequest.addObserver(server);
		receiveRequest.addObserver(serverRPC);
		called.addObserver(serverRPC);
		called.addObserver(rpcGlue);
		
		((Client) client).doAction();
	}

}
