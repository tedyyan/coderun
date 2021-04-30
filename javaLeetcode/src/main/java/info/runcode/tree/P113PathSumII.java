package info.runcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class P113PathSumII {
//	113. Path Sum II
//	Medium
//
//	699
//
//	27
//
//	Favorite
//
//	Share
//	Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
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
//	 /  \    / \
//	7    2  5   1
//	Return:
//
//	[
//	   [5,4,11,2],
//	   [5,8,4,5]
//	]

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> rr = new ArrayList<List<Integer>>();
		Stack<Integer> tmp = new Stack<Integer>();
		int target = sum;
		Recursive(root, 0, target, tmp, rr);
		return rr;

	}

	private void Recursive(TreeNode root, int sum, int target, Stack<Integer> tmp, List<List<Integer>> rr) {
		if (root == null) {
			return;
		}
		sum += root.val;
		
		tmp.push(root.val);
		if ((root.left == null) && (root.right == null)) {
			if (sum == target) {
				Integer[] a = tmp.toArray(new Integer[tmp.size()]);
				ArrayList<Integer> tmpclone = new ArrayList<Integer>(Arrays.asList(a));
				rr.add(tmpclone);
			}
		}

		this.Recursive(root.left, sum, target, tmp, rr);

		this.Recursive(root.right, sum, target, tmp, rr);

		sum -= root.val;
		tmp.pop();

	}

	public static void main(String[] args) {
		P113PathSumII p = new P113PathSumII();
		int[] t = new int[] { 5, 4, 8, 11, Integer.MAX_VALUE, 13, 4, 7, 2, Integer.MAX_VALUE, Integer.MAX_VALUE,
				Integer.MAX_VALUE, Integer.MAX_VALUE, 5, 1 };
		TreeNode root = TreeNode.createBinaryTreeByArray_good(t, 0);
		root.fronttravel12(root);
		int target = 22;
		List<List<Integer>> rr = p.pathSum(root, target);
		for (List<Integer> element : rr) {
			for (Integer ee : element) {
				System.out.print(ee);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
