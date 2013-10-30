/**
 * 
 */
package org.alma.hadl.link;

import org.alma.hadl.interfaces.port.ProvidedPort;
import org.alma.hadl.interfaces.role.Role;

/**
 * @author Julien
 *
 */
public abstract class AttachmentLink extends Link {
	private Role toRole;
	private ProvidedPort fromPort;
	
	public AttachmentLink(Role toRole, ProvidedPort fromPort) {
		super();
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
