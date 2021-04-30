package info.runcode.string;

import java.util.ArrayList;
import java.util.List;

public class P54SpiralMatrix {
//	54. Spiral Matrix
//	Medium
//
//	871
//
//	350
//
//	Favorite
//
//	Share
//	Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
//	Example 1:
//
//	Input:
//	[
//	 [ 1, 2, 3 ],
//	 [ 4, 5, 6 ],
//	 [ 7, 8, 9 ]
//	]
//	Output: [1,2,3,6,9,8,7,4,5]
//	Example 2:
//
//	Input:
//	[
//	  [1, 2, 3, 4],
//	  [5, 6, 7, 8],
//	  [9,10,11,12]
//	]
//	Output: [1,2,3,4,8,12,11,10,9,5,6,7]
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if (matrix==null) return res;
		int maxY = matrix.length-1;
		if (maxY<0) return res;
		if (matrix[0]==null) return res;
		int maxX = matrix[0].length-1;
		int minX = 0;
		int minY = 0;
		int cx = 0, cy = 0;
		while(true) {
			if ((minX>maxX)||(minY>maxY))
			{
				break;
			}
			if (minX==maxX) {
				cx=maxX;
				for(cy=minY;cy<=maxY;cy++) {
					res.add(matrix[cy][cx]);
				}
			}else if (minY==maxY) {
				cy=maxY;
				for(cx=minX;cx<=maxX;cx++) {
					res.add(matrix[cy][cx]);
				}
			}else {
				cy = minY;
				for(cx=minX;cx<=maxX;cx++) {
					res.add(matrix[cy][cx]);
				}
				
				cx = maxX;
				for(cy=minY+1;cy<=maxY;cy++) {
					res.add(matrix[cy][cx]);
				}
				
				cy = maxY;
				for(cx=maxX-1;cx>=minX;cx--) {
					res.add(matrix[cy][cx]);
				}
				
				cx = minX;
				for(cy=maxY-1;cy>=minY+1;cy--) {
					res.add(matrix[cy][cx]);
				}
				
			}
			minX++;
			minY++;
			maxX--;
			maxY--;
		}  
		return res;     
    }
	
	public static void main(String[] args) {
		int[][] board = new int[][]
		{
			{}
		};
		//char[][] board = new char[][] {{'a','a'}};
		String word= "aaa";  //ABCB SEE
		P54SpiralMatrix p = new P54SpiralMatrix();
		System.out.println(p.spiralOrder(board));
	}
}
