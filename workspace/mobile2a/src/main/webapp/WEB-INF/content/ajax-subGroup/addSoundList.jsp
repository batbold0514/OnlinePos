<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:iterator begin="0" end="%{#session.sound}" status="stat">
	<div class="form-group">
		<div class="row">
			<label for="soundText" class="control-label col-sm-5 col-lg-5">
				<s:text name="soundText" /><span class="required"> * </span>
			</label>
			<div class="col-sm-7 col-lg-6">
				<div class = "input-group">
					<input name="sounds[${stat.index}]" class="form-control" value="${session.sounds[stat.index]}"/>
					<span class="input-group-addon" style="background-color:#5cb85c;cursor:pointer" onclick="addSound()">
						<i class = "fa fa-plus"></i>
					</span>
				</div>
			</div>
		</div>
	</div>
</s:iterator>
