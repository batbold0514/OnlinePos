<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	if (request.getAttribute("successUser") == null) {
%>
<s:form action="saveChange" cssClass="form-horizontal" method="POST"
	id="changeForm">
	<s:hidden key="id" value="%{#session.product.id}" />
	<s:hidden name="modelId" value="%{#session.product.modelId}" />
	<s:hidden key="stoll" value="%{#session.product.stoll}" />
	<s:hidden key="chordPrice" value="%{#session.product.ChordPrice}" />
	<s:hidden key="unitChordPrice"
		value="%{#session.product.unitChordPrice}" />
	<s:hidden key="aidPrice" value="%{#session.product.aidPrice}" />
	<s:hidden key="sellPrice" value="%{#session.product.sellPrice}" />
	<s:hidden key="status" value="%{#session.product.status}" />
	<s:hidden key="description" value="%{#session.product.description}" />
	<s:hidden key="percent" value="%{#session.product.percent}" />
	<s:hidden key="yarnNumber" value="%{#session.product.yarnNumber}" />
	<s:iterator value="#session.listofs" status="stat" begin="0"
		end="#session.listofs.size/2-1">
		<tr>
			<td align="right"></td>
			<td></td>
		</tr>
		<div class="form-group">
			<div class="row">
				<div class="col-sm-12">
					<label for="listOfPrice[%{#stat.index}]"
						class="control-label col-sm-4 col-lg-4"> <s:property
							value="name" />(*):
					</label>
					<div class="col-sm-7 col-lg-6">
						<s:if test="id == 1000">
							<s:textfield name="listOfPrice[%{#stat.index}]"
								value="%{#session.stoll}" readonly="true"
								cssClass="form-control" />
						</s:if>
						<s:else>
							<s:textfield name="listOfPrice[%{#stat.index}]" id="focus"
								cssClass="form-control" id="%{#stat.index}" />
						</s:else>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
					id="errorlistOfPrice[%{#stat.index}]Result">
					<s:fielderror id="errorlistOfPrice[%{#stat.index}]">
						<s:param>listOfPrice[<s:property value="%{#stat.index}" />]</s:param>
					</s:fielderror>
				</div>
			</div>
		</div>
	</s:iterator>
	<s:submit id="gogo" cssStyle="display:none" />
</s:form>
<%
	}
%>
