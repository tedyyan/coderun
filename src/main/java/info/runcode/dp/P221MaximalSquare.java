package info.runcode.dp;

import java.util.Arrays;

public class P221MaximalSquare {
//	221. Maximal Square
//	Medium
//
//	997
//
//	23
//
//	Favorite
//
//	Share
//	Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
//
//	Example:
//
//	Input: 
//
//	1 0 1 0 0
//	1 0 1 1 1
//	1 1 1 1 1
//	1 0 0 1 0
//
//	Output: 4
	
	public int maximalSquare(char[][] matrix) {		
		int n = matrix.length;
		char[][] d = Arrays.copyOf(matrix, n*n);
		int result = -260;
		//d[][]
		for(int i=1;i<n ;i++) {
			for(int j=1;j<n;j++) {
				d[i][j] = min3(d[i-1][j],d[i-1][j-1],d[i][j-1]);
				if (d[i][j]>result) {
					result = d[i][j];
				}
			}
		}
		return result*result;
        
    }

	private char min3(char c, char d, char e) {
		char tmp = c>d?c:d;		
		return e>tmp?e:tmp;
	}
}
