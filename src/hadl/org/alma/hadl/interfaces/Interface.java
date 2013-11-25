/**
 * 
 */
package org.alma.hadl.interfaces;

import org.alma.hadl.general.Element;

/**
 * @author Julien
 *
 */
public abstract class Interface extends Element {
	protected String name;
	
	public Interface(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
