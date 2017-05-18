package org.jimmy.reflect;

public class PrivateClass {
	private static final PrivateClass instance = new PrivateClass();
	private PrivateClass() {
		if (instance != null) {
			throw new CannotNewSingleInstanceException("不能多次生成单例实例。");
		}
	}

	public static PrivateClass getInstance() {
		return instance;
	}
	
	public String toString() {
		return this.getClass().getName() + " / " + this.hashCode();
	}
}
class CannotNewSingleInstanceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CannotNewSingleInstanceException() {
		super();
	}
	public CannotNewSingleInstanceException(String name) {
		super(name);
	}
}