abstract class Operater {
	public final long running() {
		long begin = System.currentTimeMillis();
		System.out.println(this.getClass().getName() + begin);
		this.doWork();
		long end = System.currentTimeMillis();
		long time = end - begin;
		return time;
	}
	
	protected abstract void doWork();
}

class StringOper extends Operater {
	protected void doWork() {
		String str = "";
		for(int i = 0; i <= 10000; i++) {
			str += i;
		}
	}
}

class IntOper extends Operater {
	protected void doWork() {
		long sum = 0;
		for(int i = 0; i <= 1000000; i++) {
			sum += i;
		}
	}
}

public class TemplatePattenDemo {

	public TemplatePattenDemo() {
	}

	public static void main(String[] args) {
		System.out.println(new StringOper().running());
		System.out.println(new IntOper().running());
	}

}
