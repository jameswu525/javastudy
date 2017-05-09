import java.math.BigDecimal;

public class HelloWorld {
	
	private static int i = 1;
	public int j = 2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("HelloWorld!");
		System.out.println(i);  //必须引用static声明的变量
		System.out.println(new HelloWorld().j); // 或者实例的变量
		
		byte a = 65;
		byte i = 'V';//1
		short b = 1;//2
		int c = 2;//4
		long d = 123L; //8
		float e = 1.223f;//4
		double f = 12.4333d;//8
		char g = 'C';
		boolean h = true;
		// boolean j = 0;  编译不通过
		
		System.out.println("=========");
		System.out.println(a);
		System.out.println((char)a);
		System.out.println(i);
		System.out.println((char)i);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
		
		
		int x = 1;
		boolean y = true;
		while(y) {
			x++;
			if (x < 0) {
				y = false;
			}
		}
		System.out.println("越界" + x);
		x --;
		System.out.println("最大" + x);
		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toOctalString(x));
		System.out.println(Integer.toHexString(x));
		
		x =1;
		y = true;
		while(y) {
			x--;
			if (x > 0) {
				y = false;
			}
		}
		System.out.println("越界" + x);
		x ++;
		System.out.println("最小" + x);
		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toOctalString(x));
		System.out.println(Integer.toHexString(x));
		/*
		 * 最大2147483647
			0111 1111 1111 1111 1111 1111 1111 1111
			17777777777
			7fffffff
			最小-2147483648
			1000 0000 0000 0000 0000 0000 0000 0000
			20000000000
			80000000
		 */
		
		System.out.println(0b11100100_10011100_10010010_01001); // 2进制
		System.out.println(01456); // 8进制
		System.out.println(0x1456); // 16进制

		System.out.println(Integer.MAX_VALUE); 
		
		System.out.println(3.14E2);  // 314.0

		System.out.println(Long.MAX_VALUE); 
		double n = Double.MAX_VALUE;
		System.out.println(n);
		System.out.println(Double.toHexString(n));
		System.out.println(Double.doubleToLongBits(n));
		n = Double.MIN_VALUE;
		System.out.println(n);
		System.out.println(Double.toHexString(n));
		System.out.println(Double.doubleToLongBits(n));
		
		BigDecimal m = BigDecimal.valueOf(1.0000000000000100000100001);
		System.out.println(m.doubleValue());

		System.out.println(1 + 2 + "H"); // 3H
		System.out.println("H" + 1 + 2);

		System.out.println(10/3); //3
		System.out.println(9876 / 1000 * 1000); // 9000
		System.out.println(10.0/3); //3.3333333333333335
		System.out.println(9876.0 / 1000 * 1000); // 9876.0
		System.out.println(0.0 / 0); // NaN   Not a Number
		System.out.println(1.0 / 0); // Infinity
		System.out.println(0.0/0 == 0.0/0); // NaN != NaN
		
		int l = 1;
		System.out.println(l++); //1
		int k = 1;
		System.out.println(++k); //2
	}

}
