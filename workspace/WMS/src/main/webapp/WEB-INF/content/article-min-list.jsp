<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<div class="hidden" id="page">
	<s:url action="min-article-list" includeParams="none" />
</div>
<div class="row">
	<div class="col-sm-12">
		<div class="panel panel-success" id="mainPanel">
			<div class="panel-heading">
				<h3 class="panel-title text-center">
					<span class=""></span>
					<s:text name="minArticleList" />
				</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<display:table cellpadding="0" cellspacing="0"
						class="table table-bordered table-hover" id="mainTable"
						name="articleList" style="text-align: center;">
						<display:column property="article.name" title="Нэршил" sortable="true" />
						<display:column property="article.barCode" title="Бар код"
							sortable="true" />
						<display:column property="article.colour.name" title="Өнгө"
							sortable="true" />
						<display:column property="article.size.sizes" title="Размер"
							sortable="true" />
						<display:column property="count" title="Хэмжээ" format="{0,number,#,##0.#}"
							style="background-color: red;" sortable="true" />
						<display:column property="article.minCount" format="{0,number,#,##0.#}" title="Доод хэмжээ"
							sortable="true" />
						<display:column property="article.measure.measuringUnit" title="Нэгж"
							sortable="true" />
						<display:column property="article.moisture" title="Чийгшил"
							sortable="true" />
						<display:column property="article.location.locationName" title="Байршил"
							sortable="true" />
					</display:table>
				</div>
			</div>
		</div>
	</div>
</div>