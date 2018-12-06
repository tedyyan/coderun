package info.runcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
//
//Example:
//
//Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
//Output: [3,3,5,5,6,7] 
//Explanation: 
//
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//Note: 
//You may assume k is always valid, 1 ¡Ü k ¡Ü input array's size for non-empty array.
//
//Follow up:
//Could you solve it in linear time?

public class P239 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums==null)
            return new int[]{};
        if (k<=0)
            return new int[]{};
        if (nums.length<k)
			return new int[]{};
		
		int[] result = new int[nums.length - k + 1];
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		for (int i = 0; i < k; i++) {
			q.add(nums[i]);
		}
		result[0] = q.peek();
		
		for (int i = 0; i < nums.length - k; i++) {
			q.remove(nums[i]);
			q.add(nums[i + k]);
			result[i + 1] = q.peek();
		}
		return result;
	}

	public static void main(String[] args) {
		P239 p = new P239();
		int k = 3;
		int[] input = new int[] { 2, 3, -1, 1, 4 }; // 2,3,1,1,4 3,2,1,0,4
		System.out.println(Arrays.toString(p.maxSlidingWindow(input, k)));
	}
}
