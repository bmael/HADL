/**
 * 
 */
package org.alma.hadl.sample.client.service;

import org.alma.hadl.component.Component;
import org.alma.hadl.interfaces.service.ProvidedService;
import org.alma.hadl.observer.Observer;
import org.alma.hadl.sample.client.port.SendRequestPort;

/**
 * @author Julien
 *
 */
public class SendRequestService extends ProvidedService {

	public SendRequestService(Component owner, String name) {
		super(owner, name);
	}
	
	public void send(Observer caller, Object args) {
		System.out.println("In SendRequestService");
		((SendRequestPort) this.getOwner().getProvidedPortByType(SendRequestPort.class)).send(caller, args);
	}

}
