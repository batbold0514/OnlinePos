<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:iterator value="productModel.listOfColours" status="stat" begin="0"
	end="productModel.listOfColours.size-1" id="iterate">
	<div class="row">
		<label for="2" class="control-label col-sm-5 col-lg-5"> <s:text
				name="%{#stat.index+1} -р өнгө" />
		</label>
		<div class="col-sm-7 col-lj-6">
			<s:select list="colours" listKey="id" listValue="code + ' ' + name"
				headerKey="" headerValue="" name="listColorID[%{#stat.index}]" />
		</div>
	</div>
</s:iterator>