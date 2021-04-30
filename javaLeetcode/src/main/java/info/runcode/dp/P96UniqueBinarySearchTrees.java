package info.runcode.dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P96UniqueBinarySearchTrees {
//	96. Unique Binary Search Trees
//	Medium
//
//	1431
//
//	61
//
//	Favorite
//
//	Share
//	Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
//
//	Example:
//
//	Input: 3
//	Output: 5
//	Explanation:
//	Given n = 3, there are a total of 5 unique BST's:
//
//	   1         3     3      2      1
//	    \       /     /      / \      \
//	     3     2     1      1   3      2
//	    /     /       \                 \
//	   2     1         2                 3
	
	public int numTrees(int n) {
		return dps(n,new HashMap<Integer,Integer>());
        
    }
	
	int dps(int n, Map<Integer,Integer> cache) {
		if (cache.get(n)!=null)
			return cache.get(n);
		if(n==0) {
			return 1;
		}
		if(n==1) {
			return 1;
		}
		int i = 0;
		int s = 0;
		int cnt = n/2;
		while(cnt-i>0) {
			int l = dps(n-i-1,cache);
			int r = dps(i,cache);
			s += l * r;
			i++;
		}
		int ss = s+s;
		if (cnt*2!=n) {
			int one = dps(cnt-1,cache);
			ss += one * one;
		}
		return ss;
	}
	
	public static void main(String[] args) {
			P96UniqueBinarySearchTrees p = new P96UniqueBinarySearchTrees();
		  int n = 4;
		  int result = p.numTrees(n );
		  System.out.println(result);
	  }
}
