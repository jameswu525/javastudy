package org.jimmy.test;

import java.util.Arrays;

import org.junit.Test;

public class LambdaTest01 {
	@Test
	public void test1() {
		Integer[] its = new Integer[] {1,9,2,3,10,2,4,5};
		// 方法引用
//		Arrays.sort(its, Integer::compare);
		// 原Lambda方式
		Arrays.sort(its, (x, y) -> Integer.compare(x, y));
		System.out.println(Arrays.toString(its));
	}

}
