/**
 * 
 */
package org.alma.hadl.sample.connector;

import org.alma.hadl.component.PrimitiveConnector;
import org.alma.hadl.interfaces.role.Glue;
import org.alma.hadl.interfaces.role.Role;

/**
 * @author Julien
 *
 */
public class RPC extends PrimitiveConnector {
	
	public RPC(String name) {
		super(name);
		
		Glue rpcGlue = new RPCGlue("RPCGlue");
		Role called = new Called("Called");
		Role caller = new Caller("Caller");
		
		rpcGlue.addCalledRole(called);
		rpcGlue.addCallerRole(caller);
		
		this.addGlue(rpcGlue);
	}

}
