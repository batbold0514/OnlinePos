<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:form action="customer-save" enctype="multipart/form-data" cssClass="form-horizontal" id="editForm">
		<s:hidden name="id"  id="customerId" />
		<div class="tabbable tabbable-custom boxless">
			<ul class="nav nav-tabs">
				<li><a href="#tabEdit0" data-toggle="tab" class="customerDialogTab"><s:text
							name="mainInformatioin" /></a></li>
				<li class="customerDialogTab"><a href="#tabEdit1" data-toggle="tab"><s:text
							name="extraInformatioin" /></a></li>
				<li class="customerDialogTab active"><a href="#tabEdit2"
					data-toggle="tab"><s:text name="crashInformation" /></a></li>
					<li class="customerDialogTab"><a href="#tabEdit3"
					data-toggle="tab"><s:text name="pictures" /></a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane" id="tabEdit0">
				 
					<div class="row">
						<div class="col-sm-6 col-lg-6">
							<div class="form-group">
								<div class = "row">
									<label for="company" class="control-label col-sm-6 col-lg-6"><s:text name="company" /></label>
									<div class = "col-sm-6 col-lg-6">
										<s:select list="companies" name="companyStr" listKey="id"
											listValue="compName" cssClass="dselect"
											headerKey="" headerValue="" value="%{#session.customer.company.id}"></s:select>
									</div>
								</div>
								<div class = "row" id = "companyStrEditResult">
									<s:fielderror fieldName="companyStrEdit"/>
								</div>
							</div>
						</div>
						<div class="col-sm-5 col-lg-5">
							<div class="form-group">
								<div class="row">
									<label for="itype" class="control-label col-sm-6 col-lg-6">
										<s:text name="itype"></s:text>
									</label>
									<div class="col-sm-6 col-lg-6">
										<s:select list="itypes" name="itypeStr" listKey="id"
											listValue="type" cssClass="dselect" value = "%{#session.customer.itype.id}"></s:select>
									</div>
								</div>
								<div class = "row" id = "itypeStrEditResult">
									<s:fielderror fieldName="itypeStrEdit"/>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6 col-lg-6">
							<div class="form-group">
								<div class = "row">
									<label for="date" class="control-label col-sm-6 col-lg-6">
										<s:text name="date" />
									</label>
									<div class="col-sm-6 col-lg-6">
										<div class = "input-group">
											<s:textfield name="dateStr" value = "%{getText('{0,date,YYYY-MM-dd}',{#session.customer.date})}" cssClass="datePicker form-control" />
											<span class="input-group-addon">
												<i class = "fa fa-calendar"></i>
											</span>
										</div>
									</div>
								</div>
								<div class = "row" id = "dateStrEditResult">
									<s:fielderror fieldName="dateStrEdit"/>
								</div>
							</div>
						</div>
						<div class="col-sm-5 col-lg-5">
							<div class="form-group">
								<div class = "row">
									<label for="color" class="control-label col-sm-6 col-lg-6">
										<s:text name="color"></s:text>
									</label>
									<div class="col-sm-6 col-lg-6">
										<s:textfield name="color" value = "%{#session.customer.color}" cssClass="form-control"></s:textfield>
									</div>
								</div>
								<div class = "row" id = "colorEditResult">
									<s:fielderror fieldName="colorEdit"/>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6 col-lg-6">
							<div class="form-group">
								<div class = "row">
									<label for="carFactory" class="control-label col-sm-6 col-lg-6">
										<s:text name="carFactory" />
									</label>
									<div class="col-sm-6 col-lg-6">
										<s:select list="factories" name="factoryStr" listKey="id"
											listValue="factoryName" id="factorySelectEdit" headerKey=""  value = "%{#session.customer.carFactory.id}"
											headerValue="" cssClass=" dselect"></s:select>
									</div>
								</div>
								<div class = "row" id = "factoryStrEditResult">
									<s:fielderror fieldName="factoryStrEdit"/>
								</div>
							</div>
						</div>
						<div class="col-sm-5 col-lg-5">
							<div class="form-group">
								<div class = "row">
									<label for="vinNumber" class="control-label col-sm-6 col-lg-6">
										<s:text name="vinNumber"></s:text>
									</label>
									<div class="col-sm-6 col-lg-6">
										<s:textfield name="vinNumber" cssClass="form-control" value = "%{#session.customer.vinNumber}"></s:textfield>
									</div>
								</div>
								<div class = "row" id = "vinNumberEditResult">
									<s:fielderror fieldName="vinNumberEdit"/>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6 col-lg-6">
							<div class="form-group">
								<div class = "row">
									<label for="carMark" class="control-label col-sm-6 col-lg-6">
										<s:text name="carMark" />
									</label>
									<div class="col-sm-6 col-lg-6" id="markSelectEdit">
										<s:select list="carmarkList" name="markStr" listKey="id"
											listValue="mark" headerKey="" headerValue="" value = "%{#session.customer.carMark.id}"
											cssClass="dselect"></s:select>
									</div>
								</div>
								<div class = "row" id = "markStrEditResult">
									<s:fielderror fieldName="markStrEdit"/>
								</div>
							</div>
						</div>
						<div class="col-sm-5 col-lg-5">
							<div class="form-group">
								<div class = "row">
									<label for="ownerName" class="control-label col-sm-6 col-lg-6">
										<s:text name="ownerName"></s:text>
									</label>
									<div class="col-sm-6 col-lg-6">
										<s:textfield name="ownerName" cssClass="form-control" value = "%{#session.customer.ownerName}"></s:textfield>
									</div>
								</div>
								<div class = "row" id = "ownerNameEditResult">
									<s:fielderror fieldName="ownerNameEdit"/>
								</div>
							</div>
						</div>
					</div> 
					<div class="row">
						<div class="col-sm-6 col-lg-6">
							<div class="form-group">
								<div class="row">
									<label for="cnumber" class="control-label col-sm-6 col-lg-6">
											<s:text name="cnumber" />
									</label>
									<div class="col-sm-6 col-lg-6">
										<s:textfield name="cnumber" cssClass="form-control" value = "%{#session.customer.cnumber}"></s:textfield>
									</div>
								</div>
								<div class = "row" id = "cnumberEditResult">
									<s:fielderror fieldName="cnumberEdit"/>
								</div>
							</div>
						</div>
						<div class="col-sm-5 col-lg-5">
							<div class="form-group">
								<div class="row">
									<label for="ownerAddress" class="control-label col-sm-6 col-lg-6">
										<s:text name="ownerAddress"></s:text>
									</label>
									<div class="col-sm-6 col-lg-6">
										<s:textfield name="ownerAddress" cssClass="form-control" value = "%{#session.customer.ownerAddress}"></s:textfield>
									</div>
								</div>
								<div class = "row" id = "ownerAddressEditResult">
									<s:fielderror fieldName="ownerAddressEdit"/>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6 col-lg-6">
							<div class="form-group">
								<div class="row">
									<label for="factoryDate" class="control-label col-sm-6 col-lg-6">
										<s:text name="factoryDate" />
									</label>
									<div class="col-sm-6 col-lg-6">
										<s:textfield name="factoryDate" cssClass="form-control" value = "%{#session.customer.factoryDate}"/>
									</div>
								</div>
								<div class = "row" id = "factoryDateEditResult">
									<s:fielderror fieldName="factoryDateEdit"/>
								</div>
							</div>
						</div>
						<div class="col-sm-5 col-lg-5">
							<div class="form-group">
								<div class="row">
									<label for="ownerPhoneNumber"
										class="control-label col-sm-6 col-lg-6"> <s:text
											name="ownerPhoneNumber"></s:text>
									</label>
									<div class="col-sm-6 col-lg-6">
										<s:textfield name="ownerPhoneNumber" cssClass="form-control" value = "%{#session.customer.ownerPhoneNumber}"></s:textfield>
									</div>
								</div>
								<div class = "row" id = "ownerPhoneNumberEditResult">
									<s:fielderror fieldName="ownerPhoneNumberEdit"/>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6 col-lg-6">
							<div class="form-group">
								<div class="row">
									<label for="importedDate" class="control-label col-sm-6 col-lg-6">
										<s:text name="importedDate" />
									</label>
									<div class="col-sm-6 col-lg-6">
										<s:textfield name="importedDate" cssClass="form-control" value = "%{#session.customer.importedDate}"/>
									</div>
								</div>
								<div class = "row" id = "importedDateEditResult">
									<s:fielderror fieldName="importedDateEdit"/>
								</div>
							</div>
						</div>
						<div class="col-sm-5 col-lg-5">
							<div class="form-group">
								<div class="row">
									<label for="estPoint" class="control-label col-sm-6 col-lg-6">
										<s:text name="estPoint"></s:text>
									</label>
									<div class="col-sm-6 col-lg-6">
										<s:textfield name="estPoint" cssClass="form-control" value = "%{#session.customer.estPoint}"></s:textfield>
									</div>
								</div>
								<div class = "row" id = "estPointEditResult">
									<s:fielderror fieldName="estPointEdit"/>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6 col-lg-6">
							<div class="form-group">
								<div class="row">
									<label for="note1" class="control-label col-sm-6 col-lg-6">
										<s:text name="note1" />
									</label>
									<div class="col-sm-6 col-lg-6">
										<s:textarea name="note1" rows="2" cssClass="form-control" value = "%{#session.customer.note1}"></s:textarea>
									</div>
								</div>
								<div class = "row" id = "note1EditResult">
									<s:fielderror fieldName="note1Edit"/>
								</div>
							</div>
						</div>
						<div class="col-sm-5 col-lg-5">
							<div class="form-group">
								<div class="row">
									<label for="marketPrice" class="control-label col-sm-6 col-lg-6">
										<s:text name="marketPrice"></s:text>
									</label>
									<div class="col-sm-6 col-lg-6">
										<s:textfield name="marketPrice" cssClass="form-control" value = "%{#session.customer.marketPrice}"></s:textfield>
									</div>
								</div>
								<div class = "row" id = "marketPriceEditResult">
									<s:fielderror fieldName="marketPriceEdit"/>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="tab-pane" id="tabEdit1">
					<div class = "col-sm-12 col-lg-12">
						<div class = "col-sm-6 col-lg-6">
							<div class="form-group">
								<div class="row">
									<label for="consumer" class="control-label col-sm-4 col-lg-4">
										<s:text name="consumer" />
									</label>
									<div class="col-sm-8 col-lg-8">
										<s:textfield name="consumer" cssClass="form-control " value = "%{#session.customer.consumer}"></s:textfield>
									</div>
								</div>
								<div class = "row" id = "consumerEditResult">
									<s:fielderror fieldName="consumerEdit"/>
								</div>
							</div>
						</div>
						<div class = "col-sm-6 col-lg-5">
							<div class="form-group">
								<div class="row">
									<label for="regnumber" class="control-label col-sm-4 col-lg-4">
										<s:text name="regnumber" />
									</label>
									<div class="col-sm-8 col-lg-8">
										<s:textfield name="regNumber" cssClass="form-control " value = "%{#session.customer.regNumber}"></s:textfield>
									</div>
								</div>
								<div class = "row" id = "regnumberEditResult">
									<s:fielderror fieldName="regnumberEdit"/>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12 col-lg-12">
							<label for="agentConsumer" class="control-label col-sm-3 col-lg-2">
								<s:text name="agentConsumer" />
							</label>
							<div class="col-sm-9 col-lg-10">
								<s:textfield name="agentConsumer" cssClass="form-control " value = "%{#session.customer.agentConsumer}"></s:textfield>
							</div>
						</div>
						<div class = "row" id = "agentConsumerEditResult">
							<s:fielderror fieldName="agentConsumerEdit"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12 col-lg-12">
							<label for="defendant" class="control-label col-sm-3 col-lg-2">
								<s:text name="defendant" />
							</label>
							<div class="col-sm-9 col-lg-10">
								<s:textfield name="defendant" cssClass="form-control " value = "%{#session.customer.defendant}"></s:textfield>
							</div>
						</div>
						<div class = "row" id = "defendantEditResult">
								<s:fielderror fieldName="defendantEdit"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12 col-lg-12">
							<label for="emp" class="control-label col-sm-3 col-lg-2">
								<s:text name="emp"></s:text>
							</label>
							<div class="col-sm-3 col-lg-3">
								<div class= "row">
									<s:select list="employees" name="emp1Str" listKey="id"
										listValue="firstName" headerKey="" headerValue="" value = "%{#session.customer.emp1.id}"
										cssClass="dselect"></s:select>
								</div>
								<div class = "row" id = "emp1StrEditResult">
									<s:fielderror fieldName="emp1StrEdit"/>
								</div>
							</div>
							<div class="col-sm-3 col-lg-3">
								<div class= "row">
									<s:select list="employees" name="emp2Str" listKey="id"
										listValue="firstName" headerKey="" headerValue="" value = "%{#session.customer.emp2.id}"
										cssClass="dselect"></s:select>
								</div>
								<div class = "row" id = "emp2StrEditResult">
									<s:fielderror fieldName="emp2StrEdit"/>
								</div>
							</div>
							<div class="col-sm-3 col-lg-3">
								<div class= "row">
									<s:select list="employees" name="mainStr" listKey="id"
										listValue="firstName" headerKey="" headerValue="" value = "%{#session.customer.mainEmp.id}"
										cssClass="form-control dselect"></s:select>
								</div>
								<div class = "row" id = "mainStrEditResult">
									<s:fielderror fieldName="mainStrEdit"/>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12 col-lg-12">
							<label for="estimateStat" class="control-label col-sm-3 col-lg-2">
								<s:text name="defenestimateStatdant" />
							</label>
							<div class="col-sm-9 col-lg-10">
								<s:textarea name="estimateStat" rows="2" cssClass="form-control "value = "%{#session.customer.estimateStat}"></s:textarea>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12 col-lg-12">
							<label for="estimateMaterial"
								class="control-label col-sm-3 col-lg-2"> <s:text
									name="estimateMaterial" />
							</label>
							<div class="col-sm-9 col-lg-10">
							<s:select list="estMaterials" name="estimateMaterial" listValue="grade" listKey="description"
									cssClass="form-control dselect" headerKey="" headerValue="" value="%{#session.customer.estimateMaterial}" 
								></s:select>
								<div class="row" id="estimateMaterialEditResult">
									<s:fielderror  fieldName="estimateMaterialEdit" />
								</div>
								<%-- <s:textarea name="estimateMaterial" rows="2" value = "%{#session.customer.estimateMaterial}"
									cssClass="form-control "></s:textarea> --%>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12 col-lg-12">
							<label for="carType" class="control-label col-sm-3 col-lg-2">
								<s:text name="carType" />
							</label>
							<div class="col-sm-9 col-lg-10">
								<s:select list="carTypes" name="carTypeStr" listKey="id" value = "%{#session.customer.carType.id}"
									listValue="type" cssClass="form-control dselect"></s:select>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12 col-lg-12">
							<label for="estimateQuarantee"
								class="control-label col-sm-3 col-lg-2"> <s:text
									name="estimateQuarantee" />
							</label>
							<div class="col-sm-9 col-lg-10">
								<s:textarea name="estimateQuarantee" rows="2"value = "%{#session.customer.estimateQuarantee}"
									cssClass="form-control "></s:textarea>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12 col-lg-12">
							<label for="estimateUseState"
								class="control-label col-sm-3 col-lg-2"> <s:text
									name="estimateUseState" />
							</label>
							<div class="col-sm-9 col-lg-10">
								<s:textarea name="estimateUseState" rows="2" value = "%{#session.customer.estimateUseState}"
									cssClass="form-control "></s:textarea>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12 col-lg-12">
							<label for="estimatorExp" class="control-label col-sm-3 col-lg-2">
								<s:text name="estimatorExp" />
							</label>
							<div class="col-sm-9 col-lg-10">
								<s:textarea name="estimatorExp" rows="3"
									value = "%{#session.customer.estimatorExp}" cssClass="form-control "></s:textarea>
							</div>
						</div>
					</div>
				</div>
				<div class="tab-pane active" id="tabEdit2" style="height: 600px;">
					<div class="row" id = "defectTableSlimEdit">
						<div class = "col-sm-12 col-lg-12">
							<div class="button-group">
		    					<div class = "col-sm-2 col-lg-2">
		    						<button class="btn btn-danger btn-block hide" id="deleteImagesBtn">
		    							<i class="icon-trash"></i>
		    							Устгах
		    						</button>
		    					</div>
							</div>
							 <div style="" class = "col-sm-12 col-lg-12" >
								 <table  class="table table-bordered" style="" id = "changeDefectTableEdit">
									<thead style="">
										<tr>
											<th>Эвдэрсэн эд анги</th>
											<th>Эвдрэл</th>
											<th>Засах үнэ</th>
											<th>Солих үнэ</th>
											<th></th>
										</tr>
									</thead>
									<tbody style="">
										<s:iterator value="#session.customer.defectList" var="def">
											<tr>
												<td><s:property value="%{#def.breakedPart.partName}"/></td>
												<td><s:property value="%{#def.crashGrade.grade}"/></td>
												<td><s:property value="%{#def.repairPrice}"/></td>
												<td><s:property value="%{#def.changePrice}"/></td>
												<th></th>
											</tr>
										</s:iterator>
										<tr>
											<td id = "brokenTdEdit">
												<s:select list="brokenParts" listKey="id" listValue="partName"  headerKey="" headerValue=""  name="brokenPartStr" id ="brokenPartIdEdit"></s:select> 
											</td>
											<td ><s:select list="crashGrades" listKey="id" listValue="grade"	name="crashGradeStr" cssClass="form-control" class = "dselect" onchange="changeItem()" id ="crashGradeIdEdit"></s:select>
											</td>
											 <td class ="input-icon right">
												 <i class="fa fa-calendar"></i>
													<s:textfield name="repairPriceStr" cssClass=" form-control " id ="repairPriceIdEdit"></s:textfield>
											</td>
											<td class ="input-icon right">
												 <i class="fa fa-gears"></i>
													<s:textfield name="changePriceStr" cssClass="form-control " id ="changePriceIdEdit"></s:textfield>
											</td> 
											<th id = "addDefectBtnEdit" style="cursor: pointer;" class = "input-icon center">
												<i class="fa fa-check" style="color:green"></i>
												<div class = "form-control"></div>
											</th>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="row" id = "costTableSlimEdit">
						<div id = "changeCostTableEdit" class = "col-sm-12 col-lg-12">
							<table  class="table table-bordered" style="" >
								<thead style="">
									<tr>
										<th>Зардлын нэр</th>
										<th>Зардал</th>
										<th></th>
									</tr>
								</thead>
								<tbody style="">
										<s:iterator value="#session.customer.costList" var="cost">
											<tr>
												<td><s:property value="%{#cost.costName}"/></td>
												<td><s:property value="%{#cost.cost}"/></td>
												<th></th>
											</tr>
										</s:iterator>
									
									<tr>
										<td >
											<s:textfield name="costName" cssClass=" form-control" id ="costNameEdit"></s:textfield>
										</td>
										 <td class ="input-icon right">
											 <i class="fa fa-keyboard-o"></i>
												<s:textfield name="cost" cssClass=" form-control calculat" id ="costEdit" value = ""></s:textfield>
										</td>
										<th id = "addCostBtnEdit" style="cursor: pointer;" class = "input-icon center">
											<i class="fa fa-check" style="color:green"></i>
											<div class = "form-control"></div>
										</th>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="tab-pane" id="tabEdit3">
					<div class="row" id = "imageSlim">
    						<div class = "col-sm-12 col-lg-12">
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
										<th>Төлөв</th>
										<th>Үйлдэл</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${session.customer.imageOfList}" var="image">
										<tr data-id="${image.id}">
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
											<td>
												<c:choose>
													<c:when test="${image.isMain == 'true'}">
														<span class="label label-info arrowed">
															Гарийн үсэг
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
											<s:form method="POST" enctype="multipart/form-data" id="uploadForm">
												<input type="file" name="im" accept="image/*" id="imageUpload" multiple />
											</s:form>
										</td>
									</tr>
								</tfoot>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</s:form>
	
	<script type="text/javascript">
