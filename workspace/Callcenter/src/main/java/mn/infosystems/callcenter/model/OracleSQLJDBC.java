package mn.infosystems.callcenter.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class OracleSQLJDBC extends SwingWorker<Integer, Integer> implements
		CallCenterLogger {

	private Connection connection = null;
	private PostgreSQLJDBCBat db = new PostgreSQLJDBCBat();
	private Statement stmtTaxpayer ;
	private ResultSet taxPayerRs ;
	private Statement stmtDebt ;
	private ResultSet debtRs ;
	private Statement stmtAccountType ;
	private ResultSet accountTypeRs ;
	private Statement stmtDebtType ;
	private ResultSet debtTypeRs ;
	protected Integer doInBackground() throws Exception {
		// Do a time-consuming task.
		 haha();
	
//		 uploadPostgre();
		//updateTaxPayers();
		// updateDebtType();
//		connection.close();
		return 42;
	}
/*
	protected void done() {
		try {
			haha();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	private void haha() throws InterruptedException {
		log(null, "");
		// 30 min
		String url = "";
		String time = ConnectionMessages.getString("time");
		url = url.replace("\\", "");
		String times[] = time.split(":");
		GregorianCalendar now = new GregorianCalendar();
		now.setTime(new Date());
		/*
		 * if(Integer.parseInt(times[1]) <30){
		 * if(Integer.parseInt(times[0])==now.get(Calendar.HOUR_OF_DAY)){
		 * connectToDataBases(); uploadPostgre(); connection.close(); } }else{
		 * if((Integer.parseInt(times[0])+1)==now.get(Calendar.HOUR_OF_DAY)){
		 * connectToDataBases(); uploadPostgre(); connection.close(); } }
		 */
		
		try {
			if(connectToDataBases() == true){
				 connectToDataBases();
				db.createConnection();
				db.openConnection();
				stmtAccountType = connection.createStatement();
				System.out.println("start");
				stmtDebtType = connection.createStatement();
				stmtDebt = connection.createStatement();
				stmtTaxpayer = connection.createStatement();
				
				uploadOrInsertAccountNumberPostgre();
				uploadOrInsertDebtTypePostgre();
				uploadOrInsertTaxPayerPostgre();
				debtRs.close();
				stmtDebt.close();
				taxPayerRs.close();
				stmtTaxpayer.close();
				debtTypeRs.close();
				stmtDebtType.close();
				connection.close();
			}else{
				db.createConnection();
				db.openConnection();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			db.execute("update_all_enddate");
			db.execute("updatedtaxpayer_callquantity");
			List<String> callQuantity = new LinkedList<String>();
			callQuantity.add(db.select("callquantity", 0).get(1).getValue());
			db.execute("updatedtaxpayerzero");
			db.execute("updatebalance",callQuantity);
			db.execute("updatecallindex",callQuantity);
			db.execute("updatedateindex",callQuantity);
			db.execute("updatedebttype",callQuantity);
			db.execute("updateavgdate");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeConnection();
		}
		 Thread.sleep(1800000);
		 haha();

	}

	public void log(Object obj, String message) {
		LOG.info(message);
	}

	public boolean connectToDataBases() {
		
		GregorianCalendar now = new GregorianCalendar();
		now.setTime(new Date());
		// System.out.println("-------- Oracle JDBC Connection Testing ------");
		String url = ConnectionMessages.getString("url");
		String username = ConnectionMessages.getString("username");
		String password = ConnectionMessages.getString("password");
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			// System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return false;

		}

		// System.out.println("Oracle JDBC Driver Registered!");

		try {
			connection = DriverManager.getConnection(url, username, password);
			// connection = DriverManager.getConnection(
			// "jdbc:oracle:thin:@192.168.1.5:1521:dbtaxint?useUnicode=true&amp;characterEncoding=UTF-8",
			// "dman_user",
			// "dman_user");
			return true;
		} catch (SQLException e) {

//			 System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return false;
		}
	}


	private void uploadOrInsertTaxPayerPostgre() throws SQLException {		
		try{
			
			taxPayerRs = db.select("select * from maxprice limit 1");
			taxPayerRs.next();
			int maxBalance = Integer.parseInt(taxPayerRs.getString(2));
			taxPayerRs = stmtTaxpayer
					.executeQuery("SELECT * FROM normal.all_taxpayers WHERE (atps_soff_off_code, atps_tin) IN "
							+ "(SELECT DNP_OFF_CODE, DNP_TPEN_TIN FROM NORMAL.dman_notice_details A, NORMAL.dman_notice_page b where a.dnd_dnp_dln = b.dnp_dln)");
			String taxpayerId = "";
			
			while (taxPayerRs.next()) {
				List<String> list = new LinkedList<String>();
				String dnd_tpen_tin = taxPayerRs.getString("ATPS_TIN"); // .getString("DND_TPEN_TIN");
				list.add(dnd_tpen_tin);
				Cell cellTaxpayer = db.getCell("gettaxpayer", list);
				if(cellTaxpayer ==null){
					List<Cell> cellList = new LinkedList<Cell>();
					Cell taxid = db.getCell("gettaxpayer_max_id");
					if (taxid == null) {
						taxpayerId = "1";
					} else {
						taxpayerId = taxid.getValue();
					}
					cellList.add(new Cell("id", taxpayerId));
					cellList.add(new Cell("fax", taxPayerRs.getString("ATPS_FAX")));
					cellList.add(new Cell("email", taxPayerRs.getString("ATPS_EMAIL")));
					cellList.add(new Cell("phonenumber", taxPayerRs.getString("ATPS_PHONE_1")));
					cellList.add(new Cell("companyname", taxPayerRs.getString("ATPS_ENTITY_NAME")));
					cellList.add(new Cell("rectorfiRstname",
							taxPayerRs.getString("ATPS_HEAD_FIRSTNAME")));
					cellList.add(new Cell("rectorLastName", taxPayerRs.getString("ATPS_HEAD_LASTNAME")));
					cellList.add(new Cell("regnumber", dnd_tpen_tin));
					// cellList.add(new Cell ("",resultSet.getString("")));
					cellList.add(new Cell("totalindex", "0"));
					cellList.add(new Cell("avgday", "0"));
					cellList.add(new Cell("etype", taxPayerRs.getString("ATPS_ETYP_NAME")));
					
					// System.out.println(i + " ");
					db.insert("taxpayer", cellList);
				}else {
					List<Cell> cellList = new LinkedList<Cell>();
					taxpayerId = cellTaxpayer.getValue();
					cellList.add(new Cell("fax", taxPayerRs.getString("ATPS_FAX")));
					cellList.add(new Cell("email", taxPayerRs.getString("ATPS_EMAIL")));
					cellList.add(new Cell("phonenumber", taxPayerRs.getString("ATPS_PHONE_1")));
					cellList.add(new Cell("companyname", taxPayerRs.getString("ATPS_ENTITY_NAME")));
					cellList.add(new Cell("rectorfiRstname",taxPayerRs.getString("ATPS_HEAD_FIRSTNAME")));
					cellList.add(new Cell("rectorLastName", taxPayerRs.getString("ATPS_HEAD_LASTNAME")));
					cellList.add(new Cell("regnumber", taxPayerRs.getString("ATPS_TIN")));
					// cellList.add(new Cell ("",resultSet.getString("")));
					// System.out.println(i + " ");
					db.update("taxpayer",Long.parseLong(taxpayerId), cellList);
					// System.out.println(taxpayerId);
				}

				uploadOrInsertDebtPostgre(taxpayerId,dnd_tpen_tin,maxBalance);
			}
	} catch (Exception ex) {
		System.out.println("Error oracle: Can't select!\nMessage: "
				+ ex.toString());
	}
	System.out.println("**********************TaxPayer done**********************");		
}
	private void uploadOrInsertDebtPostgre(String taxpayerId ,String regnumber ,int maxBalance) throws SQLException{
		String debtID = "";
		Cell debt;
		try{
				debtRs = stmtDebt
						.executeQuery("select ndetails.*,npage.* from NORMAL.DMAN_NOTICE_DETAILS ndetails join " +
								"NORMAL.DMAN_NOTICE_PAGE npage on ndetails.DND_DNP_DLN = npage.DNP_DLN where sysdate < (DNP_CREATED_DATE +interval'1'day*100) and DND_TPEN_TIN like "+regnumber);
				while(debtRs.next()){
						List<String> listDebt = new LinkedList<String>();
						listDebt.add(debtRs.getString("DND_DBILL_DEBT_NO"));
						if (!db.execute("isdebt", listDebt)) {
							int balance = Integer.parseInt(debtRs.getString("DND_BALANCE_AMOUNT"));
							if(balance < maxBalance){
								List<Cell> cellList = new LinkedList<Cell>();
								Cell debtid = db.getCell("getdebt_max_id");
								if (debtid == null) {
									debtID = "1";
								} else {
									debtID = debtid.getValue();
								}
								cellList.add(new Cell("id", debtID));
								cellList.add(new Cell("debtNumber", debtRs.getString("DND_DBILL_DEBT_NO")));
								cellList.add(new Cell("balance", debtRs.getString("DND_BALANCE_AMOUNT")));
								cellList.add(new Cell("startDate", debtRs.getString("DNP_CREATED_DATE")));
								cellList.add(new Cell("duration", "90"));
								cellList.add(new Cell("ticketNumber", debtRs.getString("DND_DNP_DLN")));
								cellList.add(new Cell("taxpayer_id", taxpayerId));
								cellList.add(new Cell("callquantity", "0"));
								cellList.add(new Cell("type_id", debtRs.getString("DND_TMTYPE_CODE")));
								cellList.add(new Cell("officenumber", debtRs.getString("dnp_off_code")));
								cellList.add(new Cell("payDate", debtRs.getString("DND_PAY_DATE")));
								cellList.add(new Cell("create_yaer", debtRs.getString("DND_YEAR")));
								cellList.add(new Cell("bill_time", debtRs.getString("DND_BILL_TIME")));
								cellList.add(new Cell("dtype_code", debtRs.getString("DND_DTYP_CODE")));
								cellList.add(new Cell("status", "0"));
								// debttype start
								db.insert("debt", cellList);
							}
						} else {
							List<String> par = new LinkedList<String>();
							par.add(debtRs.getString("DND_DBILL_DEBT_NO"));
							debt = db.getCell("getdebt", par);
							if(debt !=null){
								debtID = debt.getValue();
								List<Cell> cellList = new LinkedList<Cell>();
								cellList.add(new Cell("payDate", debtRs.getString("DND_PAY_DATE")));
								cellList.add(new Cell("balance", debtRs.getString("DND_BALANCE_AMOUNT")));
								db.update("debt", Long.parseLong(debtID), cellList);
							}
						}
				}
		} catch (Exception ex) {
			System.out.println("Error oracle: Can't select!\nMessage: "
					+ ex.toString());
		}
//		System.out.println("**********************Debt done**********************");
	}
	private void uploadOrInsertDebtTypePostgre() throws SQLException {		
		
		try{
			
			debtTypeRs = stmtDebtType
					.executeQuery("SELECT * FROM normal.Tax_maintypes");
		
			while (debtTypeRs.next()) {
				List<String> listDebtType = new LinkedList<String>();
				listDebtType.add(debtTypeRs.getString("TMTY_CODE"));
				if (!db.execute("isdebt_type", listDebtType)) {
					List<Cell> celldebtTypeList = new LinkedList<Cell>();
					celldebtTypeList
							.add(new Cell("id", debtTypeRs.getString("TMTY_CODE")));
					celldebtTypeList.add(new Cell("typeName",debtTypeRs.getString("TMTY_NAME")));
					celldebtTypeList.add(new Cell("typeNumber",debtTypeRs.getString("TMTY_TSPUR_CODE")));
					celldebtTypeList.add(new Cell("debttypeindex","0"));
					celldebtTypeList.add(new Cell("status","0"));
					db.insert("debttype", celldebtTypeList);
				}
			}
	} catch (Exception ex) {
		System.out.println("Error oracle: Can't select!\nMessage: "
				+ ex.toString());
	}
	System.out.println("**********************DebtType done**********************");		
}
	private void uploadOrInsertAccountNumberPostgre() throws SQLException {		
		
		try{
			
			debtTypeRs = stmtDebtType
					.executeQuery("SELECT BNK_NAME, BANC_NUMBER, TMTY_CODE, TMTY_NAME, PBA_OFF_CODE  FROM NORMAL.V_PAY_BANK_ACCOUNTS");
		
			while (debtTypeRs.next()) {
				List<String> listAccountNumber = new LinkedList<String>();
				listAccountNumber.add(debtTypeRs.getString("PBA_OFF_CODE"));
				listAccountNumber.add(debtTypeRs.getString("TMTY_CODE"));
				if (!db.execute("isaccountnumber", listAccountNumber)) {
					Cell accountid = db.getCell("getaccount_max_id");
					String accountNumberId="";
					if (accountid == null) {
						accountNumberId = "1";
					} else {
						accountNumberId = accountid.getValue();
					}
					List<Cell> cellAccountNumberList = new LinkedList<Cell>();
					cellAccountNumberList.add(new Cell("id", accountNumberId));
					cellAccountNumberList.add(new Cell("number",debtTypeRs.getString("BANC_NUMBER")));
					cellAccountNumberList.add(new Cell("bankName",debtTypeRs.getString("BNK_NAME")));
					cellAccountNumberList.add(new Cell("officeNumber",debtTypeRs.getString("PBA_OFF_CODE")));
					cellAccountNumberList.add(new Cell("debtTypeNumber",debtTypeRs.getString("TMTY_CODE")));
					db.insert("accountnumber", cellAccountNumberList);
				}
			}
	} catch (Exception ex) {
		System.out.println("Error oracle: Can't select!\nMessage: "
				+ ex.toString());
	}
	System.out.println("**********************account Number done**********************");		
}

	public List<Row> execute(String query) throws SQLException {
		List<Row> rowList = null;
		// connectToDataBases();
		connection.setAutoCommit(false);
		Statement statement = connection.createStatement();
		ResultSet resultSet = null;
		try {
			System.out.println(query);
			resultSet = statement.executeQuery(query);
		} catch (Exception ex) {
			System.out.println("Error: Can't select!\nMessage: "
					+ ex.toString());
			statement.close();
			connection.close();
			return rowList;
		}
		rowList = new ArrayList<Row>();
		ResultSetMetaData resultSetMetadata = resultSet.getMetaData();
		while (resultSet.next()) {
			List<Cell> cellList = new ArrayList<Cell>();
			for (int c = 1; resultSetMetadata.getColumnCount() >= c; c++) {
				cellList.add(new Cell(resultSetMetadata.getColumnName(c),
						resultSet.getString(c)));
			}
			rowList.add(new Row(cellList));
		}
		resultSet.close();
		statement.close();
		// connection.close();
		return rowList;
	}

	// Select one row statement
	private void writeToConsole(String query) {
//		 System.out.println(query);
		log(null, query);
	}

	
}
