<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<display:table name="listOfModel" id="enquireModel"
	class="display table-bordered table-hoverdataTable">
	<display:column property="id" title="ID" />
	<display:column property="enquireNumber" title="Захиалгын дугаар" />
	<display:column property="price" title="Үнэ" format="{0,number,#,##0.00}"/>
	<display:column property="bankName" title="Банкын нэр" />
	<display:column property="bankNumber" title="Банкын дугаар" />
	<display:column property="createDate" title="Огноо" format="{0,date,yyyy-MM-dd}"/>
	<display:column property="enquireType.description" title="Төлөв" />
	<display:column property="customer.enquireName" title="Үйлчлүүлэгч " />
	<display:column property="customer.phone" title="Утас" />
</display:table>