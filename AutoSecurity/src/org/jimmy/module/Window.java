package org.jimmy.module;

import java.awt.Frame;

import org.jimmy.util.MathUtil;
import org.jimmy.util.SystemUtil;

public class Window extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Double LENGTH_C_MIN = 35.0;
	private static final Double LENGTH_C_MAX = 65.0;
	private static final Double LENGTH_C_STEP = 2.0;
	
	private static Window instance = new Window();
	private Double length_a = 90.0;
	private Double length_b = 60.0;
	private Double length_c = 65.0;
	
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
		SystemUtil.print(this, "opening ..." + getAngle());
		System.out.println(SystemUtil.printTime(this) + "opening ..." + getAngle());
		return MathUtil.isEqual(length_c, LENGTH_C_MAX);
	}

	/**
	 * 关闭窗户，每次将滑轨向关向移动一个STEP
	 * @return
	 */
	public boolean closing() {
		length_c = Math.max(length_c - LENGTH_C_STEP, LENGTH_C_MIN);
		SystemUtil.print(this, "closing ..." + getAngle());
		System.out.println(SystemUtil.printTime(this) + "closing ..." + getAngle());
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
