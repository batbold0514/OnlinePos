<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%-- <%@ taglib prefix="sj" uri="/struts-jquery-tags"%> --%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <sj:head jquerytheme="south-street" jqueryui="true" /> --%>
<link rel="stylesheet" type="text/css" href="../highslide/highslide.css" />
<div class="hidden" id="page">
	<s:url action="productModels" includeParams="none"/>
</div>
<div class="page-content">
	<div class="page-header">
	   <h2>
		  <s:text name="listProductModel" />
	   </h2>
    </div>
<div class="row">
<div class="col-xs-12">
   <div class="table-responsive">
	<display:table class="table table-striped table-bordered table-hover" id="productModel" name="listOfPM" >
	<display:column style="vertical-align: middle;" property="id" title="ID" />
		<c:forEach items="${productModel.imageList}" var="image">
			<display:column title="Зураг" style="vertical-align: middle;">
				<a href="../uploads/${image.name}" class="highslide"
					onclick="return hs.expand(this, { slideshowGroup: ${productModel.id} })">
					<img src="../uploads/${image.name}" alt="${image.name}"
					title="Click to enlarge" height="55" width="50" />
				</a>
				<script type="text/javascript">
					$("#pm-${productModel.id}").ready(function()
					{
						$.ajax(
						{
							url: "get-addition-images",
							data:
								{
									id: '${productModel.id}'
								},
							success: function(result)
							{
						    	$("#pm-${productModel.id}").html(result);
						    }
						});
					});
				</script>
				<div id="pm-${productModel.id}" style="display: none;"></div>
			</display:column>
		</c:forEach>
		
		<display:column style="vertical-align: middle;" property="modelId"
			title="Загварын нэр төрөл" />
		<display:column property="description"  title="Дэлгэрэнгүй"
			style="vertical-align: middle;" />
		<display:column style="vertical-align: middle;" property="yarnNumber"
			title="Утасны №" />
		<display:column property="sellPrice" format="{0,number,#,##0}" title="Худалдах үнэ"
			style="vertical-align: middle;" />
		<display:column style="vertical-align: middle;"
			property="status.label" title="Төлөв" />
		<display:column style="vertical-align: middle;" property="stoll"
			title="Stoll" />
		<c:forEach items="${productModel.listOfStepPrice}" var="p">
			<display:column style="vertical-align: middle;" value="${p.price}"
				title="${p.productStep.name}" format="{0,number,#,##0}"/>
		</c:forEach>
		<display:column property="shx" format="{0,number,#,##0}" title="Шууд хөдөлмөр"
			style="vertical-align: middle;"/>
		<display:column property="shxFull" format="{0,number,#,##0}" title="Шууд хөдөлмөр1"
			style="vertical-align: middle;"/>
	    <display:column property="chordPrice" format="{0,number,#,##0}" title="Дундаж жин"
			style="vertical-align: middle;" />
		<display:column property="aidPrice" format="{0,number,#,##0}" title="Туслах материал"
			style="vertical-align: middle;" />
		<display:column property="totalChordPrice" format="{0,number,#,##0}" title="Утасны үнэ"
			style="vertical-align: middle;" />
		<display:column property="unitChordPrice" title="Нэгж үнэ"
			style="vertical-align: middle;" format="{0,number,#,##0}" />
	    <display:column style="vertical-align: middle;" title="Өнгөний алаг" >
	      <c:forEach items="${productModel.listOfColours}" var="d">
	        <c:out value="${d.percent}"/>,
	      </c:forEach>
        </display:column>
		<display:column property="totalCostPrice" format="{0,number,#,##0}" title="Нийт зардал"
			style="vertical-align: middle;" />
		<display:column property="averageEarnings" format="{0,number,#,##0}" title="Дундаж ашиг"
			style="vertical-align: middle;" />
	</display:table>
	
	</div>
	</div>
</div>
</div>
<br />
 <s:form action="">
	<s:if test="%{#session.save == 'true'}">
		<div id="mybuttondialog">
			Загварын дугаар :  <s:property
				value="%{#session.savedObject.modelId}" />
			<br />
			Утас (граммаар) :  <s:property
				value="%{#session.savedObject.chordPrice}" />
			<br />
			Утасны нэгж үнэ :  <s:property
				value="%{#session.savedObject.unitChordPrice}" />
			<br />
			Туслах материал :  <s:property
				value="%{#session.savedObject.aidPrice}" />
			<br />
			Худалдах үнэ    :  <s:property
				value="%{#session.savedObject.sellPrice}" />
			<br />
			Дамжлагууд      :  
			<s:iterator value="%{#session.savedObject.listOfStepPrice}"
				status="stat">
				<s:property value="productStep.name" />
				<s:property value="productStep.price" />
			</s:iterator>
			<br>
			<%-- <s:text name="size"/><s:textfield name="size" value="%{#session.savedsize.sizes}" /> --%>
		</div>
		<%
			request.getSession().removeAttribute("save");
					request.getSession().removeAttribute("savedObject");
		%>
	</s:if>
</s:form> 
<div id="context" class="hide">
  ${pageContext.request.contextPath}
</div>
<script type="text/javascript" src="../highslide/highslide-full.js"></script>
<script src="../js/PageJS/productModelList.js"></script>