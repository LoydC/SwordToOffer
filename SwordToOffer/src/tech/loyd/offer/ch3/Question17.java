package tech.loyd.offer.ch3;

public class Question17 {

	private static Node mergeTwoList(Node head1,Node head2){
		if(head1 == null)
			return head2;
		if(head2 == null)
			return head1;
			
		Node node;
		Node headNew;
		if(head1.value < head2.value){
			node = head1;
			headNew = node;
			head1= head1.next;
		}else{
			node = head2;
			headNew = node;
			head2 = head2.next;
		}
		
		while(head1!=null && head2 !=null){
			if(head1.value < head2.value){
				node.next = head1;
				node = head1;
				head1= head1.next;
			}else{
				node.next = head2;
				node = head2;
				head2 = head2.next;
			}
		}
		
		if(head1 == null){
			node.next = head2;
		}else{
			node.next = head1;
		}
		
		return headNew;
	}
	
	private static void printNodeList(Node head){
		while(head != null){
			System.out.println(head.value);
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		Node node7 = new Node(6,null);
		Node node6 = new Node(5,node7);
		Node node5 = new Node(4,node6);
		Node node4 = new Node(3,node5);
		Node node3 = new Node(2,node4);

		Node node2 = new Node(7,null);
		Node node1 = new Node(1,node2);
		
		printNodeList(mergeTwoList(node1, node3));

	}

}
