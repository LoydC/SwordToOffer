package tech.loyd.offer.ch2;

/*
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

public class Question6_2 {
	public TreeNode reConstructBinaryTree(int[] pre,int[] in){
		TreeNode treeNode = reConstruct(pre,0,pre.length-1,in,0,in.length-1);
		return treeNode;
	}

	public TreeNode reConstruct(int[] pre,int startpre,int endpre,int[] in,int startIn,int endIn) {
		if(startpre>endpre || startIn>endIn)
			return null;
			TreeNode root = new TreeNode(pre[startpre]);
			for(int i =startIn;i<endIn;i++){
				if(pre[startpre] == in[i]){
					root.left =reConstruct(pre, startpre+1, startpre+i-startIn, in, startIn, i-1);
					root.right=reConstruct(pre, i-startIn+startpre+1, endpre, in, i+1, endIn);
				}
			}
		return root;
	}
	
	public static void main(String [] args){
		int[] pre={1,2,4,7,3,5,6,8};
		int[] in={4,7,2,1,5,3,8,6}; 
		TreeNode node = new Question6_2().reConstructBinaryTree(pre,in);
		System.out.println(node.val);
		
	}
}
