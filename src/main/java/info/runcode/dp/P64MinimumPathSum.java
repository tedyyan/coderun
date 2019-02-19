package info.runcode.dp;

public class P64MinimumPathSum {
//	64. Minimum Path Sum
//	Medium
//
//	1123
//
//	30
//
//	Favorite
//
//	Share
//	Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
//	Note: You can only move either down or right at any point in time.
//
//	Example:
//
//	Input:
//	[
//	  [1,3,1],
//	  [1,5,1],
//	  [4,2,1]
//	]
//	Output: 7
//	Explanation: Because the path 1¡ú3¡ú1¡ú1¡ú1 minimizes the sum.
	
//	Runtime: 5 ms, faster than 70.79% of Java online submissions for Minimum Path Sum.
//	Memory Usage: 41.6 MB, less than 100.00% of Java online submissions for Minimum Path Sum.
	public int minPathSum(int[][] grid) {
		if(grid==null) return 0;
		int rlen = grid.length;
		if (rlen == 0) return 0;
		
		if(grid[0]==null) return 0;
		int clen = grid[0].length;
		if (clen == 0) return 0;
		
		int rp=0,dp=0;
		for(int r = rlen-1;r>=0;r--) {
			for(int c = clen-1;c>=0;c--) {				
				if (c+1<clen) {
					rp = grid[r][c+1];
					if(r+1<rlen) {
						dp = grid[r+1][c];
						grid[r][c] += dp<rp?dp:rp;
					}else {
						grid[r][c] += rp;
					}
				}else {
					if(r+1<rlen) {
						dp = grid[r+1][c];
						grid[r][c] += dp;
					}else {
						//grid[r][c] = grid[r][c];
					}
				}
			}
		}
		return grid[0][0];
        
    }
	
	int dp(int[][] grid, int c, int r) {
		if((r==grid.length-1)&&(c==grid[0].length-1)) {
			return grid[grid.length-1][grid[0].length-1];
		}
		int vc = dp(grid,c+1,r)+grid[r][c];
		int vr = dp(grid,c,r+1)+grid[r][c];
		return vc>vr?vc:vr;
	}
}