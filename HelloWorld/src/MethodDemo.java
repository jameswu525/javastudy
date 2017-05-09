
public class MethodDemo {

	public MethodDemo() {
		// TODO Auto-generated constructor stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodDemo method = new MethodDemo();
		System.out.println(method.fn(6));
		System.out.println(method.getMax());
		int[] arr = method.makeQueue();
		System.out.println(arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
		method.printTest();
		method.printTest(1);
	}
	
	// 同一个Package中访问
	void printTest() {
		System.out.println("无修饰符的方法");
	}
	
	// 同一个Package中访问，或者子类访问
	protected void printTest(int a) {
		System.out.println("protected 修饰符的方法" + a);
	}
	
	public int fn(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		return fn(n - 1) + fn(n - 2);
	}
	
	public int getMax() {
		int[] queue = {1,2,3,4,455,45,5,6,5,54,255,43,46,5,987,3,2,34,3,43,65,4,2,6,5,4,56,4,5};
		int max = queue[0];
		for (int i = 0; i < queue.length; i ++) {
			max = max > queue[i] ?  max : queue[i];
		}
		return max;
	}
	
	public int[] makeQueue() {
		int[] queue = {1,2,3,4,455,45,5,6,5,54,255,43,46,5,987,3,2,34,3,43,65,4,2,6,5,4,56,4,5};
		int max = 0;
		int i = 0;
		int index = 0;
		int time = 0;
		int ch = 0;
		for (int n = 0; n < queue.length; n ++) {
			max = queue[n];
			index = n;
			for (i = n + 1; i < queue.length; i ++) {
				time ++;
				if (max < queue[i]) {
					max = queue[i];
					index = i;
					ch ++;
				}
			}
			queue[index] = queue[n];
			queue[n]  = max;
		}
		System.out.println("t:" + time + " ch: " + ch);
		return queue;
	}

}
