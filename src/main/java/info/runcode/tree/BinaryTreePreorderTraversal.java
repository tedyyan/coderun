package info.runcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
//	144. Binary Tree Preorder Traversal
//	Medium
//
//	648
//
//	35
//
//	Favorite
//
//	Share
//	Given a binary tree, return the preorder traversal of its nodes' values.
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
//	Output: [1,2,3]
//	Follow up: Recursive solution is trivial, could you do it iteratively?
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dps(root,res);
        return res;
    }
	
	void iter(TreeNode a,List<Integer> res){
		if(a==null) return ;
        Stack<TreeNode> b = new Stack<TreeNode>();
        b.add(a);
        
        while(!b.isEmpty()) {
        	a = b.pop();
        	if(a==null)
        		continue;
        	res.add(a.val);
            TreeNode le = a.left;
            b.push(a.right);
            while(le != null) {
            	res.add(le.val);
            	b.push(le.right);
                le = le.left;
            }
        }
    }
	
    void dps(TreeNode a,List<Integer> res){
        if(a==null) return ;
        //if((a.left==null)&&(a.right==null)) return;
        res.add(a.val);
        dps(a.left,res);
        dps(a.right,res);
    }
    
    
    
    public static void main(String[] args) {
    	int[] t = new int[] {1,2,3,4,5,6};
    	//int[] t = new int[] {5,1,4,Integer.MAX_VALUE,Integer.MAX_VALUE,3,6,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,12,13};
    	//int[] t = new int[] {Integer.MIN_VALUE};
    	TreeNode root = TreeNode.createBinaryTreeByArray(t, 0);
    	root.reset().midtravel(root);
    	BinaryTreePreorderTraversal p = new BinaryTreePreorderTraversal();
    	List<Integer> a = p.preorderTraversal(root);
    	System.out.println();
    	System.out.println("-------------------");
    	for(Integer aa:a)
    		System.out.println(aa);
    }
}
