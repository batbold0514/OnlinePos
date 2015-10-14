<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="hidden" id="page">
	<s:url action="stoll-price" includeParams="none" />
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="addStollPrice" />
			<small> <i class="icon-double-angle-right"></i> Жагсаалт
			</small>
		</h2>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<s:form id="addForm" cssClass="form-horizontal">
				<s:hidden key="id" />
				<div class="form-group">
					<div class="row">
						<div class="col-sm-12">
							<label for="costPrice" class="control-label col-sm-5 col-lg-4">
								<s:text name="costPrice" />(*):
							</label>
							<div class="col-sm-5 col-lg-4">
								<s:textfield key="costPrice" cssClass="form-control" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
							id="errorCostPriceResult">
							<s:fielderror fieldName="costPrice" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-sm-12">
							<label for="sellPrice" class="control-label col-sm-5 col-lg-4">
								<s:text name="sellPrice" />(*):
							</label>
							<div class="col-sm-5 col-lg-4">
								<s:textfield key="sellPrice" cssClass="form-control" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6"
							id="errorSellPriceResult">
							<s:fielderror fieldName="sellPrice" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<div class="col-sm-offset-6 col-sm-3">
							<button class="btn btn-success" id="btn">
								<s:text name="save" />
							</button>
						</div>
					</div>
				</div>
			</s:form>
			<div class="hr hr16 hr-dotted"></div>
			<div class="table-responsive" id="list-result">
				<display:table name="stollPrice" id="stollTable"
					class="table table-striped table-bordered table-hover">
					<display:column property="costPrice" title="Норм цагийн үнэлгээ"
						style="vertical-align: middle;" />
					<display:column property="sellPrice" title="Stoll зардал"
						style="vertical-align: middle;" />
				</display:table>
			</div>
		</div>
	</div>
</div>
<div id="parseResult"></div>
<div id="context" class="hide">
  ${pageContext.request.contextPath}
</div>
<script src="../js/PageJS/stollPrice.js"></script>