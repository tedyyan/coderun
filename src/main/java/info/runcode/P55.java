package info.runcode;

import java.util.Arrays;

/**
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
**/

class P55 {
	 public boolean canJump(int[] nums) {
		 int ff = 0;

	    	if (nums.length==0)
	    		return false;
	    	if (nums.length ==1) {
	    		return true;
	    	}
		 for(int i=0;i<nums.length;i++) {
			 if (nums[i]>0)
			 {
				 ff = ff > (i + nums[i])? ff : (i + nums[i]);
			 }else {
				 if (ff<=i)
					 return false;
			 }
			 if (ff>=nums.length-1) {
				 return true;
			 }
			 
		 }
		return false;
		 
	 }
    public boolean canJump1(int[] nums) {
    	if (nums.length==0)
    		return false;
    	if (nums.length ==1) {
    		return true;
    	}
    	
    	int[] occupied = new int[nums.length];

    	for (int i=0;i < nums.length;i++) {
    		occupied[i] = 0;
    	}
    	
    	int endlen = nums.length;
    	for(int j=0;j < nums[0];j++) {
			occupied[j+1] = 1;
		}
    	int i = 1;
    	while(i<endlen-1) 
    	{
    		if (occupied[i] == 1)
    		{
    			for(int j=0;j < nums[i];j++) {
    				if ((i+j+1)<endlen) {
    					occupied[+ j + 1] = 1;
    				}
    			}
    		}
			if (occupied[endlen-1] == 1) {
				return true;
			}
    		i++;
    	}    		
		return false;        
    }
    public static void main(String[] args) {
    	P55 p = new P55();
    	int[] input = new int[] {2,3,1,1,4}; //2,3,1,1,4  3,2,1,0,4
    	System.out.println(p.canJump(input));
    }
}
