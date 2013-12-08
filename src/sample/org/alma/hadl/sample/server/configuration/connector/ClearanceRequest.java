/**
 * 
 */
package org.alma.hadl.sample.server.configuration.connector;

import org.alma.hadl.component.PrimitiveConnector;
import org.alma.hadl.interfaces.role.Glue;
import org.alma.hadl.interfaces.role.Role;
import org.alma.hadl.sample.server.configuration.link.glue.ClearanceRequestGlue;
import org.alma.hadl.sample.server.configuration.link.role.Grantor;
import org.alma.hadl.sample.server.configuration.link.role.Requestor;

/**
 * @author Julien
 *
 */
public class ClearanceRequest extends PrimitiveConnector {

	public ClearanceRequest(String name) {
		super(name);
		

		Glue clearanceRequestGlue = new ClearanceRequestGlue("ClearanceRequestGlue");
		Role grantor = new Grantor("Grantor");
		Role requestor = new Requestor("Requestor");
		
		clearanceRequestGlue.addCalledRole(grantor);
		clearanceRequestGlue.addCallerRole(requestor);
		
		this.addGlue(clearanceRequestGlue);
	}

}
