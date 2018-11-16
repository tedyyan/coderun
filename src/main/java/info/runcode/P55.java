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
    			for(int j=0;j < nums[0];j++) {
    				occupied[j+1] = 1;
    			}
    			if (occupied[endlen-1] == 1) {
    				return true;
    			}
    		}
    		i++;
    	}    		
		return false;        
    }
}
