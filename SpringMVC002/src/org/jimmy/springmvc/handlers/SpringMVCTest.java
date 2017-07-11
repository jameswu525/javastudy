package org.jimmy.springmvc.handlers;

import java.util.Map;

import org.jimmy.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes(value={"test001", "test002"})
@Controller
public class SpringMVCTest {
	private final static String SUCCESS = "success";
	
	@RequestMapping(value="/test01", method=RequestMethod.POST)
	public String doTest01() {
		System.out.println("只能接受POST请求");
		return SUCCESS;
	}
	
	@RequestMapping(value="/test02", params={"username"})
	public String doTest02() {
		System.out.println("只能接受有username的请求");
		return SUCCESS;
	}

	@RequestMapping("/test03/*/main")
	public String doTest03() {
		System.out.println("Ant风格路径请求");
		return SUCCESS;
	}

	@RequestMapping("/test04/{val}")
	public ModelAndView doTest04(@PathVariable("val") String value) {
		System.out.println("@PathVariable" + value);
		ModelAndView mv = new ModelAndView();
		mv.addObject("test001", "从@PathVariable参数中获取的val值等于：" + value);
		mv.setViewName(SUCCESS);
		return mv;
	}
	
	@RequestMapping("/test05/sessionAttributes")
	public ModelAndView doTest05() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("test001", "请求域内存储的对象test001");
		mv.addObject("test002", "请求域内存储的对象test002");
		mv.setViewName(SUCCESS);
		return mv;
	}
	
	@RequestMapping("/test06/params")
	public ModelAndView doTest06(@RequestParam(value = "username" , required=true) String name) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("test001", "name = " + name);
		mv.setViewName(SUCCESS);
		return mv;
	}
	
	@RequestMapping("/test07/RequestAttributes")
	public ModelAndView doTest07(User user) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("test001", "User : " + user);
		mv.setViewName(SUCCESS);
		return mv;
	}
	
	@ModelAttribute
	public void getUser(@RequestParam(value="id", required=false ) Integer id, Map<String, Object> map ) {
		System.out.println("getUser");
		if (id != null) {
			User user = new User(100, "Jimmy Wu", "123456", "jimmy.wu@kerryprops.com", 15);
			System.out.println("修改User，获取数据库初始化User： " + user);
			map.put("user", user);
		}
	}
	
	
}
