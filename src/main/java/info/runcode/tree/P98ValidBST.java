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
	
	public boolean isValidBST(TreeNode root) {
		
		return false;        
    }
	
	public void midtravel(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.val);
		if  (root.left!=null) {
			midtravel(root.left);
		}
		if  (root.right!=null) {
			midtravel(root.right);
		}
	}
	
	public void fronttravel(TreeNode root) {
		if (root == null)
			return;
		if  (root.left!=null) {
			fronttravel(root.left);
		}
		System.out.println(root.val);
		if  (root.right!=null) {
			fronttravel(root.right);
		}
	}

    public static void main(String[] args) {
    	P98ValidBST a = new P98ValidBST();
    	int[] t = new int[] {5,3,8,2,4,6,Integer.MAX_VALUE};
    	TreeNode tree = TreeNode.createBinaryTreeByArray(t, 0);
    	a.fronttravel(tree);
    	
    }
//	public TreeNode buildMidTree(int[] input) {
//		TreeNode l = null;
//		TreeNode m = null;
//		TreeNode r = null;
//		for(int i=0;i<input.length;i++) {
//			TreeNode t = new TreeNode(input[i]);
//			if (l != null) {
//				t.left = l;
//			}
//			if (r != null) {
//				t.right = r;
//			}
//			l = t;
//			
//		}
//		return null;
//	}
	
	
}
