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
	
	public RequiredBinding(RequiredPort toPort, RequiredPort fromPort) {
		super(toPort, fromPort);
	}
}
