package mn.infosystems.callcenter.model;

import java.sql.Connection;

public class PostgreUpdate {
	private Connection connection;
	private String server;
	private String port;
	private String database;
	private String user;
	private String password;
	
	public PostgreUpdate() {
		server = "localhost";
		port = "5432";
		database = Messages.getString("databasename", "realm");
		user = "postgres";
		password = Messages.getString("password", "realm");
	}

}
