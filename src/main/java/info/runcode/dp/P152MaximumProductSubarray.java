package info.runcode.dp;

public class P152MaximumProductSubarray {
//	152. Maximum Product Subarray
//	Medium
//
//	1618
//
//	73
//
//	Favorite
//
//	Share
//	Given an integer array nums, find the contiguous subarray within an array (containing at least one number) 
//	which has the largest product.
//
//	Example 1:
//
//	Input: [2,3,-2,4]
//	Output: 6
//	Explanation: [2,3] has the largest product 6.
//	Example 2:
//
//	Input: [-2,0,-1]
//	Output: 0
//	Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
	 public int maxProduct(int[] a) {
		 if ((a==null)||(a.length==0)) {
			 return 0;
		 }
		 if (a.length==1) {
			 return a[0];
		 }
		 int cmax=a[0],tmax=a[0],allmax=a[0],tpmax=0;
		 for(int i=1;i<a.length;i++)
		 {
			 int t = cmax * a[i];
			 if (t>cmax) {
				 cmax = t;
			 }else {
				 cmax = a[i];
			 }
			 if (cmax>tmax) {
				 tmax=cmax;
			 }			
			 allmax = allmax * a[i];
			 if (allmax>tmax) {
				 tmax = allmax;
			 }
			 

		 }
		 
		return tmax;
	        
	 }
	 
	 public static void main(String args[]) {
		 P152MaximumProductSubarray p = new P152MaximumProductSubarray();
		 int[] a = new int[] {-1,10,2,-1,50,-2 }; //-2,0,-1 -10,1,2,-5 -2,0,-1
		 System.out.println(p.maxProduct(a));
		 System.out.println(p.dps(a,a.length-1));
		 int[] b = new int[a.length];
		 int[] c = new int[a.length];
		 System.out.println(p.teacher(a,b,c));
	 }
	 
	 public int dps(int[]a, int endindex) {
		 
		 if (endindex == 0)
			 return a[0];
		 
		 int pre = dps(a,endindex-1);
		 int tmp = a[endindex];
		 int max = a[endindex];
		 for(int i=endindex-1;i>=0;i--) {
			 tmp = a[i] * tmp;			 
			 if (tmp>max) {
				 max = tmp;
			 }
		 }
		 if (max<pre)
			 max = pre;
		 return max;
	 }
	 
	 public int teacher(int[]a,  int[]zmax, int[] fmax) {
		 
		if ((a==null)||(a.length==0)){
			return 0;
		}
			 zmax[0] = a[0];
			 fmax[0] = a[0];
		
		 
		 for(int i=1;i<a.length;i++) {
			 if (a[i]>0) {
				 zmax[i] = zmax[i -1 ] * a[i] > a[i]? zmax[i -1 ] * a[i]:a[i];
			 }else {
				 zmax[i] = fmax[i -1 ] * a[i] > a[i]? fmax[i -1 ] * a[i]:a[i];
			 }
	
			 if (a[i]>0) {
				 fmax[i] = fmax[i -1 ] * a[i] < a[i]? fmax[i -1 ] * a[i]:a[i];
			 }else {
				 fmax[i] = zmax[i -1 ] * a[i] < a[i]? zmax[i -1 ] * a[i]:a[i];
			 }
		 }
		 int max = a[0];
		 for(int j=1;j<a.length;j++) {
			 if (zmax[j]>max)
				 max = zmax[j];
		 }
		 
		return max;
		 
	 }
}
