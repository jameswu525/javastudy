var optfile = require('./optfile');
module.exports = {
	login:function(req, res) {
		function recall(data) {
			res.write('异步读出：' + data + '<br>');
			res.end('');
		}
		optfile['readfile']('./view/login.html', recall);;
	},

	logout:function(req, res) {
		function recall(data) {
			res.write('异步读出：' + data + '<br>');
			res.end('');
		}
		optfile['readfile']('./view/logout.html', recall);;
	}
}