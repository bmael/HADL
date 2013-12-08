/**
 * 
 */
package org.alma.hadl.sample.server.configuration.link;

import java.util.ArrayList;

import org.alma.hadl.interfaces.port.ProvidedPort;
import org.alma.hadl.interfaces.role.Role;
import org.alma.hadl.link.AttachmentLink;
import org.alma.hadl.observer.Observable;
import org.alma.hadl.sample.server.configuration.database.port.SecurityManagement;
import org.alma.hadl.sample.server.configuration.link.role.SecurityQueryRequestor;

/**
 * @author Julien
 *
 */
public class A6 extends AttachmentLink {

	public A6(String name, Role toRole, ProvidedPort fromPort) {
		super(name, toRole, fromPort);
	}

	/* (non-Javadoc)
	 * @see org.alma.hadl.observer.Observer#update(org.alma.hadl.observer.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obs, Object args) {
		if ( obs instanceof SecurityManagement ) {
			System.out.println("In A6 from SecurityManagement with args" + ((ArrayList<String>) args));
			//((SecurityQueryRequestor) this.toRole).send(this, args);
		}
		else if ( obs instanceof SecurityQueryRequestor ) {
			System.out.println("In A6 from SecurityQueryRequestor");
			//((SecurityManagement) this.fromPort).receive(this, args);
		}
	}

}
