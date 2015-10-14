<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="hidden" id="page">
	<s:url action="bestCustomers" includeParams="none" />
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="bestCustomersList" />
			<small> <i class="icon-double-angle-right"></i> Жагсаалт
			</small>
		</h2>
	</div>
	<div class="row">
		<div class="col-sm-12 col-lg12">
			<s:form action="bestCustomers" cssClass="form-horizontal">
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<label for="date" class="col-sm-4 col-lg-4 control-label ">
								<s:text name="date" />:
							</label>
							<div class="col-sm-6 col-lg-6 ">
								<s:textfield name="dateStr" cssClass="date form-control" />
							</div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
							<label for="limit" class="col-sm-4 col-lg-4 control-label ">
								<s:text name="limit" />:
							</label>
							<div class="col-sm-6 col-lg-6 ">
								<s:textfield name="limit" cssClass="form-control" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<label for="secondDate" class="col-sm-4 col-lg-4 control-label ">
								<s:text name="secondDate" />:
							</label>
							<div class="col-sm-6 col-lg-6 ">
								<s:textfield name="secondDateStr" cssClass="date form-control" />
							</div>
						</div>
					</div>
					<div class="col-sm-offset-2 col-lg-offset-2 col-sm-4 col-lg-4">
						<button class="btn btn-success col-sm-9 col-lg-9">
							<i class="icon-search"></i>
							<s:text name="search" />
						</button>
					</div>
				</div>
			</s:form>
			<div class="hr hr-24"></div>
			<display:table name="listBestCustomers"
				class="table table-striped table-bordered table-hover" id="example"
				defaultsort="3">
				<display:column property="number" title="Д/д" />
				<display:column property="patient.id" title="" />
				<display:column property="value" title="Орлого" format="{0,number,#,###}"/>
				<display:column property="patient.lastName" title="Овог" />
				<display:column property="patient.firstName" title="Нэр" />
				<display:column property="patient.regNumber" title="Регистер №"></display:column>
				<display:column property="patient.cardNumber" title="Картын дугаар" />
				<display:column property="patient.phone" title="Утасны дугаар" />
				<display:footer>
					<tr>
						<th><s:text name="total" /></th>
						<th />
						<th id="total"></th>
						<th />
						<th />
						<th />
						<th />
						<th />
					</tr>
				</display:footer>
			</display:table>
		</div>
	</div>
</div>
<script src="../js/PageJS/bestCustomers.js"></script>