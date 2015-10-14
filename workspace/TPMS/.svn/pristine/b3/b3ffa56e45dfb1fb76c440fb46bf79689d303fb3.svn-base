<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="../css/highslide.css" />
<div class="hidden" id="page">
	<s:url action="productModel" includeParams="none" />
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="editProductModel" />
		</h2>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="tabbable">
				<ul class="nav nav-tabs" id="myTab">
					<li class="active">
						<a href="#informationTab" data-toggle="tab">
							<i class="icon-tasks bigger-110 blue"></i>
							Загварын өгөгдлүүд
						</a>
					</li>
					<li>
						 <a href="#imageTab" data-toggle="tab">
							<i class="icon-picture bigger-110 green"></i>
							Зурагнууд
						</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane in active" id="informationTab">
						<s:form action="editProductModel" method="POST" cssClass="form-horizontal" id="editForm">
							<s:hidden key="id" />
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12">
										<label for="status" class="control-label col-sm-4 col-lg-4">
											<s:text name="status" />:
										</label>
										<div class="col-sm-7 col-lg-6">
											<s:select id="selectStatus"
													key="status"
													list="productModelActivity"
													listValue="label"
													onchange="initEditPrice()"
													value="status"
													cssClass="form-control" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6" id="errorstatusResult">
										<s:fielderror fieldName="status" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12">
										<label for="modelId" class="control-label col-sm-4 col-lg-4">
											<s:text name="modelId" />:
										</label>
										<div class="col-sm-7 col-lg-6">
											<s:textfield key="modelId" readonly="true" cssClass="form-control" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6" id="errormodelIdResult">
										<s:fielderror fieldName="modelId" />
									</div>
								</div>
							</div>
			
							<%-- <s:radio list="#{'00':'ноолуур','0N':'ноос'}" key="subMaterial"
									value="%{subMaterial}" cssClass="clazz"/> --%>
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12">
										<label for="subMaterial" class="control-label col-sm-4 col-lg-4">
											<s:text name="subMaterial" />:
										</label>
										<div class="col-sm-7 col-lg-6">
											<s:select list="materials"
													key="subMaterial"
													value="%{subMaterial}"
													listKey="id"
													listValue="prefix +' '+ description"
													cssClass="clazz form-control" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6" id="errorsubMaterialResult">
										<s:fielderror fieldName="subMaterial" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12">
										<label for="subCategory" class="control-label col-sm-4 col-lg-4">
											<s:text name="subCategory" />:
										</label>
										<div class="col-sm-7 col-lg-6">
											<s:select list="{'W','M','C'}"
													key="subCategory"
													value="%{subCategory}"
													cssClass="clazz form-control" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
										id="errorsubCategoryResult">
										<s:fielderror fieldName="subCategory" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12">
										<label for="subGauge" class="control-label col-sm-4 col-lg-4">
											<s:text name="subGauge" />:
										</label>
										<div class="col-sm-7 col-lg-6">
											<s:select list="{'05','07','12','14'}"
													key="subGauge"
													value="%{subGauge}"
													requiredLabel="true"
													cssClass="clazz form-control" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6" id="errorsubGaugeResult">
										<s:fielderror fieldName="subGauge" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12">
										<label for="subProductTypeString" class="control-label col-sm-4 col-lg-4">
											<s:text name="subProductTypeString" />:
										</label>
										<div class="col-sm-7 col-lg-6">
											<s:select list="productTypes"
													listKey="id"
													key="subProductTypeString"
													listValue="prefix +' '+name"
													value="%{subProductTypeString}"
													cssClass="clazz form-control" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6" id="errorsubProductTypeStringResult">
										<s:fielderror fieldName="subProductTypeString" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12">
										<label for="subNumber" class="control-label col-sm-4 col-lg-4">
											<s:text name="subNumber" />:
										</label>
										<div class="col-sm-7 col-lg-6">
											<s:textfield id="subNumber" cssClass="form-control" key="subNumber" maxLength="3" value="%{subNumber}" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6" id="errorsubNumberResult">
										<s:fielderror fieldName="subNumber" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12">
										<label for="yarnNumber" class="control-label col-sm-4 col-lg-4">
											<s:text name="yarnNumber" />:
										</label>
										<div class="col-sm-7 col-lg-6">
											<s:textfield key="yarnNumber" cssClass="form-control" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6" id="erroryarnNumberResult">
										<s:fielderror fieldName="yarnNumber" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12">
										<label for="listColor" class="control-label col-sm-4 col-lg-4">
											<s:text name="listColor"></s:text>
										</label>
										<div class="col-sm-4 col-lg-4" id="listcolordiv">
											<s:iterator value="listOfColorPercent" status="stat" begin="0" end="listOfColorPercent.size-1" id="iterate">
												<div class="row">
													<label for="2" class="control-label col-sm-4 col-lg-4">
														<s:text name="%{#stat.index+1} -р өнгө" />
													</label>
													<div class="col-sm-4 col-lj-4">
														<s:textfield name="listOfColorPercent[%{#stat.index}]" />
													</div>
												</div>
											</s:iterator>
										</div>
										<button class="btn btn-info btn-small" id="plus-btn">
											<i class="icon-plus icon-only"></i>
										</button>
										<button class="btn btn-info btn-small" id="minus-btn">
											<i class="icon-minus icon-only"></i>
										</button>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6" id="errorlistColorResult">
										<s:fielderror fieldName="listColor" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12">
										<label for="stoll" class="control-label col-sm-4 col-lg-4">
											<s:text name="stoll" />:
										</label>
										<div class="col-sm-7 col-lg-6">
											<s:textfield key="stoll" cssClass="form-control" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6" id="errorstollResult">
										<s:fielderror fieldName="stoll" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12">
										<label for="chordPrice" class="control-label col-sm-4 col-lg-4">
											<s:text name="chordPrice" />:
										</label>
										<div class="col-sm-7 col-lg-6">
											<s:textfield key="chordPrice" cssClass="form-control" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6" id="errorchordPriceResult">
										<s:fielderror fieldName="chordPrice" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12">
										<label for="unitChordPrice" class="control-label col-sm-4 col-lg-4">
											<s:text name="unitChordPrice" />:
										</label>
										<div class="col-sm-7 col-lg-6">
											<s:textfield key="unitChordPrice" cssClass="form-control" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6" id="errorunitChordPriceResult">
										<s:fielderror fieldName="unitChordPrice" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12">
										<label for="aidPrice" class="control-label col-sm-4 col-lg-4">
											<s:text name="aidPrice" />:
										</label>
										<div class="col-sm-7 col-lg-6">
											<s:textfield key="aidPrice" cssClass="form-control" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6" id="erroraidPriceResult">
										<s:fielderror fieldName="aidPrice" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12">
										<label for="percent" class="control-label col-sm-4 col-lg-4">
											<s:text name="percent" />:
										</label>
										<div class="col-sm-7 col-lg-6">
											<s:textfield key="percent" cssClass="form-control" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6" id="errorpercentResult">
										<s:fielderror fieldName="percent" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12">
										<label for="sellPrice" class="control-label col-sm-4 col-lg-4">
											<s:text name="sellPrice" />:
										</label>
										<div class="col-sm-7 col-lg-6">
											<s:textfield key="sellPrice" cssClass="form-control" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6" id="errorsellPriceResult">
										<s:fielderror fieldName="sellPrice" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-sm-12">
										<label for="description" class="control-label col-sm-4">
											<s:text name="description" />:
										</label>
										<div class="col-sm-7 col-lg-6">
											<s:textarea key="description" cssClass="form-control" />
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
										id="errordescriptionResult">
										<s:fielderror fieldName="description" />
									</div>
								</div>
							</div>
							<s:iterator value="listOfStepPrice" status="stat">
								<div class="form-group">
									<div class="row">
										<div class="col-sm-12">
											<label for="" class="control-label col-sm-4 col-lg-4">
												<s:property value="productStep.name" />:
											</label>
											<div class="col-sm-7 col-lg-6">
												<s:textfield name="price" readonly="true" cssClass="form-control" />
											</div>
										</div>
									</div>
								</div>
							</s:iterator>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-2">
									<a href='<s:url action="productModels"></s:url>' class="btn btn-block">
										<span class="icon-arrow-left"></span>&nbsp;
										<s:text name="back" />
									</a>
								</div>
								<div class="col-sm-2">
									<a href='<s:url action="savePmPrice?model.id=%{id}"></s:url>' class="btn btn-warning btn-block" id="editPrice">
										<span class="icon-pencil"></span>&nbsp;
										<s:text name="editPrice" />
									</a>
								</div>
								<s:if test="%{#session.checkVal == true}">
									<div class="col-sm-2">
										<a href='editSteps?model.id=${model.id}' class="btn btn-warning btn-block" id="editStep">
											<s:text name="editSteps" />
										</a>
									</div>
								</s:if>
								<div class="col-sm-2">
									<button type="submit" id="save" class="btn btn-success btn-block">
										<span class="icon-save"></span>&nbsp;
										<s:text name="save" />
									</button>
								</div>
								<s:if test="%{#session.checkVal == true}">
									<div class="col-sm-2">
										<a href="deleteProductModel?id=${id}&modelId=${modelId}" class="btn btn-danger btn-block" id="delete">
											<span class="icon-trash"></span>&nbsp;
											<s:text name="delete" />
										</a>
									</div>
								</s:if>
							</div>
						</s:form>
						<%
							request.getSession().removeAttribute("checkVal");
						%>
					</div>
					
					<div class="tab-pane" id="imageTab">
						<div class="row">
							<div class="col-sm-2">
	    						<button class="btn btn-sm btn-success btn-block" id="addImageBtn">
	    							<i class="icon-plus"></i>
	    							Зураг нэмэх
	    						</button>
	    					</div>
	    					<div class="col-sm-2">
	    						<button class="btn btn-sm btn-info btn-block" id="setMainImageBtn">
	    							<i class="icon-home"></i>
	    							Нүүр зураг
	    						</button>
	    					</div>
	    					<div class="col-sm-2">
	    						<button class="btn btn-sm btn-danger btn-block" id="deleteImagesBtn">
	    							<i class="icon-trash"></i>
	    							Устгах
	    						</button>
	    					</div>
	    					<div class="col-sm-6">
	    						<div class="progress" data-percent="" id="progress">
	    							<div class="progress-bar" style="width: 0%;"></div>
								</div>
	    					</div>
    					</div>
    					<div class="space-6"></div>
    					<div class="row">
							<table class="table table-striped" id="imageTable">
								<thead>
									<tr>
										<th class="center">
											<label>
												<input type="checkbox" class="ace"></input>
												<span class="lbl"></span>
											</label>
										</th>
										<th>Зураг</th>
										<th>Нэр</th>
										<th>Хэмжээ</th>
										<th>Төлөв</th>
										<th>Үйлдэл</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${productModel.imageList}" var="image">
										<tr data-id="${image.id}"
											<c:if test="${image.isMain == 'true'}">
												data-main-image="true"
											</c:if>>
											<td class="center">
												<label>
													<input type="checkbox" class="ace"></input>
													<span class="lbl"></span>
												</label>
											</td>
											<td>
												<a href="../uploads/${image.name}" onclick="return hs.expand(this)" class="highslide">
													<img src="../uploads/${image.name}" alt="${image.name}" title="Дарж томруулна уу" width="80" height="80" />
												</a>
											</td>
											<td>
												<a href="../uploads/${image.name}">${image.name}</a>
											</td>
											<td></td>
											<td>
												<c:choose>
													<c:when test="${image.isMain == 'true'}">
														<span class="label label-info arrowed">
															Үндсэн
														</span>
													</c:when>
													<c:otherwise>
														<span class="label label-success">
															Хадгалагдсан
														</span>
													</c:otherwise>
												</c:choose>
											</td>
											<td>
												<div class="btn-group">
													<c:if test="${image.isMain == 'false'}">
														<button class="btn btn-sm btn-info set-main-image-btn">
															<i class="icon-home"></i> 
															Нүүр зураг
														</button>
													</c:if>
													<button class="btn btn-sm btn-danger delete-image-btn">
														<i class="icon-trash"></i> 
														Устгах
													</button>
												</div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
								<tfoot>
									<tr class="hidden">
										<td colspan="6">
											<form method="POST" enctype="multipart/form-data" id="uploadForm">
												<s:hidden key="id" id="productModelId" />
												<input type="file" name="im" accept="image/png, image/jpeg, image/gif, image/bmp" id="imageUpload" multiple />
											</form>
										</td>
									</tr>
								</tfoot>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="../js/highslide-full.js"></script>
