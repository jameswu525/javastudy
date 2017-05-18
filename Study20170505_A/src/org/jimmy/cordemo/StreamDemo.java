package org.jimmy.cordemo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamDemo {

	public static void main(String[] args) {
		File input = new File("Java6_cn.chm");
		long begin = System.currentTimeMillis();
		int len =  -1;
		byte[] buffer = new byte[1024];
		try (
				BufferedInputStream in = new BufferedInputStream(new FileInputStream(input));
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File("bin/Java6_cn_copy.chm")));
				)
		{
			while((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
			System.out.println("Copy successed. " + (System.currentTimeMillis() - begin)); //Copy successed. 82
			// 缓冲包装流的效率大于节点流。
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
