function User(id,name,age) {
	this.id = id;
	this.name = name;
	this.age = age;

	this.enter = function() {
		console.log(this.name + '进入教室.');
	}
}
module.exports = User;