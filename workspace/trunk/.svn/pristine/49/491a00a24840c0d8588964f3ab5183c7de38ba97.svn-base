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
			<s:text name="dayb" />
			<small> <i class="icon-double-angle-right"></i> Жагсаалт
			</small>
		</h2>
	</div>
	<div class="row">
		<div class="col-sm-12 col-lg-12">
			<s:form action="dayBalance" cssClass="form-horizontal">
				<div class="row">
					<div class="col-sm-6 col-lg-6">
						<label for="date" class="col-sm-3 col-lg-3 control-label ">
							<s:text name="date" />
						</label>
						<div class="col-sm-3 col-lg-3 ">
							<s:textfield name="dateStr" cssClass="date form-control" />
						</div>
					</div>
					<div class="col-sm-6 col-lg-6">
						<label for="secondDate" class="col-sm-3 col-lg-3 control-label ">
							<s:text name="secondDate" />
						</label>
						<div class="col-sm-3 col-lg-3 ">
							<s:textfield name="secondDateStr" cssClass="date form-control" />
						</div>
					</div>
				</div>
				<div class="col-sm-12 col-lg12">
					<div class="col-sm-6">
						<label for="doctor" class="control-label col-sm-3 col-lg-2">
							<s:text name="doctor" />
						</label>
						<div class="col-sm-3 col-lg-2 ">
							<s:select key="doctorID" list="doctors" listKey="id"
								listValue="name + ' ' + familyName" headerKey="-1"
								headerValue="" cssClass="form-control" />
						</div>
					</div>
					<div class="col-sm-6">
						<label for="paymentMethod" class="control-label col-sm-3 col-lg-2">
							<s:text name="paymentMethod" />
						</label>
						<div class="col-sm-3 col-lg-2 ">
							<s:select key="paymentMethod" list="methodList" listValue="label"
								listKey="id" value="%{#session.paymentMethod.id}"
								cssClass="from-control" />
						</div>
					</div>
				</div>
				<div class="col-sm-12 col-lg12">
					<div class="col-sm-6">
						<label for="userOfBalance" class="col-sm-3 col-lg-2"> <s:text
								name="userOfBalance" />
						</label>
						<div class="col-sm-3 col-lg-2 ">
							<s:select list="usersList" key="userOfBalance"
								cssClass="form-control" />
						</div>
					</div>
					<div class="col-sm-3 col-lg-2">
						<button class="btn btn-success col-sm-5 col-lg-5">
							<s:text name="search" />
						</button>
					</div>
				</div>
			</s:form>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<display:table name="list"
				class="table table-striped table-bordered table-hover" id="example">
				<display:caption>
					<c:out value="${date}" />
				</display:caption>
				<display:column property="id" title="№" sortable="true" />
				<display:column property="patient.id" title="" />
				<display:column property="user" title="Хэрэглэгч" sortable="true" />
				<display:column property="doctor.name" title="Эмч" sortable="true" />
				<display:column property="patient.cardNumber" title="Картын дугаар" />
				<display:column property="patient.lastName" title="Овог" />
				<display:column property="patient.firstName" title="Нэр" />
				<display:column property="patient.regNumber" title="Регистер №"></display:column>
				<display:column property="paymentMethod.label"
					title="Гүйлгээний төрөл" />
				<display:column property="value" format="{0,number,#,###}"
					title="Төлбөрийн дүн" />
				<display:column property="date" title="Огноо"
					format="{0,date,yyyy-MM-dd}" />
				<display:column property="paymentNumber" title="Гүйлгээний дугаар" />
				<display:footer>
					<tr>
						<th><s:text name="total" /></th>
					<th />
					<th />
					<th />
					<th />
					<th />
					<th />
					<th />
					<th />
					<th id="total"></th>
					<th />
					<th />
					</tr>
				</display:footer>
			</display:table>
		</div>
	</div>
</div>
<div id="context" class="hide">${pageContext.request.contextPath}
</div>
<script src="../js/PageJS/reportDayBalance.js"></script>