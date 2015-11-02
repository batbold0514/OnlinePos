
<%
	if (request.isUserInRole("admin-role")) {
		response.sendRedirect("admin/usersList");
	} else if (request.isUserInRole("user-role")) {
		response.sendRedirect("user/userlogin");
	}
%>

