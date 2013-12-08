/**
 * 
 */
package org.alma.hadl.sample.server.configuration.link.role;

import org.alma.hadl.interfaces.role.Role;
import org.alma.hadl.observer.Observer;

/**
 * @author Julien
 *
 */
public class SQLCalled extends Role {

	public SQLCalled(String name) {
		super(name);
	}

	public void send(Observer caller, Object args) {
		System.out.println("In SQLCalled");
		this.notifyObserversExceptCaller(caller, args);
	}

}
