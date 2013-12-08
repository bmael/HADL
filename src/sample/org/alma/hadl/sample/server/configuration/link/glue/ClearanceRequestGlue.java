/**
 * 
 */
package org.alma.hadl.sample.server.configuration.link.glue;

import org.alma.hadl.interfaces.role.Glue;
import org.alma.hadl.observer.Observable;

/**
 * @author Julien
 *
 */
public class ClearanceRequestGlue extends Glue {

	public ClearanceRequestGlue(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see org.alma.hadl.observer.Observer#update(org.alma.hadl.observer.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obs, Object args) {
		// TODO Auto-generated method stub

	}

}
