var mysql = require('mysql');

function createConn(recall, type) {
	var connection = mysql.createConnection({
		host:'localhost',
		user:'root',
		password:'Wujianbing321',
		database:'study0505'
	});

	function convert2tbl(rs) {
		// console.log(rs);
		var rtnStr = "";
		for (var a = 0; a < rs.length; a ++) {
			rtnStr += "<tr>";
			rtnStr += "<td>";
			rtnStr += rs[a].idtest01;
			rtnStr += "</td>";
			rtnStr += "<td>";
			rtnStr += rs[a].name;
			rtnStr += "</td>";
			rtnStr += "<td>";
			rtnStr += rs[a].age;
			rtnStr += "</td>";
			rtnStr += "<td>";
			rtnStr += rs[a].sexing;
			rtnStr += "</td>";
			rtnStr += "</tr>";
		}
		return rtnStr;
	}

	connection.connect();
	connection.query('select count(0) as cnt from test01', function(error, results, fields) {
		if (error) {
			console.log("error");
			recall(error.message);
			connection.end();
		} else {
			// console.log('solution is \n', results[0].cnt);
			var id = results[0].cnt + 1;
			// console.log(id);
			var addSql = 'INSERT INTO test01(idtest01,name,age,sexing) VALUES(?,?,?,?)';
			var addSqlParams = [id, 'Jimmy'+id, id, 'M'];
			connection.query(addSql,addSqlParams,function (err, result) {
			if(err){
				console.log('[INSERT ERROR] - ',err.message);
				recall(error.message);
				connection.end();
				return;
			} else {
				var sql = 'select * from test01';
				connection.query(sql, function(error, result) {
					if (error) {
						console.log(error.message);
						recall(error.message);
						connection.end();
					} else {
						// console.log('===========================');
						// console.log(result);
						// console.log('===========================');
						if (type == 1) {
							recall(JSON.stringify(result));
						} else {
							recall(convert2tbl(result));
						}
						
						// 
						connection.end();
					}
				});
			}
			});

		}

	})
}

module.exports = createConn;


