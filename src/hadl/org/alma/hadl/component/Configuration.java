/**
 * 
 */
package org.alma.hadl.component;

import java.util.List;

import org.alma.hadl.interfaces.port.ProvidedPort;
import org.alma.hadl.interfaces.port.RequiredPort;
import org.alma.hadl.link.Link;

/**
 * @author Julien
 *
 */
public abstract class Configuration extends ComponentAssembly implements IConnector {
	private List<ComponentAssembly> components;
	private List<IConnector> connectors;
	
	
	/**
	 * Default Constructor
	 */
	public Configuration() {
		super();
	}


	/**
	 * @param components The {@link List} of {@link ComponentAssembly}
	 * @param connectors The {@link List} of {@link IConnector}
	 */
	public Configuration(List<ComponentAssembly> components, List<IConnector> connectors) {
		super();
		this.components = components;
		this.connectors = connectors;
	}
	
	/**
	 * Constructor
	 * @param links The {@link List} of {@link Link}
	 * @param providedPorts The {@link List} of {@link ProvidedPort}
	 * @param requiredPorts The {@link List} of {@link RequiredPort}
	 * @param components The {@link List} of {@link ComponentAssembly}
	 * @param connectors The {@link List} of {@link IConnector}
	 */
	public Configuration(List<Link> links, List<ProvidedPort> providedPorts, List<RequiredPort> requiredPorts, List<ComponentAssembly> components, List<IConnector> connectors) {
		super(links, providedPorts, requiredPorts);
		this.components = components;
		this.connectors = connectors;
	}


	/**
	 * @return the components
	 */
	public List<ComponentAssembly> getComponents() {
		return components;
	}


	/**
	 * @param components the components to set
	 */
	public void setComponents(List<ComponentAssembly> components) {
		this.components = components;
	}


	/**
	 * @return the connectors
	 */
	public List<IConnector> getConnectors() {
		return connectors;
	}


	/**
	 * @param connectors the connectors to set
	 */
	public void setConnectors(List<IConnector> connectors) {
		this.connectors = connectors;
	}
	
}
