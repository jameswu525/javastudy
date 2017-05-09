public class CacheDemo {
		
	public CacheDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i1 = new Integer(123);
		Integer i2 = new Integer(123);
		System.out.println(i1);
		System.out.println(i1 == i2);  // false, 内存地址
		/*
		     public static Integer valueOf(int i) {
		        if (i >= IntegerCache.low && i <= IntegerCache.high)
		            return IntegerCache.cache[i + (-IntegerCache.low)];
		        return new Integer(i);
		    }
		 */
		Integer i3 = Integer.valueOf(123);
		Integer i4 = Integer.valueOf(123);
		System.out.println(i3 == i4);  // true
		
		Integer i5 = 123;
		Integer i6 = 123;
		System.out.println(i5 == i6);  //true
		
		
	}

}
