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
	</div>
	<div class="row">
		<div class="col-sm-12 col-lg-12">
			<s:form action="monthBalance" cssClass="form-horizontal">
				<div class="row">
					<div class="col-sm-6 col-lg-6">
						<div class="form-group">
							<label for="date" class="col-sm-6 col-lg-6 control-label ">
								<s:text name="date" />
							</label>
							<div class="col-sm-6 col-lg-4 ">
								<s:textfield name="dateStr" cssClass="date form-control " />
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-lg-6">
						<%
							if (request.isUserInRole("admin-role")) {
						%>
						<div class="form-group">
							<label for="doctorID" class="col-sm-4 col-lg-4 control-label ">
								<s:text name="doctorID" />
							</label>
							<div class="col-sm-4 col-lg-4 ">
								<s:select key="doctorID" list="doctors" listValue="name"
									listKey="id" headerValue="Бүгд" headerKey="-1"
									cssClass="form-control" />
							</div>
						</div>
						<%
							}
						%>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-lg-6">
						<div class="form-group">
							<label for="secondDate" class="col-sm-6 col-lg-6 control-label ">
								<s:text name="secondDate" />
							</label>
							<div class="col-sm-4 col-lg-4 ">
								<s:textfield name="secondDateStr" cssClass="date form-control" />
							</div>
						</div>
					</div>
					<div class="col-sm-offset-2 col-lg-offset-2 col-sm-4 col-lg-4">
						<button class="btn btn-success col-sm-6 col-lg-6">
							<i class="icon-search"></i>
							<s:text name="search" />
						</button>
					</div>
				</div>
			</s:form>
			<div class="hr hr-24"></div>
			<s:set var="host">${pageContext.request.serverName}</s:set>
			Төлөгдсөн үйлчилгээнүүд:<input value="${host}" style="display: none"
				id="host">
			<display:table name="listMonthBalance"
				class="table table-striped table-bordered table-hover" id="example">
				<display:column property="orderNumber" title="Д/д" />
				<display:column property="doctor.id" title="" />
				<display:column property="doctor.name" title="Эмч" />
				<display:column property="totalPrice" format="{0,number,#,###}"
					title="Нийт орлого" />
				<%-- <c:forEach items="${example.priceMapList}" var="price">
			<display:column title="${price.sp.name}" format="{0,number,#,###}"
				value="${price.count}" />
		</c:forEach> --%>
				<display:column property="number" title="Үйлчилгээ хийсэн тоо" />
				<display:column property="duration" title="Үйлчилгээ хийсэн хугацаа"></display:column>
				<display:footer>
					<tr>
						<th><s:text name="total" /></th>
						<th />
						<th />
						<th id="total"></th>
						<%-- <c:forEach items="${example.priceMapList}" var="price">
					<th />
				</c:forEach> --%>
						<th id="total1" />
						<th />
					</tr>
				</display:footer>
			</display:table>
			<div class="hr hr-24"></div>
			<br> Бүрэн төлөгдөөгүй үйлчилгээнүүд: <br>
			<display:table name="listMonthBalancePaidFalse"
				class="table table-striped table-bordered table-hover" id="example1">
				<display:column property="orderNumber" title="Д/д" />
				<display:column property="doctor.id" title="" />
				<display:column property="doctor.name" title="Эмч" />
				<display:column property="totalPrice" format="{0,number,#,###}"
					title="Нийт орлого" />
				<%-- <c:forEach items="${example1.priceMapList}" var="price">
			<display:column title="${price.sp.name}" format="{0,number,#,###}"
				value="${price.count}" />
		</c:forEach> --%>
				<display:column property="number" title="Үйлчилгээ хийсэн тоо" />
				<display:column property="duration" title="Үйлчилгээ хийсэн хугацаа"></display:column>
				<display:footer>
					<tr>
						<th><s:text name="total" /></th>
						<th />
						<th />
						<th id="total2"></th>
						<%-- <c:forEach items="${example1.priceMapList}" var="price">
					<th />
				</c:forEach> --%>
						<th id="total3" />
						<th />
					</tr>
				</display:footer>
			</display:table>
		</div>
	</div>
</div>
<script src="../js/PageJS/reportMonthBalance.js"></script>