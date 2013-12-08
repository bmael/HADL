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
public class Called extends Role {

	public Called(String name) {
		super(name);
	}
	
	public void send(Observer caller, Object args) {
		System.out.println("In Called");
		this.notifyObserversExceptCaller(caller, args);
	}

}
