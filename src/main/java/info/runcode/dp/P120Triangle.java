package info.runcode.dp;

import java.util.ArrayList;
import java.util.List;

public class P120Triangle {
//	120. Triangle
//	Medium
//
//	869
//
//	90
//
//	Favorite
//
//	Share
//	Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//
//	For example, given the following triangle
//
//	[
//	     [2],
//	    [3,4],
//	   [6,5,7],
//	  [4,1,8,3]
//	]
//	The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
//
//	Note:
//
//	Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
	public int minimumTotal(List<List<Integer>> triangle) {
		if ((triangle == null) || (triangle.size()==0)){
			return 0;
		}
		int j = 1;
		for(List<Integer> l:triangle) {
			if (l.size()!= j) {
				return 0;
			}
			j++;
		}
		List<Integer> pre = new ArrayList<Integer>();
		pre.add(triangle.get(0).get(0));

		for(int i=1;i<triangle.size();i++) {
			List<Integer> nowNode = triangle.get(i);

			List<Integer> tmppre = new ArrayList<Integer>();
			for(int k=0;k<nowNode.size();k++) {
				int m = 0;
				int tt = 0;
				int ss = 0;
				if (k==0) {
					tt =  pre.get(k);
				}else {
					tt = pre.get(k-1);
				}
				if (k==nowNode.size()-1) {
					tt = pre.get(k-1);
				}else {
					tt = pre.get(k);
				}
				if (ss < tt) {
					m = ss;
				}else {
					m = tt;
				}
				tmppre.add(m);
			}
			pre.clear();
			pre = tmppre;
		}
		int max = pre.get(0);
		for(Integer rn : pre) {
			if (rn>max) {
				max = rn;
			}
		}
		return max;
        
    }
	 public static void main(String[] args) {
		 P120Triangle pt = new P120Triangle();
		 List<List<Integer>> triangle = new ArrayList<List<Integer>>() ;
		 ArrayList<Integer> l00 = new ArrayList<Integer>();
		 l00.add(-1);
		 triangle.add(l00);
		 ArrayList<Integer> l10 = new ArrayList<Integer>();
		 l10.add(2);		
		 l10.add(3);
		 triangle.add(l10);
		 ArrayList<Integer> l20 = new ArrayList<Integer>();
		 l20.add(1);
		 l20.add(-1);
		 l20.add(-3);
		 triangle.add(l20);
		 //---------------------------------
/*
		 ArrayList<Integer> l30 = new ArrayList<Integer>();
		 l30.add(4);
		 l30.add(1);
		 l30.add(8);
		 l30.add(3);
		 triangle.add(l30);
		*/ 
		System.out.println(pt.minimumTotal(triangle ));
	 }
}
