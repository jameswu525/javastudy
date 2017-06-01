package org.jimmy.reflect;

// 枚举型书写工厂单例
public enum BeanFactory {
	INSTANCE;
	
	public String asString(int d) {
		return String.valueOf(d);
	}
}
