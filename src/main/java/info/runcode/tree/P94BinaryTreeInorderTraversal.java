package info.runcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P94BinaryTreeInorderTraversal {
//	94. Binary Tree Inorder Traversal
//	Medium
//
//	1287
//
//	56
//
//	Favorite
//
//	Share
//	Given a binary tree, return the inorder traversal of its nodes' values.
//
//	Example:
//
//	Input: [1,null,2,3]
//	   1
//	    \
//	     2
//	    /
//	   3
//
//	Output: [1,3,2]
//	Follow up: Recursive solution is trivial, could you do it iteratively?
	
	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> rr = new ArrayList<Integer>();
		this.Recursive(root, rr);
		return rr;

	}
	private void Recursive(TreeNode root, List<Integer> rr) {
		if (root == null) {
			return;
		}
		this.Recursive(root.left, rr);
		rr.add(root.val);
		this.Recursive(root.right, rr);
	}
	private void Iteratively(TreeNode root, List<Integer> rr) {
		if (root == null) {
            return ;
        }
		Stack<TreeNode> stack = new Stack<>();
		TreeNode tempNode = root;
        stack.push(tempNode);
        while (!stack.isEmpty()) {
            while ((tempNode = stack.peek()) != null) {
                tempNode = tempNode.left;
                stack.push(tempNode);
            }
            //
            stack.pop();
            //
            if (!stack.isEmpty()) {
                tempNode = stack.pop();
                rr.add(tempNode.val);
                stack.push(tempNode.right);
            }
        }

	}

	

	public static void main(String[] args) {
		P94BinaryTreeInorderTraversal p = new P94BinaryTreeInorderTraversal();
		int[] t = new int[] { 1, Integer.MAX_VALUE, 2, Integer.MAX_VALUE, Integer.MAX_VALUE, 3, Integer.MAX_VALUE };
		TreeNode root = TreeNode.createBinaryTreeByArray_good(t, 0);
		List<Integer> rr = p.inorderTraversal(root);
		for (Integer el : rr) {
			System.out.println(el);
		}
		
		rr.clear();
		p.Iteratively(root, rr);
		for (Integer el : rr) {
			System.out.println(el);
		}
	}
}
