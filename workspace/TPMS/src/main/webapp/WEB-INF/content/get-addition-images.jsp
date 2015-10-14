<%@page import="javax.swing.JOptionPane"%>
<%@ page import="mn.threesor.tims.model.Image" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.List" %>
<%
	String id = request.getParameter("id");
	String str = "";
	@SuppressWarnings("unchecked")
	List<Image> imList = (List<Image>) request.getAttribute("imList");
	if(imList == null)
	{
	}
	else
	{
		for(int i = 0; imList.size() > i; i++)
		{
			str = str +
				"<a href='../uploads/" + imList.get(i).getName() + "' class='highslide' onclick='return hs.expand(this, { slideshowGroup: " + id +"})'>" +
					"<img src='../uploads/" + imList.get(i).getName() + "' alt='" + imList.get(i).getName() + "' title='Click to enlarge' height='50' width='40' />" +
				"</a>";
		}
	}
	out.println(str);
%>