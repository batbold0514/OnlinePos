<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-sm-12">
		<h3 class="page-title">
			<s:text name="projects" />
		</h3>
	</div>
	<p class = "active_menu hide">activeProject</p>
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-user"> <s:text name="projects" /></i>
			</div>
			<div class="tools">
				<a href="javascript:;" class="collapse"></a>
			</div>
		</div>
		<div class="portlet-body">
			<div id="list-result">
				<display:table name="projects" id="sampletable2"
					class="display table-bordered table-hoverdataTable">
					<display:column property="id" title="ID" />
					<display:column property="projectName" title="Төслийн нэр" />
					<display:column property="projectManager.firstName" title="Төслийн удирдагч" />
					<display:column property="projectGoal" title="Төслийн зорилго" />
					<display:column property="startDate" title="Эхэлсэн огноо" />
					<display:column property="endDate" title="Дуусах огноо" />
				</display:table>
			</div>
		</div>
	</div>
</div>
<div id="parseResult" class=hidden></div>
<div id="context" class="hide">${pageContext.request.contextPath}
</div>
<script src="../js/PageJS/activeProjects.js">
</script>
