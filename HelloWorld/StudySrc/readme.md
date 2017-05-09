如果发现运行失败，删除node_modules目录，并运行 npm install ，重新安装先关module

node app.js

http://localhost:8800


配置本地mysql以及postgresql数据库。

	var connection = mysql.createConnection({
		host:'localhost',
		user:'root',
		password:'Wujianbing321',
		database:'study0505'
	});



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