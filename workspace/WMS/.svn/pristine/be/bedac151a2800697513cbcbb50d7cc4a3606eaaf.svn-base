<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<div class="hidden" id="page">
	<s:url action="articleCount" includeParams="none" />
</div>
<div class="row">
	<div class="col-sm-12">
		<div class="panel panel-primary" id="mainPanel">
			<div class="panel-heading">
				<h3 class="panel-title text-center">
					<span class="fa fa-list-alt"></span>&nbsp;
					<s:text name="ArticleList" />
				</h3>
			</div>
			<div class="panel-body">
				<div class="col-sm-8 col-sm-offset-2">
					<s:form action="articleCountOrder" cssClass="form-horizontal">
						<div class="form-group">
							<div class="col-sm-4 col-sm-offset-4">
								<select class="sort-box chosen-select" style="width: 200px;"
									multiple>
									<option value="[1,'asc']">Нэр</option>
									<option value="[3,'asc']">Төрөл</option>
									<option value="[12,'asc']">Байрлал</option>
									<option value="[4,'asc']">Размер</option>
								</select>
							</div>
							<%-- <label for="sizes" class="col-sm-4 col-sm-offset-3 control-label"> <s:text
									name="articleCount" />
							</label> --%>
							<%-- <div class="col-sm-5">
								<s:textfield name="articleCount" cssStyle="display:none"
									id="textHidden" required="" cssClass="form-control input-sm" />
							</div> --%>
						</div>
						<%-- <div class="col-sm-12">
							<button type="submit"
								class="btn btn-success col-sm-3 col-sm-offset-7">
								<span class="fa fa-sort-alpha-asc"></span>&nbsp;
								<s:text name="sort" />
							</button>
						</div> --%>
					</s:form>
				</div>
				<div class="table-responsive">
					<display:table name="listArticles"
						class="table table-bordered table-hover" id="mainTable">
						<display:column property="id" title="№" />
						<display:column property="name" title="Нэр" />
						<display:column property="barCode" title="Бар код" />
						<display:column property="category.name" title="Төрөл" />
						<display:column property="size.sizes" title="Размер" />
						<display:column property="colour.name" title="Өнгөний нэр" />
						<display:column property="colour.code" title="Өнгөний код" />
						<display:column property="count" title="Тоо хэмжээ" format="{0,number,#,##0.#}"/>
						<display:column property="measure.measuringUnit"
							title="Хэмжих нэгж" />
						<display:column property="buyPriceNumber" title="Авах үнэ" />
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
									<th><input type="text" list="datalistId0"
										name="search_engine" value="" class="search_init" /></th>
									<th><input type="text" list="datalistId1"
										name="search_engine" value="" class="search_init" /></th>
									<th><input type="text" list="datalistId2"
										name="search_engine" value="" class="search_init" /></th>
									<th><input type="text" list="datalistId3"
										name="search_engine" value="" class="search_init" /></th>
									<th><input type="text" list="datalistId4"
										name="search_engine" value="" class="search_init" /></th>
									<th><input type="text" list="datalistId5"
										name="search_engine" value="" class="search_init" /></th>
									<th><input type="text" list="datalistId6"
										name="search_engine" value="" class="search_init" /></th>
									<th><input type="text" list="datalistId7"
										name="search_engine" value="" class="search_init" /></th>
									<th><input type="text" list="datalistId8"
										name="search_engine" value="" class="search_init" /></th>
									<th><input type="text" list="datalistId9"
										name="search_engine" value="" class="search_init" /></th>
									<th><input type="text" list="datalistId10"
										name="search_engine" value="" class="search_init" /></th>
									<th><input type="text" list="datalistId11"
										name="search_engine" value="" class="search_init" /></th>
									<th><input type="text" list="datalistId12"
										name="search_engine" value="" class="search_init" /></th>
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
			<%-- <div class="panel-footer">
				<div class="row">
					<div class="col-sm-12 text-center">
						<a href="newArticle" class="btn btn-primary focus"> <span
							class="fa fa-plus"></span>&nbsp; <s:text name="addArticle" />
						</a>
					</div>
				</div>
			</div> --%>
		</div>
	</div>
</div>
<script src="../js/chosen.jquery.min.js"></script>
<script type="text/javascript" src="../js/articleListCount.js"></script>