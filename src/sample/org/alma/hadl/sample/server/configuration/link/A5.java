/**
 * 
 */
package org.alma.hadl.sample.server.configuration.link;

import java.util.ArrayList;

import org.alma.hadl.interfaces.port.ProvidedPort;
import org.alma.hadl.interfaces.role.Role;
import org.alma.hadl.link.AttachmentLink;
import org.alma.hadl.observer.Observable;
import org.alma.hadl.sample.server.configuration.link.role.SecurityManagerRole;
import org.alma.hadl.sample.server.configuration.securitymanager.port.CQuery;

/**
 * @author Julien
 *
 */
public class A5 extends AttachmentLink {

	public A5(String name, Role toRole, ProvidedPort fromPort) {
		super(name, toRole, fromPort);
	}

	/* (non-Javadoc)
	 * @see org.alma.hadl.observer.Observer#update(org.alma.hadl.observer.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obs, Object args) {
		if ( obs instanceof CQuery ) {
			System.out.println("In A5 from CQuery with args" + ((ArrayList<String>) args));
			//((SecurityManagerRole) this.toRole).send(this, args);
		}
		else if ( obs instanceof SecurityManagerRole ) {
			System.out.println("In A5 from SecurityManagerRole");
			//((CQuery) this.fromPort).receive(this, args);
		}
	}

}
