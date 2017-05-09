import org.apache.commons.lang3.ArrayUtils;

/**
 * 测试apache.commons.lang3的ArrayUtils功能。
 * @author JimmyWu
 *
 */
public class TestApachCommon {
	/**
	 * 主要入口方法
	 * @param args 参数列表
	 */
	public static void main(String[] args) {
		 int[] arr = new int[]{1,2,3,4,5,6};
		 System.out.println(ArrayUtils.toString(arr));
		 
		 arr = ArrayUtils.add(arr, 8);
		 System.out.println(ArrayUtils.toString(arr));
	}
}
