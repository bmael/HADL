/**
 * 
 */
package org.alma.hadl.component;

import java.util.ArrayList;
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

	protected Configuration parentConfiguration;	// Can be null in the case of a stand alone Component
	protected List<RequiredService> requiredServices = new ArrayList<>();
	protected List<ProvidedService> providedServices = new ArrayList<>();


	/**
	 * 
	 */
	public Component(String name) {
		super(name);
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
	public RequiredService getRequiredServiceByType(Class<?> type) {
		for (RequiredService requiredService : this.requiredServices) {
			if ( requiredService.getClass().equals(type) ) {
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
	public ProvidedService getProvidedServiceByType(Class<?> type) {
		for (ProvidedService providedService : this.providedServices) {
			if ( providedService.getClass().equals(type) ) {
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
	
	
	/**
	 * @return the parentConfiguration
	 */
	public Configuration getParentConfiguration() {
		return parentConfiguration;
	}


	/**
	 * @param parentConfiguration the parentConfiguration to set
	 */
	public void setParentConfiguration(Configuration parentConfiguration) {
		this.parentConfiguration = parentConfiguration;
	}


	/**
	 * @param requiredService
	 */
	public void addRequiredService(RequiredService requiredService) {
		this.requiredServices.add(requiredService);
	}
	
	
	/**
	 * @param providedService
	 */
	public void addProvidedService(ProvidedService providedService) {
		this.providedServices.add(providedService);
	}
}
