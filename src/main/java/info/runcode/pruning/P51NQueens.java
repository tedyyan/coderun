package info.runcode.pruning;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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

	

	List<List<String>> solveNQueens(int n) {
		if (n == 1) {
			List<List<String>> r = new LinkedList<List<String>>();
			LinkedList<String> t = new LinkedList<String>();
			t.add("Q");
			r.add(t);
			return r;
		}
		List<List<String>> sub = solveNQueens(n - 1);
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
		int n = 2;
		List<List<String>> r = p.solveNQueens(n);
		Iterator<List<String>> it = r.iterator();
		while (it.hasNext()) {
			List<String> a = it.next();
			System.out.println(Arrays.toString(a.toArray()));
		}
	}
}
