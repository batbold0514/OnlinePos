<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<div class="hidden" id="page">
	<s:url action="productionSteps" includeParams="none"/>
</div>
<div class="row">
	<div class="col-sm-12">
		<div class="panel panel-primary" id="mainPanel">
		    <div class="panel-heading">
		        <h3 class="panel-title text-center">
		        	<span class="icon icon-next-task"></span>&nbsp;
		            <s:text name="listProductionStep" />
		        </h3>
		    </div>
		    <div class="panel-body">
		    	<div class="table-responsive">
		    		<display:table name="ListOfPS" class="table table-bordered table-hover" id="mainTable">
						<display:column property="id" title="ID" />
						<display:column property="name" title="Нэр" />
					</display:table>
				</div>
			</div>
			 <div class="panel-footer">
		    	<div class="row">
					<div class="col-sm-12 text-center">
						<a href="productionStep" class="btn btn-primary focus">
							<span class="fa fa-plus"></span>&nbsp;
							<s:text name="addProductionStep" />
						</a>
					</div>
				</div>
		    </div>
		</div>
	</div>
</div>
<s:hidden key = "loc" value = "productionStep" id = "hideLocation"/>
<script type="text/javascript" src="../js/datatable.js"></script> 