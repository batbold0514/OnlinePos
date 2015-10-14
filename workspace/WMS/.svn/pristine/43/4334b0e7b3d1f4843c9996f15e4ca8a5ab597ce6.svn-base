<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="hidden" id="page">
	<s:url action="size-list" includeParams="none"/>
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
    		<span class="fa fa-crop"></span>&nbsp;
    		<s:if test="id == null">
    			<s:text name="addSize" />
    		</s:if>
    		<s:else>
    			<s:text name="editSize" />
    		</s:else>
    	</h3>
  	</div>
  	<div class="panel-body">
		<s:form action="save-size" method="POST" cssClass="form-horizontal">
    		<s:hidden key="id" />
		  	<div class="form-group">
		  		<div class="row">
					<div class="col-sm-12">
				    	<label for="sizes" class="control-label col-sm-4 col-lg-offset-1 col-lg-3">
				    		<s:text name="sizes" />(*):
				    	</label>
				    	<div class="col-sm-7 col-lg-6">
					    	<s:textfield key="sizes" cssClass="form-control" id="sizes" autofocus="" />
				    	</div>
				    </div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-7 col-lg-offset-4 col-lg-6">
						<s:fielderror fieldName="sizes"/>
					</div>
				</div>
		  	</div>
		  	<div class="form-group">
				<div class="col-sm-offset-1 col-sm-3 col-lg-offset-2 col-lg-2">
					<a href="size-list" class="btn btn-back btn-block">
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
					<button type="submit" id="saveSize" class="btn btn-success btn-block">
						<span class="fa fa-save"></span>&nbsp;
						<s:text name="save" />
					</button>
				</div>
			</div>
		</s:form>
  	</div>
</div>