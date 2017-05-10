package org.jimmy.module;

import org.jimmy.util.SystemUtil;

public class PLCSignal {
	public static final int MONITORING_ON = 1;
	public static final int MONITORING_OFF = 0;
	private static PLCSignal instance= new PLCSignal();
	
	public static int signal_direction = Engine.SWITCH_STOP;
	public static int signal_speak = Speaker.SPEAK_OFF;
	private static int is_Monitoring = MONITORING_OFF;

	private PLCSignal() {}
	public static void seeSomebody() {
//		System.out.println(SystemUtil.printTime(instance) + "监控吗？  " + is_Monitoring);
		if (is_Monitoring == MONITORING_ON) {
			SystemUtil.print(instance,  "send signal for speak & to close window");
//			signal_direction = Engine.SWITCH_FORWARD;
			signal_speak = Speaker.SPEAK_ON;
		} else {
			System.out.println("recived signal, but the system if off. ");
			SystemUtil.print(instance,  "recived signal, but the system if off.");
		}
	}

	public static void setSafe() {
//		System.out.println(SystemUtil.printTime(instance) + "监控吗？  " + is_Monitoring);
		if (is_Monitoring == MONITORING_ON) {
			SystemUtil.print(instance,  "send signal to open window");
			signal_direction = Engine.SWITCH_REVERSAL;
		} else {
			SystemUtil.print(instance,  "recived signal, but the system if off.");
		}
	}
	
	public static void cutSignal() {
		SystemUtil.print(instance,  "interrupted.");
		signal_speak = Speaker.SPEAK_OFF;
		setSafe();
//		signal_direction = Engine.SWITCH_STOP;
	}
	
	public static void shutdown() {
		is_Monitoring = MONITORING_OFF;
	}
	
	public static void startup() {
		is_Monitoring = MONITORING_ON;
	}
}
