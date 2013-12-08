/**
 * 
 */
package org.alma.hadl.sample.server.configuration.connectionmanager.port;

import org.alma.hadl.component.ComponentAssembly;
import org.alma.hadl.interfaces.port.ProvidedPort;

/**
 * @author Julien
 *
 */
public class SecurityCheck extends ProvidedPort {

	public SecurityCheck(ComponentAssembly owner, String name) {
		super(owner, name);
	}

}
