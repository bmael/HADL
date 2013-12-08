/**
 * 
 */
package org.alma.hadl.sample.server.configuration.database.model;

/**
 * @author Julien
 *
 */
public class Person {

	private String firstName, lastName;
	private int id;
	
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param id
	 */
	public Person(String firstName, String lastName, int id) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}


	/**
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}


	/**
	 * 
	 */
	public Person() {
		super();
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
}
