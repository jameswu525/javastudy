/**
 *  实现IWalker，是一只猫
 * @author JimmyWu
 *
 */
public class Cat implements IWalker {

	@Override
	/**
	 * 实现走路
	 */
	public void walk() {
		System.out.println("猫咪走路");
	}

	public static void main(String[] args) {
		new Cat().walk();
	}

}
