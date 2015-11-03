<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:form method="POST" enctype="multipart/form-data" id="EditUploadImageForm" cssClass="hide">
		<input type="file" name="im" accept="image/*" id="editImageUpload" multiple />
	</s:form>
<s:form method="POST" enctype="multipart/form-data" id="EditUploadTextForm" cssClass="hide">
		<input type="file" name="im" accept="text/*" id="editTextUpload" multiple />
	</s:form>
<s:form action="" id = "editTeachingAidFrom">
	<s:hidden name="id" value = "%{#session.teachingAid.id}"/>
	<div class="form-group">
		<div class="row">
			<label for="name" class="control-label col-sm-5 col-lg-5">
				<s:text name="name" /><span class="required"> * </span>
			</label>
			<div class="col-sm-7 col-lg-6">
				<input name="aidName" class="form-control"
					value="${session.teachingAid.name}"/>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="row">
			<label for="description" class="control-label col-sm-5 col-lg-5">
				<s:text name="description" /><span class="required"> * </span>
			</label>
			<div class="col-sm-7 col-lg-6">
				<input name="aidDescription" class="form-control"
					value = "${session.teachingAid.description}" />
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
								<input name="videos[${stat.index}]" class="form-control" type = "text" 
									value = "${session.teachingAid.listOfvideo[stat.index].path}"/>
								<span class="input-group-addon" style="background-color:#5cb85c;cursor:pointer" onclick="editVideos()">
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
								<input name="sounds[${stat.index}]" class="form-control"
									value = "${session.teachingAid.listOfsounds[stat.index].path}"/>
								<span class="input-group-addon" style="background-color:#5cb85c;cursor:pointer" onclick="editSound()">
									<i class = "fa fa-plus"></i>
								</span>
							</div>
						</div>
					</div>
				</div>
			</s:iterator>
	</div>
</s:form>

<div class = "row" id = "imageId">
	<div class = "row" style="text-align: center;font-size: large;">
		<s:text  name = "images"/>
	</div>
	<div class="tiles col-xs-12 col-sm-12 col-lg-12">
		<c:forEach items="${session.teachingAid.listOfImages}" var="image">
			<div class="tile">
				<a href="../uploads/${image.name}" onclick="return hs.expand(this)" class="highslide">
					<img src="../uploads/${image.name}" alt="${image.name}" title="Дарж томруулна уу" width="120" height="120" />
				</a>
			</div>
		</c:forEach>
	</div>
</div>
<div class = "row" id = "textId">
	<div class = "row" style="text-align: center;font-size: large;">
		<s:text  name = "textFiles"/>
	</div>
	<div class="tiles col-xs-12 col-sm-12 col-lg-12">
		<c:forEach items="${session.teachingAid.listOfText}" var="image">
			<div class="tile double tile double-down" title="${image.name}">
				<object title="${image.name}" height="280px" width="280px" data="../textFiles/${image.name}" ></object>
			</div>
		</c:forEach>
</div>
</div>
 <script src="../js/PageJS/editTeachingAid.js"></script>  