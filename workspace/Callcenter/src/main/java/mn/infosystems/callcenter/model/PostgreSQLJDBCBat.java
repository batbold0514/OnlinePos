package mn.infosystems.callcenter.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.mortbay.log.Log;

public class PostgreSQLJDBCBat implements CallCenterLogger {
	private Connection connection;
	private String server;
	private String port;
	private String database;
	private String user;
	private String password;

	public PostgreSQLJDBCBat() {
		init();
	}

	public void init() {
		server = "localhost";
		port = "5432";
		database = Messages.getString("databasename", "realm");
		user = "postgres";
		password = Messages.getString("password", "realm");
	}

	public boolean createConnection() {
		if (Utilities.isEmpty(server) || Utilities.isEmpty(database)
				|| Utilities.isEmpty(user) || Utilities.isEmpty(password)) {
			System.out.println("Warning: Some variables empty in connection!");
			return false;
		}

		return true;
	}
	public List<Cell> select(String table, int id) throws SQLException {
		List<Cell> cellList = null;
		if (Utilities.isEmpty(table)) {
			System.out.println("Warning: Table name empty!");
			return cellList;
		}

			connection.setAutoCommit(false);
			Statement statement = connection.createStatement();
			ResultSet resultSet = null;
			try {
				 writeToConsole("SELECT * FROM " + table + " WHERE id = '" +
				 id + "';");
				resultSet = statement.executeQuery("SELECT * FROM " + table
						+ " WHERE id = '" + id + "';");
			} catch (Exception ex) {
				System.out.println("Error: Can't select!\nMessage: "
						+ ex.toString());
				statement.close();
				return cellList;
			}
			cellList = new ArrayList<Cell>();
			ResultSetMetaData resultSetMetadata = resultSet.getMetaData();
			while (resultSet.next()) {
				for (int c = 1; resultSetMetadata.getColumnCount() >= c; c++) {
					cellList.add(new Cell(resultSetMetadata.getColumnName(c),
							resultSet.getString(c)));
				}
			}
			resultSet.close();
			statement.close();
		return cellList;
	}
	public boolean openConnection() {
		if (Utilities.isEmpty(port)) {
			port = "5432";
		}
		String connectionString = "jdbc:postgresql://" + server + ":" + port
				+ "/" + database + "?user=" + user + "&password=" + password
				+ "&charSet=UTF-8";
		System.out.println(connectionString);
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(connectionString);

		} catch (Exception ex) {
			// throw new Exception(ex.toString());
			System.out.println("Error: Can't connect to database!\nMessage: "
					+ ex.toString());
			return false;
		}
		return true;
	}

	public boolean closeConnection() {
		try {
			connection.close();
		} catch (SQLException ex) {
			System.out.println("Error: Can't close connection!\nMessage: "
					+ ex.toString());
			return false;
		}
		return true;
	}

	public Cell getCell(String functionName) throws SQLException {
		Cell cell = null;
		if (Utilities.isEmpty(functionName)) {
			System.out.println("Warning: Function name empty!");
			return cell;
		}

		connection.setAutoCommit(false);
		Statement statement = connection.createStatement();
		ResultSet resultSet = null;
		try {
			writeToConsole("SELECT " + functionName + "();");
			resultSet = statement
					.executeQuery("SELECT " + functionName + "();");
		} catch (Exception ex) {
			System.out.println("Error: Can't execute function!\nMessage: "
					+ ex.toString());
			statement.close();
			return cell;
		}
		ResultSetMetaData resultSetMetadata = resultSet.getMetaData();
		while (resultSet.next()) {
			int nullCell = 0;
			for (int c = 1; resultSetMetadata.getColumnCount() >= c; c++) {
				if (resultSet.getString(c) == null
						|| resultSet.getString(c).trim()
								.equalsIgnoreCase("null")) {
					nullCell++;
				}
			}
			if (nullCell != resultSetMetadata.getColumnCount()) {
				for (int c = 1; resultSetMetadata.getColumnCount() >= c; c++) {
					cell = new Cell(resultSetMetadata.getColumnName(c),
							resultSet.getString(c));
				}
			} else {/*
				System.out.println("Info: Null cell returned from "
						+ functionName + "()!");*/
			}
		}
		resultSet.close();
		statement.close();
		connection.commit();
		return cell;
	}

	public boolean execute(String functionName, List<String> parameterList)
			throws SQLException {
		boolean isExecuted = false;
		if (Utilities.isEmpty(functionName) || hasEmptyString(parameterList)) {
			System.out
					.println("Warning: Function name is empty or parameters are empty!");
			return isExecuted;
		}

		String query = "SELECT " + functionName + "(";
		for (int i = 0; parameterList.size() > i; i++) {
			query = query + "'" + parameterList.get(i);
			if ((parameterList.size() - 1) != i) {
				query = query + "', ";
			} else {
				query = query + "');";
			}
		}
		connection.setAutoCommit(false);
		Statement statement = connection.createStatement();
		ResultSet resultSet = null;
		try {
			writeToConsole(query);
			resultSet = statement.executeQuery(query);
		} catch (Exception ex) {
			System.out.println("Error: Can't execute function!\nMessage: "
					+ ex.toString());
			statement.close();
			return isExecuted;
		}
		ResultSetMetaData resultSetMetadata = resultSet.getMetaData();
		while (resultSet.next()) {
			for (int c = 1; resultSetMetadata.getColumnCount() >= c; c++) {
				if (!Utilities.isEmpty(resultSet.getString(c))) {
					if (resultSet.getString(c).trim().equalsIgnoreCase("t")) {
						isExecuted = true;
					} else if (resultSet.getString(c).trim()
							.equalsIgnoreCase("f")) {
						/*System.out
								.println("Info: Execute non query function returns false value!");
						*/isExecuted = false;
					} else {
						System.out
								.println("Warning: Execute non query function returns string value!");
					}
				} else {
					/*System.out
							.println("Info: Execute non query function returns void value!");
					*/isExecuted = true;
				}
			}
		}
		resultSet.close();
		statement.close();
		connection.commit();
		return isExecuted;
	}

	public boolean execute(String functionName) throws SQLException {
		boolean isExecuted = false;
		if (Utilities.isEmpty(functionName)) {
			System.out.println("Warning: Function name is empty!");
			return isExecuted;
		}

		connection.setAutoCommit(false);
		Statement statement = connection.createStatement();
		ResultSet resultSet = null;
		try {
			writeToConsole("SELECT " + functionName + "();");
			System.out.println("SELECT " + functionName + "();");
			resultSet = statement
					.executeQuery("SELECT " + functionName + "();");
		} catch (Exception ex) {
			System.out.println("Error: Can't execute function!\nMessage: "
					+ ex.toString());
			statement.close();
			return isExecuted;
		}
		ResultSetMetaData resultSetMetadata = resultSet.getMetaData();
		while (resultSet.next()) {
			for (int c = 1; resultSetMetadata.getColumnCount() >= c; c++) {
				if (!Utilities.isEmpty(resultSet.getString(c))) {
					if (resultSet.getString(c).trim().equalsIgnoreCase("t")) {
						isExecuted = true;
					} else if (resultSet.getString(c).trim()
							.equalsIgnoreCase("f")) {
						/*System.out
								.println("Info: Execute non query function returns false value!");
						*/isExecuted = false;
					} else {
						System.out
								.println("Warning: Execute non query function returns string value!");
					}
				} else {/*
					System.out
							.println("Info: Execute non query function returns void value!");
					*/isExecuted = true;
				}
			}
		}
		resultSet.close();
		statement.close();
		connection.commit();
		return isExecuted;
	}

	public Cell getCell(String functionName, List<String> parameterList)
			throws SQLException {
		Cell cell = null;
		if (hasEmptyString(parameterList) || Utilities.isEmpty(functionName)) {
			System.out
					.println("Warning: Function name empty or parameters are empty!");
			return cell;
		}

		String query = "SELECT " + functionName + "(";
		for (int i = 0; parameterList.size() > i; i++) {
			query = query + "'" + parameterList.get(i);
			if ((parameterList.size() - 1) != i) {
				query = query + "', ";
			} else {
				query = query + "');";
			}
		}
		connection.setAutoCommit(false);
		Statement statement = connection.createStatement();
		ResultSet resultSet = null;
		try {
			writeToConsole(query);
			resultSet = statement.executeQuery(query);
		} catch (Exception ex) {
			System.out.println("Error: Can't execute function!\nMessage: "
					+ ex.toString());
			statement.close();
			return cell;
		}
		ResultSetMetaData resultSetMetadata = resultSet.getMetaData();
		while (resultSet.next()) {
			int nullCell = 0;
			for (int c = 1; resultSetMetadata.getColumnCount() >= c; c++) {
				if (resultSet.getString(c) == null
						|| resultSet.getString(c).trim()
								.equalsIgnoreCase("null")) {
					nullCell++;
				}
			}
			if (nullCell != resultSetMetadata.getColumnCount()) {
				for (int c = 1; resultSetMetadata.getColumnCount() >= c; c++) {
					cell = new Cell(resultSetMetadata.getColumnName(c),
							resultSet.getString(c));
				}
			} else {
				/*System.out.println("Info: Null cell returned from "
						+ functionName + "()!");
			*/}
		}
		resultSet.close();
		statement.close();
		connection.commit();
		return cell;
	}
	// Select all row statement
	public ResultSet select(String query) throws SQLException {
		if (Utilities.isEmpty(query)) {
			System.out.println("Warning: Table name empty!");
			return null;
		}
		ResultSet resultSet = null;
			connection.setAutoCommit(false);
			Statement statement = connection.createStatement();
			
			try {
				 writeToConsole(query);
				resultSet = statement.executeQuery(query
						+ ";");
			} catch (Exception ex) {
				System.out.println("Error: Can't select!\nMessage: "
						+ ex.toString());
				statement.close();
				return null;
			}
		
		return resultSet;
	}
	public boolean insert(String table, List<Cell> cellList)
			throws SQLException {
		boolean isInserted = false;
		if (hasEmptyColumn(cellList) || Utilities.isEmpty(table)) {
			System.out
					.println("Warning: Can't insert - Some columns name empty or table name is empty!");
			return isInserted;
		}

		String query = "INSERT INTO " + table + "(";
		for (int i = 0; i < cellList.size(); i++) {
			query = query + cellList.get(i).getColumn();
			if ((cellList.size() - 1) != i) {
				query = query + ", ";
			}
		}
		query = query + ") VALUES(";
		for (int i = 0; i < cellList.size(); i++) {
			query = query + "'" + cellList.get(i).getValue();
			if ((cellList.size() - 1) != i) {
				query = query + "', ";
			} else {
				query = query + "');";
			}
		}
		connection.setAutoCommit(false);
		Statement statement = connection.createStatement();
		try {
			writeToConsole(query);
			if (statement.executeUpdate(query) == 1) {
				isInserted = true;
			} else {
				System.out.println("Warning: Something wrong in insert!");
			}
		} catch (Exception ex) {
			System.out.println("Error: Can't insert!\nMessage: "
					+ ex.toString());
		}
		statement.close();
		connection.commit();
		return isInserted;
	}

	public boolean update(String table, Long id, List<Cell> cellList)
			throws SQLException {
		boolean isUpdated = false;
		if (hasEmptyColumn(cellList) || Utilities.isEmpty(table)) {
			System.out
					.println("Error: Can't update - Some column name's empty!");
			return isUpdated;
		}

		String query = "UPDATE " + table + " SET ";
		for (int i = 0; cellList.size() > i; i++) {
			query = query + cellList.get(i).getColumn() + "='"
					+ cellList.get(i).getValue() + "'";
			if ((cellList.size() - 1) != i) {
				query = query + ", ";
			}
		}
		query = query + " WHERE id='" + id + "';";
		connection.setAutoCommit(false);
		Statement statement = connection.createStatement();
		try {
			writeToConsole(query);
			if (statement.executeUpdate(query) == 1) {
				isUpdated = true;
			} else {
				System.out.println("Warning: There isn't any id - " + id + "!");
			}
		} catch (Exception ex) {
			System.out.println("Error: Can't update!\nMessage: "
					+ ex.toString());
		}
		statement.close();
		connection.commit();
		return isUpdated;
	}

	private boolean hasEmptyColumn(List<Cell> cellList) {
		if (cellList != null && cellList.size() > 0) {
			for (Cell cell : cellList) {
				if (Utilities.isEmpty(cell.getColumn())) {
					return true;
				}
			}
		} else {
			return true;
		}
		return false;
	}

	private boolean hasEmptyString(List<String> stringList) {
		if (stringList != null && stringList.size() > 0) {
			for (String string : stringList) {
				if (Utilities.isEmpty(string)) {
					return true;
				}
			}
		} else {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unused")
	private boolean hasEmptyString(String[] strings) {
		if (strings != null && strings.length > 0) {
			for (String string : strings) {
				if (Utilities.isEmpty(string)) {
					return true;
				}
			}
		} else {
			return true;
		}
		return false;
	}

	// - Not necessary OR Write to log...

	private void writeToConsole(String query) {
		// System.out.println(query);
//		log(null, query);
	}

	public void log(Object obj, String message) {
		Log.info(message);
	}
	
	public Long checkTaxPayer(String tpNumber) {
		try {
			Statement stmt = connection.createStatement();
			Long number = 0l;
			ResultSet rs = stmt
					.executeQuery("select * from taxpayer where regnumber = '"
							+ tpNumber + "'");
			while (rs.next()) {
				number = rs.getLong("id");
			}
			return number != 0 ? number : null;
		} catch (Exception e) {
			LOG.info(e);
		}
		return null;
	}

	public Long checkdebt(String debtNumber) {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from debt where debtnumber like '"
							+ debtNumber + "'");
			Long debtId = 0l;
			while (rs.next()) {
				debtId = rs.getLong("id");
			}
			rs.close();
			stmt.close();
			return debtId != 0 ? debtId : null;
		} catch (Exception e) {
			LOG.info(e);
		}
		return null;
	}
	
	public Long getDebtTypeId(String typeNumber){
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from debttype where typenumber like '"
							+ typeNumber + "'");
			Long debtId = 0l;
			while (rs.next()) {
				debtId = rs.getLong("id");
			}
			rs.close();
			stmt.close();
			return debtId != 0 ? debtId : null;
		} catch (Exception e) {
			LOG.info(e);
		}
		return null;
	}
	
	public Long lastIdOfDebt(){
		try{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from debt order by id desc limit 1");
			Long id = 0l;
			while(rs.next()){
				id = rs.getLong("id");
			}
			return id != 0 ? id + 1 : 1;
		}catch(Exception e){
			LOG.info(e);
		}
		return null;
	}
	public Long lastIdOfTaxPayer(){
		try{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from taxpayer order by id desc limit 1");
			Long id = 0l;
			while(rs.next()){
				id = rs.getLong("id");
			}
			return id != 0 ? id + 1 : 1;
		}catch(Exception e){
			LOG.info(e);
		}
		return null;
	}
	public Long lastIdOfDebtType(){
		try{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from debttype order by id desc limit 1");
			Long id = 0l;
			while(rs.next()){
				id = rs.getLong("id");
			}
			return id != 0 ? id + 1 : null;
		}catch(Exception e){
			LOG.info(e);
		}
		return null;
	}
}
