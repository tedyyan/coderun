package info.runcode.dfsbfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P78Subsets {
//	78. Subsets
//	Medium
//
//	1569
//
//	40
//
//	Favorite
//
//	Share
//	Given a set of distinct integers, nums, return all possible subsets (the power set).
//
//	Note: The solution set must not contain duplicate subsets.
//
//	Example:
//
//	Input: nums = [1,2,3]
//	Output:
//	[
//	  [3],
//	  [1],
//	  [2],
//	  [1,2,3],
//	  [1,3],
//	  [2,3],
//	  [1,2],
//	  []
//	]
	
	public List<List<Integer>> subsets(int[] nums) {
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
				List<Integer> ne2 = new ArrayList<Integer>(se);
				
				s2.push(ne1);
				s2.push(ne2);
			}
			s = s2;
		}
		
		return s;
        
    }
	public static void main(String[] args) {
		P78Subsets p = new P78Subsets();
		
		int[] nums = new int[] {1,2,3};
		List<List<Integer>> r = p.subsets(nums   );
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
//	List<List<Integer>> dps(boolean[] visit,int start) {
//		if (start==1) {
//			return new int[][]{{0},{1}};
//		}
//		List<List<Integer>> preresult = dps(null,start-1);
//		List<List<Integer>> genresult = new ArrayList<List<Integer>>();
//		for(List<Integer> e:preresult) {
//			b = 
//			e.add(0);
//			genresult
//		}
//		for(List<Integer> e:preresult) {
//			e.add(1);
//		}
//	}
	
	
}
