<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<s:form action="excel" method="POST" enctype="multipart/form-data">
		<div>
			<s:file key="fileUpload" id="fileUpload"/>
		</div>
		<div>
			<s:submit name="submit"></s:submit>
		</div>
	</s:form>
</div>
