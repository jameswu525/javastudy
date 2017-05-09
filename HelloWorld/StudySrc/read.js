var http = require('http');
var url = require('url');
var optfile = require('./hello_module/optfile');
http.createServer(function(request, response) {
	response.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
	if(request.url !== '/favicon.ico') {
		fun1(response, request);
		var patten = new RegExp('\/');
		var pathname = url.parse(request.url).pathname;
		pathname = pathname.replace(patten,'');
		console.log(pathname);
		// optfile['readfileSync']('./view/'+pathname+'.html', response);

		function recall(data) {
			response.write('异步读出：' + data + '<br>');
			response.end('K--------K');
		}
		optfile['readfile']('./view/'+pathname+'.html', recall);
		
		console.log('主程序执行完毕');
	}
}).listen(8800);
console.log('Server is running at http://localhost:8800');

function fun1(res, req) {
	console.log('接收到请求消息:' + req.url);
	res.write('接收到请求消息:' + req.url + '<br>');
}
