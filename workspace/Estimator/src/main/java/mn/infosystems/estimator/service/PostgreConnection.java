package mn.infosystems.estimator.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreConnection {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		Connection connection = null;
		connection = DriverManager.getConnection(
		   "jdbc:postgresql://192.168.88.91:5432/estimator","postgres", "123asd90@");
		System.out.println("Connection succesful");
		connection.close();
	}
}
