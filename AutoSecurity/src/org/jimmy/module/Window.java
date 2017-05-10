package org.jimmy.module;

import org.jimmy.util.MathUtil;

public class Window {
	private static final Double LENGTH_C_MIN = 30.0;
	private static final Double LENGTH_C_MAX = 65.0;
	private static final Double LENGTH_C_STEP = 0.5;
	
	private static Window instance = new Window();
	private Double length_a = 90.0;
	private Double length_b = 60.0;
	private Double length_c = 30.0;
	
	private Window() {}
	
	/**
	 * 返回当前状态的窗户角度
	 * @return
	 */
	public double getAngle() {
		return Math.round(Math.toDegrees(Math.acos((length_a * length_a + length_c * length_c - length_b * length_b)/(2.0 * length_a * length_c))));
	}
	
	/**
	 * 开启窗户，每次将滑轨向开向移动一个STEP
	 * @return
	 */
	public boolean opening() {
		length_c = Math.min(length_c + LENGTH_C_STEP, LENGTH_C_MAX);
//		System.out.print(length_c + "/");
		return MathUtil.isEqual(length_c, LENGTH_C_MAX);
	}

	/**
	 * 关闭窗户，每次将滑轨向关向移动一个STEP
	 * @return
	 */
	public boolean closing() {
		length_c = Math.max(length_c - 0.5, LENGTH_C_MIN);
		return MathUtil.isEqual(length_c, LENGTH_C_MIN);
	}
	
	public static Window getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		Window window = Window.getInstance(); 
		double angle = window.getAngle();
		System.out.println(angle);
		while(!window.opening()) {
			angle = window.getAngle();
			System.out.println(angle);
		}
		while(!window.closing()) {
			angle = window.getAngle();
			System.out.println(angle);
		}
	}

}
