var http = require('http');
var url = require('url');
var router = require('./router/router');
var querystring = require('querystring');

http.createServer(function(request, response) {
	if(request.url !== '/favicon.ico') {
		var pathname1 = url.parse(request.url).pathname;
		var arg = url.parse(request.url, true).query;
		var post = '';
		request.on('data', function(chunk) {
			post += chunk;
		});
		request.on('end', function() {
			post = querystring.parse(post);
			//console.log(arg);
			var patten1 = new RegExp("\/");
			var patten2 = new RegExp("[^/]*");
			pathname1 = pathname1.replace(patten1,'');
			var pathname = patten2.exec(pathname1);
			console.log("==>" + pathname);
			if(pathname === null || pathname[0] === '') {
				response.writeHead(200, {'Content-Type': 'text/html; charset=utf-8'});
				response.write('Welcome！！！<br><font style="color:#F00">这是一个首页，有何贵干？<font>');
				response.end('');
			} else {
				pathname = pathname[0];
				if(pathname === 'img') {
					router['img'](pathname1, response);
				} else if(pathname === 'image') {
					router['image'](request, response, arg.rs);
				}  else if(pathname === 'showimg') {
					router['showimg'](request, response, arg.img);
				}  else if(pathname === 'src') {
					router['src'](request, response, arg.rs);
				}  else {
					try {
						router[pathname](request, response, arg, post);
					} catch(err) {
						// router['showimg'](request, response, '1.png');
						response.writeHead(200, {'Content-Type': 'text/html; charset=utf-8'});
						if (err.toString() === 'TypeError: router[pathname] is not a function') {
							response.write('OMG,错啦！！！<br><font style="color:#F00">route [' + pathname + '] not exists.</font>');
						} else {
							response.write('OMG,错啦！！！<br><font style="color:#F00">' + err.toString() + '</font>');
						}
						response.end('');
					}
				}
			}
		});
	}
}).listen(8800);
console.log('Server is running at http://localhost:8800');

function setContentType(req, res, type) {
	console.log('接收到请求消息:' + req.url);
	res.writeHead(200, {'Content-Type': type + '; charset=utf-8'});
}