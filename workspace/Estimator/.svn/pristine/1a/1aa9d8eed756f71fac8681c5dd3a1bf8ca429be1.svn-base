<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="../css/jquery.dataTables.css" />
<script src="../assets/plugins/jquery-1.10.2.min.js"
	type="text/javascript"></script>
<script src="../js/jquery.dataTables.min.js"></script>


<%-- <style>
	div.content { width: 800px }
</style>

<div class="content">
	<div class="row">
		<img src="../img/logo_master.jpg" alt="logo"
			style="width: 80; height: 60x;"> <font size="20"> <s:text
				name="МАСТЕР ҮНЭЛГЭЭ ХХК"></s:text>
		</font>
		<hr>
	</div>
	<div class="row">
		<s:label value="АВТО МАШИН ТЕХНИКИЙН ҮНЭЛГЭЭНИЙ ТАЙЛАН"
			cssStyle="font-size: 20px;"></s:label>
	</div>
	<div>
		<table class="datatable table-bordered">
			<tr>
				<td>№
				<td>
				<td>Асуулт
				<td>
				<td>Хариулт
				<td>
			</tr>
		</table>
	</div>
</div> --%>

<div style="width: 700px; padding-left: 5px; font-size: 12px;">

	<table style="padding:5; border-spacing: 0 ; border-bottom: 2px solid blue;width: 100%">
		<tr>
			<td width="90px"><img
				src="http://unelgee.mn:80/images/logo_master.jpg" width="60"
				alt="LOGO" /></td>
			<td style="font-size: 42px; color: blue;">Мастер Үнэлгээ ХХК</td>
		</tr>
	</table>

	<div style="padding: 5px;" align="center">
		<div style="float: left; width: 20%; text-align: left;"></div>

		<div style="float: left; width: 59%">АВТО МАШИН ТЕХНИКИЙН
			ҮНЭЛГЭЭНИЙ ТАЙЛАН</div>

		<div style="float: left; width: 20%; text-align: right;">
			Утас: 75-95-9000, 99073218, 99316976<br />
		</div>
	<s:if test="#session.print.confirm.id == 1">
		<span style="color: red; font-weight: bold;"><s:property value="%{#session.print.confirm.description}"/></span>
	</s:if>
	</div>
	<br>

	<table style="width: 100%;padding: 0; border-spacing: 0 ;">
		<tr>
			<td WIDTH="30%"><s:property value="%{getText('{0,date,yyyy-MM-dd}',{#session.print.date})}"/></td>
			<td align="center">№3016 </td>
			<td WIDTH="30%" ALIGN="RIGHT">Улаанбаатар хот</td>
		</tr>
	</table>
	<br>

	<table  style="padding: 0; border-spacing: 0 ;width: 100%" 
		class="display table-bordered table-hoverdataTable borderbr">

		<tr>
			<td class="borderbr"  width="30px">№</td>
			<td class="borderbr" width="26%">Асуулт</td>
			<td class="borderbr">Хариулт</td>
		</tr>

		<tr>
			<td class="borderbr">1</td>
			<td class="borderbr">Захиалагч</td>
			<td class="borderbr"><s:property
					value="%{#session.print.consumer}" /></td>
		</tr>
		<tr>
			<td class="borderbr">2</td>
			<td class="borderbr">Захиалагчийг төлөөлж</td>
			<td class="borderbr"><s:property
					value="%{#session.print.agentCunsomer}" /></td>
		</tr>
		<tr>
			<td class="borderbr"></td>
			<td class="borderbr">Хариуцагч</td>
			<td class="borderbr"><s:property
					value="%{#session.print.defendant}" /></td>
		</tr>
		<tr>
			<td class="borderbr">3</td>
			<td class="borderbr">Гүйцэтгэгчийг төлөөлж</td>
			<td class="borderbr"><s:property
					value="%{#session.print.mainEmp.firstName}" /> <s:property
					value="%{#session.print.emp1.firstName}" /> <s:property
					value="%{#session.print.emp2.firstName}" /></td>
		</tr>
		<tr>
			<td class="borderbr">4</td>
			<td class="borderbr">Тээврийн хэрэгсэл үзлэг хийх үед ямар
				байсан</td>
			<td class="borderbr"><s:property
					value="%{#session.print.estimateStat}" /></td>
		</tr>
		<tr>
			<td class="borderbr">5</td>
			<td class="borderbr">Үнэлгээ хийхэд тулгуурласан материал</td>
			<td class="borderbr"><s:property
					value="%{#session.print.estimateMaterial}" /></td>
		</tr>
		<tr>
			<td class="borderbr">6</td>
			<td class="borderbr">Машины зориулалт</td>
			<td class="borderbr"><s:property
					value="%{#session.print.carType.type}" /></td>
		</tr>
		<tr>
			<td class="borderbr">7</td>
			<td class="borderbr">Програм хангамжийн тухай</td>
			<td class="borderbr">Тээврийн хэрэгслийн хохирлын үнэлгээний
				Estimator програм нь өндөр хурдтай, нууцлал сайтай, интернетээр
				холбогдох боломжтой зэрэг давуу талтай.</td>
		</tr>
		<tr>
			<td class="borderbr">8</td>
			<td class="borderbr">Үнэлгээгээр тогтоогдсон дүн</td>
			<!--     DFSDFSDFSDFSD   -->
			<td class="borderbr"><s:property
					value="%{#session.print.marketPrice}" /></td>
		</tr>
		<tr>
			<td class="borderbr">9</td>
			<td class="borderbr">Үнэлгээний баталгаа</td>
			<td class="borderbr"><s:property
					value="%{#session.print.estimateQuarantee}" /></td>
		</tr>
		<tr>
			<td class="borderbr">10</td>
			<td class="borderbr">Үнэлгээг ашиглаж болох нөхцлүүд</td>
			<td class="borderbr"><s:property
					value="%{#session.print.estimateUseState}" /></td>
		</tr>
		<tr>
			<td class="borderbr">11</td>
			<td class="borderbr">Үнэлгээчний мэргэжил дадлагын түвшин</td>
			<td class="borderbr"><s:property
					value="%{#session.print.estimatorExp}" /></td>
		</tr>
		<tr>
			<td class="borderbr">12</td>
			<td class="borderbr">Тайлан бичиж дууссан огноо</td>
			<td class="borderbr"><s:property value="%{getText('{0,date,yyyy-MM-dd}',{#session.print.date})}"/></td>
		</tr>
	</table>

	<div align="center" style="padding: 10px;">ТАЙЛАН БИЧСЭН:</div>

	<div align="center">
		<table style="width: 70%;padding: 5; border-spacing: 0 ;">


			<tr>
				<td width="30%">МЭРГЭЖИЛТЭН</td>
				<td>&nbsp;</td>
				<td width="30%"><s:property
						value="%{#session.print.mainEmp.firstName}" /></td>
			</tr>


			<tr>
				<td>АХЛАХ ҮНЭЛГЭЭЧИН</td>
				<td>&nbsp;</td>
				<td><s:property value="%{#session.print.emp1.firstName}" /></td>
			</tr>


			<tr>
				<td>БГД-Н САЛБАРЫН ЭРХЛЭГЧ</td>
				<td>&nbsp;</td>
				<td><s:property value="%{#session.print.emp2.firstName}" /></td>
			</tr>


		</table>
	</div>

