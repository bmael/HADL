/**
 * 
 */
package org.alma.hadl.sample.connector;

import org.alma.hadl.interfaces.role.Glue;
import org.alma.hadl.interfaces.role.Role;
import org.alma.hadl.observer.Observable;

/**
 * @author Julien
 *
 */
public class RPCGlue extends Glue {

	public RPCGlue(String name) {
		super(name);
	}

	@Override
	public void update(Observable obs, Object args) {
		if ( obs instanceof Caller ) {
			System.out.println("In RPCGlue from Caller with args " + args);
			for (Role role : calledRoles) {
				if ( role instanceof Called ) {
					((Called) role).send(this, args);
				}
			}
		}
		else if ( obs instanceof Called ) {
			System.out.println("In RPCGlue from Called");
			for (Role role : callerRoles) {
				if ( role instanceof Caller ) {
					((Caller) role).send(this, args);
				}
			}
		}
	}

}
