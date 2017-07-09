package tech.loyd.offer.ch3;

/*
 * 输入两棵二叉树A和B，判断B是不是A的子结构。
 */

class TreeNode {
	int value;
	TreeNode leftChild;
	TreeNode rightChild;

	TreeNode(int value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
	}

	TreeNode(int value, TreeNode leftChild, TreeNode rightChild) {
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
}

public class Question18 {

	//判断B是不是A的子结构
	private static boolean isHaveSubTree(TreeNode A, TreeNode B) {
		boolean result = false;

		if (A != null && B != null) {
			if (A.value == B.value) {
				result = isChild(A, B);
			}
			if (!result)
				result = isHaveSubTree(A.leftChild, B);
			if (!result)
				result = isHaveSubTree(A.rightChild, B);
		}

		return result;
	}

	//判断A为根节点的树和B为根节点的树是否结构一致或包含，边界条件是到A或B的叶子节点
	private static boolean isChild(TreeNode A, TreeNode B) {
		if (B == null)
			return true;
		if (A == null)
			return false;
		if (A.value != B.value)
			return false;

		return isChild(A.leftChild, B.leftChild) && isChild(A.rightChild, B.rightChild);
	}

	public static void main(String[] args) {
		TreeNode tn1 = new TreeNode(4);
		TreeNode tn2 = new TreeNode(7);
		TreeNode tn3 = new TreeNode(2, tn1, tn2);
		TreeNode tn4 = new TreeNode(9);
		TreeNode tn5 = new TreeNode(8, tn4, tn3);
		TreeNode tn6 = new TreeNode(7);
		TreeNode tn7 = new TreeNode(8, tn5, tn6);

		TreeNode tn8 = new TreeNode(9);
		TreeNode tn9 = new TreeNode(2);
		TreeNode tn10 = new TreeNode(8, tn8, tn9);

		System.out.println(isHaveSubTree(tn7, tn10));
	}

}
