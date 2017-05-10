package org.jimmy.module;

import org.jimmy.util.SystemUtil;

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
//			System.out.println(SystemUtil.printTime(this) + "启动吗？  " + PLCSignal.signal_direction);
			if (PLCSignal.signal_direction == SWITCH_FORWARD) {
				if (Window.getInstance().closing()) {
					PLCSignal.signal_direction = SWITCH_STOP;
				}
			} else if (PLCSignal.signal_direction == SWITCH_REVERSAL) {
				if (Window.getInstance().opening()) {
					PLCSignal.signal_direction = SWITCH_STOP;
				}
			}
			SystemUtil.sleeping(1);
		}
	}

	public void run() {
		SystemUtil.print(this, "Engine running ...");
		this.Controlling();
	}
}