<script src="../js/PageJS/productModelEdit.js"></script>
<script type="text/javascript">
$(document).ready(function()
{
	initHS();
	initEvents();
	imageUploadEvent();
	initTableEvents();
});

function initHS()
{
	hs.graphicsDir = '../css/graphics/';
	hs.align = 'center';
	hs.transitions = ['expand', 'crossfade'];
	hs.wrapperClassName = 'dark borderless';
	hs.fadeInOut = true;
	hs.dimmingOpacity = .75;
	
	if (hs.addSlideshow)
		hs.addSlideshow(
		{
			interval: 5000,
			repeat: false,
			useControls: true,
			fixedControls: 'fit',
			overlayOptions:
			{
				opacity: .6,
				position: 'bottom center',
				hideOnMouseOut: true
			}
		});
}

function initTableEvents()
{
	$("#imageTable tbody tr input:checkbox").click(function(event)
  	{
  		if ($(this).prop('checked'))
  			$(this).parents("tr:eq(0)").addClass("success");
  		else
  			$(this).parents("tr:eq(0)").removeClass("success");
  	});
	
	$(".set-main-image-btn").click(function(event)
	{
		event.preventDefault();
		var id = $(this).parents("tr:eq(0)").attr("data-id");
		$.ajax(
		{
			url: "set-main-image-pm",
			data:
			{
				"id": $("#productModelId").val(),
				"imageId": id
			},
			beforeSend: function(xhr)
			{
				$("#loadingDialog").dialog("open");
			},
			success: function(result)
			{
				$("#imageTable tbody").html(result);
				initTableEvents();
				if(last_gritter)
					$.gritter.remove(last_gritter);
				last_gritter = $.gritter.add(
				{
					title: 'Мэдээлэл',
					text: 'Зургийг амжилттай заслаа!',
					class_name: 'gritter-info gritter-right'
				});
				setTimeout(function()
				{
					$.gritter.remove(last_gritter);
				}, 4000);
			},
			complete: function(xhr, status)
			{
				$("#loadingDialog").dialog("close");
			}
		});
	});
	
	$(".delete-image-btn").click(function(event)
	{
		event.preventDefault();
		var id = $(this).parents("tr:eq(0)").attr("data-id");
		var ids = [];
		ids[0] = id;
		$.ajax(
		{
			url: "delete-pm-images",
			data:
			{
				"id": $("#productModelId").val(),
				"imageIds": ids
			},
			beforeSend: function(xhr)
			{
				$("#loadingDialog").dialog("open");
			},
			success: function(result)
			{
				$("#imageTable tbody tr[data-id='" + id + "']").remove();
				if(last_gritter)
					$.gritter.remove(last_gritter);
				last_gritter = $.gritter.add(
				{
					title: 'Мэдээлэл',
					text: 'Зургийг амжилттай устгалаа!',
					class_name: 'gritter-info gritter-right'
				});
				setTimeout(function()
				{
					$.gritter.remove(last_gritter);
				}, 4000);
			},
			complete: function(xhr, status)
			{
				$("#loadingDialog").dialog("close");
			}
		});
	});
}

