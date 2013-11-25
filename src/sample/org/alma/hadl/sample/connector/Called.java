/**
 * 
 */
package org.alma.hadl.sample.connector;

import org.alma.hadl.interfaces.role.Role;

/**
 * @author Julien
 *
 */
public class Called extends Role {

	public Called(String name) {
		super(name);
	}
	
	public void send(Object args) {
		System.out.println("In Called");
		this.notifyObservers(args);
	}

}
