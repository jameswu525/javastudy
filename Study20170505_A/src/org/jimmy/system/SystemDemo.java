package org.jimmy.system;

import java.math.BigDecimal;
import java.util.Arrays;

public class SystemDemo {
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("FINALIZE!!!!!!");
	}

	public static void main(String[] args) {
		System.out.println(Byte.MAX_VALUE);
		System.out.println((1 << 30) * 2 -1);
		System.out.println(Short.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		// 拷贝数组
		System.out.println();
		int[] arr1 = {1,2,3,4,5,6};
		int[] arr2 = new int[6];
		System.arraycopy(arr1, 1, arr2, 1, 4);
		System.out.println(Arrays.toString(arr2));
		
		System.out.println(System.currentTimeMillis()); 
		
		new SystemDemo();
		System.gc(); // 强制运行回收，以上不用的对象将被清理，  一般不用！！！
		
		System.out.println(Math.abs(-11));
		System.out.println(Math.sqrt(11));
		System.out.println(Math.max(21,11));
		System.out.println(Math.round(Math.random() * 100));
		
		// float / double不能表示精确的小数。
		System.out.println(0.01 + 0.09); // 0.09999999999999999
		System.out.println(1.0 / 3 * 3);
		// BigDecimal
		BigDecimal bd1 = new BigDecimal(0.09);
		BigDecimal bd2 = new BigDecimal(0.01);
		System.out.println(bd1.add(bd2));  // 0.09999999999999999687749774324174723005853593349456787109375
		/*  创建BigDecimal时建议使用String构造
public BigDecimal(double val)Translates a double into a BigDecimal which is the exact decimal representation of the double's binary floating-point value. The scale of the returned BigDecimal is the smallest value such that (10scale × val) is an integer. 
Notes: 

The results of this constructor can be somewhat unpredictable. One might assume that writing new BigDecimal(0.1) in Java creates a BigDecimal which is exactly equal to 0.1 (an unscaled value of 1, with a scale of 1), but it is actually equal to 0.1000000000000000055511151231257827021181583404541015625. This is because 0.1 cannot be represented exactly as a double (or, for that matter, as a binary fraction of any finite length). Thus, the value that is being passed in to the constructor is not exactly equal to 0.1, appearances notwithstanding. 
The String constructor, on the other hand, is perfectly predictable: writing new BigDecimal("0.1") creates a BigDecimal which is exactly equal to 0.1, as one would expect. Therefore, it is generally recommended that the String constructor be used in preference to this one. 
When a double must be used as a source for a BigDecimal, note that this constructor provides an exact conversion; it does not give the same result as converting the double to a String using the Double.toString(double) method and then using the BigDecimal(String) constructor. To get that result, use the static valueOf(double) method. 

		 */
		BigDecimal bd3 = new BigDecimal("0.09");
		BigDecimal bd4 = new BigDecimal("0.01");
		System.out.println(bd3.add(bd4));  // 0.1
		// BigInteger 一般不需要使用
		System.out.println(Long.MAX_VALUE);  // 9223372036854775807


		System.out.println("ENDING - " + System.currentTimeMillis()); 
		System.exit(0);  // 0正常结算，其他异常
	}

}
