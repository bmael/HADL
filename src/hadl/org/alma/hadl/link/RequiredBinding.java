/**
 * 
 */
package org.alma.hadl.link;

import org.alma.hadl.interfaces.port.RequiredPort;

/**
 * @author Julien
 *
 */
public abstract class RequiredBinding extends BindingLink {
	private RequiredPort toPort;
	private RequiredPort fromPort;
	
	public RequiredBinding(String name, RequiredPort toPort, RequiredPort fromPort) {
		super(name, toPort, fromPort);
	}
}
