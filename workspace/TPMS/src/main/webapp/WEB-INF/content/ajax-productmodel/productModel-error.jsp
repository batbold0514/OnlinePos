<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	if (request.getAttribute("successUser") == null) {
%>
<s:fielderror fieldName="subMaterial" id="errorsubMaterial"/>
<s:fielderror fieldName="subCategory" id="errorsubCategory"/>
<s:fielderror fieldName="subGauge" id="errorsubGauge"/>
<s:fielderror fieldName="subProductTypeString" id="errorsubProductTypeString"/>
<s:fielderror fieldName="subNumber" id="errorsubNumber"/>
<s:fielderror fieldName="yarnNumber" id="erroryarnNumber"/>
<s:fielderror fieldName="status" id="errorstatus"/>
<s:fielderror fieldName="stoll" id="errorstoll"/>
<s:fielderror fieldName="chordPrice" id="errorchordPrice"/>
<s:fielderror fieldName="unitChordPrice" id="errorunitChordPrice"/>
<s:fielderror fieldName="aidPrice" id="erroraidPrice"/>
<s:fielderror fieldName="percent" id="errorpercent"/>
<s:fielderror fieldName="sellPrice" id="errorsellPrice"/>
<s:fielderror fieldName="listOfStep.id" id="errorlistOfStep.id"/>
<s:fielderror fieldName="listColor" id="errorlistColor"/>
<%
	}
%>
	