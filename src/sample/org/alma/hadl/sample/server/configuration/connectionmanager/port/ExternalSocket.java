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
public class ExternalSocket extends ProvidedPort {

	public ExternalSocket(ComponentAssembly owner, String name) {
		super(owner, name);
	}

}
