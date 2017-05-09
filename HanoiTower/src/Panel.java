
public class Panel {
	private int size;
	private String name;
	
	public Panel(String name, int n) {
		this.size = n;
		this.name = name;
	}
	
	public static void main(String[] args) {
		Panel p = new Panel("", 8);
		System.out.println(p);
	}
	
	public String Name() {
		return this.name;
	}
	
	public String toString() {
		String rtn = "";
		if (size <= 0) {
			rtn = "错误的盘子尺寸";
		} else {
			for (int s = 1; s <= size; s++) {
				rtn += "-";
			}
			if (size < 10) {
				rtn += ":0";
			} else {
				rtn += ":";
			}
			rtn += size;
		}
		return rtn;
	}
}
