package org.jimmy.module;

import org.jimmy.util.SystemUtil;
/**
 * 需要进行部分Signal的线程安全保证。
 * @author LiuXin
 *
 */
public class Monitor implements Runnable {
	private static Monitor instance = new Monitor();
	public static boolean person_comming_signal = false;
	private static boolean called = false;

	public static Monitor getInstance() {
		return instance;
	}

	private Monitor() {}

	private void callIncident() {
		SystemUtil.print(this, "I find one person");
		PLCSignal.seeSomebody();
	}
	
	private void releaseIncident() {
		SystemUtil.print(this, "child is safe");
		PLCSignal.setSafe();
	}

	public void run() {
		SystemUtil.print(this, "Monitor running ...");
		while(true) {
			SystemUtil.sleeping(1);
//			System.out.println(SystemUtil.printTime(this) + "有人吗？  " + person_comming_signal);
			if (person_comming_signal) {
				if (!called) {
					callIncident();
					called = true;
				}
			} else {
				if (called) {
					releaseIncident();
					called = false;
				}
			}
		}
	}
}
