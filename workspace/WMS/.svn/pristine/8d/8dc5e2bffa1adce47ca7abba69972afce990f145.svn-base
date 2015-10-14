<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<script type="text/javascript" src="../js/chosen.jquery.min.js"></script>
<script type="text/javascript" src="../js/invoice.js"></script>
<div class="hidden" id="page">
	<s:url action="outputArticleInvoice" includeParams="none" />
</div>
<div class="panel panel-primary" id="mainPanel">
	<div class="panel-heading">
		<h3 class="panel-title text-center">
			<span class="fa fa-list-alt"></span>&nbsp;
			<s:text name="outputArticleInvoice" />
		</h3>
	</div>
	<div class="panel-body">
		<div class="row">
			<div class="col-sm-12">
				<s:form action="outputArticleInvoice-search">
					<div class="row">
						<div class="col-sm-3 text-right">
							<label for="dateRange" class="control-label">
								Огноо:
							</label>
						</div>
						<div class="col-sm-3">
							<div class="input-group">
					        	<span class="input-group-addon input-sm">
					        		<i class="fa fa-calendar"></i>
					        	</span>
								<s:textfield key="firstDate" id="dateRange" cssClass="form-control input-sm" />
							</div>
						</div>
						<div class="col-sm-1">
							Дуусах:
						</div>
						<div class="col-sm-3">
							<div class="input-group">
					        	<span class="input-group-addon input-sm">
					        		<i class="fa fa-calendar"></i>
					        	</span>
								<s:textfield key="secondDate" id="dateRange1" cssClass="form-control input-sm" />
							</div>
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-sm-3 text-right">
							<label for="customerChoose" class="control-label">
								<s:text name="Customer" />:
							</label>
						</div>
						<div class="col-sm-3">
							<s:select list="customers"
										listKey="id"
										listValue="name"
										key="customerId" 
										headerKey="-1"
										headerValue=""
										cssStyle="width: 150px;"
										cssClass="sort-box chosen-select"
										id="customerChoose"
										autofocus="" />
						</div>
						<div class="col-sm-3">
							<button type="submit" class="btn btn-sm btn-success btn-block">
								<span class="fa fa-search"></span>&nbsp;
								<s:text name="search" />
							</button>
						</div>
					</div>
					<%-- <div class="form-group">
						<label for="sizes" class="col-sm-4 col-sm-offset-3 control-label">
							<s:text name="startDate" />
						</label>
						<div class="col-sm-5">
							<s:textfield key="firstDate" id="dateRange" cssClass="form-control input-sm" />
						</div>
					</div>
					<div class="form-group">
						<label for="sizes" class="col-sm-4 col-sm-offset-3 control-label">
							<s:text name="endDate" />
						</label>
						<div class="col-sm-5">
							<s:textfield key="secondDate" id="dateRange1" cssClass="form-control input-sm" />
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-4 col-sm-offset-3 control-label">
							<s:text name="Customer" />
						</label>
						<div class="col-sm-5">
							<s:select list="customers"
									listKey="id"
									listValue="name"
									key="customerId" 
									headerKey="-1"
									headerValue=""
									cssStyle="width: 150px;"
									cssClass="sort-box chosen-select"
									id="customerChoose"
									autofocus="" />
						</div>
					</div>
					<div class="col-sm-12">
						<button type="submit" class="btn btn-success col-sm-3 col-sm-offset-9">
							<span class="fa fa-search"></span>&nbsp;
							<s:text name="search" />
						</button>
					</div> --%>
				</s:form>
			</div>
		</div>
		<hr />
		<div class="row">
			<div class="col-sm-12">
				<div class="table-responsive">
					<display:table id="mainTable" class="table table-bordered table-hover" name="listOutputIntoDisplay">
						<display:column property="id" title="ID" />
						<display:column property="outDate" title="Огноо" />
						<display:column property="from.firstName" title="Хэнээс" />
						<display:column property="reciever" title="Хүлээн авагч" />
						<display:column property="writer" title="Бүртгэгч" />
						<display:column property="number" />
						<display:column property="status.label" />
						<display:footer>
							<tfoot class="tfoot">
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
								</tr>
								<tr>
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
			<div class="col-sm-3">
				<div class="btn-group">
					<a class="btn btn-default" id="show">
						<span class="fa fa-search-plus"></span>
					</a>
					<a class="btn btn-default" id="print">
						<span class="glyphicon glyphicon-print"></span>
					</a>
				</div>
			</div>
		</div>
	</div>
</div>

<div>
	<s:form action="outputArticleInvoice-show">
		<s:hidden key="number" id="showA" />
		<s:submit cssStyle="display:none" id="showB"></s:submit>
	</s:form>
	<s:form action="outputArticleInvoice-print">
		<s:hidden key="number" id="printA" />
		<s:submit cssStyle="display:none" id="printB"></s:submit>
	</s:form>
</div>