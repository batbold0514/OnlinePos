<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:iterator value="listOfColorPercent" status="stat" begin="0"
	end="listOfColorPercent.size-1" id="iterate">
	<div class="row">
		<label for="2" class="control-label col-sm-4 col-lg-4"> <s:text
				name="%{#stat.index+1} -р өнгө" />
		</label>
		<div class="col-sm-4 col-lj-4">
			<s:textfield name="listOfColorPercent[%{#stat.index}]" />
		</div>
	</div>
</s:iterator>