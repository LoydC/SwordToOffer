package tech.loyd.offer.ch4;

public class Question26 {

	/**
	 * 复杂链表结点
	 */
	private static class ComplexListNode {
		String value;
		ComplexListNode next;
		ComplexListNode sibling;

		public ComplexListNode(String value) {
			this.value = value;
		}
	}

	public static ComplexListNode clone(ComplexListNode head) {
		ComplexListNode newHead = head;

		// 第一步
		while (newHead != null) {
			ComplexListNode cln = new ComplexListNode(newHead.value + "'");
			cln.next = newHead.next;
			newHead.next = cln;
			newHead = newHead.next.next;
			
		}

		newHead = head;
		// 第二步
		while (newHead != null) {
			if (newHead.sibling != null) {
				newHead.next.sibling = newHead.sibling.next;
			}
			newHead = newHead.next.next;
		}

		newHead = head;
		ComplexListNode returnHead = newHead.next;

		while (newHead!=null && newHead.next != null) {
			ComplexListNode nextNode= newHead.next.next;
			if(nextNode != null){
				newHead.next.next = newHead.next.next.next;
			}
			newHead.next = nextNode;
			newHead = newHead.next;
		}

		return returnHead;
	}

	private static void printNextAndSibling(ComplexListNode head) {
		ComplexListNode newHead = head;
		while (newHead != null) {
			System.out.println(newHead.value + ":next=" + (newHead.next!=null ? newHead.next.value : "空") + ",sibling=" + (newHead.sibling!=null ? newHead.sibling.value : "空"));
			newHead = newHead.next;
		}
	}

	public static void main(String[] args) {
		ComplexListNode A = new ComplexListNode("A");
		ComplexListNode B = new ComplexListNode("B");
		ComplexListNode C = new ComplexListNode("C");
		ComplexListNode D = new ComplexListNode("D");
		ComplexListNode E = new ComplexListNode("E");
		A.next = B;
		A.sibling = C;
		B.next = C;
		B.sibling = E;
		C.next = D;
		D.next = E;
		D.sibling = B;

		//打印初始的复杂链表
		printNextAndSibling(A);
		
		System.out.println();
		
		//打印12
		printNextAndSibling(clone(A));

	}

}
