package org.jimmy.reflect.dynamicAgent;

public class AgentImpl implements SuperInterface {

	public void doWork() {
		System.out.println("Do my work");
		System.out.println("doWork : " + this);
	}
	
//	public void doWork2() {
//		System.out.println("second");
//	}

}
