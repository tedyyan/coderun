package info.runcode.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class P47PermutationsII {
//	47. Permutations II
//	Medium
//
//	810
//
//	40
//
//	Favorite
//
//	Share
//	Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//	Example:
//
//	Input: [1,1,2]
//	Output:
//	[
//	  [1,1,2],
//	  [1,2,1],
//	  [2,1,1]
//	]
	public List<List<Integer>> permuteUnique(int[] nums) {
		
		List<List<Integer>> rr = new ArrayList<List<Integer>>();
		if ((nums==null)||(nums.length==0)) {
			return rr;
		}
		
		List<Integer> unused = new ArrayList<Integer>();
		for (int el:nums) {
			unused.add(el);
		}
		unused.sort(null);
		dfs(nums, unused , new Stack<Integer>(),rr );
		return rr;
        
    }
	
	void dfs(int[] n, List<Integer> unused, Stack<Integer> one,List<List<Integer>> result) {
		if (unused.size() == 0) {
			//Integer[] a = one.toArray(new Integer[n.length]);
			result.add(one);
			
			return;
		}
		Iterator<Integer> it = unused.iterator();
		Integer pre = null;
		while(it.hasNext()) {
			
			Integer value = it.next();
			if ((pre!=null)&&(pre==value)) {
				continue;
			}
			pre = value;
			one.push(value);
			Stack<Integer> b = (Stack<Integer>) one.clone();
			
			Integer[] nextunused = unused.toArray(new Integer[unused.size()]);			
			List<Integer> b2 = new ArrayList<Integer>(Arrays.asList(nextunused));
			b2.remove(value);
			
			dfs(n,b2,b,result);	
			one.pop();
		}
	}
	public static void main(String[] args) {
		P47PermutationsII p = new P47PermutationsII();
		int[] nums = {1,1,2,2};
		List<List<Integer>> r = p.permuteUnique(nums );
		int i = 0;
		for (List<Integer> element:r) {
			for(Integer ee : element) {
				System.out.print(ee);
				System.out.print(" ");
			}
			System.out.println();
			i++;
		}
		System.out.println(i);
	}
}
