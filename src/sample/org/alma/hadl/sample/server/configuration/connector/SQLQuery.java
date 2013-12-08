/**
 * 
 */
package org.alma.hadl.sample.server.configuration.connector;

import org.alma.hadl.component.PrimitiveConnector;
import org.alma.hadl.interfaces.role.Glue;
import org.alma.hadl.interfaces.role.Role;
import org.alma.hadl.sample.server.configuration.link.glue.SQLQueryGlue;
import org.alma.hadl.sample.server.configuration.link.role.SQLCalled;
import org.alma.hadl.sample.server.configuration.link.role.SQLCaller;

/**
 * @author Julien
 *
 */
public class SQLQuery extends PrimitiveConnector {

	public SQLQuery(String name) {
		super(name);
		

		Glue sqlQueryGlue = new SQLQueryGlue("RPCGlue");
		Role sqlCalled = new SQLCalled("SQLCalled");
		Role sqlCaller = new SQLCaller("SQLCaller");
		
		sqlQueryGlue.addCalledRole(sqlCalled);
		sqlQueryGlue.addCallerRole(sqlCaller);
		
		this.addGlue(sqlQueryGlue);
	}

}
