package info.runcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class P349 {
//	349. Intersection of Two Arrays
//	Easy
//	310
//	639
//
//
//	Given two arrays, write a function to compute their intersection.
//
//	Example 1:
//
//	Input: nums1 = [1,2,2,1], nums2 = [2,2]
//	Output: [2]
//	Example 2:
//
//	Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//	Output: [9,4]
//	Note:
//
//	Each element in the result must be unique.
//	The result can be in any order.
	public static int[] toPrimitive(Integer[] IntegerArray) {

		int[] result = new int[IntegerArray.length];
		for (int i = 0; i < IntegerArray.length; i++) {
			result[i] = IntegerArray[i].intValue();
		}
		return result;
	}
	
	    public int[] intersection(int[] nums1, int[] nums2) {
	    	if ((nums1==null)||(nums2==null)||(nums1.length==0)||(nums1.length==0)){
	    		int[] tmp = new int[] {};
	    		return tmp;
	    	}
	    	Integer[] tmp = new Integer[] {};
	    	HashSet<Integer> al = new HashSet<Integer>();
	        HashSet<Integer> hs = new HashSet<Integer>();
	        for(int i=0;i<nums1.length;i++) {
	        	hs.add(nums1[i]);
	        }
	        for(int i=0;i<nums2.length;i++) {
	        	if (true == hs.contains(nums2[i])) {
	        		al.add(nums2[i]);
	        	}
	        }
	        
	        
			return toPrimitive(al.toArray(tmp));
	        
	    }
	    
		 public static void main(String[] args) {
			 P349 p = new P349();
			 int[] input = new int[] {1,2,2,3,1,10}; //2,3,1,1,4  3,2,1,0,4 2,7,9,3,1 2,3,2
			 int[] input2 = new int[] {11,2,3,2,0}; 
			 System.out.println(Arrays.toString(p.intersection(input,input2)));
			 
		 }
}
