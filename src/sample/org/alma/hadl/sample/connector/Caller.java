/**
 * 
 */
package org.alma.hadl.sample.connector;

import org.alma.hadl.interfaces.role.Role;
import org.alma.hadl.observer.Observer;

/**
 * @author Julien
 *
 */
public class Caller extends Role {

	public Caller(String name) {
		super(name);
	}
	
	public void send(Observer caller, Object args) {
		System.out.println("In Caller");
		this.notifyObserversExceptCaller(caller, args);
	}

}
