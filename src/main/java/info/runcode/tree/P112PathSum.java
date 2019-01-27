package info.runcode.tree;

import java.util.List;

public class P112PathSum {
//	112. Path Sum
//	Easy
//
//	742
//
//	238
//
//	Favorite
//
//	Share
//	Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
//
//	Note: A leaf is a node with no children.
//
//	Example:
//
//	Given the below binary tree and sum = 22,
//
//	      5
//	     / \
//	    4   8
//	   /   / \
//	  11  13  4
//	 /  \      \
//	7    2      1
//	return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
	
	public boolean hasPathSum(TreeNode root, int sum) {
		return Recursive(root,0,sum);
    }
	
	private boolean Recursive(TreeNode root, int sum,int target) {
		if (root == null) {
			return false;
		}
		sum+=root.val;
		if ((root.left==null)&&(root.right==null)){
			if(sum==target)
				return true;
			else
				return false;
		}
		
		boolean r = this.Recursive(root.left, sum,target);		
		if (r == true) {
			return true;
		}
		r = this.Recursive(root.right, sum,target);
		if (r == true) {
			return true;
		}
		sum-=root.val;
		return false;
	}
	
	public static void main(String[] args) {
		P112PathSum p = new P112PathSum();
		int[] t = new int[] { 5,4,8,11, Integer.MAX_VALUE, 13,4, 7,2,Integer.MAX_VALUE, Integer.MAX_VALUE,  Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,1 };
		TreeNode root = TreeNode.createBinaryTreeByArray_good(t, 0);
		 int target = 22;
		boolean rr = p.hasPathSum(root,target);
		System.out.println(rr);
	}
}
