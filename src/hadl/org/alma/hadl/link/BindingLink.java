/**
 * 
 */
package org.alma.hadl.link;

import org.alma.hadl.interfaces.port.Port;

/**
 * @author Ma�l
 *
 */
public abstract class BindingLink extends Link {
	private Port toPort;
	private Port fromPort;
	
	public BindingLink(Port toPort, Port fromPort) {
		this.toPort = toPort;
		this.fromPort = fromPort;
	}
	
	public Port getToPort() {
		return this.toPort;
	}
	
	public Port getFromPort() {
		return this.fromPort;
	}
}
