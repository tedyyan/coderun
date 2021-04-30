package info.runcode.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class P90SubsetsII {
//	90. Subsets II
//	Medium
//
//	739
//
//	40
//
//	Favorite
//
//	Share
//	Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
//
//	Note: The solution set must not contain duplicate subsets.
//
//	Example:
//
//	Input: [1,2,2]
//	Output:
//	[
//	  [2],
//	  [1],
//	  [1,2,2],
//	  [2,2],
//	  [1,2],
//	  []
//	]
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		Stack<List<Integer>> s = new Stack<List<Integer>>();
		List<Integer> e = new ArrayList<Integer>();
		
		List<Integer> e2 = new ArrayList<Integer>();
		e2.add(nums[0]);
		s.add(e);
		s.add(e2);
		
		for(int i=2;i<=nums.length;i++) {
			Stack<List<Integer>> s2 = new Stack<List<Integer>>();
			for(List<Integer> se:s) {
				List<Integer> ne1 = new ArrayList<Integer>(se);
				ne1.add(nums[i-1]);
				if (!s2.isEmpty()) {
					if (!s2.lastElement().equals(ne1)) {
						s2.push(ne1);
					}
				}else {
					s2.push(ne1);
				}
				List<Integer> ne2 = new ArrayList<Integer>(se);		
				if (!s2.firstElement().equals(ne2)) {
					s2.push(ne2);
				}
			}
			s = s2;
		}
		
		return s;
        
    }
	
	public static void main(String[] args) {
		P90SubsetsII p = new P90SubsetsII();
		
		int[] nums = new int[] {1,1};
		List<List<Integer>> r = p.subsetsWithDup(nums   );
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
