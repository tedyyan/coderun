package info.runcode.tree.dfs1bfs;

import java.util.TreeSet;

import info.runcode.tree.TreeNode;

public class P104MaximumDepthofBinaryTree {
	// 104. Maximum Depth of Binary Tree
	// Easy
	//
	// 1002
	//
	// 43
	//
	// Favorite
	//
	// Share
	// Given a binary tree, find its maximum depth.
	//
	// The maximum depth is the number of nodes along the longest path from the root
	// node down to the farthest leaf node.
	//
	// Note: A leaf is a node with no children.
	//
	// Example:
	//
	// Given binary tree [3,9,20,null,null,15,7],
	//
	// 3
	// / \
	// 9 20
	// / \
	// 15 7
	// return its depth = 3.

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		
		return dfs(root);

	}
	public int maxDepth_bad(TreeNode root) {
		if (root == null)
			return 0;
		 dfs_bad(root);
		return maxdeep;

	}

	static int maxdeep = 1;
	static int deep = 0;

	private void dfs_bad(TreeNode roots) {
		if (roots == null) {
			return;
		}
		deep++;
		if (deep > maxdeep) {
			maxdeep = deep;
		}
		// all childs
		TreeNode t = roots.left;
		dfs_bad(t);
		t = roots.right;
		dfs_bad(t);
		deep--;
	}

	private int dfs(TreeNode roots) {
		if (roots == null) {
			return 0;
		}
		int left = dfs(roots.left);
		int right = dfs(roots.right);
		return left > right ? left + 1 : right + 1;
	}

	public static void main(String[] args) {
		// int[] t = new int[] {5,3,8,2,4,6,Integer.MAX_VALUE};
		 int[] t = new int[] { 5, 1, 4, 111, Integer.MAX_VALUE, 3, 6, 112,
		 Integer.MAX_VALUE,
		 Integer.MAX_VALUE, Integer.MAX_VALUE, 12, 13,Integer.MAX_VALUE,
		 Integer.MAX_VALUE, 14 };
		//int[] t = new int[] { 1, 2, 3, 4 };

		TreeNode root = TreeNode.createBinaryTreeByArray_good(t, 0);
		// root.fronttravel12(root);
		// System.out.println("-----------------------");
		P104MaximumDepthofBinaryTree a = new P104MaximumDepthofBinaryTree();
		// TreeNode.StartToDfs(root);
		System.out.println(a.maxDepth(root));
		
		// TreeNode.StartToDfs(root);
		System.out.println(a.maxDepth_bad(root));
		// check compareTo and hash method
		// a.visited.add(root);
		// if (a.visited.contains(root)) {
		// System.out.println("----------root-------------");
		// }
		// if (a.visited.contains(root.left)) {
		// System.out.println("----------root.left------1-------");
		// }
		// a.visited.add(root.left);
		// if (a.visited.contains(root.left)) {
		// System.out.println("----------root.left------2-------");
		// }
	}
}
