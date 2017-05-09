var http = require('http');
http.createServer(function(request, response) {
	response.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
	if(request.url !== '/favicon.ico') {
		fun1(response, request);
		response.end('');
	}
}).listen(8800);
console.log('Server is running at http://localhost:8800');

function fun1(res, req) {
	console.log('接收到请求消息:' + req.url);
	res.write('接收到请求消息:' + req.url + '<br>');
}
