var async = require('async');

function oneFun() {
	// setTimeout是一次性等待执行；
	// setTimeout(function() {
	// 	console.log("one Fun 1s");
	// }, 1000);
	var j = 0;
	// setInterval是循环等待执行；
	setInterval(function() {
		console.log("-->one = " + new Date());
		j++;
		if (j >= 2) {
			clearInterval(this);
			// return;
		}

	}, 1000);
	console.log("-->one Fun");
}

function twoFun() {
	var j = 0;
	// setInterval是循环等待执行；
	setInterval(function() {
		console.log("-->two = " + new Date());
		j++;
		if (j >= 4) {
			clearInterval(this);
			// return;
		}

	}, 1000);
	console.log("-->two Fun");
}

function syncExec() {
	// 串型无关联
	async.series({
	// async.parallel({
		one:function(done) {
			var j = 0;
			// setInterval是循环等待执行；
			setInterval(function() {
				console.log("====>ONE = " + new Date());
				j++;
				if (j >= 2) {
					clearInterval(this);
					// null,串型无错误才能继续运行后续操作。
					done(null, "1");
				}
			}, 1000);
		},
		two:function(done) {
			var j = 0;
			// setInterval是循环等待执行；
			setInterval(function() {
				console.log("====>TWO = " + new Date());
				j++;
				if (j >= 4) {
					clearInterval(this);
					// 串型有错误终止后续操作，直接回调。
					done("null", "2");
				}
			}, 1000);
		},
		three:function(done) {
			var j = 0;
			// setInterval是循环等待执行；
			setInterval(function() {
				console.log("====>THREE = " + new Date());
				j++;
				if (j >= 5) {
					clearInterval(this);
					done(null, "3");
				}
			}, 1000);
		}
	}, function(err, res) {
		console.log("====>" + err);
		console.log("====>");
		console.log(res);
	});
}

function syncExec2() {
	// 串型有关联
	async.waterfall([
		function(done) {
			var j = 0;
			// setInterval是循环等待执行；
			setInterval(function() {
				console.log("/======>ONE = " + new Date());
				j++;
				if (j >= 2) {
					clearInterval(this);
					// null,串型无错误才能继续运行后续操作。
					done(null, "1");
				}
			}, 1000);
		},
		function(prev, done) {
			console.log("/======>Pre=" + prev);
			var j = 0;
			// setInterval是循环等待执行；
			setInterval(function() {
				console.log("/======>TWO = " + new Date());
				j++;
				if (j >= 4) {
					clearInterval(this);
					// 串型有错误终止后续操作，直接回调。
					done(null, "2");
				}
			}, 1000);
		},
		function(prev, done) {
			console.log("/======>Pre=" + prev);
			var j = 0;
			// setInterval是循环等待执行；
			setInterval(function() {
				console.log("/======>THREE = " + new Date());
				j++;
				if (j >= 5) {
					clearInterval(this);
					done(null, "3");
				}
			}, 1000);
		}
	], function(err, res) {
		console.log("/======>" + err);
		console.log("/======>");
		console.log(res);
	});
}


oneFun();
twoFun();
// 仅仅为了与前两个异步测试的输出结果做区分
// setTimeout(function() {
// 	console.log("====>====>====>====>====>====>====>====>====>====>====>====>====>====>====>");
// 	syncExec();
// }, 4300);
// setTimeout(function() {
// 	console.log("/====>====>====>====>====>====>====>====>====>====>====>====>====>====>====>");
// 	syncExec2();
// }, 10500);
console.log("Main DONE!!!");