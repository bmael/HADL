/**
 * 
 */
package org.alma.hadl.interfaces.service;

import org.alma.hadl.component.Component;
import org.alma.hadl.interfaces.Interface;


/**
 * @author Julien
 *
 */
public abstract class Service extends Interface {
	protected Component owner;
	
	public Service(Component owner, String name) {
		super(name);
		this.owner = owner;
	}

	/**
	 * @return the owner
	 */
	public Component getOwner() {
		return owner;
	}

}
