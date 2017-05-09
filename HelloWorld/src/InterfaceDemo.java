interface IAnimalAction {
	public static final int MAX_VALUE = 100;
	void Eat(); // 默认修饰符 public abstract
	interface innerInterface {
		
	}
	public abstract void Sleep(); // 必须使用public或者不加修饰符（public、abstract）
}

interface IDancing {
	public abstract void Dance();
}

class Inner implements IAnimalAction.innerInterface { 
	
}

class DancerDog implements  IAnimalAction, IDancing {

	@Override
	public void Dance() { // 必须是public
		// TODO Auto-generated method stub
		System.out.println("Dance");
		System.out.println();
	}

	@Override
	public void Eat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Sleep() {
		// TODO Auto-generated method stub
		
	}
	
}

public class InterfaceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
