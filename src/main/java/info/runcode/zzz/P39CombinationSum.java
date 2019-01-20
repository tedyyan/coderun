package info.runcode.zzz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P39CombinationSum {
//	39. Combination Sum
//	Medium
//
//	1556
//
//	43
//
//	Favorite
//
//	Share
//	Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//
//	The same repeated number may be chosen from candidates unlimited number of times.
//
//	Note:
//
//	All numbers (including target) will be positive integers.
//	The solution set must not contain duplicate combinations.
//	Example 1:
//
//	Input: candidates = [2,3,6,7], target = 7,
//	A solution set is:
//	[
//	  [7],
//	  [2,2,3]
//	]
//	Example 2:
//
//	Input: candidates = [2,3,5], target = 8,
//	A solution set is:
//	[
//	  [2,2,2,2],
//	  [2,3,3],
//	  [3,5]
//	]
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> rl =new ArrayList<List<Integer>>();
		if ((candidates==null)||(candidates.length==0)) {
			return rl;
		}
		Arrays.sort(candidates);
		List<Integer> nl=new ArrayList<Integer>();
		int jj = 0;
		this.dfs(candidates, 0, target, rl, nl, jj );
		
		return rl;
        
    }
	
	void dfs(int[] c,int start,int t,List<List<Integer>> rl, List<Integer>nl, int jj) {
		if (t==0) {
			Integer[] a = nl.toArray(new Integer[nl.size()]);
			List<Integer> nl2=Arrays.asList(a);		
			rl.add(nl2);
			return;
		}
		for(int i=start;i<c.length;i++) {
			if (t-c[i]<0) {
				return;
			}else {
				nl.add(c[i]);
				//if(jj==0) {
					dfs(c,i,t-c[i],rl,nl,jj+1);
					nl.remove(new Integer(c[i]));
//				}else {
//					dfs(c,start,t-c[i],rl,nl,jj+1);
//					nl.remove(new Integer(c[i]));
//				}
			}
		}		
	}
	public static void main(String[] args) {
		P39CombinationSum p = new P39CombinationSum();
		int[] candidates = new int[]{2,3,5}; //2,3,5 2,3,6,7
		int target = 0; //8 7
		List<List<Integer>> r = p.combinationSum(candidates, target);
		for (List<Integer> element:r) {
			for(Integer ee : element) {
				System.out.print(ee);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
