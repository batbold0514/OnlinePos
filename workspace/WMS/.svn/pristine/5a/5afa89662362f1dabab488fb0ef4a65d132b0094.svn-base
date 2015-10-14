<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="hidden" id="page">
	<s:url action="newArticle" includeParams="none" />
</div>
<div class="panel panel-success" id="mainPanel">
	<div class="panel-heading">
		<h3 class="panel-title text-center">
			<span class="icon icon-product"></span>&nbsp;
			<s:text name="product" />
		</h3>
	</div>
	<div class="panel-body">
		<s:form action="saveCategoryInArticle" cssClass="form-horizontal">
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="categoryInArticle.id" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="Category" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">	
							<div class="input-group">
								<span class="input-group-addon">
									<i class="icon icon-category"></i>
								</span>
								<s:select list="categories"
										listKey="id"
										listValue="name"
										key="categoryInArticle.id"
										headerKey="-1"
										headerValue=""
										cssClass="form-control"
										id="categoryInArticle.id"
										autofocus=""
										required="" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="categoryInArticle.id" />
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
						<s:text name="next" />&nbsp;
						<span class="fa fa-arrow-circle-o-right"></span>
					</button>
				</div>
			</div>
		</s:form>
	</div>
</div>