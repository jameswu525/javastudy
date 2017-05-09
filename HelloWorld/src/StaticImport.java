import java.util.Arrays;
import static java.util.Arrays.sort;

/*
 * =========>   静态导入，忽略类名。
 * 通过反编译还是使用类名调用，语法糖。
 * 但实际开发中不使用 
 * 
 * 语法糖：
 * 1）静态导入 import static
 * 2）循环历遍（foreach）
 * for(CLASSNAME item : arr) {
 *     item ***  // 但是无法对引用源操作
 * }
 * 3） 与C#中的泛型相比，Java的泛型可以算是“伪泛型”了。
 * 4） 变长参数
 * public void foo(String str,Object...args){  
 *	  
 *	}  
 * ==> 调用
 * 	foo("oliver");  
		foo("oliver",new Object());  
		foo("oliver",new Integer(1),"sss");  
		foo("oliver",new ArrayList(),new Object(),true,1); 
 *
 *
 */

public class StaticImport {

	public StaticImport() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main (String[] args) {
		int[] arr = new int[] {1,2,11,-3,-43};
		String ret = Arrays.toString(arr);
		System.out.println(ret);
		
//		Arrays.sort(arr);
//		==>
		sort(arr);
		ret = Arrays.toString(arr);
		System.out.println(ret);
	}

}
