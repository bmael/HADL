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

	private List<Glue> glues = new ArrayList<>();
	
	public PrimitiveConnector() {
		super();
	}
	
//	public PrimitiveConnector(List<Glue> glues) {
//		this.glues = glues;
//	}
	
	public void addGlue(Glue glue) {
		this.glues.add(glue);
	}
}
