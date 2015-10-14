<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<script type="text/javascript"></script>
<div class="hidden" id="page">
	<s:url action="dayBalance" includeParams="none" />
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="donationcus" />
			<small> <i class="icon-double-angle-right"></i> Жагсаалт
			</small>
		</h2>
	</div>
	<div class="row">
		<div class="col-sm-12 col-lg12">
			<s:form action="donationCustomers" cssClass="form-horizontal">
				<div class="row">
					<div class="col-sm-8 col-lg-8">
						<div class="form-group">
							<label for="date" class="col-sm-6 col-lg-6 control-label ">
								<s:text name="date" />
							</label>
							<div class="col-sm-6 col-lg-4 ">
								<s:textfield name="dateStr" cssClass="date form-control" />
							</div>
						</div>
					</div>
					<div class="col-sm-4 col-lg-4"></div>
				</div>
				<div class="row">
					<div class="col-sm-8 col-lg-8">
						<div class="form-group">
							<label for="secondDate" class="col-sm-6 col-lg-6 control-label ">
								<s:text name="secondDate" />
							</label>
							<div class="col-sm-6 col-lg-4 ">
								<s:textfield name="secondDateStr" cssClass="date form-control" />
							</div>
						</div>
					</div>
					<div class="col-sm-4 col-lg-4">
						<button class="btn btn-success col-sm-12 col-lg-4">
							<i class="icon-search"></i>
							<s:text name="search" />
						</button>
					</div>
				</div>
			</s:form>
			<div class="hr hr-24"></div>
			<display:table name="listSp"
				class="table table-striped table-bordered table-hover" id="example">
				<display:column property="patient.id" title="" />
				<display:column property="patient.lastName" title="Овог" />
				<display:column property="patient.firstName" title="Нэр" />
				<display:column property="patient.regNumber" title="Регистер №"></display:column>
				<display:column property="patient.cardNumber" title="Картын дугаар" />
				<display:column property="patient.phone" title="Утасны дугаар" />
				<display:column property="lastActionDate"
					format="{0,date,yyyy-MM-dd}" title="Сүүлд хийсэн үйлчилгээ/төлбөр" />
				<display:column property="deference" format="{0,number,#,###}"
					title="Үлдэгдэл" />
				<display:footer>
					<tr>
						<th />
						<th><s:text name="total" /></th>
						<th />
						<th />
						<th />
						<th />
						<th />
						<th id="total"></th>
					</tr>
				</display:footer>
			</display:table>
		</div>
	</div>
</div>
<script src="../js/PageJS/reportDonationCustomers.js"></script>