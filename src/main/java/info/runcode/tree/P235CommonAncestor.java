package info.runcode.tree;

import java.util.LinkedList;

public class P235CommonAncestor {
	// 235. Lowest Common Ancestor of a Binary Search Tree
	// Easy
	// 771
	// 69
	// Favorite
	// Share
	// Given a binary search tree (BST), find the lowest common ancestor (LCA) of
	// two given nodes in the BST.
	//
	// According to the definition of LCA on Wikipedia: ¡°The lowest common ancestor
	// is defined between two nodes p and q as the lowest node in T that has both p
	// and q as descendants (where we allow a node to be a descendant of itself).¡±
	//
	// Given binary search tree: root = [6,2,8,0,4,7,9,null,null,3,5]
	//
	// _______6______
	// / \
	// ___2__ ___8__
	// / \ / \
	// 0 _4 7 9
	// / \
	// 3 5
	// Example 1:
	//
	// Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
	// Output: 6
	// Explanation: The LCA of nodes 2 and 8 is 6.
	// Example 2:
	//
	// Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
	// Output: 2
	// Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant
	// of itself
	// according to the LCA definition.
	// Note:
	//
	// All of the nodes' values will be unique.
	// p and q are different and both values will exist in the BST.

	LinkedList<Integer> ll = new LinkedList<Integer>();
	LinkedList<Integer> pl = new LinkedList<Integer>();
	LinkedList<Integer> ql = new LinkedList<Integer>();
	static boolean stopFlag = false;

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		int[] t = new int[] { Integer.MIN_VALUE };

		root.fronttravel12(root);

		return q;

	}

	public void fronttravel12(TreeNode root, TreeNode p, TreeNode q) {
		if (stopFlag) {
			return;
		}
		if (root.equals(p)) {
			pl = (LinkedList<Integer>) ll.clone();
		}
		if (root.equals(q)) {
			ql = (LinkedList<Integer>) ll.clone();
		}
		if (root == null)
			return;
		if (root.left != null) {
			fronttravel12(root.left, p, q);
		}
		if (stopFlag) {
			return;
		}
		System.out.println(root.val);
		ll.add(root.val);

		if (root.right != null) {
			fronttravel12(root.right, p, q);
		}
	}

	public static void main(String[] args) {
		// int[] t = new int[] {5,3,8,2,4,6,Integer.MAX_VALUE};
		// int[] t = new int[] {5,1,4,Integer.MAX_VALUE,Integer.MAX_VALUE,3,6};
		int[] t = new int[] { Integer.MIN_VALUE };
		TreeNode root = TreeNode.createBinaryTreeByArray(t, 0);
		TreeNode p = root.left;
		TreeNode q = root.right;
		// a.fronttravel(root);
		System.out.println(lowestCommonAncestor(root, p, q));
	}
}
