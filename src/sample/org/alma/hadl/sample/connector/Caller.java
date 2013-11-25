/**
 * 
 */
package org.alma.hadl.sample.connector;

import org.alma.hadl.interfaces.role.Role;

/**
 * @author Julien
 *
 */
public class Caller extends Role {

	public Caller(String name) {
		super(name);
	}
	
	public void send(Object args) {
		System.out.println("In Caller");
		this.notifyObservers(args);
	}

}
