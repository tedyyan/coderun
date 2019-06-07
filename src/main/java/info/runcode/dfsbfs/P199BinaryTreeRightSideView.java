package info.runcode.dfsbfs;

import java.util.ArrayList;
import java.util.List;

import info.runcode.tree.TreeNode;

public class P199BinaryTreeRightSideView {
//	199. Binary Tree Right Side View
//	Medium
//
//	864
//
//	34
//
//	Favorite
//
//	Share
//	Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
//	Example:
//
//	Input: [1,2,3,null,5,null,4]
//	Output: [1, 3, 4]
//	Explanation:
//
//	   1            <---
//	 /   \
//	2     3         <---
//	 \     \
//	  5     4       <---
	public class MyInteger {
		public int val;
		public MyInteger(int _val) {
			this.val = _val;
		}
	}
	
	 public List<Integer> rightSideView(TreeNode root) {
		if(root==null) return new ArrayList<Integer>();
		 
		List<Integer> res = new ArrayList<Integer>();
		dps(root,getHeight(root),1,new MyInteger(0),res );
		return res;
	        
	 }

	private boolean dps(TreeNode root, int totalLayer, int clayer, MyInteger rlayer, List<Integer> res) {
		
		if(clayer>rlayer.val) {
			res.add(root.val);
			rlayer.val++;
		}
		if(rlayer.val==totalLayer) {
			return true;
		}
		if(root.right!=null) {
			if(dps(root.right,totalLayer,clayer+1,rlayer,res) == true) {
				return true;
			}			
		}
		if(root.left!=null) {
			if(dps(root.left,totalLayer,clayer+1,rlayer,res) == true) {
				return true;
			}			
		}
		return false;
		
	}
	
	private int getHeight(TreeNode root) {
		int h  = preorder(root);
		return h;
	}

	private int preorder(TreeNode root) {
		if(root == null) return 0;
		
		int h1 = preorder(root.left) + 1;
		int h2 = preorder(root.right) + 1;
		return h1>h2?h1:h2;
	}
	 
}
