<%@page import="javax.swing.JOptionPane"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
 <script type='text/javascript' src='../fullcalendar/_loader.js'></script>
 <style type='text/css'>
       #calendar {
           width: 100%;
           margin: 0 auto;
       }
  </style>
        <script type='text/javascript'>

            $(document).ready(function()
            {
                var date = new Date();
                var d = date.getDate();
                var m = date.getMonth();
                var y = date.getFullYear();
                $("#dialog").dialog({
				      autoOpen: false,
				      modal: true
				});
                var $dialogContent = $("#dialogh").dialog(
        		       	{
        					modal: true,
        					autoOpen: false,
        					buttons: [
										{
											html: "<i class='icon-user bigger-110'></i>&nbsp; Үйлчлүүлэгч",
											"class" : "btn btn-primary btn-xs hide",
											"id" : "buttonCus",
											click: function() {
												document.getElementById('link').click();
											}
										},
										{
											html: "<i class='icon-trash bigger-110'></i>&nbsp; Delete",
											"class" : "btn btn-danger btn-xs hide",
											"id" : "buttonDel",
											click: function() {
												$(this).dialog( "close" );
												document.getElementById('delete').click();
											}
										},
										{
        									html: "<i class='icon-save bigger-110'></i>&nbsp; Ok",
        									"class" : "btn btn-success btn-xs",
        									"id" : "buttonOk",
        									click: function() {
        										var haha5 = document.getElementById("haha4");
        										var myRadio = $dialogContent.find('input[name=active]');
        										var checkedValue = myRadio.filter(':checked').val();
        										if (checkedValue == 1) {
        										<%
        										if (request.getSession().getAttribute("id") != null) {%>
        										$dialogContent.find("input[name = 'patientid']").val(haha5.innerHTML);
        										document.getElementById('but').click();
        										<%;
        										} else {%>
        										alert("Үйлчлүүлэгчээ сонгоно уу !!!!");
        										<%;
        										}%>
        										} else {
        											$dialogContent.find("input[name = 'patientid']").val(null);
        											document.getElementById('but').click();
        										}
        											$(this).dialog( "close" );
        									}
        								}
										,
        								{
        									html: "<i class='icon-save bigger-110'></i>&nbsp; Ok",
        									"class" : "btn btn-success btn-xs",
        									"id" : "buttonEdit",
        									click: function() {
        										var haha5 = document.getElementById("haha4");
        										var myRadio = $dialogContent.find('input[name=active]');
        										var myPatientId = $dialogContent.find('input[name=patientid]');
        										var checkedValue = myRadio.filter(':checked').val();
        										var myPatientIdValue = myPatientId.val();
        										<%-- if (checkedValue != 1) {
        											$dialogContent.find("input[name = 'patientid']").val(null);
        											document.getElementById('but').click();
        										} else{
        											 if(myPatientIdValue == ""){
        												<%
                										if (request.getSession().getAttribute("id") == null) {%>
                											alert("Үйлчлүүлэгчээ сонгоно уу !!!!");
                										<%}else{%>
                											$dialogContent.find("input[name = 'patientid']").val(haha5.innerHTML);
                											document.getElementById('but').click();
                										<%}%>
                										}else{
                											document.getElementById('but').click();
                										} 
        										} --%>
        										document.getElementById('but').click();
        										$(this).dialog( "close" );
        									}
        								}
										,
        								{
        									html: "<i class='icon-remove bigger-110'></i>&nbsp; Cancel",
        									"class" : "btn btn-warning btn-xs",
        									click: function() {
        										$(this).dialog( "close" );
        									}
        								}
        							]
        				});
		        $.getJSON("jsondoctors", function(result)
		        {
		        	pageInit(result,$dialogContent);
		        });
		        
		       	$(document).ajaxStart(function(){
				      $( "#dialog" ).dialog( "open" );
			    });
				$(document).ajaxStop(function(){
					$( "#dialog" ).dialog( "close" );
				 });
				$("#delete").click(function(event)
						{
							event.preventDefault();
							 $.ajax(
							{
								url: "deleteAppointment",
								data:
								{
									"id" : $("input[name='id']").val(),
									"time" : $("input[name='time']").val(),
									"patientid" : $("input[name='patientid']").val(),
									"duration" : $("input[name='duration']").val(),
									"resourceId" : $("input[name='resourceId']").val(),
									"title" : $("textarea[name='title']").val(),
									"active" : $("input[name='active']").val()
								},
								success: function(result)
								{
									$('#calendar').fullCalendar( 'refetchEvents' );
								}
							}); 
						});
				$("#but").click(function(event)
						{
							event.preventDefault();
							 $.ajax(
							{
								url: "saveAppointment",
								data:
								{
									"id" : $("input[name='id']").val(),
									"time" : $("input[name='time']").val(),
									"patientid" : $("input[name='patientid']").val(),
									"duration" : $("input[name='duration']").val(),
									"resourceId" : $("input[name='resourceId']").val(),
									"title" : $("textarea[name='title']").val(),
									"active" : $("input[name='active']").val()
								},
								success: function(result)
								{
									$('#calendar').fullCalendar( 'refetchEvents' );
								}
							}); 
						});
				$("#butEdit").click(function(event)
						{
							event.preventDefault();
							 $.ajax(
							{
								url: "saveAppointment",
								data:
								{
									"id" : $("input[name='id']").val(),
									"time" : $("input[name='time']").val(),
									"patientid" : $("input[name='patientid']").val(),
									"duration" : $("input[name='duration']").val(),
									"resourceId" : $("input[name='resourceId']").val(),
									"title" : $("textarea[name='title']").val(),
									"active" : $("input[name='active']").val()
								},
								success: function(result)
								{
									$('#calendar').fullCalendar( 'refetchEvents' );
								}
							}); 
						});
				$("#button").click(function(event)
						{
							event.preventDefault();
							 $.ajax(
							{
								url: "updateAppointment",
								data:
								{
									"id" : $("input[name='id']").val(),
									"time" : $("input[name='time']").val(),
									"patientid" : $("input[name='patientid']").val(),
									"duration" : $("input[name='duration']").val(),
									"resourceId" : $("input[name='resourceId']").val(),
									"title" : $("textarea[name='title']").val(),
									"active" : $("input[name='active']").val()
								},
								success: function(result)
								{
									$('#calendar').fullCalendar( 'refetchEvents' );
								}
							}); 
						});
            });
            
            function pageInit(ddk,$dialogContent)
            {
            	var calendar = $('#calendar').fullCalendar({
                    header: {
                        left: 'prev,next today',
                        center: 'title'
                    },
                    titleFormat: 'ddd, MMM dd, yyyy',
                    defaultView: 'resourceDay',
                    selectable: true,
                    slotMinutes:10,
                    minTime:8,
                    maxTime:19,
                    selectHelper: true,
                    select: function(start, end, allDay, event, resourceId) {
                    	$dialogContent.find("select[name='start']").val(start);
                    	$dialogContent.find("select[name='end']").val(end);
                    	$dialogContent.find("textarea[name='title']").val("");
                    	$dialogContent.find("input[name = 'duration']").val(parseInt(end - start) / 60000);
                    	$dialogContent.find("input[name = 'time']").val(start.getTime());
                        $dialogContent.find("input[name = 'resourceId']").val(resourceId);
                        $dialogContent.find("input[name = 'id']").val("");
                        $("#buttonDel").addClass("hide");
                        $("#buttonCus").addClass("hide");
                        $("#buttonOk").removeClass("hide");
                        $("#buttonEdit").addClass("hide");
				   		$("#dialogh").dialog("open");
				   		 $(".actClass").show();
				   		$("#dialogh").dialog('option', 'title', "new");
                    },
                    eventResize: function(event, dayDelta, minuteDelta) {
                    	$dialogContent.find("select[name='start']").val(event.start);
                    	$dialogContent.find("select[name='end']").val(event.end);
                    	$dialogContent.find("textarea[name='title']").val(event.subTitle);
                    	$dialogContent.find("input[name = 'duration']").val(parseInt(event.end - event.start) / 60000);
                    	$dialogContent.find("input[name = 'time']").val(event.start.getTime());
                        $dialogContent.find("input[name = 'resourceId']").val(event.resourceId);
                        $dialogContent.find("input[name='id']").val(event.id);
                        document.getElementById('button').click();
                    },
                    eventDrop: function( event, dayDelta, minuteDelta, allDay) {
                    	$dialogContent.find("select[name='start']").val(event.start);
                    	$dialogContent.find("select[name='end']").val(event.end);
                    	$dialogContent.find("textarea[name='title']").val(event.subTitle);
                    	$dialogContent.find("input[name = 'duration']").val(parseInt(event.end - event.start) / 60000);
                    	$dialogContent.find("input[name = 'time']").val(event.start.getTime());
                        $dialogContent.find("input[name = 'resourceId']").val(event.resourceId);
                        $dialogContent.find("input[name='id']").val(event.id);
                        document.getElementById('button').click();
                    },
                    eventClick: function(event, jsEvent, view) {
                    	var myRadio = $dialogContent.find('input[name=active]');
						var checkedValue = myRadio.filter(':checked').val();
                    	$dialogContent.find("select[name='start']").val(event.start);
                    	$dialogContent.find("select[name='end']").val(event.end);
                    	$dialogContent.find("textarea[name='title']").val(event.subTitle);
                    	$dialogContent.find("input[name = 'duration']").val(parseInt(event.end - event.start) / 60000);
                    	$dialogContent.find("input[name = 'time']").val(event.start.getTime());
                        $dialogContent.find("input[name = 'resourceId']").val(event.resourceId);
                        $dialogContent.find("input[name = 'patientid']").val(event.body);
                        $dialogContent.find("input[name='id']").val(event.id);
                        $("#dialogh").dialog('option', 'title', event.title);
                        $("#buttonDel").removeClass("hide");
                        $("#buttonCus").removeClass("hide");
                        $("#buttonOk").addClass("hide");
                        $("#buttonEdit").removeClass("hide");
                        $(".actClass").hide();
				   		$("#dialogh").dialog("open");
                    },
                    editable: true,
                    resources: ddk,
                    events: "appointments",
                    titleFormat: {
                        month: "MMMM yyyy",
                        week: "d.[ MMMM][ yyyy]{ - d. MMMM yyyy}",
                        day: "dddd, yyyy MMMM d"},
                      columnFormat: {
                        month: "ddd",
                        week: "ddd d.M.",
                        day: "dddd d.M."},
                      axisFormat: 'H:mm',
                      timeFormat: {
                          '': 'H:mm', 
                      agenda: 'H:mm{ - H:mm}'
                      },
                      isRTL: false,
                      firstDay: 1,
                      monthNames: ["1-р сарын","2-р сарын","3-р сарын","4-р сарын","5-р сарын","6-р сарын","7-р сарын","8-р сарын","9-р сарын","10-р сарын","11-р сарын","12-р сарын"],
                      dayNames: ["Ня","Да","Мя","Лха","Пү","Ба","Бя"],
                      dayNamesShort: ["Ня","Да","Мя","Лха","Пү","Ба","Бя"],
                      buttonText: {
                        prev: "&nbsp;&#9668;&nbsp;",
                        next: "&nbsp;&#9658;&nbsp;",
                        prevYear: "&nbsp;&lt;&lt;&nbsp;",
                        nextYear: "&nbsp;&gt;&gt;&nbsp;",
                        today: "Өнөөдөр",
                        month: "Сар",
                        week: "7 хоног",
                        day: "Өдөр"},
                });
            }

        </script>
