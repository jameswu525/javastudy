package org.jimmy.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

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
}
