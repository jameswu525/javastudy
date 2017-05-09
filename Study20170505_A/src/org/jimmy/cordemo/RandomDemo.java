package org.jimmy.cordemo;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDemo {

	public static void main(String[] args) {
		// 伪随机数  new Random(seed) seed相同，生成数相同 
		System.out.println(new Random(12).nextLong());
		System.out.println(new Random(12).nextLong());
		System.out.println(new Random(12).nextLong());
		
		// 20到59的随机数
		Math.random();
		System.out.println(20 + new Random().nextInt(40));
		
		
		/*
		 * public static double random() {
		        return RandomNumberGeneratorHolder.randomNumberGenerator.nextDouble();
		    }
		 */
		
		ThreadLocalRandom thR = ThreadLocalRandom.current();
		thR.nextInt(100);
		System.out.println(thR.nextInt(20, 60));
		
		// 全球通用唯一字符串，使用网卡MAC + Timeone + current Time等计算。
		System.out.println(UUID.randomUUID().toString());
		
		// 生成5位随机字符串
		System.out.println(UUID.randomUUID().toString().substring(0, 5));
		// -----------------------------------------------------------------------------------
		String pool = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		pool += pool.toLowerCase();
		pool += "0123456789";
		System.out.println(pool);
		StringBuilder sb = new StringBuilder(5);
		for (int i = 0; i < 5; i++) {
			sb.append(pool.charAt(ThreadLocalRandom.current().nextInt(0, pool.length())));
		}
		System.out.println(sb.toString());
		
	}

}
