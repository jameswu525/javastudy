var C_WIDTH = 500, C_HEIGHT = 500;
var myCanvas, stage, txt;
var count = 0;

window.onload = function() {
	createCanvas();
	stage = new createjs.Stage(myCanvas);
	txt = new createjs.Text("天下我有", "20px Arial", "#BBBBBB");
	stage.addChild(txt);
	
	createjs.Ticker.setFPS(50);
	createjs.Ticker.addEventListener("tick", tick);
}

function tick(e) {
	count ++;
	txt.text = "天下我有 : " + count + " !";
	stage.update();  // 一定要做更新，界面才会有效果
}

function createCanvas() {
	var c = document.createElement("canvas");
	myCanvas = c;
	c.id = "mycanvas";
	c.width = C_WIDTH;
	c.height = C_HEIGHT;
	document.body.appendChild(c);
}