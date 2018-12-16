package info.runcode.divideconqur;

import java.util.Arrays;

import info.runcode.dp.P213;

public class P169MajorityElement {
//	169. Majority Element
//	Easy
//
//	1245
//
//	112
//
//	Favorite
//
//	Share
//	Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2  times.
//
//	You may assume that the array is non-empty and the majority element always exist in the array.
//
//	Example 1:
//
//	Input: [3,2,3]
//	Output: 3
//	Example 2:
//
//	Input: [2,2,2,2]
//	Output: 2
	
	public int majorityElement(int[] nums) {
		int[] a = divideConquerME(nums,0,nums.length-1);
		return a[0];
        
    }
	
	public int[] divideConquerME(int[] nums, int s,int e) {
		if (e-s == 0) {
			int[] rr = new int[]{nums[s],1};
			return rr;
		}
		int[] l = divideConquerME(nums,s,(s+e)/2);
		int[] r = divideConquerME(nums,(s+e)/2+1,e);
		if (l[1]>r[1]) {
			if (l[0]==r[0]) {
				int[] rr = new int[]{r[0],r[1]+l[1]};
				return rr ;
			}else {
				return l;
			}
		}else if ((l[1]==r[1])){
			if ((l[0]!=r[0])) {
				int[] rr = new int[]{0,0};
				return rr ;
			}else {
				int[] rr = new int[]{r[0],r[1]+l[1]};
				return rr ;
			}
		}else {
			if (l[0]==r[0]) {
				int[] rr = new int[]{r[0],r[1]+l[1]};
				return rr ;
			}else {
				return r;
			}
		}
	}
	
	public int majorityElement2(int[] nums) {
		 Arrays.sort(nums);
		return nums[nums.length/2];
        
    }
	
	 public static void main(String[] args) {
		 P169MajorityElement p = new P169MajorityElement();
		 int[] input = new int[] {1,3,1,3,1,3}; //2,3,1,1,4  3,2,1,0,4 2,7,9,3,1 2,3,2
		 //System.out.println(p.majorityElement2(input));
		 System.out.println(p.majorityElement(input));
		 //1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 4
	 }
}
