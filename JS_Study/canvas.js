var C_WIDTH = 500, C_HEIGHT = 500;
var myCanvas, context;

window.onload = function() {
	createCanvas();
	//drawRect();
	drawImage();
}

function drawImage() {
	var img = new Image();
	img.onload = function() {
		context.rotate(45);  // 旋转
		context.drawImage(img, 0, 0);
	}
	img.src = "js/7.jpg";
}

function drawRect() {
	context.fillStyle = "#FF0";
//	context.rotate(45);  // 旋转
	context.translate(100, 100);  // 移动
	context.scale(2, 0.5)  // 缩放;
	context.fillRect(5, 5, 100, 100)
}

function createCanvas() {
	var c = document.createElement("canvas");
	myCanvas = c;
	context = myCanvas.getContext("2d");
	c.id = "mycanvas";
	c.width = C_WIDTH;
	c.height = C_HEIGHT;
	document.body.appendChild(c);
}