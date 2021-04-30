package info.runcode.tree;

import java.util.ArrayList;
import java.util.TreeSet;

//Definition for a binary tree node.
public class TreeNode implements java.lang.Comparable {

	TreeSet<TreeNode> visited = new TreeSet<TreeNode>();
	public static long NULL_PLACEHOLDER = Integer.MAX_VALUE;
	public int val;
	public TreeNode left;
	public TreeNode right;
	private int hashcode = 0;

	public TreeNode(int x) {
		val = x;
	}

	public TreeNode() {
		// TODO Auto-generated constructor stub
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

	public void fronttravel12(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.val);
		if (root.left != null) {
			fronttravel12(root.left);
		}
		if (root.right != null) {
			fronttravel12(root.right);
		}
	}
	int layersep = 1;
	public TreeNode reset() {
		 layersep = 1;
		return this;
	}
	public void midtravel(TreeNode root) {
		if (root == null)
			return;
		layersep++;
		if (root.left != null) {
			midtravel(root.left);
		}
		layersep--;
		
		System.out.print(" ");
		for(int i=0;i<layersep;i++) {
			System.out.print("|");;
		}
		
		System.out.print(" "+root.val+" ");
		
		for(int i=0;i<layersep;i++) {
			System.out.print("|");
		}
		System.out.print(" ");

		layersep++;
		if (root.right != null) {
			midtravel(root.right);
		}
		layersep--;
	}
	
	public static void StartToDfs(TreeNode roots) {	
		TreeNode instance = new TreeNode();
		instance.dfs(roots);
	}
	
	private void dfs(TreeNode roots) {	
		
		if (roots==null) {
			return ;
		}
		System.out.println(roots.val);
		visited.add(roots);
		
		//all childs
		TreeNode t = roots.left;
		
		if (t!=null&&!visited.contains(t)) { //
			dfs(t);
		}
		t = roots.right;
		if (t!=null&&!visited.contains(t)) { //
			dfs(t);
		}
	}

	@Override
	public int compareTo(Object o) {

		return this.hashCode() - o.hashCode() ;
	}
	
	@Override
	public int hashCode() {
		if (hashcode == 0)
		{
			hashcode = (int) (this.val * 100000 + (System.currentTimeMillis() % 10000) + Math.random()*10);
		}
		return hashcode;
	}
}
