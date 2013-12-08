/**
 * 
 */
package org.alma.hadl.sample.server.configuration.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Julien
 *
 */
public class DatabaseManager {

	private static DatabaseManager instance;
	private Connection con = null;

	/**
	 * Set the Connection
	 * @param con
	 */
	private void setCon(Connection con) {
		this.con = con;
	}

	private DatabaseManager(){
		try {
			Class.forName("org.h2.Driver"); //loads the driver
			setCon(DriverManager.getConnection("jdbc:h2:~/hadl", "sa", ""));

			//creates tables for the database
			createTablePerson();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void createTablePerson() {
		String sqlquery = "CREATE TABLE IF NOT EXISTS Person"+
				"(firstName VARCHAR(20) NOT NULL,"
				+ "lastName VARCHAR(20) NOT NULL,"
				+ "idPerson INT AUTO_INCREMENT PRIMARY KEY);";
		try{
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sqlquery);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}


	public Connection getCon() {
		return con;
	}

	public static synchronized DatabaseManager getInstance(){
		if(instance == null){
			instance = new DatabaseManager();
		}
		return instance;
	}

}
