package info.runcode.tree;

public class P98ValidBST {
//	98. Validate Binary Search Tree
//	Medium
//	1416
//	222
//
//
//	Given a binary tree, determine if it is a valid binary search tree (BST).
//
//	Assume a BST is defined as follows:
//
//	The left subtree of a node contains only nodes with keys less than the node's key.
//	The right subtree of a node contains only nodes with keys greater than the node's key.
//	Both the left and right subtrees must also be binary search trees.
//	Example 1:
//
//	Input:
//	    2
//	   / \
//	  1   3
//	Output: true
//	Example 2:
//
//	    5
//	   / \
//	  1   4
//	     / \
//	    3   6
//	Output: false
//	Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
//	             is 5 but its right child's value is 4.
//	Accepted
//	320,751
//	Submissions
//	1,294,480

	boolean stopflag = false;
	int ahead = Integer.MIN_VALUE;
	private boolean first = true;
	
	public static boolean isValidBST(TreeNode root) {
    	P98ValidBST a = new P98ValidBST();
		a.fronttravel2(root);
		return !a.stopflag;     
    }
	
	public void fronttravel2(TreeNode root) {

		if (stopflag == true){
			return;
		}
		if (root == null)
			return;
		if  (root.left!=null) {
			fronttravel2(root.left);
		}
		if (stopflag == true){
			return;
		}
		if (first  == true) {
			first = false;
			
		}else {
			if (root.val <= ahead) {
				stopflag = true;
				return;
			}
		}
		
		System.out.println(root.val);			
		ahead = root.val;
		if  (root.right!=null) {
			fronttravel2(root.right);
		}
	}
	
	

    public static void main(String[] args) {
    	//int[] t = new int[] {5,3,8,2,4,6,Integer.MAX_VALUE};
    	//int[] t = new int[] {5,1,4,Integer.MAX_VALUE,Integer.MAX_VALUE,3,6};
    	int[] t = new int[] {Integer.MIN_VALUE};
    	TreeNode root = TreeNode.createBinaryTreeByArray(t, 0);
    	//a.fronttravel(root);
    	System.out.println(P98ValidBST.isValidBST(root));
    }
}
