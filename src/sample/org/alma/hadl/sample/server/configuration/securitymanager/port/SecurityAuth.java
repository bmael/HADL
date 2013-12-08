/**
 * 
 */
package org.alma.hadl.sample.server.configuration.securitymanager.port;

import org.alma.hadl.component.ComponentAssembly;
import org.alma.hadl.interfaces.port.ProvidedPort;

/**
 * @author Julien
 *
 */
public class SecurityAuth extends ProvidedPort {

	public SecurityAuth(ComponentAssembly owner, String name) {
		super(owner, name);
	}

}
