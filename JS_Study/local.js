var txt, btn;
window.onload = function() {
	txt = document.getElementById("txt");
	btn = document.getElementById("btn");
	
	if (localStorage.text) {
		txt.value = localStorage.text;
	}
	btn.onclick=function() {
//		console.log(txt.value);
		localStorage.text = txt.value;
	}
}
