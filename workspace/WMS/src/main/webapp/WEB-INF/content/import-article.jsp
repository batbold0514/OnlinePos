<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="hidden" id="page">
	<s:url action="import-article" includeParams="none" />
</div>
<div class="panel panel-input" id="mainPanel">
	<div class="panel-heading">
		<h3 class="panel-title text-center">
			<span class="fa fa-file-text"></span>&nbsp;
			<s:text name="importFromFile" />
		</h3>
	</div>
	<div class="panel-body">
		<br>
		<s:form action="import-articles-file" method="POST" cssClass="form-horizontal" enctype="multipart/form-data">
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<div class="col-sm-offset-4 col-sm-7 col-lg-6">
							<a href="download-XLSX" class="btn btn-primary btn-block">
								<i class="fa fa-paperclip"></i>&nbsp;
								<s:text name="templateDownload" />
							</a>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="fileDownload" />
					</div>
				</div>
			</div>
			<hr>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="fileUpload" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="file" />(*):
						</label>
				    	<div class="col-sm-7 col-lg-6">
				    		<div class="input-group">
				    			<s:file key="fileUpload" cssClass="form-control" id="fileUpload"></s:file>
				    			<span class="input-group-addon">
				    				<i class="fa fa-file-text"></i>&nbsp;
				    			</span>
				    		</div>
				    	</div>
				    </div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="fileUpload" />
					</div>
				</div>
		  	</div>
		  	<div class="form-group">
		  		<div class="row">
					<div class="col-sm-12">
						<label for="reciever" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="inReciever.id" />(*):
						</label>
				    	<div class="col-sm-7 col-lg-6">
				    		<div class="input-group">
				    			<s:select list="employeeList"
				    					listKey="id"
				    					listValue="firstName"
				    					key="inReciever.id"
				    					cssClass="form-control"
				    					headerKey="-1"
				    					headerValue=""
				    					id="reciever" />
				    			<span class="input-group-addon">
				    				<i class="icon icon-employee"></i>
				    			</span>
				    		</div>
				    	</div>
				    </div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="inReciever.id" />
					</div>
				</div>
		  	</div>
		  	<div class="form-group">
		  		<div class="row">
					<div class="col-sm-12">
						<label for="fromSb" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="fromSb" />:
						</label>
				    	<div class="col-sm-7 col-lg-6">
				    		<s:textfield key="fromSb" cssClass="form-control" id="fromSb" />
				    	</div>
				    </div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<s:fielderror fieldName="fromSb" />
					</div>
				</div>
		  	</div>
		  	<div class="form-group">
				<div class="col-sm-offset-1 col-sm-3 col-lg-offset-2 col-lg-2">
					<a onclick="window.history.back()" class="btn btn-back btn-block">
						<span class="fa fa-arrow-circle-o-left"></span>&nbsp;
						<s:text name="back" />
					</a>
				</div>
				<div class="col-sm-3 col-lg-2">
					<button type="reset" class="btn btn-gray btn-block">
						<span class="fa fa-refresh"></span>&nbsp;
						<s:text name="reset" />
					</button>
				</div>
				<div class="col-sm-4">
					<button type="submit" class="btn btn-success btn-block">
						<i class="fa fa-download"></i>&nbsp;
						<s:text name="doInput" />
					</button>
				</div>
			</div>
		</s:form>
	</div>
</div>