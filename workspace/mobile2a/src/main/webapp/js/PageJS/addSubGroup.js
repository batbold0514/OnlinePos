jQuery(function($) {
	initValidatorSub();
});
function initValidatorSub() {
	$('#addSubGroupFrom').bootstrapValidator({
		fields : {
			subGroupName : {
				validators : {
					notEmpty : {
						message : 'Дэд бүлгийн нэр оруулна уу?'
					}
				}
			}

		}
	}).on('success.form.bv', function(e) {
        e.preventDefault();
        $.post('addSubGroupAjax', $("#addSubGroupFrom").serialize(), function(result) {
        	if (result.trim() != "") {
				errorMessage();
				$("#parseResult").html(result);
				for ( var i = 0; $(".errorMessage").length > i; i++) {
					var idName = $(".errorMessage").eq(i).attr("id");
						$('#addForm').bootstrapValidator(
								'revalidateField', idName);
				}
			} else {
				window.location = "KeepingAndCredit";
			}
        });
    });

}

