
public class PageDemo {

	public PageDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int totCount = 46;
		int pageSize = 10;
		
		int pages = totCount % pageSize == 0 ? totCount / pageSize : totCount / pageSize + 1;
		System.out.println("Total:" + pages);
		
		int current = 1;
		int prevPage = current > 1 ? current - 1 : current;
		System.out.println("Prev:" + prevPage);
		
		int nextPage = current >= pages ? current : current + 1;
		System.out.println("Next:" + nextPage);
		
	}

}
