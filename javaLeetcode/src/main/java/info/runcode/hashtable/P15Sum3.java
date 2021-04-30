package info.runcode.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class P15Sum3 {
	// 15. 3Sum
	// Medium
	//
	// 2828
	//
	// 324
	//
	// Favorite
	//
	// Share
	// Given an array nums of n integers, are there elements a, b, c in nums such
	// that a + b + c = 0?
	// Find all unique triplets in the array which gives the sum of zero.
	//
	// Note:
	//
	// The solution set must not contain duplicate triplets.
	//
	// Example:
	//
	// Given array nums = [-1, 0, 1, 2, -1, -4],
	//
	// A solution set is:
	// [
	// [-1, 0, 1],
	// [-1, -1, 2]
	// ]

	public List<List<Integer>> threeSum(int[] nums) {
		LinkedList<List<Integer>> f = new LinkedList<List<Integer>>();
		Set<Integer> b = new HashSet<Integer>();
		HashSet<Integer> s = new HashSet<Integer>();
		for (int i : nums) {
			s.add(i);
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				s.remove(nums[i]);
				s.remove(nums[j]);
				if (s.contains(0 - nums[i] - nums[j])) {
					if (b.contains(nums[i])&&b.contains(nums[j])&&b.contains(0-nums[i]-nums[j])){
						
					}else {
						List<Integer> t = new LinkedList<Integer>(Arrays.asList(nums[i], nums[j], 0 - nums[i] - nums[j]));
						b.add(nums[j]);
						b.add(nums[i]);
						b.add(0-nums[j]-nums[i]);
						f.add(t);
					}
				}
				s.add(nums[i]);
				s.add(nums[j]);
			}
		}
		return f;

	}

	public static void main(String[] args) {
		P15Sum3 p = new P15Sum3();
		int[] a = { -1, 0, 1, 2, -1, -4};
		System.out.println(p.threeSum(a));

	}
}
