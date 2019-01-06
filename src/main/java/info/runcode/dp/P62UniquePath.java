package info.runcode.dp;

public class P62UniquePath {
//	62. Unique Paths
//	Medium
//
//	1160
//
//	82
//
//	Favorite
//
//	Share
//	A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//	The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//	How many possible unique paths are there?
//
//
//	Above is a 7 x 3 grid. How many possible unique paths are there?
//
//	Note: m and n will be at most 100.
//
//	Example 1:
//
//	Input: m = 3, n = 2
//	Output: 3
//	Explanation:
//	From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
//	1. Right -> Right -> Down
//	2. Right -> Down -> Right
//	3. Down -> Right -> Right
//	Example 2:
//
//	Input: m = 7, n = 3
//	Output: 28
	
   public int uniquePaths(int m, int n) {
	   if ((n<1)||(m<1)) return 0;
	   int[][] matrix = new int[n][m];
	   for(int i=0;i<n;i++) {
		   for(int j=0;j<m;j++) {
			   if ((i==0)||(j==0)) {
				   matrix[i][j]=1;
			   }else {
				   matrix[i][j]=matrix[i-1][j]+matrix[i][j-1];
			   }
		   }
	   }
	   return matrix[n-1][m-1];
        
   }
   
   public static void main(String args[]) {
	   P62UniquePath p = new P62UniquePath();
	   int m = 10;
	   int n = 10;
	   System.out.println(p.uniquePaths(m, n));
   }
}
