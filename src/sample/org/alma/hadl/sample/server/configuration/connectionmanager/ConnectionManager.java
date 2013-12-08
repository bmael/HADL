/**
 * 
 */
package org.alma.hadl.sample.server.configuration.connectionmanager;

import org.alma.hadl.component.Component;
import org.alma.hadl.observer.Observable;
import org.alma.hadl.sample.server.configuration.ServerConfiguration;
import org.alma.hadl.sample.server.configuration.connectionmanager.port.DbQuery;
import org.alma.hadl.sample.server.configuration.connectionmanager.port.ExternalSocket;
import org.alma.hadl.sample.server.configuration.connectionmanager.port.SecurityCheck;

/**
 * @author Julien
 *
 */
public class ConnectionManager extends Component {

	public ConnectionManager() {
		super("ConnectionManager");
		
		this.addProvidedPort(new SecurityCheck(this, "SendRequestPort"));
		this.addProvidedPort(new ExternalSocket(this, "ExternalSocket"));
		this.addProvidedPort(new DbQuery(this, "DbQuery"));
	}

	/* (non-Javadoc)
	 * @see org.alma.hadl.observer.Observer#update(org.alma.hadl.observer.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obs, Object args) {
		if ( obs instanceof DbQuery ) {
			if ( this.parentConfiguration != null ) {
				((ServerConfiguration) this.parentConfiguration).getServer().sendResult(args);
			}
		}
	}

	public void sendRequest(Object args) {
		((DbQuery) this.getProvidedPortByType(DbQuery.class)).receive(this, args);
	}

}
