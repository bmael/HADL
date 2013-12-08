/**
 * 
 */
package org.alma.hadl.sample.server.configuration.link;

import org.alma.hadl.interfaces.port.ProvidedPort;
import org.alma.hadl.interfaces.role.Role;
import org.alma.hadl.link.AttachmentLink;
import org.alma.hadl.observer.Observable;
import org.alma.hadl.sample.server.configuration.database.port.QueryInt;
import org.alma.hadl.sample.server.configuration.link.role.SQLCalled;

/**
 * @author Julien
 *
 */
public class A4 extends AttachmentLink {

	public A4(String name, Role toRole, ProvidedPort fromPort) {
		super(name, toRole, fromPort);
	}

	/* (non-Javadoc)
	 * @see org.alma.hadl.observer.Observer#update(org.alma.hadl.observer.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obs, Object args) {
		if ( obs instanceof QueryInt ) {
			System.out.println("In A4 from QueryInt");
			((SQLCalled) this.toRole).send(this, args);
		}
		else if ( obs instanceof SQLCalled ) {
			System.out.println("In A4 from SQLCalled");
			((QueryInt) this.fromPort).receive(this, args);
		}
	}

}
