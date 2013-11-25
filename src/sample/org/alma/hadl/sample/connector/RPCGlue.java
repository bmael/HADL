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
		// TODO Auto-generated method stub
		System.out.println("In RPCGlue from " + args);
		if ( obs instanceof Caller ) {
			for (Role role : calledRoles) {
				if ( role instanceof Called ) {
					((Called) role).send(args);
				}
			}
		}
	}

}
