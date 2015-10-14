<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"></script>
<div class="hidden" id="page">
	<s:url action="monthBalance" includeParams="none" />
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="monthb" />
			<small> <i class="icon-double-angle-right"></i> Жагсаалт
			</small>
		</h2>
		<div class="col-sm-6 col-lg-5">
			<s:form action="servicePriceSearch">
				<table>
					<tr>
						<td><s:select id="ls" name="listServicePrice"
								cssClass="form-control tag-input-style chosen-select"
								list="listMonthMap" listKey="sp.code" listValue="sp.code"
								multiple="true" data-placeholder="Үйлчилгээ сонгоно уу" /></td>
						<td>
							<button class="btn btn-success">
								<s:text name="search"></s:text>
							</button>
						</td>
					</tr>
				</table>
			</s:form>
		</div>
	</div>
	<s:set var="host">${pageContext.request.serverName}</s:set>
	<br> <br> Төлөгдсөн үйлчилгээнүүд: <br> <input
		value="${host}" style="display: none" id="host">
	<div class="row-fluid">
		<div class="col-xs-12">
			<display:table name="listMonthBalance"
				class="table table-striped table-bordered table-hover" id="example">
				<display:column property="orderNumber" title="Д/д" />
				<display:column property="patient.id" title="" />
				<display:column property="doctor.name" title="Эмч" />
				<display:column property="patient.firstName" title="Үйлчлүүлэгч" />
				<display:column property="patient.regNumber" title="Регистер №"></display:column>
				<display:column property="patient.cardNumber" title="Картын дугаар" />
				<display:column property="totalPrice" format="{0,number,#,###}"
					title="Нийт орлого" />
				<c:forEach items="${example.priceMapList}" var="price">
					<display:column title="${price.sp.code}" format="{0,number,#,###}"
						value="${price.count}" />
				</c:forEach>
				<display:column property="number" title="Үйлчилгээ хийсэн тоо" />
				<display:column property="duration" title="Үйлчилгээ хийсэн хугацаа"></display:column>
				<display:footer>
					<tr>
						<th><s:text name="total" /></th>
						<th />
						<th />
						<th />
						<th />
						<th />
						<th id="total"></th>
						<c:forEach items="${example.priceMapList}" var="price">
							<th />
						</c:forEach>
						<th />
						<th />
					</tr>
				</display:footer>
			</display:table>
		</div>
	</div>
	<div class="row-fluid">Бүрэн төлөгдөөгүй үйлчилгээнүүд:</div>
	<div class="row-fluid">
		<div class="col-xs-12">
			<display:table name="listMonthBalancePaidFalse"
				class="table table-striped table-bordered table-hover" id="example1">
				<display:column property="orderNumber" title="Д/д" />
				<display:column property="patient.id" title="" />
				<display:column property="doctor.name" title="Эмч" />
				<display:column property="patient.firstName" title="Үйлчлүүлэгч" />
				<display:column property="patient.regNumber" title="Регистер №"></display:column>
				<display:column property="patient.cardNumber" title="Картын дугаар" />
				<display:column property="totalPrice" format="{0,number,#,###}"
					title="Нийт орлого" />
				<c:forEach items="${example1.priceMapList}" var="price">
					<display:column title="${price.sp.code}" format="{0,number,#,###}"
						value="${price.count}" />
				</c:forEach>
				<display:column property="number" title="Үйлчилгээ хийсэн тоо" />
				<display:column property="duration" title="Үйлчилгээ хийсэн хугацаа"></display:column>
				<display:footer>
					<tr>
						<th><s:text name="total" /></th>
						<th />
						<th />
						<th />
						<th />
						<th />
						<th id="total2"></th>
						<c:forEach items="${example1.priceMapList}" var="price">
							<th />
						</c:forEach>
						<th />
						<th />
					</tr>
				</display:footer>
			</display:table>
		</div>
	</div>
	<div class="col-xs-12">
		<a onclick="window.history.back()" style="text-decoration: none;"
			class="btn btn-back col-xs-12  col-sm-12 col-md-offset-2 col-md-6 col-lg-offset-2 col-lg-2">
			<span class="fa fa-arrow-circle-o-left"></span>&nbsp; <s:text
				name="back" />
		</a>
	</div>
</div>
<script src="../js/PageJS/reportMonthBalanceDoctor.js"></script>