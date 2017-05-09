import java.util.ArrayList;

public class Stick {
	private int height;
	private String name;
	private ArrayList<Panel> panels;
	
	public static void main(String[] args) {
		Stick s = new Stick("", 101, true);
		System.out.println(s);
		
		for(int i = 0; i <= s.Height(); i++) {
			s.printLine(i);
		}
	}

	public Stick(String name, int height, boolean init) {
		this.name = name;
		height = height > 99 ? 99 : height;
		this.height = height;
		this.panels = new ArrayList<Panel>();
		if (init) { // Initial
			for (int p = height; p >=1 ; p--) {
				Panel p1 = new Panel(String.valueOf(p), p);
				//this.panels.add(p1);
				this.Push(p1);
			}
		}
	}
	
	public int Height() {
		return this.height;
	}
	
	public String Name() {
		return this.name;
	}
	
	public Panel Take() {
		Panel p1 = this.panels.remove(panels.size() - 1);
		return p1;
	}
	
	public void Push(Panel p) {
		this.panels.add(p);
	}
	
	public String printLine(int n) {
		String rtn = "|";
		
		if (n > height) {
			rtn = "";
		} else if (n > 0 && this.panels.size() > height - n) {
			Panel p = this.panels.get(height - n);
			if (p != null) {
				rtn += p;
			}
		}
		for (int l = rtn.length(); l <= height + 3; l++) {
			rtn += " ";
		}
		//System.out.println(rtn);
		return rtn;
	}
	
	public String toString() {
		String rtn = "|" + "\n";
		for(int h = this.height; h >= 1; h--) {
			rtn += "|";
			Panel p = this.panels.get(h - 1);
			if (p != null) {
				rtn += p;
			}
			rtn += "\n"; 
		}
		
		return rtn;
	}

}
