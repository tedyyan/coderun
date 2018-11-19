package info.runcode;

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
		return 0;
	        
	 }
	 
	 /**
	  * 
	  * @param p
	  * @param n
	  * @return
	  */
	 
	 public int cut_rob_bottom_up(int p[],int n){
		 int[] r=new int[n];
		 for (int i=0;i<n;i++) {
			 r[i] = 0;
		 }
		 for(int j=0;j<n;j++) {
			 int q = Integer.MIN_VALUE;
			 for(int i=0;i<=j;i++) {
				 q = p[j] > (r[i] + p[j-i]) ?  p[j] : (r[i] + p[j-i]) ;
			 }
			 r[j] = q;
		 }
		return r[n-1];
		 
	 }
	 
}
