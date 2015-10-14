<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<script type="text/javascript" src="../js/datatable.js"></script> 
<div class="hidden" id="page">
	<s:url action="usersList" includeParams="none"/>
</div>
<div class="panel panel-primary" id="mainPanel">
    <div class="panel-heading">
        <h3 class="panel-title text-center">
        	<span class="fa fa-user"></span>&nbsp;
            <s:text name="userList" />
        </h3>
    </div>
    <div class="panel-body">
    	<div class="table-responsive">
    		<display:table name="usersList" class="table table-bordered table-hover" id="mainTable">
    			<display:column property="id" title="ID" />
				<display:column property="userName" title="Хэрэглэгчийн нэр" />
				<c:forEach items="${mainTable.role}" var="role">
					<display:column value="${role.role}" title="Хэрэглэгчийн эрх" />
				</c:forEach>
				<display:column title="Засах">
					<a href="userEditt?model.id=${mainTable.id}" class="btn btn-warning btn-xs">
						<span class="glyphicon glyphicon-pencil"></span>&nbsp;
						<s:text name="edit" />
					</a>
				</display:column>
			</display:table>
			<s:hidden key="loc" value="userEditt" id="hideLocation"/>
		</div>
	</div>
	 <div class="panel-footer">
    	<div class="row">
			<div class="col-sm-12 text-center">
				<a href="userInput" class="btn btn-primary focus">
					<span class="icon icon-add-user"></span>&nbsp;
					<s:text name="addUser" />
				</a>
			</div>
		</div>
    </div>
</div>