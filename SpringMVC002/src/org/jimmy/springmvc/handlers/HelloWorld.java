package org.jimmy.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/m01")
@Controller
public class HelloWorld {
	/*
	 * 1, @RequestMapping 注解映射请求的URL
	 * 	类定义上也可以使用该注解，表示路径
	 * 	方法定义上使用注解则表示请求地址
	 * 2. 返回值通过解析器解析为实际的物理视图
	 */
	@RequestMapping("/hello")
	public ModelAndView hello() {
		System.out.println("Hello World");
		ModelAndView mv = new ModelAndView();
		mv.addObject("test001", "这个是从Controller中存入ModelAndView的参数");
		mv.setViewName("success");
		return mv;
	}
}
