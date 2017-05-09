var User = require('./User');
function Teacher(id,name,age) {
	User.apply(this,[id,name,age]);
	this.teach=function(res, hours, mins) {
		res.write(this.name + '正在讲课, 共讲授时长：' + hours + '小时' + mins + '分钟');
	}

	this.enter=function(time, res) {
		console.log(this.name + '在' + time + '进入教室.');
		res.write(this.name + '在' + time + '进入教室.<br>');
	}
}

module.exports = Teacher;