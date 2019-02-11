package info.runcode.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class P46Permutations {
//	46. Permutations
//	Medium
//
//	1554
//
//	42
//
//	Favorite
//
//	Share
//	Given a collection of distinct integers, return all possible permutations.
//
//	Example:
//
//	Input: [1,2,3]
//	Output:
//	[
//	  [1,2,3],
//	  [1,3,2],
//	  [2,1,3],
//	  [2,3,1],
//	  [3,1,2],
//	  [3,2,1]
//	]
	public List<List<Integer>> permute(int[] nums) {
		
		List<List<Integer>> rr = new ArrayList<List<Integer>>();
		if ((nums==null)||(nums.length==0)) {
			return rr;
		}
		
		Set<Integer> unused = new TreeSet<Integer>();
		for (int el:nums) {
			unused.add(el);
		}
		dfs(nums, unused , new Stack<Integer>(),rr );
		return rr;
        
    }
	
	void dfs(int[] n, Set<Integer> unused, Stack<Integer> one,List<List<Integer>> result) {
		if (unused.size() == 0) {
			//Integer[] a = one.toArray(new Integer[n.length]);
			result.add((Stack<Integer>) one.clone());
			return;
		}
		Iterator<Integer> it = unused.iterator();
		while(it.hasNext()) {
			Integer value = it.next();
			one.push(value);
			
			Integer[] nextunused = unused.toArray(new Integer[unused.size()]);			
			Set<Integer> b2 = new TreeSet<Integer>(Arrays.asList(nextunused));
			b2.remove(value);
			
			dfs(n,b2,one,result);	
			one.pop();
		}
	}
	
	public static void main(String[] args) {
		P46Permutations p = new P46Permutations();
		int[] nums = {1,2,3,4};
		List<List<Integer>> r = p.permute(nums );
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
