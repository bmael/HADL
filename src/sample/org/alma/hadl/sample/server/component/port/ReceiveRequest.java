/**
 * 
 */
package org.alma.hadl.sample.server.component.port;

import org.alma.hadl.interfaces.port.ProvidedPort;

/**
 * @author Julien
 *
 */
public class ReceiveRequest extends ProvidedPort {

	public ReceiveRequest(String name) {
		super(name);
	}

	public void receive(Object args) {
		System.out.println("In ReceiveRequest");
		this.notifyObservers(args);
	}
}