<div class="hidden" id="page">
	<s:url action="calendar" includeParams="none" />
</div>
<div class="page-content">
<div class="page-header">
	<s:form action="search-patient">
		<div class="col-sm-12 col-lg12" onclick="patientLink(${session.id.id})" id="link1">
			<div class="col-sm-2 col-lg-2">
				<label><strong><s:text name="appPatient" /></strong></label>&nbsp;
			</div>
			<div class="col-sm-2 col-lg-2">
				<s:property value='%{#session.id.regNumber}' /> &nbsp;
			</div> 
			<div class="col-sm-2 col-lg-2">
				<s:property value='%{#session.id.lastName}' /> &nbsp;
			</div>
			<div class="col-sm-2 col-lg-2">
				<s:property value='%{#session.id.firstName}' /> &nbsp;
			</div>
			<div class="col-sm-2 col-lg-2">
				<s:property value='%{#session.id.mobil_1}' />
			</div>
			<div class="col-sm-2 col-lg-2">
				<button class="btn btn-success btn-xs" >
				     <s:text name="changePatient" />
				</button>
			</div>
		</div>
	</s:form>
</div>
<div class="row">
	<div class="col-xs-12">
        <div id='calendar'></div>
        <div id="dialogh">
		<s:form action="saveAppointment" onclick="saveAppointment" cssClass="form-horizontal">
			<s:hidden name="id" />
			<s:hidden key="time" />
			<s:hidden key="patientid" value="%{#session.id.id}" />
			<s:hidden key="duration" />
			<s:hidden key="resourceId" />
			<s:radio key="active" list="#{'1':'Бүртгэлтэй','2':'Бүртгэлгүй'}"
				value="1" id="act" cssClass="actClass"/>
			<s:textarea key="title" cssStyle="width:180px" cssClass="form-control" />
			<s:submit id="but" cssStyle="display:none" />
			<s:submit id="button" cssStyle="display:none"
				action="updateAppointment" />
			<s:submit id="delete" cssStyle="display:none"
				action="deleteAppointment" />
		</s:form>
		<s:form action="backCal">
			<s:hidden key="patientid" />
			<s:submit id="link" cssStyle="display:none" />
		</s:form>
	    </div>
	<div id="hide1" class="hide">
		<p id="haha4">
			<s:property value="#session.id.id" />
		</p>
	</div>
	</div>
</div>
</div>
<div id="dialog" title="Wait">
       <div style="text-align:center; width: 100%">
            <p>Түр хүлээн үү!</p>
            <img src="../img/waiting.gif" height="30px" width="40px"/>
       </div>
   </div>
