package info.runcode.tree.dfs1bfs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import info.runcode.tree.TreeNode;

public class P102BinaryTreeLevelOrder {
//	102. Binary Tree Level Order Traversal
//	Medium
//
//	1064
//
//	28
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
		
		if (root == null) {
			return null;
		}
		TreeNode n = root;
		List<List<Integer>> r = new LinkedList<List<Integer>>();
		//only used to graph
		TreeSet<TreeNode> visited = new TreeSet<TreeNode>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(n);
		while (queue.size()>0) {
			LinkedList<TreeNode> theloop = queue;
			queue = new LinkedList<TreeNode>();
			
			Iterator<TreeNode> it = theloop.iterator();
			List<Integer> level = new LinkedList<Integer>();
			//visit children
			while (it.hasNext()) {
				//only used to graph
				TreeNode element = it.next();
				//if (!visited.contains(n)) {
					level.add(element.val);
					visited.add(element);
				//}
				if (element.left != null)
					queue.add(element.left);
				if (element.right != null)
					queue.add(element.right);
			}			
			r.add(level);
		}
		return r;
        
    }
	
	 public static void main(String[] args) {
	    	//int[] t = new int[] {5,3,8,2,4,6,Integer.MAX_VALUE};
	    	int[] t = new int[] {5,1,4,Integer.MAX_VALUE,Integer.MAX_VALUE,3,6,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,12,13};
	    	//int[] t = new int[] {Integer.MIN_VALUE};
	    	TreeNode root = TreeNode.createBinaryTreeByArray(t, 0);
	    	root.midtravel(root);
	    	//a.fronttravel(root);
	    	P102BinaryTreeLevelOrder test = new P102BinaryTreeLevelOrder();
	    	List<List<Integer>> rr = test.levelOrder(root);
	    	Iterator<List<Integer>> it = rr.iterator();
	    	while(it.hasNext()) {
	    		 List<Integer> et = it.next();
	    		 System.out.println(Arrays.toString(et.toArray()));
	    	}
	    	System.out.println("end");
	 }
}
