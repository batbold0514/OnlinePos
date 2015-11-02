<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="form-group">
	<div class="row col-cm-12">
		<div class="col-sm-7 col-lg-6">
			<h3 class="page-title">
				<s:text name="commitmentReport" />
			</h3>
		</div>
		<div>
			<s:form action="commitment-report">
				<div class="row col-sm-12">
					<label for="startDate" class="control-label col-sm-1 col-lg-1">
						<s:text name="startDate" />
					</label>
					<div class="col-sm-3 col-lg-3">
						<s:textfield name="startDateString" value="%{startDateString}"
							cssClass="form-control" id="startDate" />
					</div>
					<label for="endDate" class="control-label col-sm-1 col-lg-1">
						<s:text name="endDate" />
					</label>
					<div class="col-sm-3 col-lg-3">
						<s:textfield name="endDateString" value="%{endDateString}"
							cssClass="form-control" id="endDate" />
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
				<i class="fa fa-phone"> <s:text name="process" /></i>
			</div>
			<div class="tools">
				<a href="javascript:;" class="collapse"></a>
			</div>
		</div>
		<div class="portlet-body">
			<div class="table-toolbar">
			</div>
			<div id="list-result">
				<display:table name="commitmentlist" id="sampletable2" class="display table-bordered table-hoverdataTable">
					<display:column property="description" title="Тайлбар"></display:column>
					<display:column property="value" title="Амлалт авсан мөнгөн дүн"></display:column>
					<display:column property="giveDate" title="Амлалт өгсөн өдөр"></display:column>
					<display:column property="payDate" title="Мөнгө төлөх өдөр"></display:column>
					<display:column property="debt.debtNumber" title="Татварын дугаар"></display:column>
				</display:table>
			</div>
		</div>
	</div>
</div>

<script src="../js/PageJS/commitment-report.js"></script>