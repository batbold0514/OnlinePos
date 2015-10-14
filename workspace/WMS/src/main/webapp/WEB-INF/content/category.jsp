<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="hidden" id="page">
	<s:url action="category-list" includeParams="none" />
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
			<span class="icon icon-category"></span>&nbsp;
			<s:if test="id == null">
				<s:text name="addCategory" />
			</s:if>
			<s:else>
				<s:text name="editCategory" />
			</s:else>
		</h3>
	</div>
	<div class="panel-body">
		<s:form action="save-category" method="POST" cssClass="form-horizontal">
			<s:hidden key="id" />
			<div class="row">
				<div class="col-sm-12">
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<label for="name" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
									<s:text name="name" />(*):
								</label>
								<div class="col-sm-7 col-lg-6">
									<s:textfield key="name" cssClass="form-control input-sm" id="name" autofocus="" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
								<s:fielderror fieldName="name" />
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-1 col-sm-5 col-lg-offset-4 col-lg-3">
					<div class="form-group">
						<div class="col-sm-12">
							<b>
								<s:text name="requiredAttributes" />(*):
							</b>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<div class="checkbox">
								<label>
									<s:checkbox key="article_name" value="true" id="article_name" cssClass="hidden" />&nbsp;
									<s:text name="article_name" />
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<div class="checkbox" >
								<label>
									<s:checkbox key="barCode" value="true" cssClass="hidden" />&nbsp;
									<s:text name="barCode" />
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<div class="checkbox">
								<label>
									<s:checkbox key="count" value="true" id="count" cssClass="hidden" />&nbsp;
									<s:text name="count" />
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<div class="checkbox">
								<label>
									<s:checkbox key="measuring_unit" value="true" id="measuring_unit" cssClass="hidden" />&nbsp;
									<s:text name="measuring_unit" />
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<div class="checkbox">
								<label>
									<s:checkbox key="minCount" value="true" id="minCount" cssClass="hidden" />&nbsp;
									<s:text name="minCount" />
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<div class="checkbox">
								<label>
									<s:checkbox key="location" value="true" id="location" cssClass="hidden" />&nbsp;
									<s:text name="location" />
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<div class="checkbox">
								<label>
									<s:checkbox key="description" value="true" id="description" cssClass="hidden" />&nbsp;
									<s:text name="description" />
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<div class="checkbox">
								<label>
									<s:checkbox key="owner" value="true" id="owner" cssClass="hidden" />&nbsp;
									<s:text name="owner" />
								</label>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-5 col-lg-3">
					<div class="form-group">
						<div class="col-sm-12">
							<b>
								<s:text name="additionAttributes" />:
							</b>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<div class="checkbox">
								<label>
									<s:checkbox key="buyPrice" id="buyPrice" />&nbsp;
									<s:text name="buyPrice" />
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<div class="checkbox">
								<label>
									<s:checkbox key="sellPrice" id="sellPrice" />&nbsp;
									<s:text name="sellPrice" />
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<div class="checkbox">
								<label>
									<s:checkbox key="packageWeight" id="packageWeight" />&nbsp;
									<s:text name="packageWeight" />
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<div class="checkbox">
								<label>
									<s:checkbox key="moisture" id="moisture" />&nbsp;
									<s:text name="moisture" />
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<div class="checkbox">
								<label>
									<s:checkbox key="article_size" id="article_size" />&nbsp;
									<s:text name="article_size" />
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<div class="checkbox">
								<label>
									<s:checkbox key="colour" id="colour" />&nbsp;
									<s:text name="colour" />
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<div class="checkbox">
								<label>
									<s:checkbox key="partNumber" id="partNumber" />&nbsp;
									<s:text name="partNumber" />
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<div class="checkbox">
								<label>
									<s:checkbox key="serial" id="serial" />&nbsp;
									<s:text name="serial" />
								</label>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-1 col-sm-3 col-lg-offset-2 col-lg-2">
					<a href="category-list" class="btn btn-back btn-block">
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
					<button type="submit" id="saveCategory" class="btn btn-success btn-block">
						<span class="fa fa-save"></span>&nbsp;
						<s:text name="save" />
					</button>
				</div>
			</div>
		</s:form>
	</div>
</div>