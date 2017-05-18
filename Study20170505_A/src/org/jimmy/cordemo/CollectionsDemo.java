package org.jimmy.cordemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("A", "B", "C");
		System.out.println(list);
		Collections.fill(list, "_");  // 填充
		System.out.println(list);
		
		List<String> list1 = new ArrayList<>();

		list1.add("A");
		list1.add("2");
		list1.add("3");
		list1.add("4");
		list1.add("5");
		list1.add("6");
		list1.add("7");
		list1.add("8");
		list1.add("9");
		list1.add("10");
		list1.add("J");
		list1.add("Q");
		list1.add("K");
		System.out.println(list1);
		list1.addAll(list1);
		System.out.println(list1);
		
		Collections.shuffle(list1);
		System.out.println(list1);
		
		
		
	}
}
