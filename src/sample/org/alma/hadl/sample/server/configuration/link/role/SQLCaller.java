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
public class SQLCaller extends Role {

	public SQLCaller(String name) {
		super(name);
	}

	public void send(Observer caller, Object args) {
		System.out.println("In SQLCaller");
		this.notifyObserversExceptCaller(caller, args);
	}

}
