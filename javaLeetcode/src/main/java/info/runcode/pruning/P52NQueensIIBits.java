package info.runcode.pruning;

import java.util.concurrent.atomic.AtomicInteger;

public class P52NQueensIIBits {
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
//	The n-queens puzzle is the problem of placing n queens on an n¡Án chessboard 
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
		
		Integer c = new Integer(0);
		return dfs(0,0,0,0,c,n);
        
    }
	
	public int cc = 0;
	
	public int dfs(int row,int col,int pie,int na,Integer count,int n) {
		if (row>=n) {
			count++;
			cc++;
			return count;
		}
		int x = (~(col|pie|na))&((1<<n)-1);
		while(x>0) {
			int p = x&(-x);
			count = dfs(row+1,col|p,(pie|p)<<1,(na|p)>>1,count,n);
			x = x&(x-1);
		}
		return count;
	}
	
	public static void main(String[] args) {
		P52NQueensIIBits p = new P52NQueensIIBits();
		System.out.println(p.totalNQueens(4));
		System.out.println(p.cc);
		AtomicInteger  c = new AtomicInteger(190000);
		System.out.println(c);
		p.updateInteger(c);
		System.out.println(c);
	}
	
	public void updateInteger(AtomicInteger  x) {
		x.incrementAndGet();
	}
}
