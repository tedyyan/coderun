package info.runcode.dp;

public class P213 {
	//House Robber II
	public int[] rob2(int[] nums) {
		 if (nums.length==0) {
			 int[] r = {0,0};
	            return r;
		 }
		int p0 = 0;
		int p1 = 0;
		for (int i=0;i<nums.length;i++) {			
			int t = p1>p0?p1:p0;
			int prev = 0;
			if (i==0) {
				prev = 0;
			}else {
				prev = nums[i-1];
			}
			if ((p0 + nums[i])>(p1-prev+nums[i])) {
				p1 = p0 + nums[i];
			}else {
				p1 = p1-prev+nums[i];
			}
			p0=t;
			System.out.println("nums["+i+"] "+nums[i]+" p0:"+p0+" p1:"+p1 + " pre:"+prev);
		}
		//return p1>p0?p1:p0;
		int[] r = {p0,p1};
		return r;
	        
	 }
	public int rob(int[] nums) {
		if (nums.length==1) {
			return nums[0];
		}
		int[] r = rob2(nums);
		int[] nums2 = new int[nums.length];
		for (int i=0;i<nums.length;i++) {
			nums2[i]=nums[nums.length-i-1];
		}
		int[] rr = rob2(nums2);
		
		int t = 0;
		if(rr[1]==r[1]) {
			t=0;
			t = rr[0]>r[0]?rr[0]:r[0];
		}else {
			t = rr[0]>r[0]?rr[0]:r[0];
			t = t > r[1]?t:r[1];
			t = t > rr[1]?t:rr[1];
		}
		return t;		
	}
	
	 
	 public static void main(String[] args) {
		 P213 p = new P213();
		 int[] input = new int[] {1}; //2,3,1,1,4  3,2,1,0,4 2,7,9,3,1 2,3,2
		 System.out.println(p.rob(input));
		 
	 }
}
