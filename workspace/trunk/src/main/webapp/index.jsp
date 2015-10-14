
<%
	if (request.isUserInRole("admin-role")) {
		response.sendRedirect("admin/calendar");
	} else if (request.isUserInRole("user-role")) {
		response.sendRedirect("user/calendar");
	}
%>

