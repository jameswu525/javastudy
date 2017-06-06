package org.jimmy.reflect;
/**
 * 静态代理
 * 代理类中放入实际实现类。
 * 缺点： 只能对SuperInterface的接口代理，别的接口无法实现。
 * @author JimmyWu
 *
 */
public class AgentDemo implements SuperInterface{
	private SuperInterface agent = null;
	// 代理与实现类均implements同一个接口。
	// 通过代理的接口方法调用实体的接口方法，在代理方法中增加需要的操作。
	public static void main(String[] args) {
		SuperInterface agent = new AgentDemo(new AgentImpl());
		agent.doWork();
	}
	
	public AgentDemo(SuperInterface s) {
		super();
		this.agent = s;
	}

	public void doWork() {
		// 代理工作
		System.out.println("Before ***");
		// 实际工作
		agent.doWork();
		System.out.println("After ***");
	}
}
