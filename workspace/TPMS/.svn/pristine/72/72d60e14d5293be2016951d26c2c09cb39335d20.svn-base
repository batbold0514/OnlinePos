<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="hidden" id="page">
	<s:url action="totalYarnReport" includeParams="none" />
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="totalYarnReport" />
			<small> <i class="icon-double-angle-right"></i>
			</small>
		</h2>
	</div>
	<div class="row">
		<div class="col-sm-12 col-lg-12">
			<s:form cssClass="form-horizontal" action="totalYarnReportSearch">
				<div class="row">
					<label for="startDate" class="control-label col-sm-2 col-lg-2">
						<s:text name="startDate" />:
					</label>
					<div class="col-sm-2 col-lg-2">
						<s:textfield name="firstDateStr" cssClass="form-control"
							id="startDate" />
					</div>
					<label for="colour" class="control-label col-sm-2 col-lg-2">
						<s:text name="colour" />:
					</label>
					<div class="col-sm-2 sol-lg-2">
						<s:select list="Colours" listKey="id" listValue="code"
							name="colourId" headerKey="-1" headerValue=""
							cssClass="form-control" />
					</div>
				</div>
				<div class="row">
					<label for="endDate" class="control-label col-sm-2 col-lg-2">
						<s:text name="endDate" />:
					</label>
					<div class="col-sm-2 col-lg-2">
						<s:textfield name="secondDateStr" cssClass="form-control"
							id="endDate" />
					</div>
					<button class="btn btn-success col-sm-2 col-lg-2">
						<i class="icon-search"></i>
						<s:text name="search" />
					</button>
				</div>
			</s:form>

			<display:table id="example"
				class="table table-striped table-bordered table-hover"
				name="listColourPersentSum">
				<display:column property="colour.code" title="Өнгөний код" />
				<display:column property="colour.name" title="Өнгөний тайлбар" />
				<display:column property="sum" title="Нийт зарцуулагдсан" />
			</display:table>

		</div>
	</div>
</div>
<script src="../js/PageJS/totalYarnReport.js"></script>