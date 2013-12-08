/**
 * 
 */
package org.alma.hadl.interfaces.port;

import org.alma.hadl.component.ComponentAssembly;
import org.alma.hadl.interfaces.Interface;


/**
 * @author Julien
 *
 */
public abstract class Port extends Interface {
	protected ComponentAssembly owner;
	
	public Port(ComponentAssembly owner, String name) {
		super(name);
		this.owner = owner;
	}

	/**
	 * @return the owner
	 */
	public ComponentAssembly getOwner() {
		return owner;
	}

}
