package tech.loyd.offer.ch2;

import java.util.ArrayList;
import java.util.Stack;

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class Question5 {

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack<ListNode> stack = new Stack<ListNode>();
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		ListNode currentNode = listNode;
		while(currentNode != null){
			stack.push(currentNode);
			currentNode = currentNode.next;
		}
		while(!stack.isEmpty()){
			arrayList.add(new Integer(stack.pop().val));
		}
		return arrayList;
	}
	
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(3);
		ListNode listNode2 = new ListNode(4);
		listNode1.next = listNode2;
		System.out.println(new Question5().printListFromTailToHead(listNode1));
	}

}
