var div1, div2, img, msg;

window.onload = function() {

	div1 = document.getElementById("box1");
	div2 = document.getElementById("box2");
	msg = document.getElementById("msg");
	img = document.getElementById("img");
	
	div1.ondragenter = function(e) {
		//showObj(e);
	}
	div1.ondragover = function(e) {
		e.preventDefault();
	}
	div2.ondragover = function(e) {
		e.preventDefault();
	}
	img.ondragstart = function(e) {
		e.dataTransfer.setData("imgID", "img");
	}
	div1.ondrop = handler;
	div2.ondrop = handler;
}

function handler(e) { // 必须先复写系统事件 ondragover
	showObj(e.dataTransfer);
	e.preventDefault();
	// 创建节点
	var img1 = document.getElementById(e.dataTransfer.getData("imgID"));
	this.appendChild(img1);
}

function showObj(obj) {
	var s = "";
	for (var i in obj) {
		s += i + ":" + obj[i] + "<br/>";
	}
	msg.innerHTML = s;
}