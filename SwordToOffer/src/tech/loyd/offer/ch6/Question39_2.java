package tech.loyd.offer.ch6;

public class Question39_2 {

	private static class TreeNode {
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

	public static boolean isAVL(TreeNode root) {
		int[] depth = new int[1];
		return isAVL(root, depth);
	}

	public static boolean isAVL(TreeNode root, int[] depth) {
		if (root == null) {
			depth[0] = 0;
			return true;
		}
		
		int[] left = new int[1];
		int[] right = new int[1];
		
		if(isAVL(root.leftChild,left) && isAVL(root.rightChild,right)){
			int diff = left[0] - right[0];
			if(diff >=-1 && diff <= 1){
				depth[0] = 1+ Math.max(right[0], left[0]);
				return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		// 		 5
		// 	    / \
		// 	   3   7
		//    / \ / \
		//   2  4 6  8
		//  /
		// 1
		TreeNode tn8 = new TreeNode(8);
		TreeNode tn7 = new TreeNode(6);
		TreeNode tn6 = new TreeNode(7, tn7, tn8);
		TreeNode tn5 = new TreeNode(1);
		TreeNode tn4 = new TreeNode(2,tn5,null);
		TreeNode tn3 = new TreeNode(4);
		TreeNode tn2 = new TreeNode(3, tn3, tn4);
		TreeNode tn1 = new TreeNode(6, tn2, tn6);

		System.out.println(isAVL(tn1));
	}

}
