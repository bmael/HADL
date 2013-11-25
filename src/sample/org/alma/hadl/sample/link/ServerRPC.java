/**
 * 
 */
package org.alma.hadl.sample.link;

import org.alma.hadl.interfaces.port.ProvidedPort;
import org.alma.hadl.interfaces.role.Role;
import org.alma.hadl.link.AttachmentLink;
import org.alma.hadl.observer.Observable;
import org.alma.hadl.sample.connector.Called;
import org.alma.hadl.sample.server.component.port.ReceiveRequest;

/**
 * @author Julien
 *
 */
public class ServerRPC extends AttachmentLink {

	public ServerRPC(String name, Role toRole, ProvidedPort fromPort) {
		super(name, toRole, fromPort);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Observable obs, Object args) {
		if ( obs instanceof Called ) {
			System.out.println("In ServerRPC with " + args);
			((ReceiveRequest) this.fromPort).receive(args);
		}
	}

}
