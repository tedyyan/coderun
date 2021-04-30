package info.runcode.bit;

public class P260SingleNumberIII {
//	260. Single Number III
//	Medium
//
//	716
//
//	66
//
//	Favorite
//
//	Share
//	Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
//
//	Example:
//
//	Input:  [1,2,1,3,2,5]
//	Output: [3,5]
//	Note:
//
//	The order of the result is not important. So in the above example, [5, 3] is also correct.
//	Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
	
	public int[] singleNumber(int[] nums) {
		int[] rr = new int[2];
		if ((nums==null)||(nums.length<=1)) {
			return new int[0];
		}
		
		int k = nums[0];
		for (int i = 1;i<nums.length;i++) {			
			k = k ^ nums[i];
		}
		System.out.println(k);
		k = k & -k;
		System.out.println(k);
		int m = 0,n = 0;
		boolean mf=false,nf=false;
		for (int i = 0;i<nums.length;i++) {
			if ((k & nums[i])>0) {
				if (true == mf) {
					m = m ^ nums[i];
				}else {
					m = nums[i];
					mf = true;
				}
			}else{
				if (true == nf) {
					n = n ^ nums[i];
				}else {
					n = nums[i];
					nf = true;
				}
			}
		}
		
		rr[0] = n;
		rr[1] = m;
		
		
		return rr;
        
    }
	
	public static void main(String[] args) {
		P260SingleNumberIII p = new P260SingleNumberIII();
		int[] nums = new int[] {1,2,1,2,5,4};
		int[] a = p.singleNumber(nums );
		System.out.println(a[0]);
		System.out.println(a[1]);
	}
}
