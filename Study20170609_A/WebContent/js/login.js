$(function() {
	$("#user").on("blur", function() {
		validateUser();
	});
	
	$("#pwd").on("blur", function() {
		validatePassword();
	});
	
	$("loginForm").on("submit", function() {
		return validateUser() && validatePassword();
	});
	
});

function validateUser() {
	return validate("user");
};

function validatePassword() {
	return validate("pwd");
};

function validate(eleId) {
	if ($("#" + eleId).val() == "") {
		$("#" + eleId + "Div").attr("class", "form-group has-error");
		$("#" + eleId + "Span").html("<span class='text-danger'>不允许为空</span>");
		return false;
	} else {
		$("#" + eleId + "Div").attr("class", "form-group has-success");
		$("#" + eleId + "Span").html("<span class='text-success'>合法</span>");
		return true;
	}
};