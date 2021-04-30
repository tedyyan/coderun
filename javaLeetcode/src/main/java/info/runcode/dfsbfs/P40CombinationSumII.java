package info.runcode.dfsbfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P40CombinationSumII {
//	40. Combination Sum II
//	Medium
//
//	686
//
//	37
//
//	Favorite
//
//	Share
//	Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//
//	Each number in candidates may only be used once in the combination.
//
//	Note:
//
//	All numbers (including target) will be positive integers.
//	The solution set must not contain duplicate combinations.
//	Example 1:
//
//	Input: candidates = [10,1,2,7,6,1,5], target = 8,
//	A solution set is:
//	[
//	  [1, 7],
//	  [1, 2, 5],
//	  [2, 6],
//	  [1, 1, 6]
//	]
//	Example 2:
//
//	Input: candidates = [2,5,2,1,2], target = 5,
//	A solution set is:
//	[
//	  [1,2,2],
//	  [5]
//	]
	 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		 List<Integer> input = new ArrayList<Integer>();
		 for(int a:candidates) {
			 input.add(a);
		 }
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 input.sort(null);
		 dps(input,0,new Stack<Integer>(),result,target);
		 return result;	        
	 }
	 
	 void dps(List<Integer> input, int start, Stack<Integer> one, List<List<Integer>> result, int total) {
		 if(total == 0) {
			 result.add(one);
			 return;
		 }
		 Integer pre = null;
		 for(int i=start;i<input.size();i++) {
			 Integer e = input.get(i);
			 if ((pre!=null)&&(pre.intValue()==e.intValue())) {
				 continue;
			 }
			 pre = new Integer(e);
			 if(total-e<0)
			 {
				 break;
			 }
			 one.push(e);			 
			 Stack<Integer> oneclone = (Stack<Integer>) one.clone();
			 dps(input,i+1,oneclone ,result,total-e);
			 one.pop();
		 }
	 }
	 
	 public static void main(String[] args) {
		 	P40CombinationSumII p = new P40CombinationSumII();
			int[] candidates = new int[]{2,5,2,1,2}; //2,5,2,1,2 10,1,2,7,6,1,5
			int target = 5; //8 5
			List<List<Integer>> r = p.combinationSum2(candidates, target);
			for (List<Integer> element:r) {
				for(Integer ee : element) {
					System.out.print(ee);
					System.out.print(" ");
				}
				System.out.println();
			}
		}
}
