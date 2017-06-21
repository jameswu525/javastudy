package org.jimmy.step01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class GetStudentName extends ActionSupport{
	private String uname;
	private Integer age;
	private String mString;
	
	public String execute() throws Exception {
		System.out.println(uname + ":" +age);
		mString = uname + ":" +age;
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
	
	public void validate() {
		Map<String, List<String>> map = getFieldErrors();
//		System.out.println(map);
		List<String> msgList = new ArrayList<String>();
		System.out.println("validate");
//		if(uname == null ||  uname.length() < 5) {
//			msgList.add("请输入大于5位的姓名");
//			map.put("uname", msgList);
//			
//			setFieldErrors(map);
//		}
	}

	public String getmString() {
		return mString;
	}

	public void setmString(String mString) {
		this.mString = mString;
	}
}
