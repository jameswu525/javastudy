var fs = require('fs');
module.exports = {
	writefile:function(path, data, recall) {
		fs.writeFile(path, data, function(err) {
			if(err) {
				console.log(err);
				throw err;
			} else {
				console.log("Saved Content:" + data.toString());
				recall(data);
			}
		});
		console.log("异步写成功");
	},	
	writefileSync:function(path, data) {
		fs.writefileSync(path, data);
		console.log("同步写成功");
	},
	readfile:function(path, recall) {
		fs.readFile(path, function(err, data) {
			if(err) {
				console.log(err);
			} else {
				//console.log(data.toString());
				recall(data);
			}
		});
		console.log("异步读取成功");
	},
	readfileSync:function(path, res) {
		var data = fs.readFileSync(path, 'utf-8');
		console.log(data);
		res.write('同步读出：' + data + '<br>');
		console.log("同步读取成功");
		//return data;
	}
}