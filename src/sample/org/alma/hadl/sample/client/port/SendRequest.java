/**
 * 
 */
package org.alma.hadl.sample.client.port;

import org.alma.hadl.interfaces.port.ProvidedPort;

/**
 * @author Julien
 *
 */
public class SendRequest extends ProvidedPort {
	
	public SendRequest(String name) {
		super(name);
	}

	public void send(Object args) {
		System.out.println("In SendRequest");
		this.notifyObservers(args);
	}
}
