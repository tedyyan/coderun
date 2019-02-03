package info.runcode.bit;

public class P137SingleNumberII {
//	137. Single Number II
//	Medium
//
//	674
//
//	229
//
//	Favorite
//
//	Share
//	Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
//
//	Note:
//
//	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
//	Example 1:
//
//	Input: [2,2,3,2]
//	Output: 3
//	Example 2:
//
//	Input: [0,1,0,1,0,1,99]
//	Output: 99
	
	public int singleNumber(int[] nums) {
		if ((nums==null)||(nums.length==0)) {
			return 0;
		}
			        int a = 0, b = 0;
			        for (int i = 0; i < nums.length; ++i) {
			            b = (b ^ nums[i]) & ~a;
			            a = (a ^ nums[i]) & ~b;
			        }
			        return b;
        
    }
}
