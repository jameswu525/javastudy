package org.jimmy.cordemo;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class EncodingDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "中国J";
//		byte[] b1 = str.getBytes("GB2312");
//		System.out.println("--\n" + Arrays.toString(b1));
//		String ret1 = new String(b1, "GBK");
//		System.out.println(ret1);
//		
//		byte[] b2 = str.getBytes("GBK");
//		System.out.println("--\n" + Arrays.toString(b2));
//		String ret2 = new String(b2, "GB2312");
//		System.out.println(ret2);

		byte[] b3 = str.getBytes("GB2312");
		System.out.println("--\n" + Arrays.toString(b3));
		String ret3 = new String(b3, "ISO-8859-1");   // 编码与解码必须使用同一个
		System.out.println(ret3);
		
		byte[] b4 = str.getBytes("UTF-16");
		System.out.println("--\n" + Arrays.toString(b4));
		String ret4 = new String(b4, "UTF-8");
		System.out.println(ret4);
		
		System.out.println("=============================================");
		byte[] b31 = ret3.getBytes("ISO-8859-1");
		System.out.println(Arrays.toString(b31));
		System.out.println(new String(b31, "GB2312"));
	}

}
