<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<script type="text/javascript" src="../js/articlelist.js"></script>
<div class="hidden" id="page">
	<s:url action="articleListSearch" includeParams="none" />
</div>
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
				<div class="table-responsive">
					<display:table name="articleList" varTotals="" class="table table-bordered table-hover" id="mainTable">
						<display:column property="id" title="№" />
						<display:column property="name" title="Нэр" />
						<display:column property="barCode" title="Бар код" />
						<display:column property="category.name" title="Төрөл" />
						<display:column property="size.sizes" title="Размер" />
						<display:column property="colour.name" title="Өнгөний нэр" />
						<display:column property="colour.code" title="Өнгөний код" />
						<display:column property="measure.measuringUnit" title="Хэмжих нэгж" />
						<display:column property="count" format="{0,number,#,##0.#}" title="Тоо хэмжээ" />
						<display:column property="buyPriceNumber" title="Авах үнэ" />
						<display:column property="sellPriceNumber" title="Зарах үнэ"  />
						<display:column property="owner.firstName" title="Нягтлан" />
						<display:column property="location.locationName" title="Байрлал" />
						<display:footer>
							<tr>
								<th colspan="8" style="text-align: right">Total:</th>
								<th id="total2"></th>
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
										<input type="text" list="datalistId10"	name="search_engine" value="" class="search_init" />
									</th>
									<th>
										<input type="text" list="datalistId11"	name="search_engine" value="" class="search_init" />
									</th>
									<th>
										<input type="text" list="datalistId12"	name="search_engine" value="" class="search_init" />
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
		<div class="row">
			<div class="col-sm-12 text-center">
				<div class="btn-group">
					<a class="btn btn-select" id="show">
						<span class="fa fa-search-plus"></span>
					</a>
					<a class="btn btn-select" id="edit">
						<span class="fa fa-edit"></span>
					</a>
					<a class="btn btn-select" id="change">
						<span class="fa fa-exchange"></span>
					</a>
					<a class="btn btn-select" id="out">
						<span class="fa fa-upload"></span>
					</a>
					<a class="btn btn-select" id="add">
						<span class="fa fa-download"></span>
					</a>
				</div>
			</div>
		</div>
	</div>
	<div class="panel-footer" onclick="CommaFormatted(416541456789456.23)">
		<div class="row">
			<div class="col-sm-offset-2 col-sm-3 col-lg-offset-3 col-lg-2">
				<a onclick="window.history.back()" class="btn btn-back col-xs-12">
					<span class="fa fa-arrow-circle-o-left"></span>&nbsp;
					<s:text name="back" />
				</a>
			</div>
			<div class="col-sm-5 col-lg-4">
				<a href="newArticle" class="btn btn-primary col-xs-12">
					<span class="fa fa-plus"></span>&nbsp;
					<s:text name="addArticle" />
				</a>
			</div>
		</div>
	</div>
</div>