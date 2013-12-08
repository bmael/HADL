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
	
	
	/**
	 * @param name
	 */
	public Glue(String name) {
		this.name = name;
	}
	
	
	/**
	 * @param name
	 * @param calledRoles
	 * @param callerRoles
	 */
	public Glue(String name, List<Role> calledRoles, List<Role> callerRoles) {
		this.name = name;
		this.calledRoles = calledRoles;
		this.callerRoles = callerRoles;
	}
	
	
	/**
	 * @param calledRole
	 */
	public void addCalledRole(Role calledRole) {
		this.calledRoles.add(calledRole);
	}
	
	
	/**
	 * @param callerRole
	 */
	public void addCallerRole(Role callerRole) {
		this.callerRoles.add(callerRole);
	}
	
	
	/**
	 * @param type
	 * @return
	 */
	public Role getCalledRoleByType(Class<?> type) {
		for (Role role : this.calledRoles) {
			if ( role.getClass().equals(type) ) {
				return role;
			}
		}
		
		return null;
	}
	
	
	/**
	 * @param type
	 * @return
	 */
	public Role getCallerRoleByType(Class<?> type) {
		for (Role role : this.callerRoles) {
			if ( role.getClass().equals(type) ) {
				return role;
			}
		}
		
		return null;
	}
}
