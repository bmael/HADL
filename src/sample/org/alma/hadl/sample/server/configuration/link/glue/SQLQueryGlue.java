/**
 * 
 */
package org.alma.hadl.sample.server.configuration.link.glue;

import org.alma.hadl.interfaces.role.Glue;
import org.alma.hadl.interfaces.role.Role;
import org.alma.hadl.observer.Observable;
import org.alma.hadl.sample.server.configuration.link.role.SQLCalled;
import org.alma.hadl.sample.server.configuration.link.role.SQLCaller;

/**
 * @author Julien
 *
 */
public class SQLQueryGlue extends Glue {

	public SQLQueryGlue(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see org.alma.hadl.observer.Observer#update(org.alma.hadl.observer.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obs, Object args) {
		if ( obs instanceof SQLCaller ) {
			System.out.println("In RPCGlue from SQLCaller with args " + args);
			for (Role role : this.calledRoles) {
				if ( role instanceof SQLCalled ) {
					((SQLCalled) role).send(this, args);
				}
			}
		}
		else if ( obs instanceof SQLCalled ) {
			System.out.println("In RPCGlue from SQLCalled");
			for (Role role : this.callerRoles) {
				if ( role instanceof SQLCaller ) {
					((SQLCaller) role).send(this, args);
				}
			}
		}
	}

}