$(document).ready(function()
{
	initHS();
	initEvents();
	initTableEvents();
	autoCompleteInitEdit();
	$("#addDefectBtnEdit").click(function(e) {
		e.preventDefault();
		addDefectEdit();
	});
	$("#addCostBtnEdit").click(function(e) {
		e.preventDefault();
		addCostEdit();
	});
	   $('#imageUpload').ajaxfileupload({
		  'action' : 'save-images',
		  'onComplete' : function(response) {
			  if(response.trim() == "success")
			  {
				 $.ajax({
					 url: "image-list",
					 success: function(result)
						{
							 $("#imageTable tbody").html(result);
							  initTableEvents();
								$.gritter.add(
								{
									title: 'Амжилттай хадгаллаа',
									text: 'Зурагнуудыг амжилттай хадгаллаа!',
									class_name: 'gritter-success gritter-right',
									time : '3000'
								});   
						}
				 });
				    
			  } else{
				  $.gritter.add(
							{
								title: 'Мэдээлэл',
								text: response,
								class_name: 'gritter-error gritter-right',
								time : '3000'
							});
			  }
			}
		});  
	  $('#imageSlim').slimScroll({height: '300px',size: '12px'});
});
function initTableEvents()
{
	$("#imageTable tbody tr input:checkbox").click(function(event)
  	{
  		if ($(this).prop('checked'))
  			$(this).parents("tr:eq(0)").addClass("success");
  		else
  			$(this).parents("tr:eq(0)").removeClass("success");
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
				"id": $("#customerId").val(),
				"imageIds": ids
			},
			success: function(result)
			{
				$("#imageTable tbody tr[data-id='" + id + "']").remove();
				$.gritter.add(
				{
					title: 'Мэдээлэл',
					text: 'Зургийг амжилттай устгалаа!',
					class_name: 'gritter-info gritter-right',
					time : '4000'
				});
			}
		});
	});
}



