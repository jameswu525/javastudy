package org.jimmy.module;

public class PLCSignal {
	public static int signal_direction = 0;
	public static int signal_speak = 0;

	public static void seeSomebody() {
		signal_direction = Engine.SWITCH_FORWARD;
		signal_speak = Speaker.SPEAK_ON;
	}
}
