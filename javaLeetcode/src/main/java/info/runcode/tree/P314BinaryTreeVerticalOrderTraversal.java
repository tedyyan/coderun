package info.runcode.tree;

import java.util.LinkedList;
import java.util.List;

public class P314BinaryTreeVerticalOrderTraversal {
/*
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples 1:

Input: [3,9,20,null,null,15,7]

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7 

Output:

[
  [9],
  [3,15],
  [20],
  [7]
]
 */
	 public List<List<Integer>> verticalOrder(TreeNode root) {
	        
	        LinkedList<List<Integer>> re  = new LinkedList<List<Integer>>();
	        LinkedList<List<TreeNode>> result  = new LinkedList<List<TreeNode>>();
	        if(root==null) return re;
	        LinkedList<TreeNode> ell = new LinkedList<TreeNode>();
	        ell.addFirst(root);
	        result.add(ell);
	        recursion(root,ell,result);
	        for(List<TreeNode> abc: result){
	            //System.out.println(abc);
	            LinkedList<Integer> element = new LinkedList<Integer>();
	            for(TreeNode e:abc){
	                element.add(e.val);
	            }
	            re.add(element);
	        }
	        return re;
	    }
	    
	    void recursion(TreeNode root, List<TreeNode> carrier,LinkedList<List<TreeNode>> result){
	        if(root==null) return;
	        int midpoint = result.indexOf(carrier);
	        List<TreeNode> left = null;
	        if(root.left!=null)
	        {            
	            if(midpoint==0){
	                left = new LinkedList<TreeNode>();
	                result.addFirst(left);
	            }else{
	                left = result.get(midpoint-1);
	            }
	            left.add(root.left);
	        }
	        midpoint = result.indexOf(carrier);
	        List<TreeNode> right = null;
	        if(root.right!=null)
	        {            
	            if(midpoint==result.size()-1){
	                right = new LinkedList<TreeNode>();
	                result.addLast(right);
	            }else{
	                right = result.get(midpoint+1);
	            }
	            right.add(root.right);
	        }
	        recursion(root.left,left,result);
	        recursion(root.right,right,result);
	        
	    }
}
