<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<head>
<title><s:text name="addAppointment" /></title>
</head>
<s:head />
<sx:head />
<sj:head jqueryui="true" jquerytheme="le-frog" />
	<h3>
		<s:text name="addAppointment" />
	</h3>
	<s:set var="time" value="11:11" />
	<s:form action="saveAppointment">
		<s:hidden name="id" />
		<sx:datetimepicker key="begin" type="date" displayFormat="MM/dd/yyyy" />
		<s:textfield key="time" />
		<s:textfield key="duration" />
		<s:textfield key="resourceId" />
		<sj:submit value="save" button="true"/>
	</s:form>


