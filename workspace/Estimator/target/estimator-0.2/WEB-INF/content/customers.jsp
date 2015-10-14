<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-sm-12">
		<h3 class="page-title">
			<s:text name="serviceReg" />
		</h3>
	</div>
	<p class="active_menu hide">serviceReg</p>
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-tag"> <s:text name="serviceReg" /></i>
			</div>
			<div class="tools">
				<a href="javascript:;" class="collapse"></a>
			</div>
		</div>
		<div class="portlet-body">
			<div class="table-toolbar">
				<div class="col-sm-12">
					<div class="col-sm-8 form-gorup">
						<s:form action="searchCustomer" id="searchCustomerForm">
							<div class="row-fluid col-sm-12">
								<div class="col-sm-1">
									<s:text name="date" />
								</div>
								<div class="col-sm-5">
									<s:textfield name="firstDate" id="firstDate" cssClass = "col-sm-6"
										tooltip="Эхлэлийн огноо" size="7" />
									<s:textfield name="secondDate" id="secondDate" cssClass = "col-sm-6" 
										tooltip="Төгсгөлийн огноо" size="7" />
								</div>
								<div class="col-sm-2">
									<s:text name="cnumber" />
								</div>
								<div class="col-sm-4">
									<s:textfield name="searchCnumber" size="6" cssClass="col-sm-12"/>
								</div>
							</div>
							<div class="row-fluid col-sm-12">
								<div class="col-sm-1">
									<s:text name="factory" />
								</div>
								<div class="col-sm-4">
									<s:select list="factories" name="searchCarFactory" listKey="id"
										id="factorySearch" listValue="factoryName" headerKey=""
										headerValue="" cssClass="select form-control"></s:select>
								</div>
								<div class="col-sm-1">
									<s:text name="mark" />
								</div>
								<div class="col-sm-3" id="carmarkresult">
									<s:select list="carmarkList" name="searchCarMark" listKey="id"
										id="markSearch" listValue="mark" headerKey="" headerValue=""
										cssClass="select form-control"></s:select>
								</div>
								<div class="col-sm-3">
									<s:text name="year" />
									<s:textfield name="searchDate" size="4" />
								</div>
							</div>
						</s:form>
					</div>
					<div class="col-sm-4">
						<%
							if (request.isUserInRole("admin-role")) {
						%>
								<button class="btn blue col-sm-3" id="confirmBtn" >
									<i class="fa fa-check"></i>
									<s:text name="confirm" />
								</button>
						<%
							}
						%>
							<button class="btn btn-success  col-sm-3" id="btnSearch">
								<i class="fa fa-search"></i>
								<s:text name="search" />
							</button>
							<button class="btn green  col-sm-3" id="btnAdd">
								<i class="fa fa-plus"></i>
								<s:text name="add" />
							</button>
							<button class="btn yellow  col-sm-3" id="btnEdit">
								<i class="fa fa-edit"></i>
								<s:text name="edit" />
							</button>
					</div>
				</div>
			</div>
			<div id="list-result">
				<display:table name="customerList" id="customerTable"
					class="display table-bordered table-hoverdataTable">
					<display:column property="id" title="" />
					<display:column property="date" title="Оноо" format="{0,date,yyyy-MM-dd hh:mm}"/>
					<display:column property="cnumber" title="Улсын дугаар" />
					<display:column property="confirm.description" title="Төлөв" />
					<display:column property="ownerName" title="Эзэмшигч" />
					<display:column property="consumer" title="Захиалагч" />
					<display:column property="carFactory.factoryName" title="Үйлдвэр" />
					<display:column property="carMark.mark" title="Загвар" />
					<display:column property="factoryDate" title="Үйлд.он" />
					<display:column property="marketPrice" title="Э.З үнэ" />
					<display:column property="vinNumber" title="Арал" />
					<display:column property="mainEmp.firstName" title="Мэргэжилтэн" />
					<display:column property="carFactory.id" title="" />
					<display:column property="carMark.id" title="" />
					<display:column property="mainEmp.id" title="" />
					<display:column property="emp1.id" title="" />
					<display:column property="emp2.id" title="" />
				</display:table>
			</div>
		</div>
	</div>
