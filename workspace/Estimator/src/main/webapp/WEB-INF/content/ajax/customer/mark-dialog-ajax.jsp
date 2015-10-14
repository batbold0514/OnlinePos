<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:select list="carmarkList" name="markStr" listKey="id" listValue="mark"
	headerKey="" headerValue="" cssClass="form-control dselect"></s:select>