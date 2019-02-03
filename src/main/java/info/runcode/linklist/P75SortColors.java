package info.runcode.linklist;

public class P75SortColors {
//	75. Sort Colors
//	Medium
//
//	1316
//
//	132
//
//	Favorite
//
//	Share
//	Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//
//	Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
//	Note: You are not suppose to use the library's sort function for this problem.
//
//	Example:
//
//	Input: [2,0,2,1,1,0]
//	Output: [0,0,1,1,2,2]
//	Follow up:
//
//	A rather straight forward solution is a two-pass algorithm using counting sort.
//	First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
//	Could you come up with a one-pass algorithm using only constant space?
	public void sortColors(int[] nums) {
        int start=0,end=nums.length-1,mid=0;
        while(mid<=end)
        {
        	if (nums[mid]==0) {
        		if (start == mid) {
        			mid++;
        			continue;
        		}
        		swap(nums,start,mid);
        		start++;
        	}else if (nums[mid]==1){
        		mid++;
        	}else if (nums[mid]==2){
        		if (end == mid) {
        			mid++;
        			continue;
        		}
        		swap(nums,end,mid);
        		end--;
        	}
        }
        
    }

	private void swap(int[]nums, int start, int mid) {
		int tmp = nums[start];
		nums[start] = nums[mid] ;
		nums[mid] = tmp;
	}
	
	public static void main(String[] args) {
		P75SortColors p = new P75SortColors();
		int[] nums = {1,2,2,1,1,1,2,0}; //{0,1,2} {2,2,0}
		p.sortColors(nums );
		for(int num:nums)
			System.out.print(num);
	}
}
