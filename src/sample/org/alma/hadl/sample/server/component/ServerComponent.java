/**
 * 
 */
package org.alma.hadl.sample.server.component;

import org.alma.hadl.component.Component;
import org.alma.hadl.observer.Observable;

/**
 * @author Julien
 *
 */
public class ServerComponent extends Component {

	public ServerComponent(String name) {
		super();
		this.name = name;
	}

	@Override
	public void update(Observable obs, Object args) {
		// TODO Auto-generated method stub
		System.out.println("Finally in server!");
	}
}
