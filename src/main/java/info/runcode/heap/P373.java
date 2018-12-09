package info.runcode.heap;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P373 {
//	373. Find K Pairs with Smallest Sums
//	Medium
//	499
//	35
//
//
//	You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
//
//	Define a pair (u,v) which consists of one element from the first array and one element from the second array.
//
//	Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
//
//	Example 1:
//
//	Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//	Output: [[1,2],[1,4],[1,6]] 
//	Explanation: The first 3 pairs are returned from the sequence: 
//	             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
//	Example 2:
//
//	Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//	Output: [1,1],[1,1]
//	Explanation: The first 2 pairs are returned from the sequence: 
//	             [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
//	Example 3:
//
//	Input: nums1 = [1,2], nums2 = [3], k = 3
//	Output: [1,3],[2,3]
//	Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
	
	public List<int[]> kSmallestPairs_bad(int[] nums1, int[] nums2, int k) {
        List<int[]> r = new ArrayList<int[]>();
    	if (nums1==null||nums2==null||nums1.length==0||nums2.length==0||k==0) {
    		return r;
    	}
    	
    	if ((nums1.length*nums2.length) < k ) 
    		k = (nums1.length*nums2.length);

    	int i1=0;
    	int i2=0;
    	int maxi1 = 0;
    	int maxi2 = 0;
    	for (int i=0;i<k;) {
    		int[] rt = new int[] {nums1[i1],nums2[i2]};
    		r.add(rt);
    		i++;
    		int c1= i1 + 1;
    		int c2= i2 + 1;
    		
    		if (( c1 < nums1.length) && ( c2 < nums2.length)) {    			
	    		if (nums1[c1] + nums2[i2]  > nums2[c2] + nums1[i1]) {
	    			i2 = c2;
	    		}else if (nums1[c1] + nums2[i2] < nums2[c2] + nums1[i1]) {
	    			i1 = c1;
	    		}else {
	    			i2 = c2;	
	    			rt = new int[] {nums1[i1+1],nums2[i2-1]};		
	    			r.add(rt);
	    			i++;
	    		}
            }else if( c1 >= nums1.length) {
            	i2++;
            	
            }else if( c2 >= nums2.length) {
            	i1++;
            	
            }
    		
    		if ((i2>maxi2)&&(i2<nums2.length)) {
        		i1 = 0;
        		maxi2 = i2;
        	}
    		if ((i1>maxi1)&&(i1<nums1.length)) {
        		i2 = 0;
        		maxi1 = i1;
        	}
    		
    		if (i1 >= nums1.length) {
    			i1=0;
    			i2++;
    			if (i2 >= nums2.length) {
        			return r;
        		}
    		}
    		if (i2 >= nums2.length) {
    			i2=0;
    			i1++;
    			if (i1 >= nums1.length) {
        			return r;
        		}
    		}
    		if ((i2>maxi2)&&(i2<nums2.length)) {
    			maxi2 = i2;
    		}
    		if ((i1>maxi1)&&(i1<nums1.length)) {
    			maxi1 = i1;
    		}
    	}
		return r;
    }
	
	public List<int[]> kSmallestPairs(int[] nl, int[] nr, int k) {
		 List<int[]> rr = new ArrayList<int[]>();
    	if (nl==null||nr==null||nl.length==0||nr.length==0||k==0) {
    		return rr;
    	}
    	
    	if ((nl.length*nr.length) < k ) 
    		k = (nl.length*nr.length);

		int l1 = 0,l=0;
		int r1=0, r=0;
		for (int i=0;i<k;i++) {
			int[] rt = new int[] {nl[l1],nr[r1]};
    		rr.add(rt);
			if ((nl[l1+1] + nr[r]) > (nr[r1+1] + nl[l])){
				l1++;
			}
			
		}
		return rr;
	}
    
    public static void main(String[] args) {
		int k = 13;
		//int[] arr1 = { 1,7,11 };
		//int[] arr2 = { 2,4,6 };
		//int[] arr1 = { 1,1,1,1,5 };
		//int[] arr2 = {2,3 };
		k=2;
		//int[] arr1 = { 1,1,2 };
		//int[] arr2 = {1,2,3 };
		k=3;
		//int[] arr1 = { 1,2 };
		//int[] arr2 = {3 };

		k=30;
		int[] arr1 = { 1,2,3 };
		int[] arr2 = {1,2,3 };
		P373 a = new P373();
		List<int[]> r = a.kSmallestPairs_bad(arr1, arr2, k);
		for (int[] e : r) {

			System.out.print(Arrays.toString(e));
		}
    }
}
