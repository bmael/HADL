/**
 * 
 */
package org.alma.hadl.sample.server.configuration.link;

import java.util.ArrayList;

import org.alma.hadl.interfaces.port.ProvidedPort;
import org.alma.hadl.interfaces.role.Role;
import org.alma.hadl.link.AttachmentLink;
import org.alma.hadl.observer.Observable;
import org.alma.hadl.sample.server.configuration.connectionmanager.port.SecurityCheck;
import org.alma.hadl.sample.server.configuration.link.role.Requestor;

/**
 * @author Julien
 *
 */
public class A1 extends AttachmentLink {

	public A1(String name, Role toRole, ProvidedPort fromPort) {
		super(name, toRole, fromPort);
	}

	/* (non-Javadoc)
	 * @see org.alma.hadl.observer.Observer#update(org.alma.hadl.observer.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obs, Object args) {
		if ( obs instanceof SecurityCheck ) {
			System.out.println("In A1 from SecurityCheck with args" + ((ArrayList<String>) args));
			//((Requestor) this.toRole).send(this, args);
		}
		else if ( obs instanceof Requestor ) {
			System.out.println("In A1 from Requestor");
			//((SecurityCheck) this.fromPort).receive(this, args);
		}
	}

}
