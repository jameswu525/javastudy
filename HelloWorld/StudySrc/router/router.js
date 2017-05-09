var optfile = require('../util/optFile');
var OptPool = require('../util/pgadmin');
var mysqlMain = require('../util/mysqlMain');

function getRecall(req, res, type) {
	if(type === null) {
		type = 'text/html';
	}
	res.writeHead(200, {'Content-Type': type + '; charset=utf-8'});
	function recall(data) {
		if(type === 'text/html') {
			// res.write('<head><meta charset="utf-8"/></head>');  
			res.write(data);// console.log(data);
		} else {
			res.write(data, 'binary');
		}
		res.end('');
	}
	return recall;
}

module.exports = {
	angular1:function(req, res, arg, arg2) {
		var recall = getRecall(req, res);
		// if (arg['email'] != undefined) {
		// 	console.log('GET: email=' + arg['email']);
		// 	console.log('GET: pwd=' + arg['pwd']);
		// }
		optfile['readfile']('./view/angular1.html', recall);
	},
	login:function(req, res, arg, arg2) {
		var recall = getRecall(req, res);
		// if (arg['email'] != undefined) {
		// 	console.log('GET: email=' + arg['email']);
		// 	console.log('GET: pwd=' + arg['pwd']);
		// }
		optfile['readfile']('./view/login.html', recall);
	},

	logout:function(req, res, arg, arg2) {
		//var recall = getRecall(req, res);
		var arr = ['id', 'pwd', 'name'];
		// if (arg2['email'] != undefined) {
		// 	console.log('POST: email=' + arg2['email']);
		// 	console.log('POST: pwd=' + arg2['pwd']);
		// }
		

		function rc(data) {
			function recall(name, data) {
				dataStr = (""+data).toString();
				for(var i = 0; i < arr.length; i++) {
					var re = new RegExp('{' + arr[i] + '}', 'ig');
					//i = 大小写不敏感
					//g = 全局匹配
					if (arr[i] == 'name' || arg2['id'] == undefined) {
						dataStr = dataStr.replace(re, '[==' + name + '==]');
					} else {
						dataStr = dataStr.replace(re, '[==' + arg2[arr[i]] + '==]');
					}
					
				}
				res.write(dataStr);
				res.end('');
			}
			if (arg2['id'] == undefined) {
				recall('***', data);
			} else {
				var optPool = new OptPool();
				optPool.getName(arg2['id'], recall, data);
			}
		}

		optfile['readfile']('./view/logout.html', rc);
	}, 

	writefile:function(req, res, arg, arg2) {
		var recall = getRecall(req, res);
		optfile['writefile']('./view/one.txt', '时间 ' + new Date() + 'write写入内容' + this.toString() + '。\r\n', recall);
	},

	appendfile:function(req, res, arg, arg2) {
		var recall = getRecall(req, res);
		optfile['appendfile']('./view/one.txt', '时间 ' + new Date() + 'append写入内容' + this.toString() + '。\r\n', recall);
	},

	showimg:function(req, res, path, arg2) {
		res.writeHead(200, {'Content-Type': 'text/html; charset=utf-8'});
		//function recall(data) {
			res.write('以下是图片内容:<br>');
			res.write('<img src=\"');
			//res.write('http://www.w3school.com.cn/i/eg_tulip.jpg');
			res.write('./img/' + path);
			res.write(' \" width=\"200px\"/>');
			// 
			// res.write('<img src=\"data:image\/png;base64,');
			// res.write(data, 'binary');
			// res.write('\"/>');
			res.end('');
		//}
		//optfile['readbinaryfile']('./img/1.png', recall);
	},

	img:function(pathname, res, arg, arg2) {
		var recall = getRecall(null, res, 'image/jpeg');
		// function recall(data) {
		// 	//res.write('以下是图片内容:<br>');
		// 	// res.write('<img src=\"');
		// 	// res.write('http://www.w3school.com.cn/i/eg_tulip.jpg');
		// 	// res.write(' \"/>');
		// 	// 
		// 	//res.write('<img src=\"data:image\/png;base64,');
		// 	res.write(data, 'binary');
		// 	//res.write('\"/>');
		// 	res.end('');
		// }
		// console.log('./' + pathname);
		optfile['readbinaryfile']('./' + pathname, recall);
	},

	image:function(pathname, res, path, arg2) {
		var recall = getRecall(null, res, 'image/jpeg');
		optfile['readbinaryfile']('./img/' + path, recall);
	},

	src:function(pathname, res, path, arg2) {
		var recall = getRecall(null, res);
		// console.log('./'+path.replace('{}','/'));
		optfile['readfile']('./'+path.replace('{}','/'), recall);
	},

	throwA:function(pathname, res, path, arg2) {
		throw("New Exception A!");
	},

	throwB:function(pathname, res, path, arg2) {
		var recall = getRecall(null, res);
		recall("<font style=\"color:#F00\">New Exception B!</font>");
	},

	select:function(req, res, arg, arg2) {
		var recall = getRecall(req, res);
		var optPool = new OptPool();
		// var pool = optPool.getPool();
		optPool.getQuery(recall);
		// optPool.getQuery();
		// function getClient(conn) {
		// 	var parameter = ['8'];
		// 	var query = "select * from kerry_properties where id = $1;";
		// 	pg['query'](conn, query, parameter, recall);
		// 	pg['close'](conn);
		// }
		// pg['connection'](recall, getClient);
	},

	conMysql:function(req, res, arg, arg2) {
		var recall = getRecall(req, res);
		mysqlMain(recall, 1);
	},

	conMysql2:function(req, res, arg, arg2) {
		var arr = ['tbl'];

		function recall(tbl) {
			function rc(data) {
				dataStr = ("" + data).toString();
				for(var i = 0; i < arr.length; i++) {
					var re = new RegExp('{' + arr[i] + '}', 'ig');
					//i = 大小写不敏感
					//g = 全局匹配
					dataStr = dataStr.replace(re, tbl);
				}
				res.write(dataStr);
				res.end('');
			}

			optfile['readfile']('./view/showdb.html', rc);
		}

		mysqlMain(recall, 2);
	}
}