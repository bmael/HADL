/**
 * 
 */
package org.alma.hadl.component;

import java.util.ArrayList;
import java.util.List;

import org.alma.hadl.interfaces.role.Glue;


/**
 * @author Julien
 *
 */
public abstract class PrimitiveConnector implements IConnector {

	protected String name;
	protected List<Glue> glues = new ArrayList<>();
	
	
	/**
	 * @param name
	 */
	public PrimitiveConnector(String name) {
		super();
		this.name = name;
	}
	
	
	/**
	 * @param name
	 * @param glues
	 */
	public PrimitiveConnector(String name, List<Glue> glues) {
		this.name = name;
		this.glues = glues;
	}
	
	
	/**
	 * @param glue
	 */
	public void addGlue(Glue glue) {
		this.glues.add(glue);
	}
	
	
	/**
	 * @param type
	 * @return
	 */
	public Glue getGlueByType(Class<?> type) {
		for (Glue glue : this.glues) {
			if ( glue.getClass().equals(type) ) {
				return glue;
			}
		}
		
		return null;
	}
}
