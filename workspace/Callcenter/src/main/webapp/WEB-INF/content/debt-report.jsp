<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="form-group">
	<div class="row col-cm-12">
		<div class="col-sm-7 col-lg-6">
			<h3 class="page-title">
				<s:text name="debtreport" />
			</h3>
		</div>
		<div>
			<s:form action="debt-report">
				<div class="row col-sm-12">
					<label for="startDate" class="control-label col-sm-1 col-lg-1">
						<s:text name="debtCreateDate" />
					</label>
					<div class="col-sm-3 col-lg-3">
						<s:textfield name="debtCreateDateRange"
							cssClass="form-control" id="startDate" />
					</div>
					<label for="endDate" class="control-label col-sm-1 col-lg-1">
						<s:text name="debtPayDate" />
					</label>
					<div class="col-sm-3 col-lg-3">
						<s:textfield name="debtPayDateRange"
							cssClass="form-control" id="endDate" />
					</div>
				</div>
				<div class="row col-sm-12">
					<label for="debtType" class="control-label col-sm-1 col-lg-1">
						<s:text name="debtType"></s:text>
					</label>
					<div class="col-sm-3 col-lg-3">
						<s:select list="debtTypes" listKey="id" listValue="typeName"
							headerKey="%" headerValue="Бүгд" name="debtTypeString"
							id="debtType" cssClass="form-control selects"></s:select>
					</div>
					<label for="taxPayer" class="control-label col-sm-1 col-lg-1">
						<s:text name="taxpayer"></s:text>
					</label>
					<div class="col-sm-3 col-lg-3">
						<s:select list="allTaxPayers" listKey="id" listValue="companyName"
							headerKey="%" headerValue="Бүгд" name="taxPayerString"
							id="taxPayer" cssClass="form-control selects"></s:select>
					</div>
					<div class="col-sm-4 col-lg-4">
						<button class="btn btn-success col-sm-12 col-lg-12">
							<s:text name="search" />
						</button>
					</div>
				</div>
			</s:form>
		</div>
	</div>
</div>
<hr>
<div class="row">
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-phone"> <s:text name="debtreport" /></i>
			</div>
			<div class="tools">
				<a href="javascript:;" class="collapse"></a>
			</div>
		</div>
		<div class="portlet-body">
			<div id="list-result">
				<display:table name="debtList" id="sampletable2"
					class="display table-bordered table-hoverdataTable">
					<display:column property="debtNumber" title="Татварын дугаар" />
					<display:column property="taxPayer.companyName" title="Т/т нэр" />
					<display:column property="officeNumber" title="Татварын албаны код" />
					<display:column property="startDate" title="Үүссэн огноо" format="{0,date,yyyy-MM-dd}"/>
					<display:column property="payDate" title="Төлсөн" format="{0,date,yyyy-MM-dd}"/>
					<display:column property="balance" title="Дүн" format = "{0,number,#,##0.00}"/>
					<display:footer>
						<tr>
							<th />
							<th />
							<th />
							<th />
							<th id="totalBalance" />
							<th/>
					</tr>
					</display:footer>
				</display:table>
			</div>
		</div>
	</div>
</div>

<script src="../js/PageJS/debt-report.js"></script>