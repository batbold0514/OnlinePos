<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<s:iterator begin="0" end="%{#session.video}" status="stat">
	<div class="form-group">
		<div class="row">
			<label for="videoText" class="control-label col-sm-5 col-lg-5">
				<s:text name="videoText" /><span class="required"> * </span>
			</label>
			<div class="col-sm-7 col-lg-6">
				<div class = "input-group">
					<input name="videos[${stat.index}]" class="form-control" type = "text"
						 value="${session.videos[stat.index]}"/>
					<span class="input-group-addon" style="background-color:#5cb85c;cursor:pointer" onclick="addVideos()">
						<i class = "fa fa-plus"></i>
					</span>
				</div>
			</div>
		</div>
	</div>
</s:iterator>
