$(document).ready(function()
{
	$("#form-login").validate(
	{
		rules:
		{
			j_username:
			{
				required: true,
				minlength: 2
			},
			j_password:
			{
				required: true,
				minlength: 4
			}
		},
		messages:
		{
			j_username:
			{
				required: "Нэвтрэх нэрээ оруулна уу!",
				minlength: "Нэвтрэх нэр хамгийн багадаа 2-н тэмдэг, үсэгтэй байна!"
			},
			j_password:
			{
				required: "Нууц үгээ оруулна уу!",
				minlength: "Нууц үг хамгийн багадаа 4-н тэмдэг, үсэгтэй байна!"
			}
		},
		highlight: function(element, errorClass)
		{
			$(element).fadeOut(function()
			{
				$(element).fadeIn();
			});
		}
	});
});