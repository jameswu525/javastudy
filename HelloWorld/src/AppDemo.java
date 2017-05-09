import java.util.Base64;

public class AppDemo {

	private static AppDemo app = new AppDemo();
	private SubClass sub = new SubClass();
	
	static {
		System.out.println("6 App 静态初始化");
	}
	public AppDemo() {
		System.out.println("5 App 构造");
	}

	public static void main(String[] args) {
		System.out.println("7 App -- > HelloWorld!");
		String s = "new string";
		// Encoding
		String ecing = Base64.getEncoder().encodeToString(s.getBytes());
		System.out.println(ecing);
		// Decoding
		String dcing = new String(Base64.getDecoder().decode(ecing));
		System.out.println(dcing);
	}
}

class SuperClass {
	static {
		System.out.println("1 SuperClass 静态初始化");
	}
	SuperClass() {
		System.out.println("3 SuperClass 构造");
	}
}

class SubClass extends SuperClass {
	static {
		System.out.println("2 SubClass 静态初始化");
	}
	SubClass() {
		System.out.println("4 SubClass 构造");
	}
}