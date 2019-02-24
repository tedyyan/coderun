package info.runcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P102BinaryTreeLevelOrderTraversal {
//	102. Binary Tree Level Order Traversal
//	Medium
//
//	1198
//
//	31
//
//	Favorite
//
//	Share
//	Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
//	For example:
//	Given binary tree [3,9,20,null,null,15,7],
//	    3
//	   / \
//	  9  20
//	    /  \
//	   15   7
//	return its level order traversal as:
//	[
//	  [3],
//	  [9,20],
//	  [15,7]
//	]
	
	 public List<List<Integer>> levelOrder(TreeNode root) {
		 
		 ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		 if (root == null) return result;
		 
		 Queue<TreeNode> nl = new LinkedList<TreeNode>();
		 nl.offer(root);
		 
		 Queue<TreeNode> cl = new LinkedList<TreeNode>();
		 ArrayList<Integer> eleres = null;
		 while(!nl.isEmpty()) {
			 cl = nl;
			 nl = new LinkedList<TreeNode>();
			 while (!cl.isEmpty()) {
				 eleres = new ArrayList<Integer>();
				 TreeNode a = nl.poll();
				 eleres.add(a.val);
				 if (a.left!=null)
					 nl.add(a.left);
				 if (a.right!=null)
					 nl.add(a.right);
			 }
			 result.add(eleres);
		 }
		 
		return result;
	        
	 }
}
