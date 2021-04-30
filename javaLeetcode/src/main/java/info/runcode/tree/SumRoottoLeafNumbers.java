package info.runcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import info.runcode.tree.P105ConstructBinaryTreeFromPreorderAndInorderTraversal.MyInteger;

public class SumRoottoLeafNumbers {
//	129. Sum Root to Leaf Numbers
//	Medium
//
//	561
//
//	22
//
//	Favorite
//
//	Share
//	Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//
//	An example is the root-to-leaf path 1->2->3 which represents the number 123.
//
//	Find the total sum of all root-to-leaf numbers.
//
//	Note: A leaf is a node with no children.
//
//	Example:
//
//	Input: [1,2,3]
//	    1
//	   / \
//	  2   3
//	Output: 25
//	Explanation:
//	The root-to-leaf path 1->2 represents the number 12.
//	The root-to-leaf path 1->3 represents the number 13.
//	Therefore, sum = 12 + 13 = 25.
//	Example 2:
//
//	Input: [4,9,0,5,1]
//	    4
//	   / \
//	  9   0
//	 / \
//	5   1
//	Output: 1026
//	Explanation:
//	The root-to-leaf path 4->9->5 represents the number 495.
//	The root-to-leaf path 4->9->1 represents the number 491.
//	The root-to-leaf path 4->0 represents the number 40.
//	Therefore, sum = 495 + 491 + 40 = 1026.
	
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
	
	public int sumNumbersHard(TreeNode root) {
		MyInteger total = new MyInteger(0);
		Deque<TreeNode> path=new LinkedList<TreeNode>();

        preorder(root,path,total);
        
		return total.me;
    }
    void preorder(TreeNode root, Deque<TreeNode> path, MyInteger total){
       if(root==null) return;
      
        if((root.left==null)&&(root.right==null)){
            total.Add(root.val);
            int size = path.size();
            int i=10;
            while(size>0){
            	TreeNode a = path.pop();
            	 total.Add(a.val*i);
            	 path.offer(a);
            	 size--;
            	 i*=10;
            }
        }
        
        path.push(root);
        preorder(root.left,path,total);
        preorder(root.right,path,total);
        path.pop();
    }
    public static void main(String[] args) {
    	int[] t = new int[] {1,2,3,4,5};
    	//int[] t = new int[] {5,1,4,Integer.MAX_VALUE,Integer.MAX_VALUE,3,6,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,12,13};
    	//int[] t = new int[] {Integer.MIN_VALUE};
    	TreeNode root = TreeNode.createBinaryTreeByArray(t, 0);
    	root.reset().midtravel(root);
    	SumRoottoLeafNumbers p = new SumRoottoLeafNumbers();
    	System.out.println("");
    	System.out.println(p.sumNumbers(root));
    }
    public int sumNumbers(TreeNode root) {
    	return sum(root,0);
    }
	private int sum(TreeNode root, int i) {
		if(root==null) return 0;
		if((root.left==null)&&(root.right==null)){
			return 10 * i + root.val;
		}
		return sum(root.left, root.val+ 10*i) + sum(root.right, root.val + 10*i);
	}
}
