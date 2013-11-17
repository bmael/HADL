/**
 * 
 */
package org.alma.hadl.interfaces.role;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Julien
 *
 */
public abstract class Glue {

	private List<Role> calledRoles = new ArrayList<Role>();
	private List<Role> callerRoles = new ArrayList<Role>();
	
	public Glue() {
		super();
	}
	
//	public Glue(List<Role> calledRoles, List<Role> callerRoles) {
//		this.calledRoles = calledRoles;
//		this.callerRoles = callerRoles;
//	}
	
	public void addCalledRole(Role calledRole) {
		this.calledRoles.add(calledRole);
	}
	
	public void addCallerRole(Role callerRole) {
		this.callerRoles.add(callerRole);
	}
}
