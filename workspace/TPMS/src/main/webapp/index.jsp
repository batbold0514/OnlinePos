
<%
	if (request.isUserInRole("admin-role")) {
		response.sendRedirect("admin/usersList");
	} else if (request.isUserInRole("designer-role")) {
		response.sendRedirect("designer/trackingSheetList");
	} else if (request.isUserInRole("master-role")) {
		response.sendRedirect("master/trackingSheetList");
	} else if (request.isUserInRole("employee-role")) {
		response.sendRedirect("employee/allEmployeeSalary");
	} else if (request.isUserInRole("user-role")) {
		response.sendRedirect("user/trackingSheetList");
	}
%>

