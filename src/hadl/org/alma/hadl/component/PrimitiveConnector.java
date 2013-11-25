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
	
	public PrimitiveConnector(String name) {
		super();
		this.name = name;
	}
	
	public PrimitiveConnector(String name, List<Glue> glues) {
		this.name = name;
		this.glues = glues;
	}
	
	public void addGlue(Glue glue) {
		this.glues.add(glue);
	}
}
