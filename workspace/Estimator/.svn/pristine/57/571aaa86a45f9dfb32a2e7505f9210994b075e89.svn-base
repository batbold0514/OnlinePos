package mn.infosystems.estimator.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import mn.infosystems.estimator.model.EmpReportModel;

public class PostgreConectionService {
	Connection con = null;
	Statement stmt = null;
	
	public PostgreConectionService(){
		connect();
	}
	
	private boolean connect(){
		try {
			Class.forName("org.postgresql.Driver");
			
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/estimator","postgres","123asd90@");
			
			stmt = con.createStatement();
			
		} catch (ClassNotFoundException e) {
			return false;
		} catch (SQLException e) {
			return true;
		}
		return true;
	}
	
	public void close(){
		try {
			stmt.close();
		} catch (SQLException e) {}
		try {
			con.close();
		} catch (SQLException e) {}
	}
	
	public List<EmpReportModel> getEmployeeReport(String firstDate,String secondDate,String emp,EmployeeService employeeService){
		firstDate = (firstDate==null || firstDate.trim().equals(""))?"1000-01-01":firstDate+" 00:00:00.001";
		secondDate = (secondDate==null || secondDate.trim().equals(""))?"3000-01-01":secondDate+" 23:59:59.999";
		emp = (emp==null || emp.trim().equals(""))?"%":emp;
		List<EmpReportModel> list = new LinkedList<EmpReportModel>();
		JOptionPane.showMessageDialog(null, "1");
		try {
			String query = "select tb1.*,tb2.c1,tb2.c2 (select mainemp_id,date,count(*),sum(repairprice + changeprice) from customer "
					+ "where date > '"+firstDate+"' and date < '"+secondDate+"' and cast(mainemp_id as character) like '"+emp+"'"
					+ " group by mainemp_id,date) tb1 join "
					+ "(select mainemp_id,date,count(*) as c1,sum(repairprice + changeprice) as c2 from customer "
					+ "where date > '"+firstDate+"' and date < '"+secondDate+"' and cast(mainemp_id as character) like '"+emp+"'"
					+ " group by mainemp_id,date) tb2 on tb1.date = tb2.date and tb1.mainemp_id = tb2.mainemp_id " ;
			ResultSet rs = stmt.executeQuery(query);
			int num = 0;
			JOptionPane.showMessageDialog(null, "2");
			while(rs.next()){
				EmpReportModel erm = new EmpReportModel(++num,rs.getString(0),rs.getInt(2),rs.getLong(3),rs.getInt(4),rs.getLong(5));
				list.add(erm);
			}
			rs.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		return list;
	}
	
}
