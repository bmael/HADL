/**
 * 
 */
package org.alma.hadl.sample.server.configuration.link;

import java.util.ArrayList;

import org.alma.hadl.interfaces.port.ProvidedPort;
import org.alma.hadl.interfaces.role.Role;
import org.alma.hadl.link.AttachmentLink;
import org.alma.hadl.observer.Observable;
import org.alma.hadl.sample.server.configuration.connectionmanager.port.DbQuery;
import org.alma.hadl.sample.server.configuration.link.role.SQLCaller;

/**
 * @author Julien
 *
 */
public class A3 extends AttachmentLink {

	public A3(String name, Role toRole, ProvidedPort fromPort) {
		super(name, toRole, fromPort);
	}

	/* (non-Javadoc)
	 * @see org.alma.hadl.observer.Observer#update(org.alma.hadl.observer.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obs, Object args) {
		if ( obs instanceof DbQuery ) {
			System.out.println("In A3 from DbQuery with args" + ((ArrayList<String>) args));
			((SQLCaller) this.toRole).send(this, args);
		}
		else if ( obs instanceof SQLCaller ) {
			System.out.println("In A3 from SQLCaller");
			((DbQuery) this.fromPort).receive(this, args);
		}
	}

}
