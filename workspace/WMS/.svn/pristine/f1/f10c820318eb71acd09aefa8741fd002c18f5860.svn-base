<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<script type="text/javascript" src="../js/outputArticle.js"></script>
<div class="hidden" id="page">
	<s:url action="outList" includeParams="none" />
</div>
<div class="panel panel-primary" id="mainPanel">
	<div class="panel-heading">
		<h3 class="panel-title text-center">
			<span class="fa fa-list-alt"></span>&nbsp;
			<s:text name="OutputArticleList" />
		</h3>
	</div>
	<div class="panel-body">
		<div class="row">
			<div class="col-sm-12">
				<div class="table-responsive">
					<display:table id="mainTable" class="table table-bordered table-hover" name="outputArticleList">
						<display:column property="id" title="ID" />
						<display:column property="outDate" title="Огноо" format="{0,date,yyyy-MM-dd hh:mm:ss}" />
						<display:column property="article.name" title="Бараа материал" />
						<display:column property="article.barCode" title="Бар код" />
						<display:column property="outCount" format="{0,number,#,##0.#}" title="Тоо хэмжээ" />
						<display:column property="article.sellPriceNumber"  title="Зарах үнэ" />
						<display:column property="from.firstName" title="Хэнээс" />
						<display:column property="customer.name" title="Харилцагч" />
						<display:column property="writer" title="Бүртгэгч" />
						<display:column property="article.id"  />
						<display:column property="number"  />
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
									<th>
										<input type="text" list="datalistId9" name="search_engine" value="" class="search_init" />
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
					<a class="btn btn-select" id="output">
						<span class="fa fa-upload"></span>
					</a>
					<a class="btn btn-select" id="show">
						<span class="fa fa-search-plus"></span>
					</a>
				</div>
			</div>
		</div>
	</div>
	<div class="panel-footer">
		<div class="row">
			<div class="col-sm-offset-4 col-sm-4 col-lg-offset-5 col-lg-2 text-center">
				<a class="btn btn-primary focus btn-block" id="outputPlas">
					<span class="fa fa-plus"></span>&nbsp;
					<s:text name="OutputArticle" />
				</a>
			</div>
		</div>
	</div>
</div>