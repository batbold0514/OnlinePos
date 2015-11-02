<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="dialog-commitment" class="hide">
	<s:form action="" cssClass="form-horizontal" id="addCommitment">
		<s:hidden name="id" />
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="userName" class="control-label col-sm-5 col-lg-5">
						<s:text name="userName" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="userName" cssClass="form-control"
							id="userNameAdd" autofocus="" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="code" class="control-label col-sm-5 col-lg-5">
						<s:text name="code"></s:text>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:textfield name="code" cssClass="form-control" id="codeAdd"></s:textfield>
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="roleString" class="control-label col-sm-5 col-lg-5">
						<s:text name="roleString" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:select key="roleString" headerKey="" headerValue=""
							list="roles" listKey="role" listValue="role"
							cssClass="form-control" id="roleStringAdd" />
					</div>
				</div>
			</div>
		</div>
		<div class="form-group hide" id="seniorOpSelect">
			<div class="row">
				<div class="col-sm-12">
					<label for=seniorOp class="control-label col-sm-5 col-lg-5">
						<s:text name="senoirop"></s:text>
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:select list="senoiorops" key="senior_id" listKey="id"
							listValue="code" headerKey="" headerValue=""
							cssClass="form-control" id="seniorop">
						</s:select>
					</div>
				</div>
			</div>
		</div>
	</s:form>
</div>
<div id="parseResult" class=hidden></div>
<div id="context" class="hide">${pageContext.request.contextPath}
</div>
