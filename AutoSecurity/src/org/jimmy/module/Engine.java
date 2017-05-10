package org.jimmy.module;

public class Engine implements Runnable {
	public static final int SWITCH_STOP = 0;
	public static final int SWITCH_FORWARD = 1;
	public static final int SWITCH_REVERSAL = -1;
	
	private static Engine instance = new Engine();
	
	private Engine() {}
	
	public static Engine getInstance() {
		return instance;
	}
	
	public void Controlling() {
		while (true) {
			if (PLCSignal.signal_direction == SWITCH_FORWARD) {
				Window.getInstance().opening();
			} else if (PLCSignal.signal_direction == SWITCH_REVERSAL) {
				Window.getInstance().closing();
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
	}
	}

	public void run() {
		this.Controlling();
	}
	public static void main(String[] args) {

	}


}
