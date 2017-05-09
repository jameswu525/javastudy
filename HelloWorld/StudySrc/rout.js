var http = require('http');
var url = require('url');
var router = require('./hello_module/router')

http.createServer(function(request, response) {
	response.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
	if(request.url !== '/favicon.ico') {
		fun1(response, request);
		var pathname = url.parse(request.url).pathname;
		// 正则表达式的两种写法
		var patten = /\//;
		var patten1 = new RegExp("\/");
		pathname = pathname.replace(patten1,'');
		console.log('PATHNAME:' + pathname);
		var patten2 = /^a[0-9]+s$/;
		// http://localhost:8800/a121saaa22343seiifdias
		var patten3 = new RegExp("a[0-9]+s", "g");
		//var patten3 = new RegExp("a[0-9]+s");
		//pathname = pathname.replace(patten2,'X');
		var regExec = patten3.exec(pathname);
		console.log('regExec:' + regExec);
		var regExec = patten3.exec(pathname);
		console.log('regExec:' + regExec);
		var regExec = patten3.exec(pathname);
		console.log('regExec:' + regExec);

		router[pathname](require, response);
		//response.end('');
	}
}).listen(8800);
console.log('Server is running at http://localhost:8800');

function fun1(res, req) {
	console.log('接收到请求消息:' + req.url);
	res.write('接收到请求消息:' + req.url + '<br>');
}