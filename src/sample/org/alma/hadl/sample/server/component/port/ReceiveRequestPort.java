/**
 * 
 */
package org.alma.hadl.sample.server.component.port;

import org.alma.hadl.component.ComponentAssembly;
import org.alma.hadl.interfaces.port.ProvidedPort;
import org.alma.hadl.observer.Observer;

/**
 * @author Julien
 *
 */
public class ReceiveRequestPort extends ProvidedPort {

	public ReceiveRequestPort(ComponentAssembly owner, String name) {
		super(owner, name);
	}

	public void receive(Observer caller, Object args) {
		System.out.println("In ReceiveRequestPort");
		this.notifyObserversExceptCaller(caller, args);
	}

	public void sendResponse(Observer caller, Object args) {
		System.out.println("In ReceiveRequestPort");
		this.notifyObserversExceptCaller(caller, args);
	}
}