</div>
<div id="dialog-edit" class="hide">

</div>
<div id="dialog-addnew" class="hide">
	<s:form method="POST" enctype="multipart/form-data" id="custUploadForm" cssClass="hide">
		<input type="file" name="im" accept="image/*" id="custImageUpload" multiple />
	</s:form>
	<s:form action="customer-save" enctype="multipart/form-data" method="POST" cssClass="form-horizontal" id="addForm">
		<s:hidden name="id" />
		<div class="tabbable tabbable-custom boxless">
			<ul class="nav nav-tabs">
				<li class="active" ><a href="#tab0" data-toggle="tab" class="customerDialogTab"><s:text
							name="mainInformatioin" /></a></li>
				<li class="customerDialogTab"><a href="#tab1" data-toggle="tab"><s:text
							name="extraInformatioin" /></a></li>
				<li class="customerDialogTab "><a href="#tab2"
					data-toggle="tab"><s:text name="crashInformation" /></a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="tab0">
				 
					<div class="row">
						<div class="col-sm-6 col-lg-6">
							<div class="form-group">
								<div class = "row">
									<label for="company" class="control-label col-sm-6 col-lg-6"><s:text name="company" /></label>
									<div class = "col-sm-6 col-lg-6">
										<s:select list="companies" name="companyStr" listKey="id"
											listValue="compName" cssClass="dselect"
											headerKey="" headerValue=""></s:select>
									</div>
								</div>
								<div class = "row" id = "companyStrResult">
									<s:fielderror fieldName="companyStr"/>
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
											listValue="type" cssClass="dselect"></s:select>
									</div>
								</div>
								<div class = "row" id = "itypeStrResult">
									<s:fielderror fieldName="itypeStr"/>
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
											<s:textfield name="dateStr" cssClass="datePicker form-control" />
											<span class="input-group-addon">
												<i class = "fa fa-calendar"></i>
											</span>
										</div>
									</div>
								</div>
								<div class = "row" id = "dateStrResult">
									<s:fielderror fieldName="dateStr"/>
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
										<s:textfield name="color" cssClass="form-control"></s:textfield>
									</div>
								</div>
								<div class = "row" id = "colorResult">
									<s:fielderror fieldName="color"/>
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
											listValue="factoryName" id="factorySelect" headerKey=""
											headerValue="" cssClass=" dselect"></s:select>
									</div>
								</div>
								<div class = "row" id = "factoryStrResult">
									<s:fielderror fieldName="factoryStr"/>
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
										<s:textfield name="vinNumber" cssClass="form-control"></s:textfield>
									</div>
								</div>
								<div class = "row" id = "vinNumberResult">
									<s:fielderror fieldName="vinNumber"/>
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
									<div class="col-sm-6 col-lg-6" id="markSelect">
										<s:select list="carmarkList" name="markStr" listKey="id"
											listValue="mark" headerKey="" headerValue=""
											cssClass="dselect"></s:select>
									</div>
								</div>
								<div class = "row" id = "markStrResult">
									<s:fielderror fieldName="markStr"/>
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
										<s:textfield name="ownerName" cssClass="form-control"></s:textfield>
									</div>
								</div>
								<div class = "row" id = "ownerNameResult">
									<s:fielderror fieldName="ownerName"/>
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
										<s:textfield name="cnumber" cssClass="form-control"></s:textfield>
									</div>
								</div>
								<div class = "row" id = "cnumberResult">
									<s:fielderror fieldName="cnumber"/>
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
										<s:textfield name="ownerAddress" cssClass="form-control"></s:textfield>
									</div>
								</div>
								<div class = "row" id = "ownerAddressResult">
									<s:fielderror fieldName="ownerAddress"/>
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
										<s:textfield name="factoryDate" cssClass="form-control" />
									</div>
								</div>
								<div class = "row" id = "factoryDateResult">
									<s:fielderror fieldName="factoryDate"/>
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
										<s:textfield name="ownerPhoneNumber" cssClass="form-control"></s:textfield>
									</div>
								</div>
								<div class = "row" id = "ownerPhoneNumberResult">
									<s:fielderror fieldName="ownerPhoneNumber"/>
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
										<s:textfield name="importedDate" cssClass="form-control" />
									</div>
								</div>
								<div class = "row" id = "importedDateResult">
									<s:fielderror fieldName="importedDate"/>
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
										<s:textfield name="estPoint" cssClass="form-control"
											value="Ослын улмаас учирсан хохиролыг тооцох"></s:textfield>
									</div>
								</div>
								<div class = "row" id = "estPointResult">
									<s:fielderror fieldName="estPoint"/>
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
										<s:textarea name="note1" rows="2" cssClass="form-control"></s:textarea>
									</div>
								</div>
								<div class = "row" id = "note1Result">
									<s:fielderror fieldName="note1"/>
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
										<s:textfield name="marketPrice" cssClass="form-control"></s:textfield>
									</div>
								</div>
								<div class = "row" id = "marketPriceResult">
									<s:fielderror fieldName="marketPrice"/>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="tab-pane" id="tab1">
					<div class = "col-sm-12 col-lg-12">
						<div class = "col-sm-6 col-lg-6">
							<div class="form-group">
								<div class="row">
									<label for="consumer" class="control-label col-sm-4 col-lg-4">
										<s:text name="consumer" />
									</label>
									<div class="col-sm-7 col-lg-7">
										<s:textfield name="consumer" cssClass="form-control "></s:textfield>
									</div>
								</div>
								<div class = "row" id = "consumerResult">
									<s:fielderror fieldName="consumer"/>
								</div>
							</div>
						</div>
						<div class = "col-sm-6 col-lg-5">
							<div class="form-group">
								<div class="row">
									<label for="regnumber" class="control-label col-sm-4 col-lg-4">
										<s:text name="regnumber" />
									</label>
									<div class="col-sm-7 col-lg-7">
										<s:textfield name="regNumber" cssClass="form-control "></s:textfield>
									</div>
								</div>
								<div class = "row" id = "regnumberResult">
									<s:fielderror fieldName="regnumber"/>
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
								<s:textfield name="agentConsumer" cssClass="form-control "></s:textfield>
							</div>
						</div>
						<div class = "row" id = "agentConsumerResult">
							<s:fielderror fieldName="agentConsumer"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12 col-lg-12">
							<label for="defendant" class="control-label col-sm-3 col-lg-2">
								<s:text name="defendant" />
							</label>
							<div class="col-sm-9 col-lg-10">
								<s:textfield name="defendant" cssClass="form-control "></s:textfield>
							</div>
						</div>
						<div class = "row" id = "defendantResult">
								<s:fielderror fieldName="defendant"/>
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
										listValue="firstName" headerKey="" headerValue=""
										cssClass="dselect"></s:select>
								</div>
								<div class = "row" id = "emp1StrResult">
									<s:fielderror fieldName="emp1Str"/>
								</div>
							</div>
							<div class="col-sm-3 col-lg-3">
								<div class= "row">
									<s:select list="employees" name="emp2Str" listKey="id"
										listValue="firstName" headerKey="" headerValue=""
										cssClass="dselect"></s:select>
								</div>
								<div class = "row" id = "emp2StrResult">
									<s:fielderror fieldName="emp2Str"/>
								</div>
							</div>
							<div class="col-sm-3 col-lg-3">
								<div class= "row">
									<s:select list="employees" name="mainStr" listKey="id"
										listValue="firstName" headerKey="" headerValue=""
										cssClass="form-control dselect"></s:select>
								</div>
								<div class = "row" id = "mainStrResult">
									<s:fielderror fieldName="mainStr"/>
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
								<s:textarea name="estimateStat" rows="2" cssClass="form-control "></s:textarea>
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
									cssClass="form-control dselect" headerKey="" headerValue="" 
								></s:select>
								<div class="row" id="estimateMaterialResult">
									<s:fielderror  fieldName="estimateMaterial" />
								</div>
								<%-- <s:textarea name="estimateMaterial" rows="2"  id="estMaterialId"
								value="Сэлбэгийн зах зээлийн дундаж үнэ, 3-р зэрэглэлийн засварын ажлын дундаж үнийн тарифыг баримтлав."
									cssClass="form-control "></s:textarea>  --%>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12 col-lg-12">
							<label for="carType" class="control-label col-sm-3 col-lg-2">
								<s:text name="carType" />
							</label>
							<div class="col-sm-9 col-lg-10">
								<s:select list="carTypes" name="carTypeStr" listKey="id"
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
								<s:textarea name="estimateQuarantee" rows="2"
									value="Үнэлгээг хууль эрхийн холбогдох заалтын дагуу хийсэн, уг машины эзэнтэй ямар нэг холбоогүй, Үнийн дүнд үэнлгээний ажлын хөлс ороогүй"
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
								<s:textarea name="estimateUseState" rows="2"
									value="Буруутай эзнээр хохирол төлүүлэх, даатгалаас нөхүүлэхэд ашиглана"
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
									value="'Мастер үнэлгээ' ХХК нь даатгалын хохирол үнэлэгчийн 233/17 тоот тусгай зөвшөөрөлтэй, тухайн чиглэлээр  3-5 жил ажилласан туршлагатай ажиллагсадтай, Хөрөнгийн үнэлгээ хийх эрхийн №091100171 тоот зөвшөөрөлтэй. Мэргэжлийн хариуцлагын даатгал 'Миг даатгал'ХХК ГД: 15/31, 50 сая төг, 2015-5-26-с 2016-05-25"
									cssClass="form-control "></s:textarea>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class = "col-sm-12 col-lg-12 " id = "imageId">
								
						</div>
					</div>
				</div>
				<div class="tab-pane" id="tab2" style="height: 600px;">
					<div class="row " id = "defectTableSlim">
						 <div class="col-sm-12 col-lg-12"  id = "changeDefectTable">
							 <table  class="table table-bordered " style="">
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
									<tr>
										<td id = "brokenTd">
											<s:select list="brokenParts" listKey="id" listValue="partName"  headerKey="" headerValue=""  name="brokenPartStr" id ="brokenPartId"></s:select>
										</td>
										<td ><s:select list="crashGrades" listKey="id" listValue="grade"	name="crashGradeStr" cssClass="form-control" class = "dselect" id ="crashGradeId"></s:select>
										</td>
										 <td class ="input-icon right">
											 <i class="fa fa-keyboard-o"></i>
												<s:textfield name="repairPriceStr" cssClass=" form-control calculat" id ="repairPriceId"></s:textfield>
										</td>
										<td class ="input-icon right">
											 <i class="fa fa-keyboard-o"></i>
												<s:textfield name="changePriceStr" cssClass="form-control calculat" id ="changePriceId"></s:textfield>
										</td> 
										<th id = "addDefectBtn" style="cursor: pointer;" class = "input-icon center">
											<i class="fa fa-check" style="color:green"></i>
											<div class = "form-control"></div>
										</th>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="row" id = "costTableSlim">
						<div id = "changeCostTable" class = "col-sm-12 col-lg-12">
							<table  class="table table-bordered" style="" >
								<thead style="">
									<tr>
										<th>Зардлын нэр</th>
										<th>Зардал</th>
										<th></th>
									</tr>
								</thead>
								<tbody style="">
									<tr>
										<td >
											<s:textfield name="costName" cssClass=" form-control" id ="costName"></s:textfield>
										</td>
										 <td class ="input-icon right">
											 <i class="fa fa-keyboard-o"></i>
												<s:textfield name="cost" cssClass=" form-control calculat" id ="cost"></s:textfield>
										</td>
										<th id = "addCostBtn" style="cursor: pointer;" class = "input-icon center">
											<i class="fa fa-check" style="color:green"></i>
											<div class = "form-control"></div>
										</th>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</s:form>
</div>
<div id="parseResult" class=hidden></div>
<div id="context" class="hide">${pageContext.request.contextPath}
</div>
<link rel="stylesheet" type="text/css" href="../js/fileinput/highslide.css" />
 <script type="text/javascript" src="../js/fileinput/highslide-full.js"></script> 
<script src="../js/PageJS/customers.js"></script>
