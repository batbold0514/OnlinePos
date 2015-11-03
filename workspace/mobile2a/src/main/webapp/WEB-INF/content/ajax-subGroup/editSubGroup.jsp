<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<s:form action="" id = "addSubGroupFrom">
	<s:hidden name="id" value = "%{#request.subGroup.id}"/>
	<s:hidden name = "categoryId" list="categories" listKey="id" listValue="description" value = "%{#request.subGroup.category.id}"/>
	<div class="form-group">
		<div class="row">
			<label for="groupName" class="control-label col-sm-5 col-lg-5">
				<s:text name="groupName" /><span class="required"> * </span>
			</label>
			<div class="col-sm-7 col-lg-6">
				<s:textfield name="subGroupName" cssClass="form-control"
					autofocus="" />
			</div>
		</div>
	</div>
</s:form>

<script src="../js/PageJS/editSubGroup.js"></script> 