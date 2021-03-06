package info.runcode.pruning;

import java.util.List;

public class P52NQueensII {
//	52. N-Queens II
//	Hard
//
//	194
//
//	95
//
//	Favorite
//
//	Share
//	The n-queens puzzle is the problem of placing n queens on an n��n chessboard 
//	such that no two queens attack each other.
//
//
//
//	Given an integer n, return the number of distinct solutions to the n-queens puzzle.
//
//	Example:
//
//	Input: 4
//	Output: 2
//	Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
//	[
//	 [".Q..",  // Solution 1
//	  "...Q",
//	  "Q...",
//	  "..Q."],
//
//	 ["..Q.",  // Solution 2
//	  "Q...",
//	  "...Q",
//	  ".Q.."]
//	]
	public int totalNQueens(int n) {
		
		
		return n;
        
    }
	
	public void dfs(int row,int col,int pie,int na,Integer count,int n) {
		if (row>=n) {
			count++;
			return ;
		}
		int x = (~(col&pie&na))&((1<<n)-1);
		while(x>0) {
			int p = x&(-x);
			dfs(row+1,col|p,pie|(p<<1),na|(p>>1),count,n);
			x = x&(x-1);
		}
	}
}