function initEvents()
{
	
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
					"id": $("#customerId").val(),
					"imageIds": ids
				},
				success: function(result)
				{
					$("#imageTable tbody tr.success").remove();
					$.gritter.add(
					{
						title: 'Мэдээлэл',
						text: 'Зурагнуудыг амжилттай устгалаа!',
						class_name: 'gritter-info gritter-right',
						time : '3000'
					});
				}
			});
		}
		else
		{
			$.gritter.add(
			{
				title: 'Анхааруулга',
				text: 'Та ямар нэгэн зураг сонгоогүй байна.<br/>Устгах зурагнуудаа сонгоно уу!',
				class_name: 'gritter-warning gritter-center',
				time : '3000'
			});
		}
	});
	
}
function autoCompleteInitEdit(){
	$('.calculat').zeninput();
	$(".dselect").chosen({
		width: "95%"
	});
	$('#brokenPartIdEdit').selectize({
		create: true,
		sortField: {
			field: 'text',
			direction: 'asc'
		}
	});
	$("#brokenPartIdEdit").change(function(event)
	{
		if(this.value !=""){
		$.ajax({
			 data:{"brokenPartStr":this.value},
			 url:"brokenPartChangeEdit",
			 success : function(result) {
				 $("#brokenTdEdit").html(result);
				 autoCompleteInitEdit();
				}
		 });
		}
	});
}
function addDefectEdit(){
	if($("#brokenPartIdEdit").val() != ""){
		$.ajax({
			data:{
				"brokenPartStr":$("#brokenPartIdEdit").val(),
				"crashGradeStr":$("#crashGradeIdEdit").val(),
				"repairPriceStr":$("#repairPriceIdEdit").val(),
				"changePriceStr":$("#changePriceIdEdit").val(),
				},
			url:"addDefect-ajax-edit",
			 success : function(result) {
				 $("#changeDefectTableEdit").html(result);
				 autoCompleteInitEdit();
				 $("#addDefectBtnEdit").click(function(e) {
						e.preventDefault();
						addDefectEdit();
					});
				}
		});
	}else{
		alert("Эвдэрсэн эд анги хоосон байна");
	}
}
function addCostEdit(){
	if($("#costNameEdit").val() != "" && $("#costEdit").val() != ""){
		 $.ajax({
			data:{
				"costName":$("#costNameEdit").val(),
				"cost":$("#costEdit").val(),
				},
			url:"addCost-ajax-edit",
			 success : function(result) {
				 $("#changeCostTableEdit").html(result);
				 $('.calculat').zeninput();
				}
		});
	}else{
		alert("хоосон байна");
	}
}
</script>