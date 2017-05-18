package org.jimmy.cordemo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ByteCopyDemo {

	public static void main(String[] args) {
		// 字符流，必须是纯文本文件
		File input = new File("note.md");
		char[] buffer = new char[1024];
		long begin = System.currentTimeMillis();
		int len = -1;
		try (
				Reader in = new FileReader(input);
				Writer out = new FileWriter(new File("bin/note_copy2.md"));
				)
		{
			while((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
			System.out.println("Copy successed. " + (System.currentTimeMillis() - begin));
		} catch(IOException e) {
			e.printStackTrace();
		}
		// 字符流
	}

}
