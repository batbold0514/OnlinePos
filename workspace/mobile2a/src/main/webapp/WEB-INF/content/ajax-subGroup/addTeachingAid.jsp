<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:form method="POST" enctype="multipart/form-data" id="uploadImageForm" cssClass="hide">
		<input type="file" name="im" accept="image/*" id="imageUpload" multiple />
	</s:form>
<s:form method="POST" enctype="multipart/form-data" id="uploadTextForm" cssClass="hide">
		<input type="file" name="im" accept="text/*" id="textUpload" multiple />
	</s:form>
<s:form action="" id = "addTeachingAidFrom">
	<s:hidden name="id" value = "%{#request.subGroup.id}"/>
	<div class="row">
		<label for="groupName" class="control-label col-sm-5 col-lg-5">
			<s:text name="groupName" />
		</label>
		<div class="col-sm-7 col-lg-6">
			<s:textfield name="groupName" cssClass="form-control"
				id="groupName" autofocus="" readonly="true" value="%{#request.subGroup.groupName}"/>
		</div>
	</div>
	<div class="row">
		<label for="category" class="control-label col-sm-5 col-lg-5">
			<s:text name="category" /><span class="required"> </span>
		</label>
		<div class="col-sm-7 col-lg-6">
			<s:textfield  cssClass="form-control"
				autofocus="" readonly="true" value="%{#request.subGroup.category.description}"/>
		</div>
	</div>
	<div class ="row" style="text-align: center;font-size: medium;" >
		<s:text name="teachingAid"/>
	</div>
	<div class="form-group">
		<div class="row">
			<label for="name" class="control-label col-sm-5 col-lg-5">
				<s:text name="name" /><span class="required"> * </span>
			</label>
			<div class="col-sm-7 col-lg-6">
				<s:textfield name="aidName" cssClass="form-control"
					autofocus="" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<label for="description" class="control-label col-sm-5 col-lg-5">
				<s:text name="description" /><span class="required"> * </span>
			</label>
			<div class="col-sm-7 col-lg-6">
				<s:textfield name="aidDescription" cssClass="form-control"
					autofocus="" />
			</div>
		</div>
	</div>
	<div id = "videosId" class ="row">
			<s:iterator begin="0" end="%{#session.video}" status="stat">
				<div class="form-group">
					<div class="row">
						<label for="videoText" class="control-label col-sm-5 col-lg-5">
							<s:text name="videoText" /><span class="required"> * </span>
						</label>
						<div class="col-sm-7 col-lg-6">
							<div class = "input-group">
								<input name="videos[${stat.index}]" class="form-control" type = "text" />
								<span class="input-group-addon" style="background-color:#5cb85c;cursor:pointer" onclick="addVideos()">
									<i class = "fa fa-plus"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</s:iterator>
	</div>
	<div class = "row" id = "soundId">
			<s:iterator begin="0" end="%{#session.sound}" status="stat">
				<div class="form-group">
					<div class="row">
						<label for="soundText" class="control-label col-sm-5 col-lg-5">
							<s:text name="soundText" /><span class="required"> * </span>
						</label>
						<div class="col-sm-7 col-lg-6">
							<div class = "input-group">
								<input name="sounds[${stat.index}]" class="form-control"/>
								<span class="input-group-addon" style="background-color:#5cb85c;cursor:pointer" onclick="addSound()">
									<i class = "fa fa-plus"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</s:iterator>
	</div>
</s:form>

<div class = "row" id = "imageId"></div>
<div class = "row" id = "textId"></div>
<script src="../js/PageJS/addTeachingAid.js"></script> 