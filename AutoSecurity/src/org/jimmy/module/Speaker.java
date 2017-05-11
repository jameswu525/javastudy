package org.jimmy.module;

import org.jimmy.util.SystemUtil;

public class Speaker implements Runnable {
	public static final int SPEAK_ON = 1;
	public static final int SPEAK_OFF = 0;
	private static Speaker instance = new Speaker();
	public static Speaker getInstance() {
		return instance;
	}
	private Speaker() {}

	public void run() {
		SystemUtil.print(this, "Monitor running ...");
		int continuing = 0;
		while(true) {
//			System.out.println(SystemUtil.printTime(this) + "要响吗？  " + PLCSignal.signal_speak);
			if (PLCSignal.signal_speak == SPEAK_ON) {
				if (continuing ++ < 3) {
					System.out.println(SystemUtil.printTime(this) + "Bee Bee Bee");
				} else {
					PLCSignal.signal_speak = SPEAK_OFF;
					continuing = 0;
				}
			} else {
				continuing = 0;
			}
			SystemUtil.sleeping(1);
		}
	}

}
