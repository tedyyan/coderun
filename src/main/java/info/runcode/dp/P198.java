package info.runcode.dp;

/**
 * 
 * @author yanxuan
 * 198. House Robber
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class P198 {

	 
	 public int rob(int[] nums) {
		 if (nums.length==0)
	            return 0;
		int p0 = 0;
		int p1 = 0;
		for (int i=0;i<nums.length;i++) {			
			int t = p1>p0?p1:p0;
			int prev = 0;
			if (i==0) {
				prev = 0;
			}else {
				prev = nums[i-1];
			}
			if ((p0 + nums[i])>(p1-prev+nums[i])) {
				p1 = p0 + nums[i];
			}else {
				p1 = p1-prev+nums[i];
			}
			p0=t;
			System.out.println("nums["+i+"] "+nums[i]+" p0:"+p0+" p1:"+p1 + " pre:"+prev);
		}
		return p1>p0?p1:p0;
	        
	 }
	 
	
	 
	 public static void main(String[] args) {
		 P198 p = new P198();
		 int[] input = new int[] {2,3,2}; //2,3,1,1,4  3,2,1,0,4 2,7,9,3,1 2,3,2
		 System.out.println(p.rob(input));
		 
	 }
	 
}
