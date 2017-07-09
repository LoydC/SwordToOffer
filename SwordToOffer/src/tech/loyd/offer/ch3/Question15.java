package tech.loyd.offer.ch3;

/*
 * 输入一个链表，输出该链表中倒数第k和节点。为了符合大多人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如一个链表有6个节点，从头结点开始他们的值一次是1、2、3、4、5、6.这个链表的倒数第3个节点是值为4的节点。
 */

public class Question15 {

	private static Node getNodeFromBack(Node head,int num){
		if(num == 0)
			return null;
		
		int x = num;
		
		Node temp = head;
		while(num > 0){
			if(temp != null){
				temp = temp.next;
				num--;
			}else{
				return null;
			}
		}
		
		while(temp !=null){
			head = head.next;
			temp = temp.next;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		
		Node node5 = new Node(5,null);
		Node node4 = new Node(4,node5);
		Node node3 = new Node(3,node4);
		Node node2 = new Node(2,node3);
		Node node1 = new Node(1,node2);
		
		System.out.println(getNodeFromBack(node1, 3).value);
		
	}
	
}
