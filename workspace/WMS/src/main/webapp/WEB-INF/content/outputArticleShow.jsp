<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="hidden" id="page">
	<s:url action="outList" includeParams="none" />
</div>
<div class="row">
	<div class="col-sm-12">
		<div class="panel panel-success" id="mainPanel">
			<div class="panel-heading">
				<h3 class="panel-title text-center">
					<span class=""></span>
					<s:text name="OutputArticle" />
				</h3>
			</div>
			<div class="panel-body">
				<div class="col-sm-8 col-sm-offset-2">
					<s:form action="doOutputArticle" cssClass="form-horizontal">
						<s:hidden key="id" />
						<div class="form-group">
							<label for="article.name" class="col-sm-4 control-label">
								<s:text name="articleName" />:
							</label>
							<div class="col-sm-8">
								<s:textfield key="article.name" disabled="true"
									cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="article.serialNumber" class="col-sm-4 control-label">
								<s:text name="article.serialNumber" />:
							</label>
							<div class="col-sm-8">
								<s:textfield key="article.serialNumber" disabled="true"
									cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="outDate" class="col-sm-4 control-label"> <s:text
									name="outDate" />:
							</label>
							<div class="col-sm-8">
								<s:textfield key="outDate" disabled="true"
									cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="outCount" class="col-sm-4 control-label"> <s:text
									name="outCount" />:
							</label>
							<div class="col-sm-8">
								<s:textfield key="outCount" disabled="true"
									cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="reciever" class="col-sm-4 control-label"> <s:text
									name="reciever" />:
							</label>
							<div class="col-sm-8">
								<s:textfield key="reciever" disabled="true"
									cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="writer" class="col-sm-4 control-label"> <s:text
									name="writer" />:
							</label>
							<div class="col-sm-8">
								<s:textfield key="writer" disabled="true"
									cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="from.firstName" class="col-sm-4 control-label">
								<s:text name="from.id" />:
							</label>
							<div class="col-sm-8">
								<s:textfield key="from.firstName" disabled="true"
									cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="decription" class="col-sm-4 control-label"> <s:text
									name="description" />:
							</label>
							<div class="col-sm-8">
								<s:textarea key="article.description" disabled="true"
									cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-4">
								<a onclick="window.history.back()"
									class="btn btn-back col-xs-12  col-sm-12 col-md-offset-2 col-md-10 col-lg-offset-4 col-lg-8">
									<span class="fa fa-arrow-circle-o-left"></span>&nbsp; <s:text
										name="back" />
								</a>
							</div>
							<div class="col-sm-2">
								<a href="showArticle?model.id=${article.id}"
									class="btn btn-primary focus"> <span
									class="fa fa-search-plus"></span>&nbsp; <s:text
										name="articleShow" />
								</a>
							</div>
						</div>
					</s:form>
				</div>
			</div>
		</div>
	</div>
</div>