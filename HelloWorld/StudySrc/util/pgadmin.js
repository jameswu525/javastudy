var pg = require('pg');

// var constr = 'tcp://wx:kerry2016!@localhost/wx20161230'
// var client = new pg.Client(constr);  //构造一个数据库对象  
// //连接数据库，连接成功，执行回调函数   
// client.connect(function(error, results) {
//      if(error){  
//             console.log('ClientConnectionReady Error: ' + error.message);  
//             client.end();  
//             return;  
//         }
//         console.log("client.connect OK.");
//     });
// client.query("select * from kerry_properties;",function(error,results){  
//     console.log("in callback function.\n");  
//     if (error) {  
//         console.log("error");  
//         console.log('GetData Error: ' + error.message);  
//         client.end();  
//         return;  
//     }  
//     if(results.rowCount > 0) {  
// 		console.log(JSON.stringify(results)); 
// 	}
// }); 


// module.exports = {
// 	connection:function(recall, getClient){
// 		// this.isFirst = false;
// 		var constr = 'tcp://wx:kerry2016!@localhost/wx20161230';
// 		var client = new pg.Client(constr);  //构造一个数据库对象  
// 		client.connect(function(error) {
// 		    if(error){
// 	            console.log('ClientConnectionReady Error: ' + error.message);  
// 	            client.end();
// 	            recall('ClientConnectionReady Error: ' + error.message);
// 		    } else {
// 		    	console.log("client connect OK.");
// 		    	// console.log(results);
// 		    	// console.log(client);
// 		    	client.query("select * from kerry_properties where id=$1", ['8'], function(error, results){  
// 			    	// console.log("in callback function.\n");  
// 				    if (error) {
// 				    	console.log('GetData Error: ' + error.message);  
// 				    	recall('GetData Error: ' + error.message);
// 				        // console.log("error");  
// 				        // client.end();  
// 				        // return;  
// 				    } else {
// 				    	// console.log(results.rowCount);
// 				    	var rst = results.rowCount;
// 				    	console.log("count = " + rst);
// 				    	getClient(client);
// 				    	// recall("count = " + rst);
// 				    	// recall(JSON.stringify(results));
// 				    }
// 				 //    if(results.rowCount > 0) {
// 				 //    	console.log("Result Rows = " + results.rowCount);
// 					// 	// console.log(JSON.stringify(results)); 
// 					// } else {
// 					// 	console.log("No results.");
// 					// }
// 				}); 

		    	
// 		    }
// 	    });
// 	}, 

// 	query:function(client, query, parameter, recall) {
// 		// console.log(client);
// 		client.query(query, parameter, function(error, results){  
// 	    	// console.log("in callback function.\n");  
// 		    if (error) {
// 		    	console.log('GetData Error: ' + error.message);  
// 		    	recall('GetData Error: ' + error.message);
// 		        // console.log("error");  
// 		        // client.end();  
// 		        // return;  
// 		    } else {
// 		    	var rst = results.rowCount;
// 		    	console.log("count = " + rst);
// 		    	recall("count = " + rst);
// 		    }
// 		 //    if(results.rowCount > 0) {
// 		 //    	console.log("Result Rows = " + results.rowCount);
// 			// 	// console.log(JSON.stringify(results)); 
// 			// } else {
// 			// 	console.log("No results.");
// 			// }
// 		}); 
// 	}, 

// 	close:function(client) {
// 		client.end();
// 	}
// }
// 
// 
function OptPool() {
	var config = {
	    user:"wx",
	    database:"wx20161230",
	    password:"kerry2016!",
	    port:5432,
	    // charset:'utf8',
	    // 扩展属性
	    max:20, // 连接池最大连接数
	    idleTimeoutMillis:3000, // 连接最大空闲时间 3s
	}
	this.pool = new pg.Pool(config);

	this.pool.on("error", function(err, client){
	    console.log("error --> ", err)
	});
	this.pool.on('acquire', function (client) {  
	  // console.log("acquire Event")
	});

	this.pool.on('connect', function () {  
	  // console.log("connect Event");
	});

	// 查询
	this.getQuery = function(callback) {
		this.pool.connect(function(err, client, done) {
			if(err) {
				// console.error('数据库连接出错', err);
				callback('数据库连接出错:' + err.toString());
			} else {
				// 简单输出个 Hello World
				client.query('select name from kerry_properties where id = $1', ["8"], function(err, result) {
					done();// 释放连接（将其返回给连接池）
					if(err) {
						callback('数据库查询出错:' + err.toString());
					} else {
						console.log('查询结果是:' + result.rows[0].name);
						callback('查询结果是:' + result.rows[0].name);
					}
				});
			}
		  
		});
	}

	// 查询名称
	this.getName = function(id, callback, data) {
		this.pool.connect(function(err, client, done) {
			if(err) {
				// console.error('数据库连接出错', err);
				callback('数据库连接出错:' + err.toString());
			} else {
				// 简单输出个 Hello World
				client.query('select name from kerry_properties where id = $1', [id], function(err, result) {
					done();// 释放连接（将其返回给连接池）
					if(err) {
						callback('数据库查询出错:' + err.toString());
					} else {
						
						if (result.rowCount >= 1) {
							console.log('查询结果是:' + result.rows[0].name);
							callback(result.rows[0].name, data);
						} else {
							callback('没有结果', data);
						}
						
					}
				});
			}
		  
		});
	}

};

module.exports = OptPool;