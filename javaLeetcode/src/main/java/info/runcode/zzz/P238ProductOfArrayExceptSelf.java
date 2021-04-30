package info.runcode.zzz;

public class P238ProductOfArrayExceptSelf {
//	238. Product of Array Except Self
//	Medium
//
//	1802
//
//	140
//
//	Favorite
//
//	Share
//	Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
//	Example:
//
//	Input:  [1,2,3,4]
//	Output: [24,12,8,6]
//	Note: Please solve it without division and in O(n).
//
//	Follow up:
//	Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
	public int[] productExceptSelf(int[] nums) {
		if ((nums == null)||(nums.length==0)){
			return new int[0];
		}
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		left[0] = nums[0];
		for(int i=1;i<=nums.length-2;i++) {
			left[i]=nums[i]*left[i-1];
		}
		
		right[nums.length-2] = nums[nums.length-1];
		for(int i=nums.length-3;i>=0;i--) {
			right[i]=nums[i+1]*right[i+1];
		}
		
		for(int i=0;i<nums.length;i++) {
			if (i==0) {
				nums[i] = right[i];
			}else if(i==nums.length-1) {
				nums[i] = left[i-1];				
			}else {
				nums[i] = left[i-1]*right[i];
			}
		}
		return nums;        
    }
	
	public static void main(String[] args) {
		P238ProductOfArrayExceptSelf p = new P238ProductOfArrayExceptSelf();
		int[] nums = {1,2,3,4};
		int[] r = p.productExceptSelf(nums );
		for (int rr:r) {
			System.out.print(" ");
			System.out.println(rr);
		}
	}
}
