var http = require('http');
var otherfun = require('./hello_module/otherfun.js');
var otherfuns = require('./hello_module/otherfuns.js');
http.createServer(function(request, response) {
	response.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
	if(request.url !== '/favicon.ico') {
		fun1(response, request);
		otherfun(response);
		otherfuns.fun4(response);
		otherfuns['fun5'](response);
		response.end('');
	} else {
		fun2(response, request);
		response.end('');
	}
}).listen(8800);
console.log('Server is running at http://localhost:8800');

function fun1(res, req) {
	console.log('fun1:' + req.url);
	res.write('Hello, 我是Fun1:' + req.url + '<br>');
}

function fun2(res, req) {
	console.log('fun2:' + req.url);
	res.write('Hello, 我是Fun2:' + req.url + '<br>');
}