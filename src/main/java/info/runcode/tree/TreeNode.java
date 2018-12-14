package info.runcode.tree;


 //Definition for a binary tree node.
 public class TreeNode {
	public static long NULL_PLACEHOLDER = Integer.MAX_VALUE;
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
     

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
 	public static TreeNode createBinaryTreeByArray(int []array,int start)
 	{
 		if (array[start] == NULL_PLACEHOLDER) {
 	        return null;
 	    }
 		
 		TreeNode root = new TreeNode(array[start]);

 	    int lnode = 2*start + 1;
 	    int rnode = 2*start + 2;
 	    if ( lnode > array.length -1) {
 	        root.left = null;
 	    }else{
 	        root.left = createBinaryTreeByArray(array, lnode);
 	    }

 	    if (rnode > array.length -1) {
 	        root.right = null;
 	    }else{
 	        root.right = createBinaryTreeByArray(array, rnode);
 	    }
 	
 	   
 		return root;
 	}
 	
 	public void midtravel(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.val);
		if  (root.left!=null) {
			midtravel(root.left);
		}
		if  (root.right!=null) {
			midtravel(root.right);
		}
	}
	
	public void fronttravel12(TreeNode root) {
		if (root == null)
			return;
		if  (root.left!=null) {
			fronttravel12(root.left);
		}
		System.out.println(root.val);
		if  (root.right!=null) {
			fronttravel12(root.right);
		}
	}
 }
 
