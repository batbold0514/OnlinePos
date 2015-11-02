
<%
	if (request.isUserInRole("admin-role")) {
		response.sendRedirect("admin/adminlogin");
	} else if (request.isUserInRole("operator")) {
		response.sendRedirect("operator/userlogin");
	}
	else response.sendRedirect("senior/seniorlogin");
%>

