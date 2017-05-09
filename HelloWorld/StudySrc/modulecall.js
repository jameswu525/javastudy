var http = require('http');
var moment = require("moment");
var User = require('./hello_module/User');
var Teacher = require('./hello_module/Teacher');
http.createServer(function(request, response) {
	response.writeHead(200, {'Content-Type':'text/html; charset=utf-8'});
	if(request.url !== '/favicon.ico') {
		fun1(response, request);
		response.end('');
	}
}).listen(8800);
console.log('Server is running at http://localhost:8800');

function fun1(res, req) {
	//moment().format("YYYY-MM-DD HH:mm:ss");
	// console.log('fun1:' + req.url);
	// var now = moment();
	// console.log(now);
	// res.write('Hello, 我是Fun1:' + req.url + '<br>');
	var strDTFmt = 'YYYY/MM/DD h:mm:ss a';
	var str1 = "2017-03-09 14:00:00";
	var t0 = new Date(str1);
	var t1 = new Date();
	console.log(moment(t0).format(strDTFmt));
	res.write('<font style="font-size:20px">现在时间：</font><font style="color:#F00">'+moment(t1).format(strDTFmt)+'</font><br><br>');

	user = new User(1,'张三', 20);
	// user.id=1;
	// user.name='张三';
	// user.age=20;
	user.enter();
	teacher = new Teacher(2, '老王', 45);
	teacher.enter(moment(t0).format(strDTFmt), res);

	//res.write(t1.getTime() + '<br>');
	var miltime = t1.getTime() - t0.getTime();
	var hours=Math.floor(miltime/(3600*1000));
	var mins=Math.floor((miltime%(3600*1000))/(60*1000));
	teacher.teach(res, hours, mins);
}
