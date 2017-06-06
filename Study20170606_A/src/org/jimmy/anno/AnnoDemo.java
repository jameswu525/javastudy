package org.jimmy.anno;

public class AnnoDemo{
	@AnnoTest(value="",  method=HttpMethod.POST)
	public void method3() {
		
	}
	
	// 不建议使用
	@Deprecated
	public void method1() {
		
	}
	
	// 必须是重写
	@Override
	public String toString() {
		return "";
	}
	
	// 抑制警告
	@SuppressWarnings ("all")
	public void method2() {
		
	}
}
