package org.jimmy.thread_priority;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Begin >>>");
//		Timer timer = new Timer(true); // 后台线程，没有效果
		Timer timer = new Timer(); // 3s只有打印
		
//		timer.schedule(new TimerTask() {   // 打印1次
//			public void run() {
//				System.out.println("=========");
//			}
//		}, 3000);
		
//		timer.schedule(new TimerTask() {   // 3秒后 打印/1秒
//			public void run() {
//				System.out.println("=========");
//			}
//		}, 3000, 1000);
		
		timer.schedule(new TimerTask() {   // 3秒后 打印/1秒
			public void run() {
				System.out.println("=========");
			}
		}, 3000, 1000);
		
		System.out.println("End <<<");
		
		Thread.sleep(10000);
		timer.cancel(); //// 取消定时器
	}

}
