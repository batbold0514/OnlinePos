<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="panel-group bh-menu-footer" id="menu">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a href="#menu-search" data-toggle="collapse" data-parent="#menu">
					<i class="fa fa-search fa-fw"></i>
					<s:text name="search" />
				</a>
			</h4>
		</div>
		<div id="menu-search" class="panel-collapse collapse">
			<div class="panel-body">
				<ul class="nav nav-pills nav-stacked">
					<li>
						<a href="<s:url action="articleListSearch" includeParams="none"/>">
							<i class="icon icon-product fa-fw"></i>
							<s:text name="articleSearch" />
						</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a href="#menu-input" data-toggle="collapse" data-parent="#menu">
					<i class="fa fa-download fa-fw"></i>
					<s:text name="InputArticle" />
				</a>
			</h4>
		</div>
		<div id="menu-input" class="panel-collapse collapse">
			<div class="panel-body">
				<ul class="nav nav-pills nav-stacked">
					<li>
						<a href="<s:url action="inputArticleList" includeParams="none"/>">
							<i class="fa fa-list-alt fa-fw"></i>
							<s:text name="InputArticleList" />
						</a>
					</li>
					<li>
						<a href="<s:url action="newArticle" includeParams="none"/>">
							<i class="fa fa-plus fa-fw"></i>
							<s:text name="addArticle" />
						</a>
					</li>
					<li>
						<a href="<s:url action="import-article" includeParams="none"/>">
							<i class="icon icon-file-import fa-fw"></i>&nbsp;
							<s:text name="importFromFile" />
						</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a href="#menu-output" data-toggle="collapse" data-parent="#menu">
					<i class="fa fa-upload fa-fw"></i>
					<s:text name="OutputArticle" />
				</a>
			</h4>
		</div>
		<div id="menu-output" class="panel-collapse collapse">
			<div class="panel-body">
				<ul class="nav nav-pills nav-stacked">
				  	<li>
				  		<a href="<s:url action="outList" includeParams="none"/>">
				  			<i class="fa fa-list-alt fa-fw"></i>
				  			<s:text name="OutputArticleList" />
						</a>
				  	</li>
				  	<li>
				  		<a href="<s:url action="multipleOutput" includeParams="none"/>" id = "multiOutList">
				  			<i class="icon icon-multi-arrow fa-fw"></i>&nbsp;
							<s:text name="multipleOutput" />
						</a>
				  	</li>
				  	<li>
				  		<a href="<s:url action="outputArticleInvoice" includeParams="none"/>">
				  			<i class="fa fa-file-text-o fa-fw"></i>
							<s:text name="outputArticleInvoice" />
						</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<%
		if (request.isUserInRole("admin-role"))
		{
	%>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a href="#menu-article" data-toggle="collapse" data-parent="#menu">
					<i class="fa fa-archive fa-fw"></i>
					<s:text name="Article" />
				</a>
			</h4>
		</div>
		<div id="menu-article" class="panel-collapse collapse">
			<div class="panel-body">
				<ul class="nav nav-pills nav-stacked">
					<li>
						<a href="<s:url action="min-article-list" includeParams="none"/>">
							<i class="fa fa-exclamation-circle fa-fw"></i>
							<s:text name="minArticleList" />
						</a>
					</li>
					<li>
						<a href="<s:url action="articleCount" includeParams="none"/>">
							<i class="fa fa-edit fa-fw"></i>
							<s:text name="articleCount" />
						</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<%
		}
	%>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a href="#menu-settings" data-toggle="collapse" data-parent="#menu">
					<i class="fa fa-info fa-fw"></i>
					<s:text name="Settings" />
				</a>
			</h4>
		</div>
		<div id="menu-settings" class="panel-collapse collapse">
			<div class="panel-body">
				<ul class="nav nav-pills nav-stacked">
					<li>
						<a href="<s:url action="category-list" includeParams="none"/>">
							<i class="icon icon-category fa-fw"></i>&nbsp;
							<s:text name="Category" />
						</a>
					</li>
					<li>
						<a href="<s:url action="customer-list" includeParams="none"/>">
							<i class="icon icon-customer fa-fw"></i>&nbsp;
							<s:text name="Customer" />
						</a>
					</li>
					<li>
						<a href="<s:url action="colour-list" includeParams="none"/>">
							<i class="icon icon-paint fa-fw"></i>&nbsp;
							<s:text name="Colour" />
						</a>
					</li>
					<li>
						<a href="<s:url action="size-list" includeParams="none"/>">
							<i class="fa fa-crop fa-fw"></i>
							<s:text name="Size" />
						</a>
					</li>
					<li>
						<a href="<s:url action="measure-list" includeParams="none"/>">
							<i class="icon icon-scale fa-fw"></i>&nbsp;
							<s:text name="Measure" />
						</a>
					</li>
					<li>
						<a href="<s:url action="location-list" includeParams="none"/>">
							<i class="fa fa-location-arrow fa-fw"></i>
							<s:text name="Location" />
						</a>
					</li>
					<%
						if (request.isUserInRole("admin-role"))
						{
					%>
					<li>
						<a href="<s:url action="usersList" includeParams="none"/>">
							<i class="fa fa-user fa-fw"></i>
							<s:text name="user" />
						</a>
					</li>
					<%
						}
					%>
					<li>
						<a href="<s:url action="occupation-list" includeParams="none"/>">
							<i class="fa fa-briefcase fa-fw"></i>
							<s:text name="occupation" />
						</a>
					</li>
					<%
						if (request.isUserInRole("admin-role"))
						{
					%>
					<li>
						<a href="<s:url action="employee-list" includeParams="none"/>">
							<i class="icon icon-employee fa-fw"></i>&nbsp;
							<s:text name="employees" />
						</a>
					</li>
					<%
						}
					%>
				</ul>
			</div>
		</div>
	</div>
</div>