/**
 * 
 */
package org.alma.hadl.sample.clientserver.component;

import org.alma.hadl.component.Component;
import org.alma.hadl.observer.Observable;
import org.alma.hadl.sample.clientserver.configuration.ClientServerConfiguration;

/**
 * @author Julien
 *
 */
public class ClientServer extends Component {

	public ClientServer(String name) {
		super(name);
		
		ClientServerConfiguration clientServerConfiguration = new ClientServerConfiguration();
		clientServerConfiguration.getClient().doAction();
	}

	/* (non-Javadoc)
	 * @see org.alma.hadl.observer.Observer#update(org.alma.hadl.observer.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obs, Object args) {
		// TODO Auto-generated method stub

	}

}
