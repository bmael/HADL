/**
 * 
 */
package org.alma.hadl.component;

import java.util.ArrayList;
import java.util.List;

import org.alma.hadl.interfaces.port.ProvidedPort;
import org.alma.hadl.interfaces.port.RequiredPort;
import org.alma.hadl.link.Link;

/**
 * @author Julien
 *
 */
public abstract class ComponentAssembly {
	protected String name;
	protected List<Link> links = new ArrayList<>();
	protected List<ProvidedPort> providedPorts = new ArrayList<>();
	protected List<RequiredPort> requiredPorts = new ArrayList<>();
	
	/**
	 * Default constructor
	 */
	public ComponentAssembly() {
		super();
	}
	
	/**
	 * Constructor
	 * @param links The {@link List} of {@link Link}
	 * @param providedPorts The {@link List} of {@link ProvidedPort}
	 * @param requiredPorts The {@link List} of {@link RequiredPort}
	 */
	public ComponentAssembly(String name, List<Link> links, List<ProvidedPort> providedPorts, List<RequiredPort> requiredPorts) {
		this.name = name;
		this.links = links;
		this.providedPorts = providedPorts;
		this.requiredPorts = requiredPorts;
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
	 * 
	 * @param name
	 * @return
	 */
	public ProvidedPort getProvidedPortByName(String name) {
		for (ProvidedPort providedPort : this.providedPorts) {
			if ( providedPort.getName().equals(name) ) {
				return providedPort;
			}
		}
		
		return null;
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
	 * 
	 * @param name
	 * @return
	 */
	public RequiredPort getRequiredPortByName(String name) {
		for (RequiredPort requiredPort : this.requiredPorts) {
			if ( requiredPort.getName().equals(name) ) {
				return requiredPort;
			}
		}
		
		return null;
	}

	/**
	 * @param requiredPorts the requiredPorts to set
	 */
	public void setRequiredPorts(List<RequiredPort> requiredPorts) {
		this.requiredPorts = requiredPorts;
	}
	
	
	public void addLink(Link link) {
		this.links.add(link);
	}
	
	public void addProvidedPort(ProvidedPort providedPort) {
		this.providedPorts.add(providedPort);
	}
	
	public void addRequiredPort(RequiredPort requiredPort) {
		this.requiredPorts.add(requiredPort);
	}
}
