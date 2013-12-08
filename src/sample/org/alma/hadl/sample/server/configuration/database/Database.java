/**
 * 
 */
package org.alma.hadl.sample.server.configuration.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.alma.hadl.component.Component;
import org.alma.hadl.observer.Observable;
import org.alma.hadl.sample.server.configuration.database.port.QueryInt;
import org.alma.hadl.sample.server.configuration.database.port.SecurityManagement;

/**
 * @author Julien
 *
 */
public class Database extends Component {

	public Database() {
		super("Database");

		this.addProvidedPort(new QueryInt(this, "QueryInt"));
		this.addProvidedPort(new SecurityManagement(this, "SecurityManagement"));
	}

	/* (non-Javadoc)
	 * @see org.alma.hadl.observer.Observer#update(org.alma.hadl.observer.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obs, Object args) {
		if ( obs instanceof QueryInt ) {
			System.out.println("In database from QueryInt with args " + args);

			if ( args != null ) {

				switch ( ((List<String>) args).get(0) ) {

				case "addUser" :
					System.out.println("Adding User in database");
					try {
						addUserInDatabase(((List<String>) args).get(1), ((List<String>) args).get(2));
						((QueryInt) this.getProvidedPortByType(QueryInt.class)).send(this, "User successfully added into database");
					} catch (SQLException e) {
						e.printStackTrace();
						((QueryInt) this.getProvidedPortByType(QueryInt.class)).send(this, "A problem occured when querying the database");
					}
					break;

				case "removeUser" :
					System.out.println("Removing User from database");
					try {
						deleteUserInDatabase(((List<String>) args).get(1), ((List<String>) args).get(2));
						((QueryInt) this.getProvidedPortByType(QueryInt.class)).send(this, "User successfully removed from database");
					} catch (SQLException e) {
						e.printStackTrace();
						((QueryInt) this.getProvidedPortByType(QueryInt.class)).send(this, "A problem occured when querying the database");
					}
					break;

				case "selectAllUsers" :
					System.out.println("Selecting all users in database");
					try {
						List<String> res = new ArrayList<>();
						res = selectAllUsersInDatabase();
						
						((QueryInt) this.getProvidedPortByType(QueryInt.class)).send(this, res);
					} catch (SQLException e) {
						e.printStackTrace();
						((QueryInt) this.getProvidedPortByType(QueryInt.class)).send(this, "A problem occured when querying the database");
					}
					break;
					
				default :
					System.err.println("Unknown request " + args);
					break;
					
				}
			}
		}
	}


	public void addUserInDatabase(String firstName, String lastName) throws SQLException {
		Statement s = DatabaseManager.getInstance().getCon().createStatement();
		String sqlquery = "INSERT INTO Person (firstName, lastName)"
				+ "VALUES('"+ firstName + "', "
				+ "'" + lastName + "') ";
		System.out.println(sqlquery);
		s.executeUpdate(sqlquery);
	}


	public void deleteUserInDatabase(String firstName, String lastName) throws SQLException {
		Statement s = DatabaseManager.getInstance().getCon().createStatement();
		String sqlquery = "DELETE FROM Person "
				+ "WHERE firstName = '" + firstName + "' "
				+ "AND lastName = '" + lastName + "'";
		System.out.println(sqlquery);
		s.executeUpdate(sqlquery);
	}


	public List<String> selectAllUsersInDatabase() throws SQLException {
		List<String> persons = new ArrayList<>();

		Statement s = DatabaseManager.getInstance().getCon().createStatement();
		String sqlquery = "SELECT * FROM Person";
		System.out.println(sqlquery);
		ResultSet res = s.executeQuery(sqlquery);

		while(res.next()){
			persons.add(res.getString("firstName") + " " + res.getString("lastName"));
		}

		return persons;
	}

}
