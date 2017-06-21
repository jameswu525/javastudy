$(document).ready(function(){
});

function checkValidate() {
	var v = $("#age").val();
	var intRegex = /^\+?[1-9][0-9]*$/;
	if(!!!intRegex.exec(v)) {
		$("#age").val("");
		$("#errorMsg").text("ERROR， 请输入正确的数字");
		$("#errorMsg").css("color", "red");
	} else {
		$("#errorMsg").text("");
		$("#errorMsg").css("color", "green");
	}
//	$("#ageMsg").innerText=v + " is error";
	return false;
}