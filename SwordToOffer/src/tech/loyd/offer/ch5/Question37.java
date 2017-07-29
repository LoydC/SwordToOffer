package tech.loyd.offer.ch5;

public class Question37 {

	private static class Node{
		int value;
		Node next;
		
		Node(int value){
			this.value = value;
		}
	}
	
	public static Node findFirstPublicNode(Node head1,Node head2){
		
		if(head1 == null || head2 == null)
			return null;
		
		Node newHead1 = head1;
		Node newHead2 = head2;
		int length1 = 0;
		int length2 = 0;
		
		while(head1!=null){
			length1++;
			head1 = head1.next;
		}
		
		while(head2!=null){
			length2++;
			head2 = head2.next;
		}
		
		if(length1>length2){
			for(int i=0;i<length1-length2;i++){
				newHead1 = newHead1.next;
			}
		}else{
			for(int i=0;i<length2-length1;i++){
				newHead2 = newHead2.next;
			}
		}
		
		Node publicNode = null;
		while(newHead1!=null){
			if(newHead1 != newHead2){
				newHead1 = newHead1.next;
				newHead2 = newHead2.next;
			}else{
				publicNode = newHead1;
				break;
			}	
		}
		
		return publicNode;
	}
	
	
	public static void main(String[] args) {
        // 第一个公共结点在链表中间
        // 1 - 2 - 3 \
        //            6 - 7
        //     4 - 5 /
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n6;
        n6.next = n7;

        n4.next = n5;
        n5.next = n6;		

        System.out.println(findFirstPublicNode(n1, n4).value);
	}

}
