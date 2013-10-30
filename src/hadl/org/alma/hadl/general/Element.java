/**
 * 
 */
package org.alma.hadl.general;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author Maël
 *
 */
public class Element {
	private Map<String, Object> properties;
	
	public Element() {
		this.properties = new Hashtable<>();
	}
	
	public void addProperty(String key, Object value) {
		this.properties.put(key, value);
	}
	
	public Object getProperty(String key) {
		return this.properties.get(key);
	}
}
