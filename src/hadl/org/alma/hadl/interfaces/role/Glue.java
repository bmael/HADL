/**
 * 
 */
package org.alma.hadl.interfaces.role;

import java.util.ArrayList;
import java.util.List;

import org.alma.hadl.observer.Observer;

/**
 * @author Julien
 *
 */
public abstract class Glue implements Observer {
	protected String name;
	protected List<Role> calledRoles = new ArrayList<Role>();
	protected List<Role> callerRoles = new ArrayList<Role>();
	
	public Glue(String name) {
		this.name = name;
	}
	
	public Glue(String name, List<Role> calledRoles, List<Role> callerRoles) {
		this.name = name;
		this.calledRoles = calledRoles;
		this.callerRoles = callerRoles;
	}
	
	public void addCalledRole(Role calledRole) {
		this.calledRoles.add(calledRole);
	}
	
	public void addCallerRole(Role callerRole) {
		this.callerRoles.add(callerRole);
	}
}
