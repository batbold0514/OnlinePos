<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>

<link href="../css/style.css" rel="stylesheet" type="text/css" />
<center>
	<h2>
		<s:text name="" />
	</h2>
</center>
<table style="width: 100%; font-family: comic sans ms">
	<s:iterator value="doctorSessionList">
		<tr style="width: 100%">
			<th style="border-top: 1px dashed black"><s:property
					value="date" /></th>
			<th style="border-top: 1px dashed black"><s:property
					value="doctor.name" /></th>
		</tr>
		<tr>
			<th colspan="2">
				<ul style="list-style-type: decimal">
					<s:iterator value=" listOfService" status="stat">
							<tr>
								<td style="width: 50%"><s:property value="#stat.index+1"/>.  <s:property value="name" /></td>
								<td style="width: 50%"><s:property value="price" /></td>
							</tr>
					</s:iterator>
				</ul>
			</th>
		</tr>
		<tr style="witdh: 100%">
			<th style="border-top: 1px dashed black">
				<s:property value="note"/>
			</th>
		</tr>
		<tr>
			<td style="width: 50%" align="center"><s:text name="edit"/></td>
			<td style="width: 50%">&#8721 &nbsp &nbsp<s:property value="sum" /></td>
		</tr>
	</s:iterator>
</table>