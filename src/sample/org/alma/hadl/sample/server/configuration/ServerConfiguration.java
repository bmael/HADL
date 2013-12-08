/**
 * 
 */
package org.alma.hadl.sample.server.configuration;

import org.alma.hadl.component.Configuration;
import org.alma.hadl.component.PrimitiveConnector;
import org.alma.hadl.sample.server.component.Server;
import org.alma.hadl.sample.server.configuration.connectionmanager.ConnectionManager;
import org.alma.hadl.sample.server.configuration.connectionmanager.port.DbQuery;
import org.alma.hadl.sample.server.configuration.connectionmanager.port.ExternalSocket;
import org.alma.hadl.sample.server.configuration.connectionmanager.port.SecurityCheck;
import org.alma.hadl.sample.server.configuration.connector.ClearanceRequest;
import org.alma.hadl.sample.server.configuration.connector.SQLQuery;
import org.alma.hadl.sample.server.configuration.connector.SecurityQuery;
import org.alma.hadl.sample.server.configuration.database.Database;
import org.alma.hadl.sample.server.configuration.database.port.QueryInt;
import org.alma.hadl.sample.server.configuration.database.port.SecurityManagement;
import org.alma.hadl.sample.server.configuration.link.A1;
import org.alma.hadl.sample.server.configuration.link.A2;
import org.alma.hadl.sample.server.configuration.link.A3;
import org.alma.hadl.sample.server.configuration.link.A4;
import org.alma.hadl.sample.server.configuration.link.A5;
import org.alma.hadl.sample.server.configuration.link.A6;
import org.alma.hadl.sample.server.configuration.link.glue.ClearanceRequestGlue;
import org.alma.hadl.sample.server.configuration.link.glue.SQLQueryGlue;
import org.alma.hadl.sample.server.configuration.link.glue.SecurityQueryGlue;
import org.alma.hadl.sample.server.configuration.link.role.Requestor;
import org.alma.hadl.sample.server.configuration.link.role.SQLCalled;
import org.alma.hadl.sample.server.configuration.link.role.SQLCaller;
import org.alma.hadl.sample.server.configuration.link.role.SecurityManagerRole;
import org.alma.hadl.sample.server.configuration.link.role.SecurityQueryRequestor;
import org.alma.hadl.sample.server.configuration.securitymanager.SecurityManager;
import org.alma.hadl.sample.server.configuration.securitymanager.port.CQuery;
import org.alma.hadl.sample.server.configuration.securitymanager.port.SecurityAuth;

/**
 * @author Julien
 *
 */
public class ServerConfiguration extends Configuration {

	protected ConnectionManager connectionManager;
	protected Database database;
	protected SecurityManager securityManager;

	protected PrimitiveConnector clearanceRequest;
	protected PrimitiveConnector securityQuery;
	protected PrimitiveConnector sqlQuery;

	protected A1 a1;
	protected A2 a2;
	protected A3 a3;
	protected A4 a4;
	protected A5 a5;
	protected A6 a6;

	protected Server server;

	public ServerConfiguration() {
		super("ServerConfiguration");

		// Constructing Components
		this.connectionManager = new ConnectionManager();
		this.database = new Database();
		this.securityManager = new SecurityManager();
		
		this.connectionManager.setParentConfiguration(this);

		// Contructing PrimitiveConnectors
		this.clearanceRequest = new ClearanceRequest("ClearanceRequest");
		this.securityQuery = new SecurityQuery("SecurityQuery");
		this.sqlQuery = new SQLQuery("SQLQuery");

		// AttachmentLinks
		this.a1 = new A1("A1", clearanceRequest.getGlueByType(ClearanceRequestGlue.class).getCallerRoleByType(Requestor.class), connectionManager.getProvidedPortByType(SecurityCheck.class));
		this.a2 = new A2("A2", clearanceRequest.getGlueByType(ClearanceRequestGlue.class).getCalledRoleByType(Requestor.class), securityManager.getProvidedPortByType(SecurityAuth.class));
		this.a3 = new A3("A3", sqlQuery.getGlueByType(SQLQueryGlue.class).getCallerRoleByType(SQLCaller.class), connectionManager.getProvidedPortByType(DbQuery.class));
		this.a4 = new A4("A4", sqlQuery.getGlueByType(SQLQueryGlue.class).getCalledRoleByType(SQLCalled.class), database.getProvidedPortByType(QueryInt.class));
		this.a5 = new A5("A5", securityQuery.getGlueByType(SecurityQueryGlue.class).getCallerRoleByType(SecurityManagerRole.class), securityManager.getProvidedPortByType(CQuery.class));
		this.a6 = new A6("A6", securityQuery.getGlueByType(SecurityQueryGlue.class).getCalledRoleByType(SecurityQueryRequestor.class), database.getProvidedPortByType(SecurityManagement.class));

		// Setting Observer Patterns
		this.connectionManager.getProvidedPortByType(ExternalSocket.class).addObserver(connectionManager);
		//this.connectionManager.getProvidedPortByType(ExternalSocket.class).addObserver();
		this.connectionManager.getProvidedPortByType(DbQuery.class).addObserver(connectionManager);
		this.connectionManager.getProvidedPortByType(DbQuery.class).addObserver(a3);
		
		this.sqlQuery.getGlueByType(SQLQueryGlue.class).getCallerRoleByType(SQLCaller.class).addObserver(a3);
		this.sqlQuery.getGlueByType(SQLQueryGlue.class).getCallerRoleByType(SQLCaller.class).addObserver(sqlQuery.getGlueByType(SQLQueryGlue.class));
		this.sqlQuery.getGlueByType(SQLQueryGlue.class).getCalledRoleByType(SQLCalled.class).addObserver(a4);
		this.sqlQuery.getGlueByType(SQLQueryGlue.class).getCalledRoleByType(SQLCalled.class).addObserver(sqlQuery.getGlueByType(SQLQueryGlue.class));
		
		this.database.getProvidedPortByType(QueryInt.class).addObserver(this.database);
		this.database.getProvidedPortByType(QueryInt.class).addObserver(this.a4);
	}

	/**
	 * @return the connectionManager
	 */
	public ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	/**
	 * @return the database
	 */
	public Database getDatabase() {
		return database;
	}

	/**
	 * @return the securityManager
	 */
	public SecurityManager getSecurityManager() {
		return securityManager;
	}

	/**
	 * @return the clearanceRequest
	 */
	public PrimitiveConnector getClearanceRequest() {
		return clearanceRequest;
	}

	/**
	 * @return the securityQuery
	 */
	public PrimitiveConnector getSecurityQuery() {
		return securityQuery;
	}

	/**
	 * @return the sqlQuery
	 */
	public PrimitiveConnector getSqlQuery() {
		return sqlQuery;
	}

	/**
	 * @return the a1
	 */
	public A1 getA1() {
		return a1;
	}

	/**
	 * @return the a2
	 */
	public A2 getA2() {
		return a2;
	}

	/**
	 * @return the a3
	 */
	public A3 getA3() {
		return a3;
	}

	/**
	 * @return the a4
	 */
	public A4 getA4() {
		return a4;
	}

	/**
	 * @return the a5
	 */
	public A5 getA5() {
		return a5;
	}

	/**
	 * @return the a6
	 */
	public A6 getA6() {
		return a6;
	}

	/**
	 * @return the server
	 */
	public Server getServer() {
		return server;
	}

	/**
	 * @param server the server to set
	 */
	public void setServer(Server server) {
		this.server = server;
	}
}
