package info.runcode.tree.dfs1bfs;

import info.runcode.tree.TreeNode;

public class P111MinimumDepthofBinaryTree {
	
//	111. Minimum Depth of Binary Tree
//	Easy
//
//	565
//
//	279
//
//	Favorite
//
//	Share
//	Given a binary tree, find its minimum depth.
//
//	The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//
//	Note: A leaf is a node with no children.
//
//	Example:
//
//	Given binary tree [3,9,20,null,null,15,7],
//
//	    3
//	   / \
//	  9  20
//	    /  \
//	   15   7
//	return its minimum depth = 2.
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		dfs(root);
		return mindeep;

	}
	static int maxdeep = 1;
	public static int mindeep = Integer.MAX_VALUE;
	static int deep = 0;
	private void dfs(TreeNode roots) {
		
		if (roots == null) {
			return;
		}
		deep++;
		if (deep>maxdeep) {
			maxdeep = deep;
		}
		//System.out.println(roots.val);

		// all childs
		TreeNode t = roots.left;
		

		if ((roots.left==null)&&(roots.right==null)){
			if (deep<mindeep) {
				mindeep = deep;
			}
		}
		
		dfs(t);
		
		t = roots.right;
	
		dfs(t);
		deep--;

	}
	public static void main(String[] args) {
		// int[] t = new int[] {5,3,8,2,4,6,Integer.MAX_VALUE};
		//int[] t = new int[] { 5, 1, 4, 111, Integer.MAX_VALUE, 3, 6, 112, Integer.MAX_VALUE,
		//		Integer.MAX_VALUE, Integer.MAX_VALUE, 12, 13,Integer.MAX_VALUE, Integer.MAX_VALUE, 14 };
		int[] t = new int[] {0};
		
		TreeNode root = TreeNode.createBinaryTreeByArray_good(t, 0);
		//root.fronttravel12(root);
		//System.out.println("-----------------------");
		P111MinimumDepthofBinaryTree a = new P111MinimumDepthofBinaryTree();
		//TreeNode.StartToDfs(root);
		System.out.println(a.minDepth(root));
		
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
