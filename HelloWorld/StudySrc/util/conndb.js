var pg = require('pg');

var constr = 'tcp://wx:kerry2016!@localhost/wx20161230'
var client = new pg.Client(constr);  //构造一个数据库对象  
//连接数据库，连接成功，执行回调函数   
client.connect(function(error, results) {
     if(error){  
            console.log('ClientConnectionReady Error: ' + error.message);  
            client.end();  
            return;  
        }
        console.log("client.connect OK.");
    });
client.query("select * from kerry_properties;",function(error,results){  
    console.log("in callback function.\n");  
    if (error) {  
        console.log("error");  
        console.log('GetData Error: ' + error.message);  
        client.end();  
        return;  
    }  
    if(results.rowCount > 0) {  
		console.log(JSON.stringify(results)); 
	}
}); 
