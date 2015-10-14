
<%
	if (request.isUserInRole("admin-role")) {
		response.sendRedirect("admin/service-reg");
	} else if (request.isUserInRole("user-role")) {
		response.sendRedirect("user/service-reg");
	}
%>

