/**
 * 
 */
package org.alma.hadl.sample.client;

import java.util.ArrayList;
import java.util.List;

import org.alma.hadl.component.Component;
import org.alma.hadl.observer.Observable;
import org.alma.hadl.sample.client.port.SendRequest;

/**
 * @author Julien
 *
 */
public class Client extends Component {
	public Client() {
		super();
		this.name = "Client";
	}
	
	public void doAction() {
		System.out.println("In Client");
		
		List<String> args = new ArrayList<>();
		args.add("Connection");
		args.add("username");
		args.add("password");
		
		((SendRequest) this.getProvidedPortByName("SendRequest")).send(args);
	}

	@Override
	public void update(Observable obs, Object args) {
		// TODO Auto-generated method stub
		//System.out.println("Update from client");
	}
}
