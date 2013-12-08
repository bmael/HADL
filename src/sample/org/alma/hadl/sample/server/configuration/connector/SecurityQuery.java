/**
 * 
 */
package org.alma.hadl.sample.server.configuration.connector;

import org.alma.hadl.component.PrimitiveConnector;
import org.alma.hadl.interfaces.role.Glue;
import org.alma.hadl.interfaces.role.Role;
import org.alma.hadl.sample.server.configuration.link.glue.SecurityQueryGlue;
import org.alma.hadl.sample.server.configuration.link.role.SecurityManagerRole;
import org.alma.hadl.sample.server.configuration.link.role.SecurityQueryRequestor;

/**
 * @author Julien
 *
 */
public class SecurityQuery extends PrimitiveConnector {

	/**
	 * @param name
	 */
	public SecurityQuery(String name) {
		super(name);
		

		Glue securityQueryGlue = new SecurityQueryGlue("SecurityQueryGlue");
		Role securityManagerRole = new SecurityManagerRole("SecurityManagerRole");
		Role securityQueryRequestor = new SecurityQueryRequestor("SecurityQueryRequestor");
		
		securityQueryGlue.addCalledRole(securityManagerRole);
		securityQueryGlue.addCallerRole(securityQueryRequestor);
		
		this.addGlue(securityQueryGlue);
	}

}
