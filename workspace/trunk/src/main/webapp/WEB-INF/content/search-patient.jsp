<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="hidden" id="page">
	<s:url action="search-patient" includeParams="none" />
</div>
<div class="page-content">
	<div class="page-header">
		<h2>
			<s:text name="searchPatient" />
			<small> <i class="icon-double-angle-right"></i> Жагсаалт
			</small>
		</h2>
		<div id="d1"
			style="float: right; border-radius: 50px; background-color: #F0F0F0">
			<p id="s">
				<s:text name="advice" />
			</p>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12 col-lg-12">
			<s:form action="search" cssClass="form-horizontal">
				<div class="form-group">
					<label for=regNumber class="control-label col-sm-4 col-lg-4">
						<s:text name="regNumber" />:
					</label>
					<div class="col-sm-8 col-lg-4">
						<s:textfield name="regNumber" id="regNumber"
							cssClass="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label for=cardNumber class="control-label col-sm-4 col-lg-4">
						<s:text name="cardNumber" />:
					</label>
					<div class="col-sm-8 col-lg-4">
						<s:textfield name="cardNumber" id="cardNumber"
							cssClass="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label for=lastName class="control-label col-sm-4 col-lg-4">
						<s:text name="lastName" />:
					</label>
					<div class="col-sm-8 col-lg-4">
						<s:textfield name="lastName" id="lastName" cssClass="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label for=firstName class="control-label col-sm-4 col-lg-4">
						<s:text name="firstName" />:
					</label>
					<div class="col-sm-8 col-lg-4">
						<s:textfield name="firstName" id="firstName"
							cssClass="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label for=phone class="control-label col-sm-4 col-lg-4"> <s:text
							name="phone" />:
					</label>
					<div class="col-sm-8 col-lg-4">
						<s:textfield name="phone" id="phone" cssClass="form-control" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-6 col-sm-6 col-lg-2">
						<button class="col-sm-12 btn brn-success" id="search123">
							<span class="fa fa-search"></span>&nbsp;
							<s:text name="search" />
						</button>
					</div>
				</div>
			</s:form>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$('#s1').hide();
		$('#s').click(function() {
			$('#s1').show(1000);
			$('#s').hide();
		});
		$('#s2').click(function() {
			$('#s1').hide(1000);
			$('#s').show();
		});
	});
</script>
<style>
#s2:hover {
	color: red;
	text-decoration: underline;
}

#d1:hover {
	background-color: #E0E0E0;
}

#s:hover {
	color: red;
	text-decoration: underline;
}
</style>
<div id="s1"
	style="margin-bottom: 10px; text-align: left; border-radius: 50px; background-color: #F0F0F0; padding-left: 50px; padding-top: 20px; padding-bottom: 20px">
	<ul>
		<li>Хайлт хийхэд бүх талбар өгөгдөлтэй байх шаардлагагүй</li>
		<li>Хоёр буюу түүнээс дээш өгөгдөл хийвэл & холбоосоор хайна</li>
		<li>Өгөгдөл бичилгүй буюу бүх талбар хоосон байхад хайлт хийвэл
			бүх үйлчлүүлэгчдийн жагсаалт гарна</li>
		<li>Хайж буй өгөгдлөө бүрэн мэдэхгүй бол дутуу бичээд хайж болно.</li>
		<ul>
			<li>Жишээ нь:<br> "бат"-ийг хайхад "бат" орсон бүх нэрнүүд
				(<b>бат</b>болд, хүрэл<b>бат</b>, Ган<b>бат</b>хүү) олдоно.
			</li>
		</ul>
		</li>
	</ul>
	<div id="s2">Хаах</div>
</div>