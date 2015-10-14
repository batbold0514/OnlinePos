<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="hidden" id="page">
	<s:url action="employee-list" includeParams="none" />
</div>
<div class="panel 
		<s:if test="id == null">
			panel-success
		</s:if>
		<s:else>
			panel-warning
		</s:else>"
	id="mainPanel">
	<div class="panel-heading">
		<h3 class="panel-title text-center">
			<span class="icon icon-employee"></span>&nbsp;
			<s:if test="id == null">
				<s:text name="addEmployee" />
			</s:if>
			<s:else>
				<s:text name="editEmployee" />
			</s:else>
		</h3>
	</div>
	<div class="panel-body">
		<s:form action="save-employee" method="POST" cssClass="form-horizontal">
			<s:hidden key="id" />
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="code" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="code" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield key="code" cssClass="form-control input-sm" id="code" autofocus="" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="code" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="regNumber" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="regNumber" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield key="regNumber" cssClass="form-control input-sm" id="regNumber" autofocus="" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="regNumber" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="lastName" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="lastName" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield key="lastName" cssClass="form-control input-sm" id="lastName" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="lastName" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="firstName" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="firstName" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield key="firstName" cssClass="form-control input-sm" id="firstName" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="firstName" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="positions" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="position" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<div class="input-group">
								<span class="input-group-addon input-sm">
									<i class="fa fa-briefcase"></i>
								</span>
								<s:select name="empPosition"
									list="employeePositions"
									listValue="name"
									listKey="id"
									headerKey=""
									headerValue=""
									value="position.id"
									value="empPosition"
									cssClass="form-control input-sm"
									id="positions" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="empPosition" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="birthday" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="birthday" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<div class="input-group">
								<span class="input-group-addon input-sm">
									<i class="fa fa-calendar"></i>
								</span>
								<s:textfield key="bday" cssClass="form-control input-sm" id="birthday" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="bday" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="email" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="email" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<div class="input-group">
								<span class="input-group-addon input-sm">
									<i class="fa fa-envelope"></i>
								</span>
								<s:textfield key="email" cssClass="form-control input-sm" id="email" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="email" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="phone" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="phone" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<div class="input-group">
								<span class="input-group-addon input-sm">
									<i class="glyphicon glyphicon-earphone"></i>
								</span>
								<s:textfield key="phone" cssClass="form-control input-sm" id="phone" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="phone" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="status" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="status" />:
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:select key="status"
									list="statuses"
									listValue="label"
									cssClass="form-control input-sm"
									id="status" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="status" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-3 col-lg-offset-2 col-lg-2">
					<a href="employee-list" class="btn btn-back btn-block">
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
					<button type="submit" class="btn btn-success btn-block" id="saveEmployee">
						<span class="fa fa-save"></span>&nbsp;
						<s:text name="save" />
					</button>
				</div>
			</div>
		</s:form>
	</div>
</div>