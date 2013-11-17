/**
 * 
 */
package org.alma.hadl.component;

import java.util.List;

import org.alma.hadl.interfaces.service.ProvidedService;
import org.alma.hadl.interfaces.service.RequiredService;

/**
 * @author Julien
 *
 */
public abstract class Component extends ComponentAssembly {

	private List<RequiredService> requiredServices;
	private List<ProvidedService> providedServices;


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
	public Component(List<RequiredService> requiredServices,
			List<ProvidedService> providedServices) {
		super();
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
