package info.runcode.dp;

public class P70Climbing {
//	70. Climbing Stairs
//	Easy
//
//	1626
//
//	62
//
//	Favorite
//
//	Share
//	You are climbing a stair case. It takes n steps to reach to the top.
//
//	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//	Note: Given n will be a positive integer.
//
//	Example 1:
//
//	Input: 2
//	Output: 2
//	Explanation: There are two ways to climb to the top.
//	1. 1 step + 1 step
//	2. 2 steps
//	Example 2:
//
//	Input: 3
//	Output: 3
//	Explanation: There are three ways to climb to the top.
//	1. 1 step + 1 step + 1 step
//	2. 1 step + 2 steps
//	3. 2 steps + 1 step
	 public int climbStairs(int n) {
		 int b0,b1,bn =0;
		 b0 = 1;
		 b1 = 2;//b2=3 b3=5, b4=8
		 for(int i=2;i<n;i++) {
			 bn = b0 + b1;
			 b0 = b1;
			 b1 = bn;
		 }
		return bn;
	        
	 }
	 public static void main(String[] args) {
		 P70Climbing p = new P70Climbing();
		 int input = 4;
		 System.out.println(p.climbStairs(input));
	 }
	 
	 //------------------------------------------------------------
	 public int climbStairsFaster(int n) {
	        int[][] q = {{1, 1}, {1, 0}};
	        int[][] res = pow(q, n);
	        return res[0][0];
	    }
	    public int[][] pow(int[][] a, int n) {
	        int[][] ret = {{1, 0}, {0, 1}};
	        while (n > 0) {
	            if ((n & 1) == 1) {
	                ret = multiply(ret, a);
	            }
	            n >>= 1;
	            a = multiply(a, a);
	        }
	        return ret;
	    }
	    public int[][] multiply(int[][] a, int[][] b) {
	        int[][] c = new int[2][2];
	        for (int i = 0; i < 2; i++) {
	            for (int j = 0; j < 2; j++) {
	                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
	            }
	        }
	        return c;
	    }
}
