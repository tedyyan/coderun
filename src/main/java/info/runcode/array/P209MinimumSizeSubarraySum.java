package info.runcode.array;

import java.util.ArrayList;

public class P209MinimumSizeSubarraySum {
//	209. Minimum Size Subarray Sum
//	Medium
//
//	971
//
//	64
//
//	Favorite
//
//	Share
//	Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ¡Ý s. If there isn't one, return 0 instead.
//
//	Example: 
//
//	Input: s = 7, nums = [2,3,1,2,4,3]
//	Output: 2
//	Explanation: the subarray [4,3] has the minimal length under the problem constraint.
//	Follow up:
//	If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
	
	 public int minSubArrayLenMy(int s, int[] nums) {
	        int shortest = 0;
	        int bottom = 0;
	        ArrayList<Integer> rod = new ArrayList<Integer>();
	        for(int i=0;i<nums.length;i++){
	            if(nums[i]>=s) return 1;
	            if(shortest==0) {
	                bottom = -1;
	            }else{
	                bottom = (rod.size() - 1) - shortest + 1;
	            }
	            
	            
	            
	            for(int j=rod.size()-1; j>bottom ;j--){
	                int tmp = rod.get(j);
	                if (tmp + nums[i] >= s){
	                    if(shortest==0) shortest = (rod.size() - 1) - j + 2;
	                    if (shortest > (rod.size() - 1) - j + 2)
	                        shortest = (rod.size() - 1) - j + 2;
	                    break;
	                }
	            }
	            
	            for(int j=rod.size()-1; j>bottom ;j--){
	                rod.set(j,rod.get(j)+nums[i]);
	            }
	            rod.add(nums[i]);
	        }
	        return shortest;
	    }
	 
	 public int minSubArrayLen(int s, int[] nums) {
		 
		 
		return s;
		 
	 }
	 
	 
}
