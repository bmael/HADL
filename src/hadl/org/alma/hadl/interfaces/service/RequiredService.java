/**
 * 
 */
package org.alma.hadl.interfaces.service;

import org.alma.hadl.component.Component;

/**
 * @author Julien
 *
 */
public abstract class RequiredService extends Service {

	public RequiredService(Component owner, String name) {
		super(owner, name);
	}

}
