/**
 * 
 */
package org.alma.hadl.link;

import org.alma.hadl.interfaces.port.Port;
import org.alma.hadl.observer.Observer;

/**
 * @author Ma�l
 *
 */
public abstract class BindingLink extends Link implements Observer {
	private Port toPort;
	private Port fromPort;
	
	public BindingLink(String name, Port toPort, Port fromPort) {
		super(name);
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
