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
		// console.log("异步写成功");
	},
	writefileSync:function(path, data) {
		fs.writefileSync(path, data);
		// console.log("同步写成功");
	},
	appendfile:function(path, data, recall) {
		fs.appendFile(path, data, function(err) {
			if(err) {
				console.log(err);
				throw err;
			} else {
				console.log("Append Content:" + data.toString());
				recall(data);
			}
		});
		// console.log("异步再写成功");
	},
	readfile:function(path, recall) {
		fs.readFile(path, function(err, data) {
			if(err) {
				console.log(err);
				recall("文件不存在");
			} else {
				//console.log(data.toString());
				recall(data);
			}
		});
		// console.log("异步读取成功");
	},
	readbinaryfile:function(path, recall) {
		fs.exists(path, function(exists) {
			if (exists) {
				//console.log("文件存在");
			} else {
				//console.log("文件不存在");
				path = './img/pg.png';
			}
			fs.readFile(path, 'binary', function(err, data) {
				if(err) {
					console.log(err);
					recall("文件不存在");
				} else {
					//console.log(data.toString());
					recall(data);
					// console.log("异步读取成功");
				}
			});	
		});
		
		// 
		// var rs = fs.createReadStream(path);
		// rs.on('data', function(data) {
		// 	recall(data);
		// });
		
	},
	readfileSync:function(path, res) {
		var data = fs.readFileSync(path, 'utf-8');
		console.log(data);
		res.write('同步读出：' + data + '<br>');
		// console.log("同步读取成功");
		//return data;
	},
	readimg:function(path, res) {
		fs.readFile(path, 'binary', function(err, file) {
			if(err) {
				console.log(err);
				recall("文件不存在");
			} else {
				console.log("输出文件");
				res.write(file, 'binary');
				res.end();
			}
		})
	}
}