function imageUploadEvent()
{
	$("#imageUpload").change(function(event)
	{
		var invalid = false;
		var invalidFiles = [];
		var files = $(this)[0].files;
		for (var i = 0; i < files.length; i++)
		{
			var file = files[i];
			var allowedFileTypes = ["image/png", "image/jpeg", "image/gif", "image/bmp"];
			if (!(allowedFileTypes.indexOf(file.type) > -1))
			{
				invalidFiles.push(file);
				invalid = true;
			}
			else
			{
				if (file.size > 5500000)
				{
					invalidFiles.push(file);
					invalid = true;
				}
			}
		}
		
		if (invalid)
		{
			var str = "<ul>";
			for (var i = 0; i < invalidFiles.length; i++)
			{
				str = str + "<li>" + invalidFiles[i].name + " - " + convertBytes(invalidFiles[i].size) + "</li>";
			}
			str = str + "</ul>";
			$("#uploadForm")[0].reset();
			if(last_gritter)
				$.gritter.remove(last_gritter);
			last_gritter = $.gritter.add(
			{
				title: 'Алдаа',
				text: '<ul><li>Зургийн хэмжээ 5MB-с хэтрэх ёсгүй!</li><li>JPG, GIF, PNG, BMP формат(өргөтгөл)-тай зураг байх!</li></ul>Хуулах боломжгүй файлууд: ' + str,
				class_name: 'gritter-error gritter-center'
			});
			setTimeout(function()
			{
				$.gritter.remove(last_gritter);
			}, 4000);
		}
		else
		{
			var formData = new FormData($("#uploadForm")[0]);
			$.ajax(
			{
				url: "save-pm-images",
		  		data: formData,
		  		type: "POST",
		  		processData: false,
		  		contentType: false,
		  		beforeSend: function(xhr)
		  		{
		  			$("#progress").attr("data-percent", "Эхлэж байна!");
		  			$("#progress").addClass("progress-striped active");
		  			$("#progress .progress-bar").css("width", "0%");
		  		},
		  		xhr: function()
  				{
  					var xhr = new window.XMLHttpRequest();
  					xhr.upload.addEventListener("progress", function(event)
  					{
  						if (event.lengthComputable)
  						{
  							var percentComplete = Math.round((event.loaded / event.total) * 100);
  							$("#progress").attr("data-percent", percentComplete + "%");
  							$("#progress .progress-bar").css("width", percentComplete + "%");
  						}
  					}, false);
  					return xhr;
  				},
		  		success: function(result)
		  		{
		  			$("#progress").removeClass("progress-striped active");
		  			$("#progress").attr("data-percent", "Амжилттай хууллаа!");
		  			$("#imageTable tbody").html(result);
		  			initTableEvents();
		  			if(last_gritter)
						$.gritter.remove(last_gritter);
					last_gritter = $.gritter.add(
					{
						title: 'Амжилттай хадгаллаа',
						text: 'Зурагнуудыг амжилттай хадгаллаа!',
						class_name: 'gritter-success gritter-right'
					});
					setTimeout(function()
					{
						$("#progress").attr("data-percent", "");
						$.gritter.remove(last_gritter);
					}, 3000);
		  		}
			});
		}
	});
}

