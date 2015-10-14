<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="hidden" id="page">
	<s:url action="search-patient" includeParams="none" />
</div>
<div class="page-content">
	<div class="page-header">
		<h3>
			<s:text name="addSession" />
		</h3>
	</div>
	<div class="row">
		<div class="col-sm-12 col-lg-12">
			<s:form action="servicePriceCountNew"
			 cssClass="form-horizontal">
				<table>
					<s:iterator value="#session.doctorSession.listOfService"
						status="stat">
						<tr>
							<td class="col-sm-4 col-lg-4 control-label">${doctorSession.listOfService[stat.index].name}:</td>
							<td class="col-sm-2 col-lg-2 control-label"><s:textfield
									key="priceCount[%{#stat.index}]" cssClass="form-control"
									value="1" /></td>
						</tr>
					</s:iterator>
				</table>
				<div class="col-sm-offset-6 col-lg-offset-6">
					<button class="btn btn-success">
						<i class="icon-save"></i>
						<s:text name="save" />
					</button>
					<div onclick="window.history.back()" class="btn btn-warning">
						<i class="icon-arrow-right"></i>
						<s:text name="back" />
					</div>
				</div>
			</s:form>
		</div>
	</div>
</div>