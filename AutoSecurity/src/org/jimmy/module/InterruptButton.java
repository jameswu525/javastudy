package org.jimmy.module;

public class InterruptButton {
	private static InterruptButton instance = new InterruptButton();
	private InterruptButton() {};
	public static InterruptButton getInstance() {
		return instance;
	}
	
	public void interrupt() {
		PLCSignal.cutSignal();
	}
}
