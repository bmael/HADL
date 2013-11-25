/**
 * 
 */
package org.alma.hadl.link;

import org.alma.hadl.interfaces.port.ProvidedPort;
import org.alma.hadl.interfaces.role.Role;
import org.alma.hadl.observer.Observer;

/**
 * @author Julien
 *
 */
public abstract class AttachmentLink extends Link implements Observer {
	protected Role toRole;
	protected ProvidedPort fromPort;
	
//	public AttachmentLink(String name) {
//		super(name);
//	}
	
	public AttachmentLink(String name, Role toRole, ProvidedPort fromPort) {
		super(name);
		this.toRole = toRole;
		this.fromPort = fromPort;
	}
	
	public Role getToRole() {
		return this.toRole;
	}
	
	public ProvidedPort getFromPort() {
		return this.fromPort;
	}
}
