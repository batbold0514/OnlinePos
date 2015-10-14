<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<script type="text/javascript" src="../js/datatable.js"></script>
<div class="hidden" id="page">
	<s:url action="employee-list" includeParams="none"/>
</div>
<div class="panel panel-primary" id="mainPanel">
    <div class="panel-heading">
        <h3 class="panel-title text-center">
        	<span class="fa fa-users"></span>&nbsp;
            <s:text name="listEmployee" />
        </h3>
    </div>
    <div class="panel-body">
    	<div class="table-responsive">
			<display:table name="empList" id="mainTable" class="table table-bordered table-hover" >
			    <display:column property="id" title="№" />
				<display:column property="code" title="Ажилчны код" />
				<display:column property="regNumber" title="Регистрийн дугаар" />
				<display:column property="firstName" title="Нэр" />
				<display:column property="lastName" title="Овог" />
				<display:column property="position.name" title="Ажил/Мэргэжил" />
				<display:column property="birthday" title="Төрсөн өдөр" />
				<display:column property="phone" title="Утас" />
				<display:column property="email" title="Имэйл" />
				<display:column property="status.label" title="Төлөв" />
				<display:column title="Засах">
					<a href="employee?model.id=${mainTable.id}" class="btn btn-warning btn-xs">
						<span class="glyphicon glyphicon-pencil"></span>&nbsp;
						<s:text name="edit" />
					</a>
				</display:column>
			</display:table>
			<s:hidden key="loc" value="employee" id="hideLocation"/>
		</div>
	</div>
	 <div class="panel-footer">
    	<div class="row">
			<div class="col-sm-12 text-center">
				<a href="employee" class="btn btn-primary focus">
					<span class="icon icon-add-employee"></span>&nbsp;
					<s:text name="addEmployee" />
				</a>
			</div>
		</div>
    </div>
</div>