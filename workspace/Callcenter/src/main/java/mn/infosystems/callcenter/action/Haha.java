package mn.infosystems.callcenter.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import java.util.Properties;
import java.util.Scanner;

import javax.swing.JOptionPane;

import mn.infosystems.callcenter.model.Cell;
import mn.infosystems.callcenter.model.ConnectionMessages;
import mn.infosystems.callcenter.model.MessagesClient;
import mn.infosystems.callcenter.model.OracleSQLJDBC;
import mn.infosystems.callcenter.model.PostgreSQLJDBC;
import mn.infosystems.callcenter.model.PostgreSQLJDBCBat;
import mn.infosystems.callcenter.model.Row;

public class Haha {
	private Connection connection = null;
	private PostgreSQLJDBCBat db = new PostgreSQLJDBCBat();
	public static void main(String[] args) throws SQLException {
		String workingDir = System.getProperty("user.dir");
		   System.out.println("Current working directory : " + workingDir);
	}
	public void connectToDataBases() throws SQLException {
		
	}
	private void uploadOrInsertAccountNumberPostgre() throws SQLException {		
		Statement stmtDebtType = null;
		try{
//			stmtDebtType = connection.createStatement();
			ResultSet debtTypeRs = db.select("select * from maxprice");
			if(debtTypeRs !=null){
				System.out.println("dsf");
				debtTypeRs.next();
				int maxBalance = Integer.parseInt(debtTypeRs.getString(2));
				JOptionPane.showMessageDialog(null, maxBalance);
			}
//			debtTypeRs = stmtDebtType
//					.executeQuery("SELECT BNK_NAME, BANC_NUMBER, TMTY_CODE, TMTY_NAME, PBA_OFF_CODE FROM NORMAL.V_PAY_BANK_ACCOUNTS");
//		 
			/*while (debtTypeRs.next()) {
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
			}*/
			debtTypeRs.close();
	} catch (Exception ex) {
		System.out.println("Error oracle1111: Can't select!\nMessage: "
				+ ex.toString());
	}finally{
//		debtTypeRs.close();
//		stmtDebtType.close();
	}
	System.out.println("**********************account Number done**********************");		
}
	private void uploadOrInsertTaxPayerPostgre() throws SQLException {		
		Statement stmtTaxpayer = null;
		ResultSet taxPayerRs = null;
		try{
			stmtTaxpayer = connection.createStatement();
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
					cellList.add(new Cell("status", "0"));
					cellList.add(new Cell("avgday", "0"));
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
				uploadOrInsertDebtPostgre(taxpayerId,dnd_tpen_tin);

			}
	} catch (Exception ex) {
		System.out.println("Error oracle: Can't select!\nMessage: "
				+ ex.toString());
	}finally{
		taxPayerRs.close();
		stmtTaxpayer.close();
	}
	System.out.println(new Date() +"**********************TaxPayer done**********************");		
}
private void uploadOrInsertDebtPostgre(String taxpayerId ,String regnumber) throws SQLException{
	String debtID = "";
	Statement stmtDebt = null;
	ResultSet debtRs = null;
	try{
		stmtDebt = connection.createStatement();
		
			debtRs = stmtDebt
					.executeQuery("select ndetails.*,npage.* from NORMAL.DMAN_NOTICE_DETAILS ndetails join " +
							"NORMAL.DMAN_NOTICE_PAGE npage on ndetails.DND_DNP_DLN = npage.DNP_DLN ");
			
				while(debtRs.next()){
					
						List<String> listDebt = new LinkedList<String>();
						listDebt.add(debtRs.getString("DND_DBILL_DEBT_NO"));
						System.out.println(debtRs.getString("DNP_CREATED_DATE") + " " + debtRs.getString("DNP_WDAY"));
						/*if (!db.execute("isdebt", listDebt)) {
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
							cellList.add(new Cell("duration", debtRs.getString("DNP_WDAY")));
							cellList.add(new Cell("ticketNumber", debtRs.getString("DND_DNP_DLN")));
							cellList.add(new Cell("taxpayer_id", taxpayerId));
							cellList.add(new Cell("callquantity", "0"));
							cellList.add(new Cell("type_id", debtRs.getString("DND_TMTYPE_CODE")));
							cellList.add(new Cell("officenumber", debtRs.getString("dnp_off_code")));
							// debttype start
//							db.insert("debt", cellList);
						} else {
							List<String> par = new LinkedList<String>();
							par.add(debtRs.getString("DND_DBILL_DEBT_NO"));
							debtID = db.getCell("getdebt", par).getValue();
							List<Cell> cellList = new LinkedList<Cell>();
							cellList.add(new Cell("payDate", debtRs.getString("DND_PAY_DATE")));
							cellList.add(new Cell("balance", debtRs.getString("DND_BALANCE_AMOUNT")));
//							db.update("debt", Long.parseLong(debtID), cellList);
						}
					*/
				}
			
	} catch (Exception ex) {
		System.out.println("Error oracle: Can't select!\nMessage: "
				+ ex.toString());
	}finally{
		debtRs.close();
		stmtDebt.close();
	}
//	System.out.println("**********************Debt done**********************");
}
	private void uploadOrInsertDebtTypePostgre() throws SQLException {		
		Statement stmtDebtType = null;
		ResultSet debtTypeRs = null;
		try{
			stmtDebtType = connection.createStatement();
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
					celldebtTypeList.add(new Cell("debttypeindex",
							"0"));
					db.insert("debttype", celldebtTypeList);
				}
			}
	} catch (Exception ex) {
		System.out.println("Error oracle: Can't select!\nMessage: "
				+ ex.toString());
	}finally{
		debtTypeRs.close();
		stmtDebtType.close();
	}
	System.out.println("**********************DebtType done**********************");		
}
}
