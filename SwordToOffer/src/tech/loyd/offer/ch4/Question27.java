package tech.loyd.offer.ch4;

public class Question27 {
	
	private static class SearchTreeNode{
		int value;
		SearchTreeNode leftChild;
		SearchTreeNode rightChild;
		
		SearchTreeNode(int value){
			this.value = value;
		}
	}
	
	private static SearchTreeNode convertBinarySearchTree2DoubleLinkedList(SearchTreeNode root){
		
		SearchTreeNode[] preNode = new SearchTreeNode[1];
		convertBinarySearchTree2DoubleLinkedList(root,preNode);
		
		SearchTreeNode listHead = preNode[0];
		
		while(listHead!=null && listHead.leftChild != null){
			listHead = listHead.leftChild;
		}
		
		return listHead;
		
	}
	
	private static void convertBinarySearchTree2DoubleLinkedList(SearchTreeNode node,SearchTreeNode[] preNode){
		
		if(node != null){
			
			if(node.leftChild != null){
				convertBinarySearchTree2DoubleLinkedList(node.leftChild,preNode);
			}
			
			// 将当前结点的前驱指向已经处理好的双向链表（由当前结点的左子树构成）的尾结点
			node.leftChild = preNode[0];
			
			// 将当前结点的前驱指向已经处理好的双向链表（由当前结点的左子树构成）的尾结点
			if(preNode[0] != null){
				preNode[0].rightChild = node;
			}
			
			preNode[0] = node;
			
			if(node.rightChild != null){
				convertBinarySearchTree2DoubleLinkedList(node.rightChild,preNode);
			}
			
		}
	}
	
	private static void printDoubleLinkedList(SearchTreeNode head){
		SearchTreeNode newHead = head;
		while(newHead != null){
			System.out.println("value:" + newHead.value + ",preValue:"+(newHead.leftChild!=null ? newHead.leftChild.value: "空")
					+ "nextValue:" + (newHead.rightChild!=null ? newHead.rightChild.value: "空"));
			newHead = newHead.rightChild;
		}
	}
	
	public static void main(String[] args) {
	
		//        10
		//        / \ 
		//      6    14
		//     / \   / \
		//    4   8 12  16
		
		SearchTreeNode node1 = new SearchTreeNode(10);
		SearchTreeNode node2 = new SearchTreeNode(6);
		SearchTreeNode node3 = new SearchTreeNode(14);
		SearchTreeNode node4 = new SearchTreeNode(4);
		SearchTreeNode node5 = new SearchTreeNode(8);
		SearchTreeNode node6 = new SearchTreeNode(12);
		SearchTreeNode node7 = new SearchTreeNode(16);	
		node1.leftChild = node2;
		node1.rightChild = node3;		
		node2.leftChild = node4;
		node2.rightChild = node5;		
		node3.leftChild = node6;
		node3.rightChild = node7;
		
		printDoubleLinkedList(convertBinarySearchTree2DoubleLinkedList(node1));
		
	}

}
