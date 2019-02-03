package info.runcode.bit;

public class P136SingleNumber {
//	136. Single Number
//	Easy
//
//	2007
//
//	80
//
//	Favorite
//
//	Share
//	Given a non-empty array of integers, every element appears twice except for one. Find that single one.
//
//	Note:
//
//	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
//	Example 1:
//
//	Input: [2,2,1]
//	Output: 1
//	Example 2:
//
//	Input: [4,1,2,1,2]
//	Output: 4
	
	public int singleNumber(int[] nums) {
		if ((nums==null)||(nums.length==0)) {
			return 0;
		}
		int k = nums[0];
		for (int i = 1;i<nums.length;i++) {			
			k = k ^ nums[i];
		}
		return k;        
    }
	
	public static void main(String[] args) {
		P136SingleNumber p = new P136SingleNumber();
		int[] nums = new int[] {1,2,1,2,5};
		int a = p.singleNumber(nums );
		System.out.println(a);
	}
}
