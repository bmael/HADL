/**
 * 
 */
package org.alma.hadl.component;

import java.util.List;

import org.alma.hadl.interfaces.port.ProvidedPort;
import org.alma.hadl.interfaces.port.RequiredPort;
import org.alma.hadl.link.Link;
import org.alma.hadl.link.ProvidedBinding;

/**
 * @author Julien
 *
 */
public abstract class ComponentAssembly {
	private List<Link> links;
	private List<ProvidedPort> providedPorts;
	private List<RequiredPort> requiredPorts;
	
	/**
	 * Default constructor
	 */
	public ComponentAssembly() {
		
	}
	
	/**
	 * Constructor
	 * @param links The {@link List} of {@link Link}
	 * @param providedPorts The {@link List} of {@link ProvidedPort}
	 * @param requiredPorts The {@link List} of {@link RequiredPort}
	 */
	public ComponentAssembly(List<Link> links, List<ProvidedPort> providedPorts, List<RequiredPort> requiredPorts) {
		this.links = links;
		this.providedPorts = providedPorts;
		this.requiredPorts = requiredPorts;
	}

	/**
	 * @return the links
	 */
	public List<Link> getLinks() {
		return links;
	}

	/**
	 * @param links the links to set
	 */
	public void setLinks(List<Link> links) {
		this.links = links;
	}

	/**
	 * @return the providedPorts
	 */
	public List<ProvidedPort> getProvidedPorts() {
		return providedPorts;
	}

	/**
	 * @param providedPorts the providedPorts to set
	 */
	public void setProvidedPorts(List<ProvidedPort> providedPorts) {
		this.providedPorts = providedPorts;
	}

	/**
	 * @return the requiredPorts
	 */
	public List<RequiredPort> getRequiredPorts() {
		return requiredPorts;
	}

	/**
	 * @param requiredPorts the requiredPorts to set
	 */
	public void setRequiredPorts(List<RequiredPort> requiredPorts) {
		this.requiredPorts = requiredPorts;
	}
	
	
}
