package tech.loyd.offer.ch3;

/*
 * 给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间删除该节点。
 */


class Node{
	int value;
	Node next;
	
	Node(int value,Node next){
		this.value = value;
		this.next = next;
	}
}

public class Question13 {
	
	/*
	 * 删除节点
	 */
	private static void deleteNode(Node head,Node target){
		if(head == null){
			return;
		}
		if(target.next == null){
			Node node = head.next;
			
			while(node.next != target){
				node = node.next;
			}
			
			node.next = null;
			
		}else{
			target.value = target.next.value;
			target.next = target.next.next;
		}
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
		
		deleteNode(node1,node3);
		
		printNodeList(node1);
	}
}
