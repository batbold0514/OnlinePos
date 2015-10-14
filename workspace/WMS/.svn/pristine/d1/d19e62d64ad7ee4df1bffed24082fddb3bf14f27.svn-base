<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="hidden" id="page">
	<s:url action="usersList" includeParams="none" />
</div>
<div class="panel panel-warning" id="mainPanel">
  	<div class="panel-heading">
    	<h3 class="panel-title text-center">
    		<span class="fa fa-user"></span>&nbsp;
    		<s:text name="editUser" />
    	</h3>
  	</div>
  	<div class="panel-body">
		<s:form action="userEdit" method="POST" cssClass="form-horizontal">
    		<s:hidden key="id" />
		  	<div class="form-group">
		  		<div class="row">
					<div class="col-sm-12">
				    	<label for="userName" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
				    		<s:text name="userName" />(*):
				    	</label>
				    	<div class="col-sm-7 col-lg-6">
				    		<div class="input-group">
					    		<span class="input-group-addon">
					    			<i class="glyphicon glyphicon-user"></i>
					    		</span>
							    <s:textfield key="userName" cssClass="form-control" id="userName" autofocus="" />
					    	</div>
				    	</div>
				    </div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="userName" />
					</div>
				</div>
		  	</div>
		  	<div class="form-group">
		  		<div class="row">
					<div class="col-sm-12">
				    	<label for="role" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
				    		<s:text name="role" />(*):
				    	</label>
				    	<div class="col-sm-7 col-lg-6">
				    		<div class="input-group">
					    		<span class="input-group-addon">
					    			<i class="glyphicon glyphicon-star"></i>
					    		</span>
					    		<s:select key="roleString"
					    				list="{'admin-role','user-role'}"
					    				value="role[0].role"
					    				cssClass="form-control"
					    				id="role" />
					    	</div>
				    	</div>
				    </div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="roleString" />
					</div>
				</div>
		  	</div>
		  	<div class="form-group">
		  		<div class="row">
					<div class="col-sm-12">
				    	<label for="pwd" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
				    		<s:text name="pwd" />(*):
				    	</label>
				    	<div class="col-sm-7 col-lg-6">
				    		<div class="input-group">
					    		<span class="input-group-addon">
					    			<i class="glyphicon glyphicon-lock"></i>
					    		</span>
							    <s:password key="pwd" cssClass="form-control" id="pwd"  />
					    	</div>
				    	</div>
				    </div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="pwd" />
					</div>
				</div>
		  	</div>
		  	<div class="form-group">
		  		<div class="row">
					<div class="col-sm-12">
				    	<label for="confirmPwd" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
				    		<s:text name="confirmPwd" />(*):
				    	</label>
				    	<div class="col-sm-7 col-lg-6">
				    		<div class="input-group">
					    		<span class="input-group-addon">
					    			<i class="glyphicon glyphicon-lock"></i>
					    		</span>
							    <s:password key="confirmPwd" cssClass="form-control" id="confirmPwd"/>
							    <span class="input-group-addon">
					    			<i class="glyphicon glyphicon-repeat"></i>
					    		</span>
					    	</div>
				    	</div>
				    </div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="confirmPwd" />
					</div>
				</div>
		  	</div>
		  	<div class="form-group">
				<div class="col-sm-offset-1 col-sm-3 col-lg-offset-2 col-lg-2">
					<a href="usersList" class="btn btn-back btn-block">
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
					<button type="submit" id="saveSize" class="btn btn-success btn-block">
						<span class="fa fa-save"></span>&nbsp;
						<s:text name="save" />
					</button>
				</div>
			</div>
		</s:form>
  	</div>
</div>