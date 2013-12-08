/**
 * 
 */
package org.alma.hadl.interfaces.port;

import org.alma.hadl.component.ComponentAssembly;

/**
 * @author Julien
 *
 */
public abstract class RequiredPort extends Port {

	public RequiredPort(ComponentAssembly owner, String name) {
		super(owner, name);
	}

}
