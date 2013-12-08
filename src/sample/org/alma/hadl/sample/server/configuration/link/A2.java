/**
 * 
 */
package org.alma.hadl.sample.server.configuration.link;

import java.util.ArrayList;

import org.alma.hadl.interfaces.port.ProvidedPort;
import org.alma.hadl.interfaces.role.Role;
import org.alma.hadl.link.AttachmentLink;
import org.alma.hadl.observer.Observable;
import org.alma.hadl.sample.server.configuration.link.role.Grantor;
import org.alma.hadl.sample.server.configuration.securitymanager.port.SecurityAuth;

/**
 * @author Julien
 *
 */
public class A2 extends AttachmentLink {

	public A2(String name, Role toRole, ProvidedPort fromPort) {
		super(name, toRole, fromPort);
	}

	/* (non-Javadoc)
	 * @see org.alma.hadl.observer.Observer#update(org.alma.hadl.observer.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obs, Object args) {
		if ( obs instanceof SecurityAuth ) {
			System.out.println("In A2 from SecurityAuth with args" + ((ArrayList<String>) args));
			//((Grantor) this.toRole).send(this, args);
		}
		else if ( obs instanceof Grantor ) {
			System.out.println("In A2 from Grantor");
			//((SecurityAuth) this.fromPort).receive(this, args);
		}
	}

}
