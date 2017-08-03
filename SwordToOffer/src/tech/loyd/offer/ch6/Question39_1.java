package tech.loyd.offer.ch6;

public class Question39_1 {

	private static class TreeNode{
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
	
	public static int height(TreeNode root){
		if(root == null)
			return 0;
		
		return Math.max(height(root.leftChild), height(root.rightChild)) + 1;
	}
	
	public static void main(String[] args) {
		//           1
		//         /   \
		//      2         5
		//    /  \       /  \ 
		//   3    4     6     8
		//             /
		//            7
		TreeNode tn8 = new TreeNode(8);
		TreeNode tn7 = new TreeNode(7);
		TreeNode tn6 = new TreeNode(6, tn7, null);
		TreeNode tn5 = new TreeNode(5, tn6, tn8);
		TreeNode tn4 = new TreeNode(4);
		TreeNode tn3 = new TreeNode(3);
		TreeNode tn2 = new TreeNode(2, tn3, tn4);
		TreeNode tn1 = new TreeNode(1, tn2, tn5);

		System.out.println(height(tn1));
	}

}
