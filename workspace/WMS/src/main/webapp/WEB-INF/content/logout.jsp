<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title><s:text name="logoutSuccessful" /></title>
</head>
<body>
    <s:include value="inc/title.jsp" />
    <h3><s:text name="logoutSuccessful" /></h3>
    <a href="/login/login.jsp"><s:text name="clickHereToLoginAgain" /></a>
</body>
</html>