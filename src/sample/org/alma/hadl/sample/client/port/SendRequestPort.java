/**
 * 
 */
package org.alma.hadl.sample.client.port;

import org.alma.hadl.component.ComponentAssembly;
import org.alma.hadl.interfaces.port.ProvidedPort;
import org.alma.hadl.observer.Observer;

/**
 * @author Julien
 *
 */
public class SendRequestPort extends ProvidedPort {
	
	public SendRequestPort(ComponentAssembly owner, String name) {
		super(owner, name);
	}

	public void send(Observer caller, Object args) {
		System.out.println("In SendRequestPort from Client");
		this.notifyObserversExceptCaller(caller, args);
	}

	public void receive(Observer caller, Object args) {
		System.out.println("In SendRequestPort from ClientRPC");
		this.notifyObserversExceptCaller(caller, args);
	}
}
