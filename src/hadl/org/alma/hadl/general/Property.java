/**
 * 
 */
package org.alma.hadl.general;


/**
 * @author Maël
 *
 */
public class Property {
	private String key;
	private Object value;
	
	public Property(String key, Object value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return this.key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public Object getValue() {
		return this.value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
}
