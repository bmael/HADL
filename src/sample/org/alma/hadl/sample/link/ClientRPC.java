/**
 * 
 */
package org.alma.hadl.sample.link;

import java.util.ArrayList;

import org.alma.hadl.interfaces.port.ProvidedPort;
import org.alma.hadl.interfaces.role.Role;
import org.alma.hadl.link.AttachmentLink;
import org.alma.hadl.observer.Observable;
import org.alma.hadl.sample.client.port.SendRequest;
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
		// TODO Auto-generated method stub
		if ( obs instanceof SendRequest ) {
			System.out.println("In ClientRPC from " + ((ArrayList<String>) args).get(1) + " - " + ((ArrayList<String>) args).get(0));
			((Caller) this.toRole).send(args);
		}
		// instanceof Caller
		else {
			//System.out.println("Retour de bâton!!!");
		}
	}

}
