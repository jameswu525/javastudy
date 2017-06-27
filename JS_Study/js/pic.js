window.onload = function() {
	console.log("瀑布流");
	imgLocation("container", "box");

	// 滚动条加载方法，实现滚动条拖到底部后加载新的内容
	window.onscroll = function() {
		var rst = checkFlag("container", "box");
		if (rst) {
			var imgData = {"data":[{"src":"7.jpg"},{"src":"8.jpg"},{"src":"9.jpg"},{"src":"3.jpg"},{"src":"4.jpg"},{"src":"5.jpg"}]};
			var cparent = document.getElementById("container");
			for (var i = 0; i < imgData.data.length; i++) {
				var ccontent = document.createElement("div");
				ccontent.className = "box";
				cparent.appendChild(ccontent);

				var boximg = document.createElement("div");
				boximg.className = "box_img";
				ccontent.appendChild(boximg);
				//console.log(imgData.data[i].src);

				var img = document.createElement("img");
				img.src = "" + imgData.data[i].src;
				boximg.appendChild(img);
			}
			imgLocation("container", "box");
		}
	}
}

function checkFlag(parent, content) {
	var cparent = document.getElementById(parent);
	var ccontent = getChild(cparent, content);
	var lastContentHeight = ccontent[ccontent.length - 1].offsetTop;
	var scrollToping = document.documentElement.scrollTop || document.body.scrollTop;
	var pageHeight = document.documentElement.clientHeight || document.body.clientHeight;
	//console.log("==>" + lastContentHeight + ":" + scrollToping + ":" + pageHeight);
	return lastContentHeight < scrollToping + pageHeight;
}

function imgLocation(parent, content) {
	var cparent = document.getElementById(parent); // 得到容器节点
	var ccontent = getChild(cparent, content);     // 获取该容器中所有承载图片的box
	//console.log(ccontent);
	var width = ccontent[0].offsetWidth;			// 获取图片的宽度
	var cols = Math.floor(document.documentElement.clientWidth / width);  // 获取能够摆放图片的列数(取整)
	//console.log(cols);
	cparent.style.cssText="width:" + width * cols + "px;margin:0 auto";   // 固定容器的宽度，并且居中展示
	var boxHeightArr = [];
	for (var i = 0; i < ccontent.length; i++) {
		if (i < cols) {
			boxHeightArr.push(ccontent[i].offsetHeight);		// 保存行高
		} else {
			var minHeight = Math.min.apply(null, boxHeightArr); // 获取最低行高
			var index = getMinHeightIndex(boxHeightArr, minHeight);	// 获取最低行高的列
			//console.log(index);
			ccontent[i].style.position = "absolute";
			ccontent[i].style.top = minHeight + "px";
			ccontent[i].style.left = ccontent[index].offsetLeft + "px";
			boxHeightArr[index] = boxHeightArr[index] + ccontent[i].offsetHeight;	// 重新计算列的行高
		}
	}
}

function getMinHeightIndex(boxHeightArr,minHeight) {
	for (var i in boxHeightArr) {
		if (boxHeightArr[i] == minHeight) {
			return i;
		}
	}
}

function getChild(parent, content) {
	var contentArr = [];
	var allContent = parent.getElementsByTagName("*");  // 所有子节点
	for (var i = 0; i < allContent.length; i++) {
		if (allContent[i].className == content) {       // 承载图片的盒子
			contentArr.push(allContent[i]);
		}
	}
	return contentArr;
}