public class LinkedListDemo {
	public static final int MAX_ELE = Integer.MAX_VALUE;
	private Node first;
	private class Node {
		Node prev;
		Node next;
		Integer ele;
		public Node(Integer ele) {
			this.ele = ele;
		}
		public String toString() {
			return (this.prev==null?"":"<----") + String.valueOf(ele);
//			return (this.prev == null?"NULL":this.prev) + "<----" + String.valueOf(ele) + "---->" + (this.next == null?"NULL":this.next);
		}
	}	
	public LinkedListDemo(Integer item){
		this.first = new Node(item);
		this.first.prev = null;
		this.first.next = null;
	}
	
	public Node removeNode(int which) {
		Node ele = this.first;
		for (int i = 1; i < which; i++) {
			if (ele.next != null) {
				ele = ele.next;
			}
		}
		if (which == 1) {
			this.first = ele.next;
			this.first.prev = null;
		} else {
			ele.prev.next = ele.next;
			if (ele.next != null) {
				ele.next.prev = ele.prev;
			}
		}

		return ele;
	}
	
	public void insertNode(Node iNode, int which) {
		// which = 1 ... n (1 is first)
		Node ele = this.first;
		int order = 1;
		for (int i = 1; i < which; i++) {
			if (ele.next != null) {
				ele = ele.next;
				order ++;
			}
		}
		if (which == 1) {
			this.first = iNode;		
			iNode.next = ele;
			iNode.prev = null;
			ele.prev = iNode;
		} else if (order < which) {
			iNode.next = null;
			iNode.prev = ele;
			ele.next = iNode;
		} else {
			ele.prev.next = iNode;
			iNode.next = ele;
			iNode.prev = ele.prev;
			ele.prev = iNode;
		}
	}
	
	public void insertNode(Integer item, int which) { 
		Node iNode = new Node(item);
		insertNode(iNode, which);
	}
	
	public String toString() {
		String str = "";
		Node ele = this.first;
		do {
			str += ele;
			ele = ele.next;
		} while(ele != null);
		
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("BEGIN === !!!");
		LinkedListDemo list = new LinkedListDemo(new Integer(1));
		System.out.println(list);
		
		list.insertNode(2, 2);
		list.insertNode(3, 3);
		list.insertNode(4, 3);
		list.insertNode(5, 3);
		list.insertNode(6, 1);

		System.out.println(list);
		
		list.removeNode(3);
		System.out.println(list);
		
	}

}
