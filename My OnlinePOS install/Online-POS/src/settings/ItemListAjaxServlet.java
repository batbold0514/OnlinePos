package settings;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;
import utils.Cell;
import utils.LoggedUser;
import utils.PostgreSQLJDBC;
import utils.Row;

@WebServlet("/item-list-ajax")
public class ItemListAjaxServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    public ItemListAjaxServlet()
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
		
		User user = (User) session.getAttribute("user");
		Date startDate = null;
		String startDateStr = (String) request.getParameter("startDate");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			if (startDateStr != null && !startDateStr.equals(""))
				startDate = formatter.parse(startDateStr);
			
		}
		catch (ParseException e)
		{
			System.out.println("Error: Can't parse startDate!\nMessage: " + e.toString());
		}
		
		Date endDate = null;
		String endDateStr = (String) request.getParameter("endDate");
		try
		{
			if (endDateStr != null && !endDateStr.equals(""))
				endDate = formatter.parse(endDateStr);
			
		}
		catch (ParseException e)
		{
			System.out.println("Error: Can't parse startDate!\nMessage: " + e.toString());
		}
		
		//String type = (String) request.getParameter("type");
		List<Row> rowList = null;
		
		PostgreSQLJDBC db = new PostgreSQLJDBC();
		if (db.createConnection())
		{
//				String[] params = { Integer.toString(user.getId()), startDateStr + " 00:00:00", endDateStr + " 23:59:59" };
			try
			{
				rowList = db.getRowList("bb_getitemlist");
			}
			catch (SQLException e)
			{
				System.out.println("Error: Can't execute bh_searchSales()!\nMessage: " + e.toString());
			}
		}
		
		
		if (rowList != null && rowList.size() > 0)
		{
			String tableBody = "{ \"aaData\": [";
			int count = 1;
			for (Row row : rowList)
	    	{
				if (row.getCellList() != null && row.getCellList().size() > 0)
	    		{
					tableBody = tableBody + "{";
					tableBody = tableBody + "\"num\":\""+count+"\",";
		    		for (Cell cell : row.getCellList())
		    		{
		    			
		    			switch (cell.getColumn())
		    			{
		    				case "id":
		    					tableBody = tableBody + "\"id\":\"" + cell.getValue() + "\",";
		    					break;
		    				case "name":
		    					tableBody = tableBody + "\"name\":\"" + cell.getValue() + "\",";
		    					break;
		    				case "description":
	    						tableBody = tableBody +"\"description\":\"" + cell.getValue() + "\",";
		    					break;
		    				case "item_unit_id":
		    					tableBody = tableBody + "\"item_unit_id\":\"" + cell.getValue() + "\",";
		    					break;
		    				case "item_unit_name":
		    					tableBody = tableBody + "\"item_unit_name\":\"" + cell.getValue() + "\",";
		    					break;
		    				case "asset_acc":
		    					tableBody = tableBody + "\"asset_acc\":\"" + cell.getValue() + "\",";
		    					break;
		    				case "quantity":
		    					tableBody = tableBody + "\"quantity\":\"" + cell.getValue() + "\",";
		    					break;
		    				case "price":
		    					tableBody = tableBody + "\"price\":\"" + cell.getValue() + "\",";
		    					break;
		    				
		    				default:
		    					System.out.println("More unknown columns from bh_searchSales()!");
		    					System.out.println(cell.getColumn());
		    					break;
		    			}
		    		}
		    		tableBody = tableBody.substring(0, tableBody.length()-1);
		    	count++;
		    		tableBody = tableBody + "},";
	    		}
	    	}
			tableBody = tableBody.substring(0, tableBody.length()-1);
			tableBody=tableBody+"]}";
			System.out.println(tableBody);
			PrintWriter out = response.getWriter();
			out.print(tableBody);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}