function initEvents()
{
	$("#addImageBtn").click(function(event)
	{
		event.preventDefault();
		$("#imageUpload").trigger("click");
	});
	
	$('#imageTable thead th input:checkbox').on('click' , function()
	{
		var that = this;
		$(this).closest('table').find('tr > td:first-child input:checkbox').each(function()
		{
			this.checked = that.checked;
			if ($(this).prop('checked'))
				$(this).parents("tr:eq(0)").addClass("success");
			else
				$(this).parents("tr:eq(0)").removeClass("success");
		});
	});
	
	$("#deleteImagesBtn").click(function(event)
	{
		event.preventDefault();
		if ($("#imageTable tbody tr.success").length > 0)
		{
			var ids = [];
			for (var i = 0; i < $("#imageTable tbody tr.success").length; i++)
			{
				ids[i] = $("#imageTable tbody tr.success").eq(i).attr("data-id");
			}
			
			$.ajax(
			{
				url: "delete-pm-images",
				data:
				{
					"id": $("#productModelId").val(),
					"imageIds": ids
				},
				beforeSend: function(xhr)
				{
					$("#loadingDialog").dialog("open");
				},
				success: function(result)
				{
					$("#imageTable tbody tr.success").remove();
					if (last_gritter)
						$.gritter.remove(last_gritter);
					last_gritter = $.gritter.add(
					{
						title: 'Мэдээлэл',
						text: 'Зурагнуудыг амжилттай устгалаа!',
						class_name: 'gritter-info gritter-right'
					});
					setTimeout(function()
					{
						$.gritter.remove(last_gritter);
					}, 3000);
				},
				complete: function(xhr, status)
				{
					$("#loadingDialog").dialog("close");
				}
			});
		}
		else
		{
			if (last_gritter)
				$.gritter.remove(last_gritter);
			last_gritter = $.gritter.add(
			{
				title: 'Анхааруулга',
				text: 'Та ямар нэгэн зураг сонгоогүй байна.<br/>Устгах зурагнуудаа сонгоно уу!',
				class_name: 'gritter-warning gritter-center'
			});
			setTimeout(function()
			{
				$.gritter.remove(last_gritter);
			}, 3500);
		}
	});
	
	$("#setMainImageBtn").click(function(event)
	{
		event.preventDefault();
		if ($("#imageTable tbody tr.success").length == 1)
		{
			var isMain = $("#imageTable tbody tr.success").attr("data-main-image");
			if (isMain == 'true')
			{
				if (last_gritter)
					$.gritter.remove(last_gritter);
				last_gritter = $.gritter.add(
				{
					title: 'Анхааруулга',
					text: 'Таны сонгосон зураг үндсэн зураг байна.<br/>Бусад зураг сонгоно уу!',
					class_name: 'gritter-warning gritter-center'
				});
				setTimeout(function()
				{
					$.gritter.remove(last_gritter);
				}, 3500);
			}
			else
			{
				var id = $("#imageTable tbody tr.success").attr("data-id");
				$.ajax(
				{
					url: "set-main-image-pm",
					data:
					{
						"id": $("#productModelId").val(),
						"imageId": id
					},
					beforeSend: function(xhr)
					{
						$("#loadingDialog").dialog("open");
					},
					success: function(result)
					{
						$("#imageTable tbody").html(result);
						initTableEvents();
						if(last_gritter)
							$.gritter.remove(last_gritter);
						last_gritter = $.gritter.add(
						{
							title: 'Мэдээлэл',
							text: 'Зургийг амжилттай заслаа!',
							class_name: 'gritter-info gritter-right'
						});
						setTimeout(function()
						{
							$.gritter.remove(last_gritter);
						}, 4000);
					},
					complete: function(xhr, status)
					{
						$("#loadingDialog").dialog("close");
					}
				});
			}
		}
		else if ($("#imageTable tbody tr.success").length == 0)
		{
			if (last_gritter)
				$.gritter.remove(last_gritter);
			last_gritter = $.gritter.add(
			{
				title: 'Анхааруулга',
				text: 'Та ямар нэгэн зураг сонгоогүй байна.<br/>Нэг зураг сонгоно уу!',
				class_name: 'gritter-warning gritter-center'
			});
			setTimeout(function()
			{
				$.gritter.remove(last_gritter);
			}, 3500);
		}
		else
		{
			if (last_gritter)
				$.gritter.remove(last_gritter);
			last_gritter = $.gritter.add(
			{
				title: 'Анхааруулга',
				text: 'Та нэгээс илүү зураг сонгосон байна.<br/>Зөвхөн нэг зураг сонгоно уу!',
				class_name: 'gritter-warning gritter-center'
			});
			setTimeout(function()
			{
				$.gritter.remove(last_gritter);
			}, 3500);
		}
	});
}
</script>