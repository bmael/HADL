/**
 * 
 */
package org.alma.hadl.sample.server.configuration.connectionmanager.port;

import org.alma.hadl.component.ComponentAssembly;
import org.alma.hadl.interfaces.port.ProvidedPort;
import org.alma.hadl.observer.Observer;

/**
 * @author Julien
 *
 */
public class DbQuery extends ProvidedPort {

	public DbQuery(ComponentAssembly owner, String name) {
		super(owner, name);
	}

	public void receive(Observer caller, Object args) {
		System.out.println("In DbQuery");
		this.notifyObserversExceptCaller(caller, args);
	}

}
