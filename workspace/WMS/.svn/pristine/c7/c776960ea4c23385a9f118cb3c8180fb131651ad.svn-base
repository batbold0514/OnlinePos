<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<script type="text/javascript" src="../js/page-js/inputArticle.js"></script>
<div class="hidden" id="page">
	<s:url action="inputArticleList" includeParams="none" />
</div>
<div class="panel panel-primary" id="mainPanel">
	<div class="panel-heading">
		<h3 class="panel-title text-center">
			<span class="fa fa-list-alt"></span>&nbsp;
			<s:text name="InputArticleList" />
		</h3>
	</div>
	<div class="panel-body">
		<div class="row">
			<div class="col-sm-12">
				<s:form action="inputArticleList" cssClass="form-inline">
					<div class="row">
						<div class="col-sm-12 text-center visible-xs visible-sm">
							<label for="firstDate" class="control-label text-success">
								<s:text name="searchByDate" />:
							</label>
						</div>
						<div class="col-md-3 text-right visible-md visible-lg">
							<label for="firstDate" class="control-label text-success">
								<s:text name="searchByDate" />:
							</label>
						</div>
						<div class="row visible-sm">
							<div class="col-sm-12">
								<br/>
							</div>
						</div>
				    	<div class="col-sm-5 col-md-3">
				    		<div class="input-group">
					        	<span class="input-group-addon input-sm">
					        		<i class="fa fa-calendar"></i>
					        	</span>
					        	<s:textfield key="firstDate" cssClass="form-control input-sm" id="firstDate" />
					      	</div>
				      	</div>
				      	<div class="hidden-xs col-sm-2 col-md-1 text-center">
				      		<label for="secondDate" class="control-label">
				      			&minus;&minus;
				      		</label>
				      	</div>
				      	<div class="col-sm-5 col-md-3">
				      		<div class="input-group">
					        	<span class="input-group-addon input-sm">
					        		<i class="fa fa-calendar"></i>
					        	</span>
					        	<s:textfield key="secondDate" cssClass="form-control input-sm" id="secondDate" />
					      	</div>
				      	</div>
				      	<div class="row visible-sm">
				      		<div class="col-sm-12">
				      			<br/>
				      		</div>
				      	</div>
					  	<div class="col-sm-offset-4 col-sm-4 col-md-offset-0 col-md-2">
						  	<button type="submit" class="btn btn-sm btn-success btn-block">
						  		<span class="fa fa-search"></span>&nbsp;
								<s:text name="search" />
							</button>
						</div>
					</div>
				</s:form>
			</div>
		</div>
		<hr />
		<div class="row">
			<div class="col-sm-12">
				<div class="table-responsive">
					<display:table class="table table-bordered table-hover" name="inputArticleList" id="mainTable">
						<display:column property="id" title="ID" />
						<display:column property="inDate" title="Огноо" format="{0,date,yyyy-MM-dd hh:mm:ss}" />
						<display:column property="article.name" title="Бараа материал" />
						<display:column property="article.barCode" title="Бар код" />
						<display:column property="addCount" format="{0,number,#,##0.#}" title="Нэмсэн хэмжээ" />
						<display:column property="article.buyPriceNumber"  title="Авах үнэ" />
						<display:column property="inReciever.firstName" title="Хүлээн авагч" />
						<display:column property="customer.name" title="Харилцагч" />
						<display:column property="writer" title="Бүртгэгч" />
						<display:column property="article.id" />
						<display:footer>
							<tr>
								<th colspan="5" style="text-align: right">Total:</th>
								<th id="total"></th>
								<th></th>
								<th></th>
								<th></th>
							</tr>
							<tfoot class="tfot">
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
								</tr>
							</tfoot>
						</display:footer>
					</display:table>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12 text-center">
				<div class="btn-group">
					<a class="btn btn-select" id="show">
						<span class="fa fa-search-plus"></span>
					</a>
					<a class="btn btn-select" id="input">
						<span class="fa fa-download fa-fw"></span>
					</a> 
					<a class="btn btn-select" id="edit">
						<span class="fa fa-edit"></span>
					</a>
				</div>
			</div>
		</div>
	</div>
	<div class="panel-footer">
		<div class="row">
			<div class="col-sm-offset-4 col-sm-4 col-lg-offset-5 col-lg-2 text-center">
				<a class="btn btn-primary focus btn-block" id="inputPlus">
					<span class="fa fa-plus"></span>&nbsp;
					<s:text name="InputArticle" />
				</a>
			</div>
		</div>
	</div>
</div>