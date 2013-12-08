/**
 * 
 */
package org.alma.hadl.sample.server.component;

import java.util.List;

import org.alma.hadl.component.Component;
import org.alma.hadl.observer.Observable;
import org.alma.hadl.sample.server.component.port.ReceiveRequestPort;
import org.alma.hadl.sample.server.component.service.SendResponseService;
import org.alma.hadl.sample.server.configuration.ServerConfiguration;

/**
 * @author Julien
 *
 */
public class Server extends Component {

	protected ServerConfiguration serverConfiguration;
	protected ReceiveRequestPort receiveRequestPort;
	protected SendResponseService receiveRequestService;
	protected SendResponseService sendResponseService;

	public Server() {
		super("ServerComponent");

		this.serverConfiguration = new ServerConfiguration();
		this.serverConfiguration.setServer(this);
		this.addProvidedPort(new ReceiveRequestPort(this, "ReceiveRequestPort"));
		this.addProvidedService(new SendResponseService(this, "ReceiveRequestService"));
		this.addProvidedService(new SendResponseService(this, "SendResponseService"));
	}

	@Override
	public void update(Observable obs, Object args) {
		
		if ( obs instanceof ReceiveRequestPort ) {
			
			System.out.println("Finally in server!");
			
			if ( args != null ) {

				switch ( ((List<String>) args).get(0) ) {

				case "addUser" :
					System.out.println("Adding user " + args);
					this.serverConfiguration.getConnectionManager().sendRequest(args);
					break;

				case "removeUser" :
					System.out.println("Removing user " + args);
					this.serverConfiguration.getConnectionManager().sendRequest(args);
					break;

				case "selectAllUsers" :
					System.out.println("Displaying every user in database");
					this.serverConfiguration.getConnectionManager().sendRequest(args);
					
					//((SendResponseService) this.getProvidedServiceByType(SendResponseService.class)).send(args);
					break;

				default :
					System.err.println("Unknown request : " + args);
					break;
				}

			}
			else {

			}
		}
	}
	
	
	public void sendResult(Object args) {
		System.out.println("In Server sending results back to client");
		((SendResponseService) this.getProvidedServiceByType(SendResponseService.class)).send(this, args);
	}
}
