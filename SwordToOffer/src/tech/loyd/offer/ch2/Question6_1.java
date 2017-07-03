package tech.loyd.offer.ch2;

/*
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Question6_1 {

	
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if(pre == null || in == null)
			return null;

		//获取pre中第一个元素在in中的位置
		int count = 0;
		for(int i=0;i<in.length;i++){
			if(in[i] == pre[0]){
				count = i;
				break;
			}
		}
		
		int[] leftPre = count != 0 ?  new int[count] : null;
		int[] leftIn = count != 0 ?  new int[count] : null;
		int[] rightPre = count != pre.length-1 ? new int[pre.length - count - 1] : null;
		int[] rightIn = count != pre.length-1 ? new int[pre.length - count - 1] : null;
		
		for(int i=0;i<count;i++){
			leftPre[i] = pre[i+1];
			leftIn[i] = in[i];
		}
		
		for(int i=0;i<pre.length- count - 1;i++){
			rightPre[i] = pre[count + 1 + i];
			rightIn[i] = in[count + 1 + i];
		}
		
		TreeNode tn = new TreeNode(pre[0]);
		tn.left = reConstructBinaryTree(leftPre,leftIn);
		tn.right = reConstructBinaryTree(rightPre,rightIn);
		
		return tn;
	}

	public static void main(String[] args) {
		int[] pre={1,2,4,7,3,5,6,8};
		int[] in={4,7,2,1,5,3,8,6}; 
		TreeNode node = new Question6_1().reConstructBinaryTree(pre,in);
		System.out.println(node.val);

	}

}
