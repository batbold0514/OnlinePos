<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="row">
	
		<div class="col-md-12">
			<div class="col-sm-5 col-lg-5">
				<h3 class="page-title">
					<s:text name="operator" />
	<s:hidden value= "%{#session.users.status.id}" id = "status_id" />
				</h3>
			</div>
			<s:if test="%{#session.users.status.id == 1}">
				<s:if test="listOfPlanCall!=null"></s:if>
				<div class="col-sm-7 col-lg-7">
						 <button class="btn btn-success col-sm-7 col-lg7"
							style="border: 1px solid #07c" id="operatorCallBtn">
							<i class="icon-th-list"></i> <span> <s:text name="prepareCall" /></span>
						</button>
				</div>
			</s:if>
		</div> 
	</div>
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-user"> <s:text name="operator" /></i>
			</div>
			<div class="tools">
				<a href="javascript:;" class="collapse"></a>
			</div>
		</div>
		<div class="portlet-body">
			<s:if test="%{#session.users.status.id == 2}">
				<div class="row">
					<s:form id="addform" class = "col-sm-12">
							<div class="form-group">
								<div class="col-sm-9">
									<label for="phone" class="control-label col-sm-5 col-lg-5">
										<s:text name="phoneNumber"></s:text>
									</label>
									<div class="col-sm-7 col-lg-6">
										<s:textfield name="phoneNumber" cssClass="form-control"
											id="phoneNumber" />
									</div>
								</div>
							</div>
							<div class="col-sm-3">
								<input class="btn green col-sm-12" id="btnSearch" type="submit"
									value="Хайх" />
							</div>
					</s:form>
				</div>
				<div id="parseResult" class="row"></div>
			</s:if>
			<s:if test="%{#session.users.status.id == 1}">
				<div class="row">
					<div class="col-sm-6">
						<div id="list-result-notCall">
							<display:table name="listOfPlanNotCall" id="planNotCall"
								class=" table table-bordered table-hoverdataTable">
								<display:column property="id" title="ID" />
								<display:column property="taxPayer.regNumber" title="Дугаар" />
								<display:column property="taxPayer.companyName" title="Нэр" />
								<display:column property="taxPayer.email" title="Е-мэйл" />
							<%-- 	<display:column property="taxPayer.phoneNumber" title="Утас" /> --%>
							</display:table>
						</div>
					</div>
					<div class="col-sm-6">
						<div id="list-result-call">
							<display:table name="listOfPlanCall" id="planCall"
								class=" table table-bordered table-hoverdataTable">
								<display:column property="id" title="ID" />
								<display:column property="taxPayer.regNumber" title="Дугаар" />
								<display:column property="taxPayer.companyName" title="Нэр" />
								<display:column property="taxPayer.email" title="Е-мэйл" />
								<%-- <display:column property="taxPayer.phoneNumber" title="Утас" /> --%>
							</display:table>
						</div>
					</div>
				</div>
			</s:if>
		</div>
	</div>
</div>

<div id="parseResult" class=hidden></div>
<div id="context" class="hide">${pageContext.request.contextPath}
</div>
<script src="../js/PageJS/operator-home-page.js"></script>