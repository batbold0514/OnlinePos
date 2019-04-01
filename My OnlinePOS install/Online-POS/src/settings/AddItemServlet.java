package settings;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.Cell;
import utils.LoggedUser;
import utils.PostgreSQLJDBC;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@WebServlet("/add-item-setup")
public class AddItemServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
    public AddItemServlet()
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		int status = LoggedUser.checkLogin(session);
		if (status != 1)
		{
			response.sendRedirect("login.jsp");
		}
		
		String name = request.getParameter("itemName");
	    String description = request.getParameter("description");
	    String price = request.getParameter("price");
	    String quantity = request.getParameter("quantity");
	    String assetAcc =request.getParameter("assetAcc");
	    String unitId = request.getParameter("unitId");
	    Gson json = new Gson();
//	    Type listType = new TypeToken<List<String>>() {}.getType();
	    Type type = new TypeToken<List<String>>() {}.getType();
	    List<String> assetAccs= json.fromJson(assetAcc, type);
	    PostgreSQLJDBC db = new PostgreSQLJDBC();
	    if (description == null)
		{
	    	description = "";
		}
	    String errorCode = "200";
		if (db.createConnection())
		{
			String[] parameters = { name.trim() };
			try
			{
				
				if (!db.execute("bb_isitem", parameters))
				{
					String[] itemp = { name.trim(),description.trim(),unitId };
					
					Cell itemId = db.getCell("bb_additem", itemp);
					for(String as :assetAccs){
					String[] isAsset = { as.trim(),unitId };
						if (!db.execute("bb_isasset_prices", isAsset))
						{
							String[] assetp = {as.trim(),itemId.getValue(), price,quantity };
							db.getCell("bb_add_asset_price", assetp);
						}else{
							errorCode = "201";
						}
					}
				}else{
					errorCode = "404";
				}
			}
			catch (SQLException e)
			{
				errorCode = e.toString();
				System.out.println("Error: Can't execute bh_checkBarcode() function!\nMessage: " + e.toString());
			}finally{
				response.setContentType("text/html");
			    PrintWriter out = response.getWriter();
				out.print(errorCode);
			}
		}
	    
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}
