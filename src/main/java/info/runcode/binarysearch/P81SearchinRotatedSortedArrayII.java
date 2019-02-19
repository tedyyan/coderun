package info.runcode.binarysearch;

import java.util.Arrays;

public class P81SearchinRotatedSortedArrayII {
//	81. Search in Rotated Sorted Array II
//	Medium
//
//	530
//
//	256
//
//	Favorite
//
//	Share
//	Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//	(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
//
//	You are given a target value to search. If found in the array return true, otherwise return false.
//
//	Example 1:
//
//	Input: nums = [2,5,6,0,0,1,2], target = 0
//	Output: true
//	Example 2:
//
//	Input: nums = [2,5,6,0,0,1,2], target = 3
//	Output: false
//	Follow up:
//
//	This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
//	Would this affect the run-time complexity? How and why?
	
	 public boolean search(int[] a, int target) {
	        if(a == null || a.length == 0) return false;
	        int index = 0;
	        for(int i=0;i<a.length - 1;i++) {
	            if(a[i+1]<a[i]) {
	                index = i+1;
	                break;
	            }
	        }        
	        int left = Arrays.binarySearch(a,0,index,target);
	        int right = Arrays.binarySearch(a,index,a.length,target);        
	        return left>=0 || right>=0;
	    }
}
