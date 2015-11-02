package mn.infosystems.callcenter.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class OracleConExample {

	public static void main(String[] args) {
		PostgreSQLJDBCBat db = new PostgreSQLJDBCBat();
		db.createConnection();
		db.openConnection();
		Connection con = null;
		Statement stmtTaxpayer = null;
		ResultSet taxPayerRs = null;


		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = ConnectionMessages.getString("url");
			String username = ConnectionMessages.getString("username");
			String password = ConnectionMessages.getString("password");
			con = DriverManager.getConnection(url, username, password);

			stmtTaxpayer = con.createStatement();
			taxPayerRs = stmtTaxpayer
					.executeQuery("SELECT ndetails.*,npage.* from NORMAL.DMAN_NOTICE_DETAILS ndetails join " +
								"NORMAL.DMAN_NOTICE_PAGE npage on ndetails.DND_DNP_DLN = npage.DNP_DLN where sysdate < (DNP_CREATED_DATE +interval'1'day*DNP_WDAY)");
			String taxpayerId = "";
			Long count = 0l;
			
			while(taxPayerRs.next()){
				System.out.println(++count + "  |  " +  taxPayerRs.getString("DND_C1_DATE") + "  |  " +taxPayerRs.getString("DNP_CREATED_DATE"));
			}
			
			
			/*while (taxPayerRs.next()) {
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
					cellList.add(new Cell("rectorfitaxPayerRstname",
							taxPayerRs.getString("ATPS_HEAD_FItaxPayerRsTNAME")));
					cellList.add(new Cell("rectorLastName", taxPayerRs.getString("ATPS_HEAD_LASTNAME")));
					cellList.add(new Cell("regnumber", taxPayerRs.getString("ATPS_TIN")));
					// cellList.add(new Cell ("",resultSet.getString("")));
					cellList.add(new Cell("totalindex", "0"));
					cellList.add(new Cell("status", "0"));
					cellList.add(new Cell("avgday", "0"));
					// System.out.println(i + " ");
					db.insert("taxpayer", cellList);
				}else {
					taxpayerId = cellTaxpayer.getValue();
					// System.out.println(taxpayerId);
				}
				// taxPayerRs1 = stmtTaxpayer
				// .executeQuery("select * from normal.DMAN_NOTICE_DETAILS where DND_TMTYPE_CODE like '01020101'");

				// while (taxPayerRs1.next()) {
				// System.out.println(++number + "  |  " +taxPayerRs1.getString(1));
				// }

			}*/

			/*
			 * TaxPayer
			 * 
			 * SELECT * FROM normal.all_taxpayetaxPayerRs WHERE (atps_soff_off_code,
			 * atps_tin) IN (SELECT DNP_OFF_CODE, DNP_TPEN_TIN FROM
			 * NORMAL.dman_notice_details A, NORMAL.dman_notice_page b where
			 * a.dnd_dnp_dln = b.dnp_dln);
			 */

			/*
			 * DebtType Normal.tax_maintypes
			 */

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				taxPayerRs.close();
				stmtTaxpayer.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
