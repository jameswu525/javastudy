package org.jimmy.cordemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyDemo {

	public static void main(String[] args) {
		File input = new File("Java6_cn.chm");
		long begin = System.currentTimeMillis();
		byte[] buffer = new byte[1024];
		int len = -1;
		try (
				// 字节流
				InputStream in = new FileInputStream(input);
				OutputStream out =new FileOutputStream(new File("bin/Java6_cn_copy.chm"));
				)
		{
			while((len = in.read(buffer)) != -1) {
//				System.out.println(new String(buffer, 0, len));
				out.write(buffer, 0, len);
			}
			System.out.println("Copy successed. " + (System.currentTimeMillis() - begin)); //Copy successed. 302
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
