package mn.infosystems.callcenter.action;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import mn.infosystems.callcenter.model.OracleSQLJDBC;


/**
 * @author Suld
 * @see Баазаас татах
 */
@WebServlet("/oracleConServlet")
public class OracleCon extends HttpServlet {
	
private static final long serialVersionUID = 1L;
    
	public OracleCon() throws InterruptedException
	{
       super(); 
    }
	public void init(ServletConfig config) throws ServletException {
//		new OracleSQLJDBC().execute();
	}
}

