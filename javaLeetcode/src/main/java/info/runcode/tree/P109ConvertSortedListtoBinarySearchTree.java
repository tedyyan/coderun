package info.runcode.tree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import info.runcode.linklist.ListNode;

public class P109ConvertSortedListtoBinarySearchTree {
//	109. Convert Sorted List to Binary Search Tree
//	Medium
//
//	820
//
//	61
//
//	Favorite
//
//	Share
//	Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
//
//	For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//	Example:
//
//	Given the sorted linked list: [-10,-3,0,5,9],
//
//	One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//
//	      0
//	     / \
//	   -3   9
//	   /   /
//	 -10  5
	

	 
	public TreeNode sortedListToBST(ListNode head) {
		if(head==null)
			return null;
		if(head.next == null) {
			return new TreeNode(head.val);
		}
		if(head.next.next==null) {
			TreeNode a = new TreeNode(head.next.val);
			TreeNode b = new TreeNode(head.val);
			//b < a
			a.left = b;
			return a;
		}
//		if(head.next.next.next==null) {
//			TreeNode a = new TreeNode(head.next.next.val);
//			TreeNode b = new TreeNode(head.next.val);
//			TreeNode c = new TreeNode(head.val);
//			//c< b < a
//			b.left = a;
//			b.right = c;
//			return b;
//		}
		ListNode fast = head;
		ListNode slow = head;
		ListNode iter = head;
		while((fast!=null)&&(fast.next!=null)) {
			slow = iter;
			iter = iter.next;
			fast = fast.next.next;
		}
		TreeNode c = new TreeNode(iter.val);
		slow.next = null;
		TreeNode right = sortedListToBST(iter.next);
		TreeNode left = sortedListToBST(head);
		c.right =right;
		c.left = left;
		
		return c;
        
    }
	
	public static void main(String[] args) {
		P109ConvertSortedListtoBinarySearchTree  p = new P109ConvertSortedListtoBinarySearchTree();
		int[] head = {-10,-3};  //3,1,2,4,5
		
		ListNode heada = ListNode.BuildAList(head);
		TreeNode res = p.sortedListToBST(heada );
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
