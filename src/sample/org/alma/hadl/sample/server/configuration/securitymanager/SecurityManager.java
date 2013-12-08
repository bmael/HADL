/**
 * 
 */
package org.alma.hadl.sample.server.configuration.securitymanager;

import org.alma.hadl.component.Component;
import org.alma.hadl.observer.Observable;
import org.alma.hadl.sample.server.configuration.securitymanager.port.CQuery;
import org.alma.hadl.sample.server.configuration.securitymanager.port.SecurityAuth;

/**
 * @author Julien
 *
 */
public class SecurityManager extends Component {

	public SecurityManager() {
		super("SecurityManager");

		this.addProvidedPort(new SecurityAuth(this, "SecurityAuth"));
		this.addProvidedPort(new CQuery(this, "CQuery"));
	}

	/* (non-Javadoc)
	 * @see org.alma.hadl.observer.Observer#update(org.alma.hadl.observer.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obs, Object args) {
		// TODO Auto-generated method stub

	}

}
