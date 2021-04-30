package info.runcode.binarysearch;

public class P162FindPeakElement {
//	162. Find Peak Element
//	Medium
//
//	708
//
//	1133
//
//	Favorite
//
//	Share
//	A peak element is an element that is greater than its neighbors.
//
//	Given an input array nums, where nums[i] ¡Ù nums[i+1], find a peak element and return its index.
//
//	The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
//
//	You may imagine that nums[-1] = nums[n] = -¡Þ.
//
//	Example 1:
//
//	Input: nums = [1,2,3,1]
//	Output: 2
//	Explanation: 3 is a peak element and your function should return the index number 2.
//	Example 2:
//
//	Input: nums = [1,2,1,3,5,6,4]
//	Output: 1 or 5 
//	Explanation: Your function can return either index number 1 where the peak element is 2, 
//	             or index number 5 where the peak element is 6.
//	Note:
//
//	Your solution should be in logarithmic complexity.
	
	public int findPeakElement(int[] nums) {
		if((nums==null)||(nums.length==0)) return -1;
		if(nums.length==1) return 0;
		if((nums.length==2)||(nums[1]<nums[0])) {
			if(nums[0]>nums[1])
				return 0;
			else {
				return 1;
			}
		}
		int l = 0;
		int r = nums.length-1;
		int m = (l+r)/2;
		
		while(true) {
				if((nums[m-1]>nums[m])) {					
					r = m -1;
					if(l==r) {
						return l;
					}
					m = (l+r)/2;
				}else if((nums[m+1]>nums[m])) {
					l = m + 1;
					if(l==r) {
						return l;
                    }
					m = (l+r)/2;
				}else {
					return m;
				}
                if(l==r-1){
                    if(nums[l]>nums[r]){
                        return l;
                    }else{
                        return r;
                    }
                } 
			
		}
    }
}
