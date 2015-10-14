<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<script src="../js/chosen.jquery.min.js"></script>
<script type="text/javascript" src="../js/multipleOutput.js"></script>
<div class="hidden" id="page">
	<s:url action="multipleOutput" includeParams="none" />
</div>
<div class="row">
	<div class="col-xs-12 col-md-3 pull-right">
		<div class="panel panel-search">
			<div class="panel-heading">
				<h3 class="panel-title text-center">
					<span class="fa fa-search"></span>
					<s:text name="articleSearch" />
				</h3>
			</div>
			<div class="panel-body">
				<s:form action="multiOutputSearch">
					<div class="form-group">
						<label for="articleName" class="control-label">
							<s:text name="articleName" />:
						</label>
						<s:textfield key="articleName" cssClass="form-control input-sm" id="articleName" autofocus="" />
					</div>
					<div class="form-group">
						<label for="barcode" class="control-label">
							<s:text name="articleBarCode" />:
						</label>
						<s:textfield key="articleBarCode" cssClass="form-control input-sm" id="barcode" />
					</div>
					<div class="form-group">
						<label for="articleColour" class="control-label">
							<s:text name="articleColour" />:
						</label>
						<s:select list="Colours"
								listKey="code +' ' +name"
								listValue="code"
								key="articleCode"
								headerKey=""
								headerValue=""
								cssClass="form-control input-sm"
								id="articleColour" />
					</div>
					<div class="form-group">
						<label for="articleSize" class="control-label">
							<s:text name="articleSize" />:
						</label>
						<s:select list="sizes"
								listKey="id"
								listValue="sizes"
								key="articleSize"
								headerKey="-1"
								headerValue=""
								cssClass="form-control input-sm"
								id="articleSize" />
					</div>
					<div class="form-group">
						<label for="articleLocation" class="control-label">
							<s:text name="articleLocation" />:
						</label>
						<s:select list="locations"
								listKey="id"
								listValue="locationName"
								key="articleLocation"
								headerKey="-1"
								headerValue=""
								cssClass="form-control input-sm"
								id="articleLocation" />
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-sm btn-success btn-block">
							<span class="fa fa-search"></span>&nbsp;
							<s:text name="search" />
						</button>
					</div>
				</s:form>
			</div>
		</div>
	</div>
	<div class="col-xs-12 col-md-9">
		<div class="panel panel-primary" id="mainPanel">
			<div class="panel-heading">
				<h3 class="panel-title text-center">
					<span class="fa fa-list-alt"></span>&nbsp;
					<s:text name="ArticleList" />
				</h3>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-sm-12">
						<s:form action="multiOutputGetCustomer" cssClass="form-inline">
							<div class="row">
								<div class="col-sm-4 text-right hidden-xs">
									<label for="customerChoose" class="control-label">
										<s:text name="Customer" />:
									</label>
								</div>
								<div class="col-xs-12 visible-xs">
									<label for="customerChoose" class="control-label">
										<s:text name="Customer" />:
									</label>
								</div>
								<div class="col-sm-4">
									<s:select list="customers"
											listKey="id"
											listValue="name"
											key="customerId"
											headerKey="-1"
											headerValue=""
											cssStyle="width: 150px; height:30px; !important;"
											cssClass="sort-box chosen-select"
											id="customerChoose" />
								</div>
								<div class="row visible-xs">
									<div class="col-xs-12 ">
										<br />
									</div>
								</div>
								<div class="col-sm-4 col-lg-3">
									<button type="submit" class="btn btn-sm btn-success btn-block">
										<span class="glyphicon glyphicon-check"></span>&nbsp;
										Сонгох
									</button>
								</div>
							</div>
						</s:form>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-sm-12">
						<div class="table-responsive">
							<display:table name="articleList" class="table table-bordered table-hover" id="mainTable" varTotals="">
								<display:column property="id" title="№" />
								<display:column property="name" title="Нэр" />
								<display:column property="serialNumber" title="Сериал дугаар" />
								<display:column property="category.name" title="Төрөл" />
								<display:column property="size.sizes" title="Размер" />
								<display:column property="colour.name" title="Өнгөний нэр" />
								<display:column property="colour.code" title="Өнгөний код" />
								<display:column property="measure.measuringUnit" title="Хэмжих нэгж" />
								<display:column property="count" title="Тоо хэмжээ" />
								<display:column property="buyPriceNumber"  title="Авах үнэ" />
								<display:column property="sellPriceNumber" title="Зарах үнэ" />
								<display:column property="owner.firstName" title="Нягтлан" />
								<display:column property="location.locationName" title="Байрлал" />
								<display:footer>
									<tr>
										<th colspan="9" style="text-align: right">Total:</th>
										<th id="total"></th>
										<th id="total1"></th>
										<th></th>
										<th></th>
									</tr>
									<tfoot class="tfot2">
										<tr>
											<th>
												<input type="text" list="datalistId0" name="search_engine" value="" class="search_init" />
											</th>
											<th>
												<input type="text" list="datalistId1" name="search_engine" value="" class="search_init" />
											</th>
											<th>
												<input type="text" list="datalistId2" name="search_engine" value="" class="search_init" />
											</th>
											<th>
												<input type="text" list="datalistId3" name="search_engine" value="" class="search_init" />
											</th>
											<th>
												<input type="text" list="datalistId4" name="search_engine" value="" class="search_init" />
											</th>
											<th>
												<input type="text" list="datalistId5" name="search_engine" value="" class="search_init" />
											</th>
											<th>
												<input type="text" list="datalistId6" name="search_engine" value="" class="search_init" />
											</th>
											<th>
												<input type="text" list="datalistId7" name="search_engine" value="" class="search_init" />
											</th>
											<th>
												<input type="text" list="datalistId8" name="search_engine" value="" class="search_init" />
											</th>
											<th>
												<input type="text" list="datalistId9" name="search_engine" value="" class="search_init" />
											</th>
											<th>
												<input type="text" list="datalistId10" name="search_engine" value="" class="search_init" />
											</th>
											<th>
												<input type="text" list="datalistId11" name="search_engine" value="" class="search_init" />
											</th>
											<th>
												<input type="text" list="datalistId12" name="search_engine" value="" class="search_init" />
											</th>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
									</tfoot>
								</display:footer>
							</display:table>
						</div>
					</div>
				</div>
			</div>
			<div class="panel-footer">
				<div class="row">
					<div class="col-sm-offset-4 col-sm-4">
						<a id="next" class="btn btn-addon btn-block">
							<span class="fa fa-shopping-cart"></span>&nbsp;
							<s:text name="add" />
						</a>
					</div>
				</div>
			</div>
		</div>
		<div class="panel panel-select">
			<div class="panel-heading">
				<h3 class="panel-title text-center">
					<span class="fa fa-list-alt"></span>&nbsp;
					<s:text name="multiOutputList" />
				</h3>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-sm-12 text-center">
						<h5>
							<span class="icon icon-customer"></span>&nbsp;
							<s:text name="Customer" />:
							<s:property value="#session.customer.name" />
						</h5>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-sm-12">
						<table id="resultTable" class="table table-bordered table-hovered">
							<thead>
								<tr>
									<th>id</th>
									<th>name</th>
									<th>count</th>
									<th style="width: 1%"></th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="#session.multiOutlist" status="stat">
									<tr>
										<td>${multiOutlist[stat.index].id}</td>
										<td>${multiOutlist[stat.index].name}</td>
										<td>${multiOutlist[stat.index].count}</td>
										<td onclick="minus('<s:property value="%{#stat.index}"/>')">
											<a class="btn btn-danger">
												<span class="fa fa-minus"></span>
											</a>
										</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="panel-footer">
				<div class="row">
					<div class="col-sm-offset-2 col-sm-4">
						<a class="btn btn-warning btn-block" id="temp">
							<span class="fa fa-tag"></span>&nbsp;
							Түр хадгалах
						</a>
					</div>
					<div class="col-sm-4">
						<a class="btn btn-primary btn-block" id="finish">
							<span class="fa fa-upload"></span>&nbsp;
							<s:text name="OutputArticle" />
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>