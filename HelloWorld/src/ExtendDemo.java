class SuperC {
	public String pubStr = "共有";
	private String prStr = "私有";
	String defStr = "默认";
	protected String prdStr = "保护";
	public String name = "";
	public void print1() {
		System.out.println("public");
	}
	private void print2() {
		System.out.println("private");
	}
	void print3() {
		System.out.println("Default");
	}
	protected void print4() {
		System.out.println("protected");
	}
	
	public void show () {
		System.out.println(name+ "========");
		System.out.println(pubStr);
		System.out.println(prStr);
		System.out.println(defStr);
		System.out.println(prdStr);
	}
}

class SonC extends SuperC {
//	public String pubStr = "子类共有";
//	private String prStr = "子类私有";
//	String defStr = "子类默认";
//	protected String prdStr = "子类保护";
//	public String name = "";
	
//	pubStr = "子类共有";
//	prStr = "子类私有";
//	defStr = "子类默认";
//	prdStr = "子类保护";
//	name = "";
	// 子类访问权限必须大于等于父类
	@Override  // 编译时判断是否符合覆盖
	public void print1() {
		System.out.println("public son");
	}
	@Override  // 编译时判断是否符合覆盖
	void print3() {
		System.out.println("Default son");
	}
	@Override  // 编译时判断是否符合覆盖	
	protected void print4() {
		System.out.println("protected son");
	}
	
	public void show () {
		this.print1();
		this.print3();
		this.print4();
		
	}
}

abstract class Animal {
	public abstract void eat() ;
}
class Dog extends Animal {
	public void eat() {
		System.out.println("狗正在吃肉骨头");
	}
	
	public void watch() {
		System.out.println("狗看门");
	}
}
class Cat extends Animal {
	public void eat() {
		System.out.println("猫正在吃鱼");
	}

	public void catchMouse() {
		System.out.println("狗抓老鼠");
	}
}
class Person {
	public void feed(Animal an) {
		System.out.println("饲养员正在喂食" + an.getClass().getName());
		an.eat();
		if(an instanceof Dog) {
			((Dog) an).watch();
		} else if (an instanceof Cat) {
			((Cat) an).catchMouse();
		}
	}
}


public class ExtendDemo {

	public ExtendDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SonC instance = new SonC();
		instance.show();
		System.out.println(instance);
		System.out.println(instance.getClass().getName());
		System.out.println(instance.hashCode());

		System.out.println(Integer.toHexString(instance.hashCode()));

		System.out.println("====-----------====");
		   TxtThread tt = new TxtThread(); 
		   new Thread(tt, "A").start(); 
		   new Thread(tt, "B").start(); 
		   new Thread(tt, "C").start(); 
		   new Thread(tt, "D").start(); 

			System.out.println("====-----------====");
			Person feeding = new Person();
			Animal dog = new Dog();
			Animal cat = new Cat();
			feeding.feed(dog);
			feeding.feed(cat);
	}

}


class TxtThread implements Runnable {
	static int num = 100; // 即便使用static修饰，如果没有synchronized互斥锁，仍然线程冲突。
	/* 没有Synchronized的情况
	 * B: & this is 99
		D: & this is 98
		C: & this is 100
		A: & this is 97
		A: & this is 96
        ... ...
        
        以下是有锁的情况,线程安全，被A线程互斥：
        A: & this is 100
		A: & this is 99
		A: & this is 98
		A: & this is 97
		A: & this is 96
		... ...
	 */
	String str = new String();
	public void run() {
		synchronized (str) {   // 线程安全，必须使用synchronized锁。
			while (num > 0) {
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.getMessage();
				}
				System.out.println(Thread.currentThread().getName() + ": & this is " + num--);
			}
		}
	}
}
