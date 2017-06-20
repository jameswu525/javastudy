$(document).ready(function(){
	$("#btnSubmit").click(function(){checkValidate();});
});

function checkValidate() {
	var v = $("#age").val();
	var intRegex = /^\+?[1-9][0-9]*$/;
	if(!!!intRegex.exec(v)) {
		$("#age").val("");
		$("#ageMsg").val("ERROR");
	} else {
		//alert ("数字");
		$("#ageMsg").val("");
	}
//	$("#ageMsg").innerText=v + " is error";
	return false;
}