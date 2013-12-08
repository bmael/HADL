/**
 * 
 */
package org.alma.hadl.sample.server.component.service;

import org.alma.hadl.component.Component;
import org.alma.hadl.interfaces.service.ProvidedService;
import org.alma.hadl.observer.Observer;
import org.alma.hadl.sample.server.component.port.ReceiveRequestPort;

/**
 * @author Julien
 *
 */
public class SendResponseService extends ProvidedService {

	public SendResponseService(Component owner, String name) {
		super(owner, name);
	}
	
	public void send(Observer caller, Object args) {
		System.out.println("In SendResponseService");
		((ReceiveRequestPort) this.getOwner().getProvidedPortByType(ReceiveRequestPort.class)).sendResponse(caller, args);
	}

}
