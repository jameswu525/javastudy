package org.jimmy.util;

public class SystemUtil {
	private SystemUtil() {	}

	public static final boolean IS_DEBUG = false;
	public static final boolean IS_TIMING = true;
	private static final long TIME_STEP = 1000l;
	private static final long START_TIME = System.currentTimeMillis();

	public static void print(Object obj, String strOut) {
		if (IS_DEBUG) {
			String strClass = obj.getClass().getName();
			System.out.print(strClass.substring(strClass.lastIndexOf('.') + 1));
			System.out.print("\t\t");
			System.out.println(strOut);
		}
	}
	
	public static String printTime(Object obj) {
		String str = "";
		if (IS_TIMING) {
			String strClass = obj.getClass().getName();
			str += strClass.substring(strClass.lastIndexOf('.') + 1) + ":";
			str += (int)((System.currentTimeMillis() - START_TIME)/1000) + "\t\t";
		}
		return str;
	}
	
	public static void sleeping(int time) {
		try {
			Thread.sleep(time * TIME_STEP);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
