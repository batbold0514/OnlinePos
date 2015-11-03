<%@page import="mn.infosystems.mobile.model.SubGroup"%>
<%@page import="mn.infosystems.mobile.service.MobileStaticFunctions"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p class = "active_menu hide">KeepingAndCredit</p>
<div class = "row">
	<div class = "col-sm-6 col-lg-6">
		<button class="btn btn-sm btn-success btn-block" id="addGroup">
			<i class="icon-home"></i>
			<s:text name = "subGroup"/>
		</button>
	</div>
	<%-- <div class = "col-sm-6 col-lg-6">
		<button class="btn btn-sm btn-info btn-block" id="addTeachingAid">
			<i class="icon-home"></i>
			<s:text name = "teachingAid"/>
		</button>
	</div> --%>
</div>
<div class = "row">
<div class = "hide" id = "returnPackage">KeepingAndCredit</div>
<div id="MyTree6" class="tree tree-no-line tree-unselectable">
 <% 
	List<SubGroup> list =(List<SubGroup>) request.getAttribute("subGroupList");
		out.print(MobileStaticFunctions.convertTree(list));
	%> 
</div>
</div>

<div id ="dialog-addGroup" class = "hide">
	<s:form action="" id = "addForm">
		<s:hidden name="id" />
		<s:hidden name = "categoryId" list="categories" listKey="id" listValue="description" value = "0"/>
		<div class="form-group">
			<div class="row">
				<label for="groupName" class="control-label col-sm-5 col-lg-5">
					<s:text name="groupName" /><span class="required"> * </span>
				</label>
				<div class="col-sm-7 col-lg-6">
					<s:textfield name="groupName" cssClass="form-control"
						id="groupName" autofocus="" />
				</div>
			</div>
		</div>
		<s:submit id = "submitOk" cssClass="hide"/>
	</s:form>
</div>
<div id = "addSubGroup" class = "hide"></div>
<div id = "addTeachingAid" class = "hide"></div>
<div id="parseResult" class=hidden></div>
<div id="context" class="hide">${pageContext.request.contextPath}
</div>
<link rel="stylesheet" type="text/css" href="../js/fileinput/highslide.css" />
 <script type="text/javascript" src="../js/fileinput/highslide-full.js"></script> 
<link rel="stylesheet" type="text/css" href="../assets/plugins/fuelux/css/tree-metronic.css"/>
<script src="../assets/plugins/fuelux/js/tree.js"></script>
<script src="../js/PageJS/subGroupList.js">
</script>
<script>
jQuery(document).ready(function() {       
	   // initiate layout and plugins
	   var DataSourceTree = function (options) {
                this._data  = options.data;
                this._delay = options.delay;
            };

            DataSourceTree.prototype = {

                data: function (options, callback) {
                    var self = this;

                    setTimeout(function () {
                        var data = $.extend(true, [], self._data);

                        callback({ data: data });

                    }, this._delay)
                }
            };
	   var treeDataSource6 = new DataSourceTree({
                data: [
                ],
                delay: 400
            }); 
	   $('#MyTree6').tree({
           selectable: false,
           dataSource: treeDataSource6,
           loadingHTML: '<img src="../assets/img/input-spinner.gif"/>',
       });
	});
</script>