package info.runcode.pruning;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class P51NQueens {
	// 51. N-Queens
	// Hard
	//
	// 659
	//
	// 29
	//
	// Favorite
	//
	// Share
	// The n-queens puzzle is the problem of placing n queens on an n¡Án chessboard
	// such that no two queens attack each other.
	//
	// Given an integer n, return all distinct solutions to the n-queens puzzle.
	//
	// Each solution contains a distinct board configuration of the n-queens'
	// placement, where 'Q' and '.' both indicate a queen
	// and an empty space respectively.
	//
	// Example:
	//
	// Input: 4
	// Output: [
	// [".Q..", // Solution 1
	// "...Q",
	// "Q...",
	// "..Q."],
	//
	// ["..Q.", // Solution 2
	// "Q...",
	// "...Q",
	// ".Q.."]
	// ]
	// Explanation: There exist two distinct solutions to the 4-queens puzzle as
	// shown above.

	List<List<String>> solveNQueens_NoRecursion(int n) {

		List<List<String>> r = new LinkedList<List<String>>();
		
		
		for(int col=0;col<n;col++) {
			int[][] board = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) 
					board[i][j]=0;
			}
			//int[][] board = Arrays.co(boarda1,n);
			board[0][col] = 1;
			//fillin
			TreeSet<Integer> colset = new TreeSet<Integer>();
			colset.add(col);
			TreeSet<Integer> pieset = new TreeSet<Integer>();
			pieset.add(0+col);
			TreeSet<Integer> naset = new TreeSet<Integer>();
			naset.add(col-0);
			int hasrow = 0;
			for(int row=1;row<n;row++) {
				int orginal=hasrow;
				for(int incol=0;incol<n;incol++) {

					if(colset.contains(incol))
						continue;
					if(pieset.contains(row+incol))
						continue;
					if(naset.contains(incol-row))
						continue;
					board[row][incol]=1;
					colset.add(incol);
					pieset.add(row+incol);
					naset.add(incol-row);
					hasrow++;
					break;
				}
				if (orginal == hasrow) {
					break;
				}
			}
			if (hasrow==n-1) {
				List<String> ss = new LinkedList<String>();
				for(int i=0;i<n;i++) {
					String t = "";
					for(int j=0;j<n;j++) {
						if(board[i][j]==1) {
							t+="Q";
						}else {
							t+=".";
						}
					}
					ss.add(t);
				}
				r.add(ss);
			}
		}
		return r;
	}
	
	List<List<String>> solveNQueens(int n) {

		List<List<String>> r = new LinkedList<List<String>>();
		TreeSet<Integer> colset = new TreeSet<Integer>();
	
		TreeSet<Integer> pieset = new TreeSet<Integer>();
	
		TreeSet<Integer> naset = new TreeSet<Integer>();
	
		return r;
	}
	
	void dps(int r, int c, int n, TreeSet<Integer> colset,TreeSet<Integer> pieset,TreeSet<Integer> naset
			,LinkedList<List<String>> result){
		
		for(int i=0;i<n;i++) {
			
			if ((!colset.contains(c))&&(!pieset.contains(c+r))&&(!naset.contains(c-r))) {
				colset.add(c);
				pieset.add(c+r);
				naset.add(c-r);
				
				dps(r+1,c,n,colset,pieset,naset,result);
			}
		}
	}

	List<List<String>> solveNQueens_allowDiagonal(int n) {
		if (n == 1) {
			List<List<String>> r = new LinkedList<List<String>>();
			LinkedList<String> t = new LinkedList<String>();
			t.add("Q");
			r.add(t);
			return r;
		}
		List<List<String>> sub = solveNQueens_allowDiagonal(n - 1);
		List<List<String>> rr = new LinkedList<List<String>>();
		
		String dd = new String();
		for (int i = 0; i < n; i++) {
			dd = dd + ".";
		}
		for (int i = 0; i < n; i++) {
			String d = dd.substring(0, i) + "Q" + dd.substring(i + 1, dd.length());
			
			Iterator<List<String>> it = sub.iterator();
			while (it.hasNext()) {
				List<String> a = it.next();
				Iterator<String> itinner = a.iterator();

				List<String> nn = new LinkedList<String>();
				nn.add(d);	
				while (itinner.hasNext()) {
					String b = itinner.next();
					String c = b.substring(0, i) + "." + b.substring(i, b.length());
					
					nn.add(c);
				}
				rr.add(nn);
			}
		}
		return rr;
	}

	public static void main(String[] args) {
		P51NQueens p = new P51NQueens();
		int n = 5;
		List<List<String>> r = p.solveNQueens(n);
		Iterator<List<String>> it = r.iterator();
		while (it.hasNext()) {
			List<String> a = it.next();
			System.out.println(Arrays.toString(a.toArray()));
		}
	}
}
