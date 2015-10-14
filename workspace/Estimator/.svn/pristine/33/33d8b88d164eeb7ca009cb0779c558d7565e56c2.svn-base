<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script>
//	var h = $(window).height() / 100 * 15;
//	var h1 = parseInt(h);
	function location1() {
		window.location = 'usersList'';
	}
</script>
<table style="width: 100%; height: 100%">
	<tr>
		<!-- td><img src="../img/Logo25.jpg" onclick="location1()"
			alt="Цагийн бүртгэл"></td> -->
		<td width=200  style="text-align: center">
			<div style="color:#FFFFFF; font-size: 30;font-family: Arial black">
				<h1><b>
					<s:text name="serviceProvider" /></b>
				</h1>
			</div>
		</td>
		<td style="text-align: center">
			<!--img alt="UB-Panorama" src="/img/UB_200.jpg"-->
			</td>
	</tr>
</table>
<%
	if (request
			.getSession()
			.getAttribute(
					"org.eclipse.jetty.security.sessionKnownOnlytoAuthenticated") != null) {
%>
<%-- <a href="<s:url action="logout" namespace="/" />">[ <s:text
		name="logout" /> ]
</a> --%>
<%
	}
%>
