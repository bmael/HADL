/**
 * 
 */
package org.alma.hadl.interfaces.service;

import org.alma.hadl.component.Component;

/**
 * @author Julien
 *
 */
public abstract class ProvidedService extends Service {

	public ProvidedService(Component owner, String name) {
		super(owner, name);
	}

}
