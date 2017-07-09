package tech.loyd.offer.ch3;

/*
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 */
public class Question16 {

	private static Node reverseList(Node head){
		if(head == null)
			return null;
		if(head.next == null)
			return head;
		
		Node node1 = head;
		Node node2 = head.next;
		Node node3 = node2.next;
		node1.next = null;
		
		while(node3 != null){
			node2.next = node1;
			node1 = node2;
			node2 = node3;
			node3 = node3.next;
		}
		
		node2.next = node1;
		return node2;
	}
	
	/*
	 * 打印链表
	 */
	private static void printNodeList(Node head){
		while(head != null){
			System.out.println(head.value);
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		Node node5 = new Node(5,null);
		Node node4 = new Node(4,node5);
		Node node3 = new Node(3,node4);
		Node node2 = new Node(2,node3);
		Node node1 = new Node(1,node2);

		printNodeList(node1);
		
		System.out.println("翻转后：");
		
		printNodeList(reverseList(node1));
	}

}
