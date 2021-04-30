package info.runcode.dp;

import java.util.ArrayList;
import java.util.List;

public class P300LongestIncreasingSubsequence {
	// 300. Longest Increasing Subsequence
	// Medium
	//
	// 1933
	//
	// 42
	//
	// Favorite
	//
	// Share
	// Given an unsorted array of integers, find the length of longest increasing
	// subsequence.
	//
	// Example:
	//
	// Input: [10,9,2,5,3,7,101,18]
	// Output: 4
	// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the
	// length is 4.
	// Note:
	//
	// There may be more than one LIS combination, it is only necessary for you to
	// return the length.
	// Your algorithm should run in O(n2) complexity.
	// Follow up: Could you improve it to O(n log n) time complexity?

	public int lengthOfLIS(int[] n) {
		if ((n == null) || (n.length == 0)) {
			return 0;
		}
		if (n.length == 1) {
			return 1;
		}
		int[] r = new int[n.length];

		r[0] = 1;
		int max1 = 1;
		for (int i = 1; i < n.length; i++) {
			int tt = n[i];
			int mymax = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (tt > n[j]) {
					if (mymax < r[j]) {
						mymax = r[j];
					}
				}
			}
			r[i] = mymax + 1;
			if (r[i] > max1) {
				max1 = r[i];
			}
		}
		return max1;
	}

	public static void main(String[] args) {
		P300LongestIncreasingSubsequence p = new P300LongestIncreasingSubsequence();
		int[] a = new int[] { 10, -9, 2, 5, 3, 7, 101, 18 ,102,103}; //10, 9, 2, 5, 3, 7, 101, 18
		System.out.println(p.lengthOfLIS(a));

	}
}
