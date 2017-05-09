var mysql = require('mysql');
var connection = mysql.createConnection({
	host:'localhost',
	user:'root',
	password:'Wujianbing321',
	database:'study0505'
});

connection.connect();
connection.query('select count(0) as cnt from test01', function(error, results, fields) {
	if (error) {
		console.log("error");
		connection.end();
	} else {
		console.log('solution is \n', results[0].cnt);
		var id = results[0].cnt + 1;
		// console.log(id);
		var addSql = 'INSERT INTO test01(idtest01,name,age,sexing) VALUES(?,?,?,?)';
		var addSqlParams = [id, 'Jimmy'+id, id, 'M'];
		connection.query(addSql,addSqlParams,function (err, result) {
		if(err){
			console.log('[INSERT ERROR] - ',err.message);
			connection.end();
			return;
		} else {
			var sql = 'select * from test01';
			connection.query(sql, function(error, result) {
				if (error) {
					console.log(error.message);
					connection.end();
				} else {
					console.log('===========================');
					console.log(result);
					console.log('===========================');
					connection.end();
				}
			});
		}
		});

	}

})


