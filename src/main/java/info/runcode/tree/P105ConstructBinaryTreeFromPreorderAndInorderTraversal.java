package info.runcode.tree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
//	105. Construct Binary Tree from Preorder and Inorder Traversal
//	Medium
//
//	1431
//
//	39
//
//	Favorite
//
//	Share
//	Given preorder and inorder traversal of a tree, construct the binary tree.
//
//	Note:
//	You may assume that duplicates do not exist in the tree.
//
//	For example, given
//
//	preorder = [3,9,20,15,7]
//	inorder = [9,3,15,20,7]
//	Return the following binary tree:
//
//	    3
//	   / \
//	  9  20
//	    /  \
//	   15   7

	class MyInteger {
		int me;

		public MyInteger(int value) {
			this.me = value;
		}

		public int intValue() {
			return me;
		}

		public int increaseAndGet() {
			return ++me;
		}
		
		public void Add(int a) {
			this.me += a;
		}
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		MyInteger tmp = new MyInteger(0);
		return build(preorder, inorder, tmp, 0, inorder.length - 1);

	}

	TreeNode build(int[] preorder, int[] inorder, MyInteger prestart, int instart, int inend) {

		if (prestart.intValue() >= preorder.length) {
			return null;
		}
		int ce = preorder[prestart.intValue()];
		TreeNode e = new TreeNode(ce);
		if (instart == inend) {
			e.left = null;
			e.right = null;
			return e;
		}

		int next2instart = 0;
		int next1inend = 0;
		for (int i = instart; i <= inend; i++) {
			if (inorder[i] == ce) {
				next2instart = i + 1;
				next1inend = i - 1;
				break;
			}
		}
		e.left = null;
		e.right = null;
		if (instart <= next1inend) {
			prestart.increaseAndGet();
			TreeNode left = build(preorder, inorder, prestart, instart, next1inend);
			e.left = left;
		}
		if (next2instart <= inend) {
			prestart.increaseAndGet();
			TreeNode right = build(preorder, inorder, prestart, next2instart, inend);
			e.right = right;
		}
		return e;
	}
	
	
	public static void main(String[] args) {
		P105ConstructBinaryTreeFromPreorderAndInorderTraversal  p = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal();
		int[] preorder = {3,1,2,4,5};  //3,1,2,4,5
		int[] inorder = {1,2,3,4,5};  //1,2,3,4,5
		TreeNode res = p.buildTree(preorder, inorder);
		TreeNode.StartToDfs(res);
		
		P102BinaryTreeLevelOrder test = new P102BinaryTreeLevelOrder();
    	List<List<Integer>> rr = test.levelOrder(res);
    	Iterator<List<Integer>> it = rr.iterator();
    	while(it.hasNext()) {
    		 List<Integer> et = it.next();
    		 System.out.println(Arrays.toString(et.toArray()));
    	}
	}
}
