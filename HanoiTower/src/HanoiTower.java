import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class HanoiTower {
	private int t = 0;
	public final static int Num = 3;
	private Stick hanoiA;
	private Stick hanoiB;
	private Stick hanoiC;
	
	public HanoiTower(int n) {
		hanoiA = new Stick("A", n, true);
		hanoiB = new Stick("B", n, false);
		hanoiC = new Stick("C", n, false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//        System.out.println(System.getProperties());
        System.out.print("请输入圆盘的个数：");
		Scanner _input = new Scanner(System.in);
		int m = 0;
		try {
			m = _input.nextInt();
		} catch (Exception e) {
			m = HanoiTower.Num;
		}
		_input.close();
		if (m <= 0) {
			m = HanoiTower.Num;
		}

		PrintStream out = System.out;
		try {
			System.setOut(new PrintStream(new File("running.log")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("******************************************************************************************");
        System.out.println("这是汉诺塔问题（把A塔上编号从小号到大号的" + m + "个圆盘从A塔通过B辅助塔移动到C塔上去");
        System.out.println("******************************************************************************************");
        
		HanoiTower instance = new HanoiTower(m);
		instance.printStep();
		instance.Move(m, instance.hanoiA, instance.hanoiB, instance.hanoiC);
		
		System.setOut(out);
		System.out.println("程序运行完成，请查看文件  " + System.getProperty("user.dir") + "\\running.log");
	}
	
	public void Move(int n, Stick a, Stick b, Stick c) {
		if (n == 1) {
			MovingM2N(a, c);
		} else {
			Move(n-1, a, c, b);
			MovingM2N(a, c);
			Move(n-1, b, a, c);
		}
	}
	
	public void MovingM2N(Stick m, Stick n) {
		Panel p = m.Take();
		System.out.println("第" + ++t + "次:" + p.Name() + "从" + m.Name() + "移到" + n.Name());
		n.Push(p);
		printStep();
	}
	
	public void printStep() {
		for(int n = 0; n <= hanoiA.Height(); n++) {
			System.out.println(hanoiA.printLine(n)+hanoiB.printLine(n)+hanoiC.printLine(n));
		}
		String space = "";
		for(int i = 0; i < hanoiA.Height() * 3 + 12; i++) {
			space += "=";
		}
		System.out.println(space);
	}

}
