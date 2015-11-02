<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-align-justify"> <s:text name="manageOperator" /></i>
			</div>
			<div class="tools">
				<a href="javascript:;" class="collapse"></a>
			</div>
		</div>
		<div class="portlet-body">
			<div class="list-result">
				<s:form action="save-mng-ops">
					<table class="display table-hoverdataTable table-bordered"
						id="sampletable2">
						<tr>
							<th>Оператор</th>
							<th>Төлөв</th>
						</tr>
						<s:iterator value="#session.managelist" status="stat" var="iter">
							<tr>
								<th><s:property value="#iter.code" /></th>
								<th><s:select list="operatorStatuses" listKey="id" value="#iter.status.id"
										listValue="description" name="listStatus[%{#stat.index}]" /></th>
							</tr>
						</s:iterator>
					</table>
					<div class="row">
						<div class=" col-sm-12">
							<button class="btn btn-success col-sm-12"
								style="border: 1px solid #07c" id="btn">
								<i class="icon-th-list"></i> <span> <s:text
										name="manageOperator" /></span>
							</button>
						</div>
					</div>
				</s:form>
			</div>
		</div>
	</div>
</div>
<script src="../js/PageJS/manage-operator.js"></script>


