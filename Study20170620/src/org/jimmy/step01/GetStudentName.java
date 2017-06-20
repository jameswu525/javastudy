package org.jimmy.step01;

import com.opensymphony.xwork2.ActionSupport;

public class GetStudentName extends ActionSupport{
	private String uname;
	private Integer age;
	
	public String execute() throws Exception {
		System.out.println(uname + ":" + age);
		return SUCCESS;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
