
public class LocationOfPoint {

	public LocationOfPoint() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle circle = new Circle(20, 0, 5);
		Point p = new Point(4.0, 0.0);
		int rst = circle.getRst(p);
		if (rst == 0) {
			System.out.println("on");
		} else if (rst == 1) {
			System.out.println("outter");
		} else {
			System.out.println("inner");
		}
		
	}

}

class Circle {
	double x = 0.0;
	double y = 0.0;
	double r = 0.0;
	
	Circle(double x, double y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	public int getRst(Point b) {
		double dis = Math.sqrt((b.x - this.x) * (b.x - this.x) + (b.y - this.y) * (b.y - this.y));
		if (r > dis) {
			return -1;
		} else if (Math.sqrt(r) == dis) {
			return 0;
		} else {
			return 1;
		}
	}
}

class Point {
	double x = 0.0;
	double y = 0.0;
	
	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}