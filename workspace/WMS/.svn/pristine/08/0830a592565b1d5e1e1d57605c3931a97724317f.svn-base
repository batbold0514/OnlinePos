<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<script type="text/javascript" src="../js/datatable.js"></script> 
<div class="hidden" id="page">
	<s:url action="occupation-list" includeParams="none"/>
</div>
<div class="panel panel-primary" id="mainPanel">
    <div class="panel-heading">
        <h3 class="panel-title text-center">
        	<span class="fa fa-briefcase"></span>&nbsp;
            <s:text name="occupationList" />
        </h3>
    </div>
    <div class="panel-body">
    	<div class="table-responsive">
    		<display:table name="occupationList" class="table table-bordered table-hover" id="mainTable">
    			<display:column property="id" title="ID" />
				<display:column property="name" title="Нэр" />
				<display:column title="Засах">
					<a href="occupation?model.id=${mainTable.id}" class="btn btn-warning btn-xs">
						<span class="glyphicon glyphicon-pencil"></span>&nbsp;
						<s:text name="edit" />
					</a>
				</display:column>
			</display:table>
			<s:hidden key="loc" value="occupation" id="hideLocation"/>
		</div>
	</div>
	 <div class="panel-footer">
    	<div class="row">
			<div class="col-sm-12 text-center">
				<a href="occupation" class="btn btn-primary focus">
					<span class="fa fa-plus"></span>&nbsp;
					<s:text name="addOccupation" />
				</a>
			</div>
		</div>
    </div>
</div>