<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<div class = "col-sm-12 col-lg-12">
<s:iterator value="#session.listOfUserProFile" status="stat" var="iter">
	<div class="heigth" style="width: 25%;float: left;">
		<div class = "col-sm-12 col-lg-12">
			<div class = "row">
				<a href="../uploads/${image}" onclick="return hs.expand(this)" class="highslide">
					<img src="../uploads/${image}" alt="${image}"  width="50%" height="120" style="float: left;"/>
				</a>
				<s:if test="#iter.callStatus.id == 2">
					<div  style="width: 50%;float:right;">
						${code}
					</div>
					<div  style="width: 50%;float:right ;">
						<s:text name="warning"/>
					</div>
					<div  style="width: 50%;float:right;">
						<div class="progress progress-striped  active">
							<div class="progress-bar progress-bar-danger" style="width: 100%;">
								<s:property value = "%{#iter.durationTime}"/>
							</div>
						</div>
					</div>
					<%-- <div class="col-sm-3 col-lg-2">
						<button class="btn btn-success form-control">
							<s:text name="call"></s:text>
						</button>--%>
				</s:if>
				<s:elseif test="#iter.callStatus.id == 1">
					<div  style="width: 50%;float:right;">
						${code}
					</div>
					<div  style="width: 50%;float:right;">
						<s:text name="incall"/>
					</div>
					<div  style="width: 50%;float:right;">
						<div class="progress progress-striped  active">
							<div class="progress-bar progress-bar-success" style="width: 100%;">
								<s:property value = "%{#iter.durationTime}"/>
							</div>
						</div>
					</div>
				</s:elseif>
				<s:else>
					<div  style="width: 50%;float:right;">
						${code}
					</div>
					<div  style="width: 50%;float:right;">
						<s:text name="nocall"/>
					</div>
					<div  style="width: 50%;float:right;">
						<div class="progress progress-striped  active">
							<div class="progress-bar progress-bar-warning" style="width: 100%;"></div>
						</div>
					</div>
				</s:else>
			</div>
			<div class = "row">
				Компаны нэр:${taxPayer.companyName} 
			</div>
			<div class = "row">
				Татвар төлөгчийн дугаар:${taxPayer.regNumber}
			</div>
			<div class = "row">
				 Овог: ${taxPayer.rectorLastName} Нэр: ${taxPayer.rectorFirstName} 
			</div>
			<div class = "row">
				 Дундаж өдөр: ${taxPayer.avgDay} 
			</div>
			
			
		</div>
	</div>
</s:iterator>
</div>
<script>
jQuery(function($) {
	vph = window.innerHeight;
	$('.heigth').css({'height': (vph-(vph/5))/2 + 'px'});
});
</script>