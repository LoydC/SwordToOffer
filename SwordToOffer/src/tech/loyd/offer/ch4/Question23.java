package tech.loyd.offer.ch4;

import java.util.LinkedList;
import java.util.Queue;

public class Question23 {

	private static void printTreeByLevel(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> list = new LinkedList<TreeNode>();
		list.add(root);
		// 用于记录当前处理的结点
		TreeNode curNode;
		while (!list.isEmpty()) {
			curNode = list.remove();
			System.out.print(curNode.value + " ");
			if (curNode.leftChild != null) {
				list.add(curNode.leftChild);
			}
			if (curNode.rightChild != null) {
				list.add(curNode.rightChild);
			}
		}

	}

	public static void main(String[] args) {
		// 1
		// / \
		// 2 5
		// / \ / \
		// 3 4 6 8
		// /
		// 7
		TreeNode tn8 = new TreeNode(8);
		TreeNode tn7 = new TreeNode(7);
		TreeNode tn6 = new TreeNode(6, tn7, null);
		TreeNode tn5 = new TreeNode(5, tn6, tn8);
		TreeNode tn4 = new TreeNode(4);
		TreeNode tn3 = new TreeNode(3);
		TreeNode tn2 = new TreeNode(2, tn3, tn4);
		TreeNode tn1 = new TreeNode(1, tn2, tn5);
		
		printTreeByLevel(tn1);
	}
}
