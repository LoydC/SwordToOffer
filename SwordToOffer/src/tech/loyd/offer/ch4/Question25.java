package tech.loyd.offer.ch4;

import java.util.ArrayList;
import java.util.List;

public class Question25 {

	public static void findPath(TreeNode root, int expectedSum) {
		// 创建一个链表，用于存放根结点到当前处理结点的所经过的结点
		List<Integer> list = new ArrayList<>();

		if (root != null) {
			findPath(root, 0, expectedSum, list);
		}
	}

	public static void findPath(TreeNode root, int curSum, int expectedSum, List<Integer> result) {
		// 如果结点不为空就进行处理
		if (root != null) {
			curSum += root.value;
			result.add(root.value);
			// 如果当前结点的值小于期望的和
			if (curSum < expectedSum) {
				findPath(root.leftChild, curSum, expectedSum, result);
				findPath(root.rightChild, curSum, expectedSum, result);
			}
			// 如果当前和与期望的和相等
			else if (curSum == expectedSum) {
				// 当前结点是叶结点，则输出结果
				if (root.leftChild == null && root.rightChild == null) {
					System.out.println(result);
				}
			}
			// 移除当前结点
			result.remove(result.size() - 1);
		}
	}

	public static void main(String[] args) {
		// 		1
		//     / \
		//    2   5
		//   / \ / \
		//  3  4 6  8
		//      /
		//     2
		TreeNode tn8 = new TreeNode(8);
		TreeNode tn7 = new TreeNode(2);
		TreeNode tn6 = new TreeNode(6, tn7, null);
		TreeNode tn5 = new TreeNode(5, tn6, tn8);
		TreeNode tn4 = new TreeNode(4);
		TreeNode tn3 = new TreeNode(3);
		TreeNode tn2 = new TreeNode(2, tn3, tn4);
		TreeNode tn1 = new TreeNode(1, tn2, tn5);

		// 有两条路径上的结点和为14
		System.out.println("findPath(root, 14);");
		findPath(tn1, 14);

		// 没有路径上的结点和为12
		System.out.println("findPath(root, 12);");
		findPath(tn1, 12);

		// 有一条路径上的结点和为7
		System.out.println("findPath(root, 7);");
		findPath(tn1, 7);

	}
}
