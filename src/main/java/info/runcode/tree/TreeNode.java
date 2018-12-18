package info.runcode.tree;

import java.util.ArrayList;

//Definition for a binary tree node.
public class TreeNode implements java.lang.Comparable {
	public static long NULL_PLACEHOLDER = Integer.MAX_VALUE;
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	public String toString() {
		return String.valueOf(val);

	}

	/**
	 * 
	 * 
	 * 
	 * @param array
	 * @param index
	 * @return
	 */
	public static TreeNode createBinaryTreeByArray_good(int[] array, int start) {
		if (array[start] == NULL_PLACEHOLDER) {
			return null;
		}

		TreeNode root = new TreeNode(array[start]);

		int lnode = 2 * start + 1;
		int rnode = 2 * start + 2;
		if (lnode > array.length - 1) {
			root.left = null;
		} else {
			root.left = createBinaryTreeByArray_good(array, lnode);
		}

		if (rnode > array.length - 1) {
			root.right = null;
		} else {
			root.right = createBinaryTreeByArray_good(array, rnode);
		}

		return root;
	}

	public static TreeNode createBinaryTreeByArray(int[] array, int start) {

		int before = 1;
		int beforelevel = 1;
		TreeNode root = new TreeNode(array[0]);
		ArrayList<TreeNode> ln = new ArrayList<TreeNode>();
		ln.add(root);
		int  index = 0;
		ArrayList<TreeNode> lnready = new ArrayList<TreeNode>();
		while (before < array.length) {
			for (int i = 0 ; i< (1<<beforelevel); i++) {
				index = before + i;
				if (index > array.length - 1) {
					break;
				}

				TreeNode node = null;
				int a = array[index];

				if (a != Integer.MAX_VALUE) {
					node = new TreeNode(a);
					int p = (i >> 1) ;
					int left = i & 0x01;
					if (left == 0)
						ln.get(p).left = node;
					else
						ln.get(p).right = node;
				}

				lnready.add(node);
			}
			ln = (ArrayList<TreeNode>) lnready.clone();
			lnready.clear();
			before += (1<<beforelevel);
			beforelevel++;
		}

		return root;
	}

	public void midtravel(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.val);
		if (root.left != null) {
			midtravel(root.left);
		}
		if (root.right != null) {
			midtravel(root.right);
		}
	}

	public void fronttravel12(TreeNode root) {
		if (root == null)
			return;
		if (root.left != null) {
			fronttravel12(root.left);
		}
		System.out.println(root.val);
		if (root.right != null) {
			fronttravel12(root.right);
		}
	}

	@Override
	public int compareTo(Object o) {

		return this.hashCode() > o.hashCode() ? 1 : 0;
	}
}
