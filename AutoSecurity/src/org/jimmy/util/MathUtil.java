package org.jimmy.util;

public class MathUtil {
	
	/**
	 * 判断两个double数据是否相等，相等返回true
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean isEqual(double a, double b) {
		double c = Math.abs(a - b);
		return c <= 0.00000001;
	}

	public static void main(String[] args) {
		System.out.println(MathUtil.isEqual(1.01001, 1.01002));
	}

}
