
public class ByteCalculate {

	public ByteCalculate() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *  5原码 :    00000101
		 *  5反码 :    00000101
		 *  5补码：   00000101
		 *  
		 *  -5原码 :    10000101
		 *  -5反码 :    11111010
		 *  -5补码：   11111011
		 * 
		 *  3 :    00000011
		 *  5:     00000101
		 *  ------------------------
		 *  &:     00000001		1
		 *  |:      00000111		7
		 *  ^:      00000110		6
		 *  ~:      11110110		
		 */
		System.out.println(3 & 5);
		System.out.println(3 | 5);
		System.out.println(3 ^ 5);
		System.out.println(Integer.toBinaryString(3 ^ 5));
		System.out.println(~ 5);
		
		System.out.println(Integer.toBinaryString(5));
		System.out.println(5<<2);
		System.out.println(Integer.toBinaryString(5<<2));
		System.out.println(Integer.toBinaryString(-5));
		System.out.println(-5<<2);
		System.out.println(Integer.toBinaryString(-5<<2));
		System.out.println(-5>>>2);
		System.out.println(Integer.toBinaryString(-5>>>2));
		
		int i = 10, j = 15;
		i = j - i;
		j = j - i;
		i = j + i;
		// 运算交换
		System.out.println(i + "/" + j);
		
		// 异或
		i = 10;  // 1010
		j = 15;  // 1111
		i = i ^ j; // j = 1010^1111^1111    i = 1010^1111^1010^1111^1111
		j = i ^ j;
		i = i ^ j; // 任意数与相同的数异或两次还是这个值。
		System.out.println(i + "/" + j);
		
		int weekday = 4;
		switch(weekday) {
		case 1 : 
		case 2 :
		case 3 :
		case 4 :
		case 5 : System.out.println("工作日"); break;
		case 6 :
		case 7 : System.out.println("周末"); break;
		default: System.out.println("没有这一天");
		}
	}

}
