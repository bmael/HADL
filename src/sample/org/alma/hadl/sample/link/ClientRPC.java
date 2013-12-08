/**
 * 
 */
package org.alma.hadl.sample.link;

import java.util.ArrayList;

import org.alma.hadl.interfaces.port.ProvidedPort;
import org.alma.hadl.interfaces.role.Role;
import org.alma.hadl.link.AttachmentLink;
import org.alma.hadl.observer.Observable;
import org.alma.hadl.sample.client.port.SendRequestPort;
import org.alma.hadl.sample.connector.Caller;

/**
 * @author Julien
 *
 */
public class ClientRPC extends AttachmentLink {

	public ClientRPC(String name, Role toRole, ProvidedPort fromPort) {
		super(name, toRole, fromPort);
	}

	@Override
	public void update(Observable obs, Object args) {
		if ( obs instanceof SendRequestPort ) {
			System.out.println("In ClientRPC from SendRequestPort with args" + ((ArrayList<String>) args));
			((Caller) this.toRole).send(this, args);
		}
		else if ( obs instanceof Caller ) {
			System.out.println("In ClientRPC from Caller");
			((SendRequestPort) this.fromPort).receive(this, args);
		}
	}

}
