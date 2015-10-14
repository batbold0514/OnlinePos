<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%-- <link rel="stylesheet" type="text/css" media="screen" href='../turshilt/jquery-ui-1.8.16.custom.css' />
<script type='text/javascript' src='../turshilt/util.js'></script>
<script type='text/javascript' src='../turshilt/jquery-fileupload/vendor/jquery.ui.widget.js'></script>
<script type='text/javascript' src='../turshilt/jquery-fileupload/jquery.iframe-transport.js'></script>
<script type='text/javascript' src='../turshilt/jquery-fileupload/jquery.fileupload.js'></script> --%>
<div class="hidden" id="page">
	<s:url action="productModel" includeParams="none" />
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			Загвар<small> <i class="icon-double-angle-right"></i> Нэмэх
			</small>
		</h2>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-header widget-header-blue widget-header-flat">
							<h4 class="lighter">Загвар нэмэх үе шат</h4>
						</div>

						<div class="widget-body">
							<div class="widget-main">
								<div id="fuelux-wizard" class="row-fluid"
									data-target="#step-container">
									<ul class="wizard-steps">
										<li data-target="#step1" class="active"><span
											class="step">1</span> <span class="title">Үндсэн
												өгөгдөл</span></li>

										<li data-target="#step2"><span class="step">2</span> <span
											class="title">Дамжлагын үнэ</span></li>
									</ul>
								</div>

								<hr />
								<div class="step-content row-fluid position-relative"
									id="step-container">
									<div class="step-pane active" id="step1">
										<s:form action="" enctype="multipart/form-data" id="addForm"
											cssClass="form-horizontal">
											<s:push value="productModel">
												<s:hidden key="id" />
												<s:hidden key="modelId" />
												<div class="form-group">
													<div class="row">
														<div class="col-sm-12">
															<label for="subMaterial"
																class="control-label col-sm-4 col-lg-4"> <s:text
																	name="subMaterial" />(*):
															</label>
															<div class="col-sm-5 col-lg-4">
																<s:select list="materials" key="subMaterial"
																	headerKey="-1" headerValue=" " listKey="id"
																	value="%{#session.subMaterial}"
																	listValue="prefix +' '+ description"
																	cssClass="clazz form-control input-sm" />
															</div>
														</div>
													</div>
													<div class="row">
														<div
															class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
															id="errorsubMaterialResult">
															<s:fielderror fieldName="subMaterial" />
														</div>
													</div>
												</div>
												<div class="form-group">
													<div class="row">
														<div class="col-sm-12">
															<label for="subCategory"
																class="control-label col-sm-4 col-lg-4"> <s:text
																	name="subCategory" />(*):
															</label>
															<div class="col-sm-5 col-lg-4">
																<s:select list="{'W','M','C'}" key="subCategory"
																	headerKey="-1" headerValue=""
																	value="%{#session.subCategory}" id="focus"
																	cssClass="clazz form-control input-sm" />
															</div>
														</div>
													</div>
													<div class="row">
														<div
															class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
															id="errorsubCategoryResult">
															<s:fielderror fieldName="subCategory" />
														</div>
													</div>
												</div>
												<div class="form-group">
													<div class="row">
														<div class="col-sm-12">
															<label for="subGauge"
																class="control-label col-sm-4 col-lg-4"> <s:text
																	name="subGauge" />(*):
															</label>
															<div class="col-sm-5 col-lg-4">
																<s:select list="{'05','07','12','14'}" key="subGauge"
																	value="%{#session.subGauge}" headerKey="-1"
																	headerValue="" cssClass="clazz form-control input-sm" />
															</div>
														</div>
													</div>
													<div class="row">
														<div
															class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
															id="errorsubGaugeResult">
															<s:fielderror fieldName="subGauge" />
														</div>
													</div>
												</div>
												<div class="form-group">
													<div class="row">
														<div class="col-sm-12">
															<label for="subProductTypeString"
																class="control-label col-sm-4 col-lg-4"> <s:text
																	name="subProductTypeString" />(*):
															</label>
															<div class="col-sm-5 col-lg-4">
																<s:select list="productTypes" listKey="id"
																	key="subProductTypeString" listValue="prefix +' '+name"
																	value="%{#session.subProductType.id}" headerKey="-1"
																	headerValue="" cssClass="clazz form-control input-sm" />
															</div>
														</div>
													</div>
													<div class="row">
														<div
															class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
															id="errorsubProductTypeStringResult">
															<s:fielderror fieldName="subProductTypeString" />
														</div>
													</div>
												</div>
												<div class="form-group">
													<div class="row">
														<div class="col-sm-12">
															<label for="subNumber"
																class="control-label col-sm-4 col-lg-4"> <s:text
																	name="subNumber" />(*):
															</label>
															<div class="col-sm-5 col-lg-4">
																<s:textfield id="subNumber" key="subNumber"
																	maxLength="3" cssClass="form-control input-sm" />
															</div>
														</div>
													</div>
													<div class="row">
														<div
															class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
															id="errorsubNumberResult">
															<s:fielderror fieldName="subNumber" />
														</div>
													</div>
												</div>
												<div class="form-group">
													<div class="row">
														<div class="col-sm-12">
															<label for="yarnNumber"
																class="control-label col-sm-4 col-lg-4"> <s:text
																	name="yarnNumber" />(*):
															</label>
															<div class="col-sm-5 col-lg-4">
																<s:textfield key="yarnNumber"
																	cssClass="form-control input-sm" />
															</div>
														</div>
													</div>
													<div class="row">
														<div
															class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
															id="erroryarnNumberResult">
															<s:fielderror fieldName="yarnNumber" />
														</div>
													</div>
												</div>
												<div class="form-group">
													<div class="row">
														<div class="col-sm-12">
															<label for="listColor"
																class="control-label col-sm-4 col-lg-4"> <s:text
																	name="listColor"></s:text>
															</label>
															<div class="col-sm-2 col-lg-2" id="listcolordiv">
																<s:iterator value="listOfColorPercent" status="stat"
																	begin="0" end="listOfColorPercent.size-1" id="iterate">
																	<div class="row">
																		<label for="2" class="control-label col-sm-6 col-lg-6">
																			<s:text name="%{#stat.index+1} -р өнгө" />
																		</label>
																		<div class="col-sm-6 col-lj-6">
																			<s:textfield
																				name="listOfColorPercent[%{#stat.index}]" />
																		</div>
																	</div>
																</s:iterator>
															</div>
															<div class="col-sm-offset-1 col-sm-3">
															<button class="btn btn-info btn-small" id="plus-btn">
																<i class="icon-plus icon-only"></i>
															</button>
															<button class="btn btn-info btn-small" id="minus-btn">
																<i class="icon-minus icon-only"></i>
															</button>
															</div>
														</div>
													</div>
													<div class="row">
														<div
															class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
															id="errorlistColorResult">
															<s:fielderror fieldName="listColor" />
														</div>
													</div>
												</div>
												<div class="form-group">
													<div class="row">
														<div class="col-sm-12">
															<label for="status"
																class="control-label col-sm-4 col-lg-4"> <s:text
																	name="status" />(*):
															</label>
															<div class="col-sm-5 col-lg-4">
																<s:select key="status" list="productModelActivity"
																	listValue="label" value="%{#session.product.status.id}"
																	cssClass="form-control input-sm" />
															</div>
														</div>
													</div>
													<div class="row">
														<div
															class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
															id="errorstatusResult">
															<s:fielderror fieldName="status" />
														</div>
													</div>
												</div>
												<div class="form-group">
													<div class="row">
														<div class="col-sm-12">
															<label for="stoll"
																class="control-label col-sm-4 col-lg-4"> <s:text
																	name="stoll" />(*):
															</label>
															<div class="col-sm-5 col-lg-4">
																<s:textfield key="stoll"
																	cssClass="form-control input-sm"
																	value="%{#session.product.stoll}"
																	title="Столл цаг сөрөг биш байна.                                    Бутархай тоо цэгээр тусгаарлагдана"></s:textfield>
															</div>
														</div>
													</div>
													<div class="row">
														<div
															class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
															id="errorstollResult">
															<s:fielderror fieldName="stoll" />
														</div>
													</div>
												</div>
												<div class="form-group">
													<div class="row">
														<div class="col-sm-12">
															<label for="chordPrice"
																class="control-label col-sm-4 col-lg-4"> <s:text
																	name="chordPrice" />(*):
															</label>
															<div class="col-sm-5 col-lg-4">
																<s:textfield key="chordPrice"
																	value="%{#session.product.chordPrice}"
																	cssClass="form-control input-sm" />
															</div>
														</div>
													</div>
													<div class="row">
														<div
															class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
															id="errorchordPriceResult">
															<s:fielderror fieldName="chordPrice" />
														</div>
													</div>
												</div>
												<div class="form-group">
													<div class="row">
														<div class="col-sm-12">
															<label for="unitChordPrice"
																class="control-label col-sm-4 col-lg-4"> <s:text
																	name="unitChordPrice" />(*):
															</label>
															<div class="col-sm-5 col-lg-4">
																<s:textfield key="unitChordPrice"
																	value="%{#session.product.unitChordPrice}"
																	cssClass="form-control input-sm" />
															</div>
														</div>
													</div>
													<div class="row">
														<div
															class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
															id="errorunitChordPriceResult">
															<s:fielderror fieldName="unitChordPrice" />
														</div>
													</div>
												</div>
												<div class="form-group">
													<div class="row">
														<div class="col-sm-12">
															<label for="aidPrice"
																class="control-label col-sm-4 col-lg-4"> <s:text
																	name="aidPrice" />(*):
															</label>
															<div class="col-sm-5 col-lg-4">
																<s:textfield key="aidPrice"
																	value="%{#session.product.aidPrice}"
																	cssClass="form-control input-sm" />
															</div>
														</div>
													</div>
													<div class="row">
														<div
															class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
															id="erroraidPriceResult">
															<s:fielderror fieldName="aidPrice" />
														</div>
													</div>
												</div>
												<div class="form-group">
													<div class="row">
														<div class="col-sm-12">
															<label for="percent"
																class="control-label col-sm-4 col-lg-4"> <s:text
																	name="percent" />(*):
															</label>
															<div class="col-sm-5 col-lg-4">
																<s:textfield key="percent"
																	value="%{#session.product.percent}"
																	cssClass="form-control input-sm" />
															</div>
														</div>
													</div>
													<div class="row">
														<div
															class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
															id="errorpercentResult">
															<s:fielderror fieldName="percent" />
														</div>
													</div>
												</div>
												<div class="form-group">
													<div class="row">
														<div class="col-sm-12">
															<label for="sellPrice"
																class="control-label col-sm-4 col-lg-4"> <s:text
																	name="sellPrice" />(*):
															</label>
															<div class="col-sm-5 col-lg-4">
																<s:textfield key="sellPrice"
																	value="%{#session.product.sellPrice}"
																	cssClass="form-control input-sm" />
															</div>
														</div>
													</div>
													<div class="row">
														<div
															class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
															id="errorsellPriceResult">
															<s:fielderror fieldName="sellPrice" />
														</div>
													</div>
												</div>
												<%
													if (request.getSession().getAttribute("listofs") != null) {
												%>
												<div class="form-group">
													<div class="row">
														<div class="col-sm-12">
															<label for="listOfStep.id"
																class="control-label col-sm-4 col-lg-4"> <s:text
																	name="listOfStep.id" />(*):
															</label>
															<div class="col-sm-5 col-lg-4">
																<s:select key="listOfStep.id" cssClass="multiselect"
																	list="productStepList" listKey="id" listValue="name"
																	multiple="true" value="%{#session.listofs.{id}}"
																	cssClass="form-control input-sm" />
															</div>
														</div>
													</div>
													<div class="row">
														<div
															class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
															id="errorlistOfStep.idResult">
															<s:fielderror fieldName="listOfStep.id" />
														</div>
													</div>
												</div>

												<%
													;
															} else {
												%>
												<div class="form-group">
													<div class="row">
														<div class="col-sm-12">
															<label for="listOfStep.id"
																class="control-label col-sm-4 col-lg-4"> <s:text
																	name="listOfStep.id" />(*):
															</label>
															<div class="col-sm-5 col-lg-4">
																<s:select key="listOfStep.id" list="productStepList"
																	listKey="id" listValue="name"
																	data-placeholder="Дамжлага сонгоно уу!!"
																	multiple="true"
																	cssClass="chosen-select form-control input-sm" />
															</div>
														</div>
													</div>
													<div class="row">
														<div
															class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
															id="errorlistOfStep.idResult">
															<s:fielderror fieldName="listOfStep.id" />
														</div>
													</div>
												</div>
												<%
													;
															}
												%>
												<div class="form-group">
													<div class="row">
														<div class="col-sm-12">
															<label for="description"
																class="control-label col-sm-4 col-lg-4"> <s:text
																	name="description" />(*):
															</label>
															<div class="col-sm-5 col-lg-4">
																<s:textarea key="description" cols="20" rows="6"
																	value="%{#session.product.description}"
																	cssClass="form-control input-sm" />
															</div>
														</div>
													</div>
													<div class="row">
														<div
															class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
															id="errordescriptionResult">
															<s:fielderror fieldName="description" />
														</div>
													</div>
												</div>
												<div class="form-group">
												<div class="row">
													<div class="col-sm-12">
														<label for="im" class="control-label col-sm-4 col-lg-4">
															<s:text name="im" />(*):
														</label>
														<div class="col-sm-5 col-lg-4">
															<%-- <s:file key="im" cssClass="imageInput" /> --%>
															<input name="im" type="file" id="id-input-file-3" multiple />
														</div>
													</div>
												</div>
												<div class="row">
													<div
														class="col-sm-offset-4 col-sm-7 col-lg-offset-3 col-lg-6"
														id="errorimResult">
														<s:fielderror fieldName="im" />
													</div>
												</div>
											</div>
											</s:push>
										</s:form>
									</div>

									<div class="step-pane" id="step2">
										<div id="change-result"></div>
									</div>
								</div>

								<hr />
								<div class="row-fluid wizard-actions">
									<button class="btn btn-prev">
										<i class="icon-arrow-left"></i> Өмнөх
									</button>

									<button id="next" class="btn btn-success btn-next"
										data-last="Хадгалах ">
										Дараах <i class="icon-arrow-right icon-on-right"></i>
									</button>
								</div>
							</div>
							<!-- /widget-main -->
						</div>
						<!-- /widget-body -->
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="parseResult" class=hidden></div>
<script src="../js/PageJS/productModel.js"></script>