var http = require('http');
var optfile = require('./optFile');
http.createServer(function(request, response) {
	if(request.url !== '/favicon.ico') {
		fun1(response, request);
	}
}).listen(8800);
console.log('Server is running at http://localhost:8800');

function fun1(res, req) {
	console.log('接收到请求消息:' + req.url);
	// res.write('接收到请求消息:' + req.url + '<br>');
	function recall(data) {
		// res.writeHead(200, {'Content-Type': 'text/html; charset=utf-8'});
		res.write(data);
		res.write('接收到请求消息:' + req.url + '<br>');
		res.end('');
	};
	optfile['readfile']('./test01.html', recall);
}
