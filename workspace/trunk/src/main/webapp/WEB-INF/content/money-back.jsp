<%@page import="mn.chinbat.surgery.enums.Customer"%>
<%@page import="mn.chinbat.surgery.model.Messages"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<div class="pageContent">
	<div class="pageHeader">
		<h3>
			<s:text name="money_back" />
		</h3>
	</div>
	<s:form action="doMoney_back">
		<s:hidden key="id" />
		<s:hidden key="user" value="%{user}" />
		<div class="row-fluid">
			<%
				if (Messages.getCustomer("customer").trim()
							.equals(Customer.degfim.toString().trim())) {
			%>
			<div class="row-fluid">
				<div class="col-sm-12">
					<div class="col-sm-2 col-lg3"></div>
					<label for="doctorID" class="control-label col-sm-2 col-lg-1">
						<s:text name="doctorID" />
					</label>
					<div class="col-sm-8 col-lg-8">
						<s:select key="doctorID" list="doctorList" listKey="id"
							id="doctorID" listValue="name + ' ' + familyName " headerKey=""
							headerValue="" />
					</div>
				</div>
			</div>
			<%
				}
			%>
			<div class="row-fluid">
				<div class="col-sm-12">
					<div class="col-sm-2 col-lg3"></div>
					<label for="value" class="control-label col-sm-2 col-lg-1">
						<s:text name="value" />
					</label>
					<div class="col-sm-8 col-lg-8">
						<s:textfield key="value" id="value" />
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="col-sm-12">
					<div class="col-sm-2 col-lg3"></div>
					<label for="description" class="control-label col-sm-2 col-lg-1">
						<s:text name="description" />
					</label>
					<div class="col-sm-8 col-lg-8">
						<s:textarea key="description" id="description" />
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="col-sm-12">
					<div class="col-sm-3 col-lg-3"></div>
					<div class="col-sm-4-col-lg-3">
						<button class="btn btn-success">
							<s:text name="save" />
						</button>
					</div>
				</div>
			</div>
		</div>
	</s:form>
	<div class="center">
		<button class="btn btn-warning" onclick="window.history.back()">
			<s:text name="back" />
		</button>
	</div>
</div>
<sx:head />
<%-- <s:form action="doMoney_back">
	<s:hidden key="id" />
	<s:hidden key="user" value="%{user}" />
	<% if(Messages.getCustomer("customer").trim().equals(Customer.degfim.toString().trim())){ %>
	<s:select key="doctorID" list="doctorList" listKey="id"
		listValue="name + ' ' + familyName " headerKey="" headerValue="" />
	<% } %>
	<s:textfield key="value" />
	<s:textarea key="description" />
	<sj:submit id="save" value="%{getText('save')}" button="true"
		cssStyle="font-size:15px; float:right"></sj:submit>
</s:form>
<table class="ui-button ui-widget ui-state-default ui-corner-all">
	<tr>
		<td><a onclick="window.history.back()"
			style="text-decoration: none;"
			class="btn btn-back col-xs-12  col-sm-12 col-md-offset-2 col-md-10 col-lg-offset-4 col-lg-8">
				<span class="fa fa-arrow-circle-o-left"></span>&nbsp; <s:text
					name="back" />
		</a></td>
	</tr>
</table> --%>