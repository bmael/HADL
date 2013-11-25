/**
 * 
 */
package org.alma.hadl.link;

import org.alma.hadl.interfaces.port.ProvidedPort;

/**
 * @author Julien
 *
 */
public abstract class ProvidedBinding extends BindingLink {
	private ProvidedPort toPort;
	private ProvidedPort fromPort;
	
	public ProvidedBinding(String name, ProvidedPort toPort, ProvidedPort fromPort) {
		super(name, toPort, fromPort);
	}
}
