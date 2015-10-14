<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<label for="user" class="control-label col-sm-5 col-lg-5"> <s:text
		name="user" /><span class="required"> * </span>
</label>
<div class="col-sm-7 col-lg-6">
	<s:select list="usersList" listKey="id" listValue="userName"
		headerKey="" headerValue="" cssClass="form-control" name="userStr"
		autoficus="" id="user"></s:select>
</div>