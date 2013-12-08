/**
 * 
 */
package org.alma.hadl.sample.server.configuration.database.port;

import org.alma.hadl.component.ComponentAssembly;
import org.alma.hadl.interfaces.port.ProvidedPort;
import org.alma.hadl.observer.Observer;

/**
 * @author Julien
 *
 */
public class QueryInt extends ProvidedPort {

	public QueryInt(ComponentAssembly owner, String name) {
		super(owner, name);
	}

	public void receive(Observer caller, Object args) {
		System.out.println("In QueryInt from A4");
		this.notifyObserversExceptCaller(caller, args);
	}
	
	public void send(Observer caller, Object args) {
		System.out.println("In QueryInt from Database");
		this.notifyObserversExceptCaller(caller, args);
	}

}
