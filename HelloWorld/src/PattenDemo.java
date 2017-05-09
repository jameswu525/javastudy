
public class PattenDemo {

	// 饿汉模式/单例设计模式
	private static final PattenDemo pDemo = new PattenDemo();
	private PattenDemo() {

	}
	
	public static PattenDemo getInstance() {
		return pDemo;
	}
	
	public void sort() {
		System.out.println("使用" + this.hashCode());
	}

	public static void main(String[] args) {
		PattenDemo.getInstance().sort();
		PattenDemo.getInstance().sort();
		PattenDemo.getInstance().sort();
		PattenDemo.getInstance().sort();
	}

}


//class extendedPatten extends PattenDemo {
//	 // ERROR: Implicit super constructor PattenDemo() is not visible for default constructor. Must define an explicit constructor
//}