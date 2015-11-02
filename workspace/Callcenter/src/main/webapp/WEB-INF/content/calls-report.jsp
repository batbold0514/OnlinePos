<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="form-group">
	<div class="row col-cm-12">
		<div class="col-sm-7 col-lg-6">
			<h3 class="page-title">
				<s:text name="callreport" />
			</h3>
		</div>
		<div>
			<s:form action="call-report">
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
					<label for="duration" class="control-label col-sm-2 col-lg-2">
						<s:text name="duration"></s:text>
					</label>
					<div class="col-sm-2 col-lg-2">
						<s:textfield name="callDuration" cssClass="form-control"></s:textfield>
					</div>
				</div>
				<div class="row col-sm-12">
					<%
						if (!request.isUserInRole("operator")) {
					%>
					<label for="opId" class="control-label col-sm-1 col-lg-1">
						<s:text name="operator"></s:text>
					</label>
					<div class="col-sm-3 col-lg-3">
						<s:select list="operators" listKey="id" listValue="code"
							headerKey="%" headerValue="Бүгд" name="operatorIdString"
							id="opId" cssClass="form-control selects"></s:select>
					</div>
					<%
						} else {
					%>
					<div class="col-sm-3 col-lg-3 hide">
						<s:select list="operators" listKey="id" listValue="code"
							headerKey="%" headerValue="Бүгд" name="operatorIdString"
							id="opId" cssClass="form-control selects"
							value="#session.users.id"></s:select>
					</div>
					<%
						}
					%>
					<label for="reasonId" class="control-label col-sm-1 col-lg-1">
						<s:text name="reasons"></s:text>
					</label>
					<div class="col-sm-3 col-lg-3">
						<s:select list="reasons" listKey="id" listValue="description"
							headerKey="%" headerValue="Бүгд" name="reasonIdString"
							id="reasonId" cssClass="form-control selects"></s:select>
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
				<i class="fa fa-phone"> <s:text name="calls" /></i>
			</div>
			<div class="tools">
				<a href="javascript:;" class="collapse"></a>
			</div>
		</div>
		<div class="portlet-body">
			<div id="list-result">
				<display:table name="callList" id="sampletable2"
					class="display table-bordered table-hoverdataTable">
					<display:column property="taxPayer.regNumber" title="Т/т дугаар" />
					<display:column property="taxPayer.companyName" title="Т/т нэр" />
					<display:column property="date" title="Дуудлага хийсэн огноо" />
					<display:column property="operator.code" title="Оператор" />
					<%-- 	<c:forEach items="${sampletable2.debtList}" var="role">
						<display:column value="${debtList.balance}"
							title="${debtList.debtNumber}" />
					</c:forEach> --%>
					<display:column property="duration" title="Үргэлжилсэн хугацаа" />
					<display:column property="reason.description"
						title="Дуудлагын төлөв" />
						<display:column property="fileName" title="файл нэр" />
					<display:footer>
						<tr>
							<th > Амжилттай:</th>
							<th ><s:property  value="callProcessList[0].listOfCall.size()"/></th>
							<th >Бусад:</th>
							<th ><s:property  value="callProcessList[1].listOfCall.size()"/></th>
							<th id="totalDuration" />
							<th />
							<th />
						</tr>
					</display:footer>
				</display:table>
			</div>
		</div>
	</div>
</div>

<div  id="audio-dialog" class = "hide">
	<div id="jquery_jplayer_1" class="jp-jplayer"></div>
	<div id="jp_container_1" class="jp-audio">
		<div class="jp-type-single">
			<div class="jp-gui jp-interface">
				<div class="jp-controls">
					<button class="jp-play" tabindex="0" id = "play">play</button>
					<button class="jp-stop" tabindex="0" id = "stop">stop</button>
				</div>
				<div class="jp-progress">
					<div class="jp-seek-bar">
						<div class="jp-play-bar"></div>
					</div>
				</div>
				<div class="jp-volume-controls">
					<button class="jp-mute"  tabindex="0">mute</button>
					<button class="jp-volume-max" tabindex="0">max volume</button>
					<div class="jp-volume-bar">
						<div class="jp-volume-bar-value"></div>
					</div>
				</div>
				<div class="jp-time-holder">
					<div class="jp-current-time" >&nbsp;</div>
					<div class="jp-duration">&nbsp;</div>
					<div class="jp-toggles">
						<button class="jp-repeat"  tabindex="0">repeat</button>
					</div>
				</div>
			</div>
			<div class="jp-details">
				<div class="jp-title" >&nbsp;</div>
			</div>
			<div class="jp-no-solution">
			</div>
		</div>
	</div>
</div>



<script src="../js/PageJS/calls-report.js"></script>