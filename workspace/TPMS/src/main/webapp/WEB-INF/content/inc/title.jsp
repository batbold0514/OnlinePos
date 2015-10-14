<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script>
	function location1()
	{
		window.location = 'trackingSheetList';
	}
</script>
<table style="width: 100%;">
	<tr>
		<th>
			<img src="../img/Logo25.png" onclick="location1()" alt="Logo">
		</th>
		<th width="80%" style="text-align: center; vertical-align: middle;">
			<div>
				<h1 style="font-size: 40px;">
					<s:text name="projectName" />
				</h1>
			</div>
		</th>
			<%-- <td width="10%" style="vertical-align: top" align="right">
			<div style="vertical-align: top">
				<s:url id="localeDE" namespace="/" action="locale">
					<s:param name="request_locale">de</s:param>
				</s:url>
				<s:a href="%{localeDE}">De&nbsp;/</s:a>
				<s:url id="localeA" namespace="/" action="locale">
					<s:param name="request_locale">mn</s:param>
				</s:url>
				<s:a href="%{localeA}">АМ&nbsp;/</s:a>
				<s:url id="localeA" namespace="/" action="locale">
					<s:param name="request_locale">en</s:param>
				</s:url>
				<s:a href="%{localeA}">EN</s:a>
			</div>
		</td> --%>
	</tr>
</table>
