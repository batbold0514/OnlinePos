<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="hidden" id="page">
	<s:url action="colour-list" includeParams="none" />
</div>
<div class="panel
		<s:if test="id == null">
			panel-success
		</s:if>
		<s:else>
			panel-warning
		</s:else>"
	id="mainPanel">
	<div class="panel-heading">
		<h3 class="panel-title text-center">
			<span class="icon icon-paint"></span>&nbsp;
			<s:if test="id == null">
				<s:text name="addColour" />
			</s:if><s:else>
				<s:text name="editColour" />
			</s:else>
		</h3>
	</div>
	<div class="panel-body">
		<s:form action="save-colour" method="POST" cssClass="form-horizontal" id="mainForm">
			<s:hidden key="id" />
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="code" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="code" />(*):
						</label>
						<div class="col-sm-7 col-lg-6">
							<s:textfield key="code" cssClass="form-control" id="code" autofocus="" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6" id="errorCodeResult">
						<s:fielderror fieldName="code" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="name" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
							<s:text name="name" />(*):
						</label>
						<div class="col-sm-7 col-lg-6"> 
							<s:textfield key="name" cssClass="form-control" id="name" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6" id="errorNameResult">
						<s:fielderror fieldName="name"  />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-3 col-lg-offset-2 col-lg-2">
					<a href="colour-list" class="btn btn-back btn-block">
						<span class="fa fa-arrow-circle-o-left"></span>&nbsp;
						<s:text name="back" />
					</a>
				</div>
				<div class="col-sm-3 col-lg-2">
					<button type="reset" class="btn btn-gray btn-block">
						<span class="fa fa-refresh"></span>&nbsp;
						<s:text name="reset" />
					</button>
				</div>
				<div class="col-sm-4">
					<button type="submit" id="saveColour" class="btn btn-success btn-block">
						<span class="fa fa-save"></span>&nbsp;
						<s:text name="save" />
					</button>
				</div>
			</div>
		</s:form>
	</div>
</div>
<%-- <div id="parseResult" class="hidden">
</div>
<script>
	$(document).ready(function()
	{
		$("#saveColour").click(function(event)
		{
			event.preventDefault();
		    $.ajax(
			{
				url: "save-colour-ajax",
				data: $("#mainForm").serialize(),
				success: function(result)
				{
					if(result.trim() != "")
					{
						$("#parseResult").html(result);
						for (var i = 0; $(".errorMessage").length > i; i++)
						{
							var idName = $(".errorMessage").eq(i).attr("id");
							$("#" + idName + "Result").html($(".errorMessage").eq(i));
						}
						$(".errorMessage").parents(".form-group").addClass("has-error");
					}
				}
			});
		});
	});
</script> --%>