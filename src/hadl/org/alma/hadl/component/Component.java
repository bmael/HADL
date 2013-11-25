/**
 * 
 */
package org.alma.hadl.component;

import java.util.List;

import org.alma.hadl.interfaces.port.ProvidedPort;
import org.alma.hadl.interfaces.port.RequiredPort;
import org.alma.hadl.interfaces.service.ProvidedService;
import org.alma.hadl.interfaces.service.RequiredService;
import org.alma.hadl.link.Link;
import org.alma.hadl.observer.Observer;

/**
 * @author Julien
 *
 */
public abstract class Component extends ComponentAssembly implements Observer {

	protected String name;
	protected List<RequiredService> requiredServices;
	protected List<ProvidedService> providedServices;


	/**
	 * 
	 */
	public Component() {
		super();
	}

	
	/**
	 * @param requiredServices
	 * @param providedServices
	 */
	public Component(String name, List<Link> links, List<ProvidedPort> providedPorts, List<RequiredPort> requiredPorts, List<RequiredService> requiredServices, List<ProvidedService> providedServices) {
		super(name, links, providedPorts, requiredPorts);
		this.name = name;
		this.requiredServices = requiredServices;
		this.providedServices = providedServices;
	}
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the requiredServices
	 */
	public List<RequiredService> getRequiredServices() {
		return requiredServices;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public RequiredService getRequiredServiceByName(String name) {
		for (RequiredService requiredService : this.requiredServices) {
			if ( requiredService.getName().equals(name) ) {
				return requiredService;
			}
		}
		
		return null;
	}


	/**
	 * @param requiredServices the requiredServices to set
	 */
	public void setRequiredServices(List<RequiredService> requiredServices) {
		this.requiredServices = requiredServices;
	}


	/**
	 * @return the providedServices
	 */
	public List<ProvidedService> getProvidedServices() {
		return providedServices;
	}

	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public ProvidedService getProvidedServiceByName(String name) {
		for (ProvidedService providedService : this.providedServices) {
			if ( providedService.getName().equals(name) ) {
				return providedService;
			}
		}
		
		return null;
	}

	/**
	 * @param providedServices the providedServices to set
	 */
	public void setProvidedServices(List<ProvidedService> providedServices) {
		this.providedServices = providedServices;
	}
	
	public void addRequiredService(RequiredService requiredService) {
		this.requiredServices.add(requiredService);
	}
	
	public void addProvidedService(ProvidedService providedService) {
		this.providedServices.add(providedService);
	}
}
