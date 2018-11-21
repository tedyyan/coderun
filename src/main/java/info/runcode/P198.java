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
		 if (nums.length==0)
	            return 0;
		int prepos = 1;
		int prevalue = nums[0];
		for (int i=1;i<nums.length;i++) {			
			if (prepos==0) {
				prevalue = prevalue + nums[i];
				prepos = 1;
			}else {
				if (nums[i]>nums[i-1]) {
					if (i-2>=0) {
						prevalue = prevalue - nums[i-1] + nums[i] + nums[i-2];
					}else {
						prevalue = prevalue - nums[i-1] + nums[i];
					}
					prepos = 1;
				}else {
					prepos = 0;
				}
			}
		}
		return prevalue;
	        
	 }
	 
	 
	 
	 /**
	  * Our first example uses dynamic programming to solve a simple problem in deciding where to cut steel rods. Serling Enterprises buys long steel rods and cuts them
into shorter rods, which it then sells. Each cut is free. The management of Serling
Enterprises wants to know the best way to cut up the rods.
We assume that we know, for i D 1; 2; : : :, the price pi in dollars that Serling
Enterprises charges for a rod of length i inches. Rod lengths are always an integral
number of inches. Figure 15.1 gives a sample price table
	  * @param p
	  * @param n
	  * @return
	  */
	 
	 public int cut_rob_bottom_up(int p[],int n){
		 int[] r=new int[n+1];
		 for (int i=0;i<=n;i++) {
			 r[i] = 0;
		 }
		 for(int j=0;j<n;j++) {
			 int q = Integer.MIN_VALUE;
			 for(int i=0;i<=j;i++) {
				 q = q > (r[j-i] + p[i]) ?  q : (r[j-i] + p[i]) ;
			 }
			 r[j+1] = q;
		 }
		return r[n];
		 
	 }
	 public static void main1(String[] args) {
		 P198 p = new P198();
	    	int[] input = new int[] {1,5,8,9,10,17,17,20,24,30}; //2,3,1,1,4  3,2,1,0,4
	    	for( int i=1;i<11;i++)
	    		System.out.println(i+": "+p.cut_rob_bottom_up(input,i));
	    }
	 
	 public static void main(String[] args) {
		 P198 p = new P198();
		 int[] input = new int[] {1,2,3,1}; //2,3,1,1,4  3,2,1,0,4
		 System.out.println(p.rob(input));
		 
	 }
	 
}