</div>


<div style="width: 700px; padding-left: 5px; page-break-before: always ;font-size: 12px">
	<table 	style="border-bottom: 2px solid blue; width: 100% ; padding: 5; border-spacing: 0 ;">
		<tr>
			<td width="90px"><img
				src="http://unelgee.mn:80/images/logo_master.jpg" width="60"
				alt="LOGO" /></td>
			<td style="font-size: 42px; color: blue;">Мастер Үнэлгээ ХХК</td>
		</tr>
	</table>

	<div style="margin-bottom: 12px;">
		<div style="float: right;">Утас: 75-95-9000, 99073218, 99316976
		</div>
	</div>

	<div style="padding: 5px; font-size: 14px; font-weight: bold;"
		align="center">АВТО МАШИН ТЕХНИКИЙН ЭВДРЭЛ, ХОХИРЛЫН ҮНЭЛГЭЭ</div>


	<table style="width: 100%;padding: 0; border-spacing: 0 ;">
		<tr>
			<td WIDTH="30%"><s:property value="%{getText('{0,date,yyyy-MM-dd}',{#session.print.date})}"/></td>
			<td align="center">№3016</td>
			<td WIDTH="30%" ALIGN="RIGHT">Улаанбаатар хот</td>
		</tr>
	</table>



	<table 	style="margin-bottom: 5px; margin-top: 5px;width: 100%;padding: 0; border-spacing: 0 ;">

		<tr>

			<td style="vertical-align: top;">

				<table style="width: 100%; border-spacing: 0 ;" class = "borderbr">
					<tr>
						<td class=" label1 borderbr">Эзэмшигчийн нэр:</td>
						<td class="borderbr"><s:property value="%{#session.print.ownerName}" />
						</td>
					</tr>
					<tr>
						<td class="borderbr label1">Хаяг:</td>
						<td class="borderbr"><s:property
								value="%{#session.print.ownerAddress}" /></td>
					</tr>
					<tr>
						<td class="borderbr label1">Утас:</td>
						<td class="borderbr"><s:property
								value="%{#session.print.ownerPhoneNumber}" /></td>
					</tr>
					<tr>
						<td class="borderbr label1">Үнэлгээний зорилго:</td>
						<td class="borderbr"><s:property value="%{#session.print.estPoint}" /></td>
					</tr>
					<tr>
						<td class="borderbr label1">Зах зээлийн үнэ:</td>
						<td class="borderbr"><s:property
								value="%{#session.print.marketPrice}" /></td>
					</tr>
					<tr>
						<td class="borderbr label1">Даатгалын төрөл:</td>
						<td class="borderbr"><s:property value="%{#session.print.itype.type}" /></td>
					</tr>
				</table>
			</td>
			<td style="vertical-align: top;width: 50%">

				<table style="width: 100%; border-spacing: 0 ;" class = "borderbr">
					<tr>
						<td class="borderbr label1">Үйлдвэр загвар:</td>
						<td class="borderbr"><s:property
								value="%{#session.print.carFactory.factoryName}" /></td>
					</tr>
					<tr>
						<td class="borderbr label1">Улсын дугаар:</td>
						<td class="borderbr"><s:property value="%{#session.print.cnumber}" /></td>
					</tr>
					<tr>
						<td class="borderbr label1">Үйлдвэрлэсэн он:</td>
						<td class="borderbr"><s:property
								value="%{#session.print.factoryDate}" /></td>
					</tr>
					<tr>
						<td class="borderbr label1">Орж ирсэн он:</td>
						<td class="borderbr"><s:property
								value="%{#session.print.importedDate}" /></td>
					</tr>
					<tr>
						<td class="borderbr label1">Өнгө:</td>
						<td class="borderbr"><s:property value="%{#session.print.color}" /></td>
					</tr>
					<tr>
						<td class="borderbr label1">Арлын дугаар:</td>
						<td class="borderbr"><s:property value="%{#session.print.vinNumber}" /></td>
					</tr>
				</table>

			</td>

		</tr>

	</table>


	<table  style="width: 100%; border-spacing: 0 ;" class = "borderbr">
		<tr>
			<td  class="borderbr">№</td>
			<td  class="borderbr">Эвдэрсэн эд энгийн нэр</td>
			<td  class="borderbr">Эвдрэл</td>
			<td  class="borderbr">Засварлах</td>
			<td  class="borderbr">Солих</td>
		</tr>

		<s:iterator value="#session.print.defectList" status="stat" var="iter">
			<tr>
				<th class="borderbr"><s:property value="" />${stat.index+1 }</th>
				<th class="borderbr"><s:property value="#iter.breakedPart.partName" /></th>
				<th class="borderbr"><s:property value="#iter.crashGrade.grade" /></th>
				<th class="borderbr"><s:property value="#iter.repairPrice" /></th>
				<th class="borderbr"><s:property value="#iter.changePrice" /></th>
			</tr>
		</s:iterator>




	</table>

	<div align="right" style="padding: 5px; font-weight: bold;">
		Үнэлгээгээр тогтоогдсон дүн: 6'186'000</div>


	<div align="center" style="padding: 5px;">ҮНЭЛГЭЭ ХИЙСЭН:</div>

	<div align="center">
		<table style="padding: 5; border-spacing: 0 ;width: 70%">


			<tr>
				<td width="30%">МЭРГЭЖИЛТЭН</td>
				<td>&nbsp;</td>
				<td width="30%">Б.САРУУЛ</td>
			</tr>


			<tr>
				<td>АХЛАХ ҮНЭЛГЭЭЧИН</td>
				<td>&nbsp;</td>
				<td>Ц.ЛХАГВАДУЛАМ</td>
			</tr>


			<tr>
				<td>БГД-Н САЛБАРЫН ЭРХЛЭГЧ</td>
				<td>&nbsp;</td>
				<td>Б.БОЛД-ЭРДЭНЭ</td>
			</tr>


		</table>
	</div>

	<div align="right" style="padding: 5px;">
		Тээврийн хэрэгслийн хохирол үнэлгээний <b>ESTIMATOR</b> онлайн програм
		<b>www.UNELGEE.mn</b>
	</div>

</div>
<script src="../js/PageJS/print.js"></script>
<style>
<!--

-->
.borderbr{
border : 1px solid
}
</style> 