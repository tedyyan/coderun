package info.runcode.zzz;

public class P48RotateImage {
	// 48. Rotate Image
	// Medium
	//
	// 1210
	//
	// 114
	//
	// Favorite
	//
	// Share
	// You are given an n x n 2D matrix representing an image.
	//
	// Rotate the image by 90 degrees (clockwise).
	//
	// Note:
	//
	// You have to rotate the image in-place, which means you have to modify the
	// input 2D matrix directly. DO NOT allocate another 2D matrix and do the
	// rotation.
	//
	// Example 1:
	//
	// Given input matrix =
	// [
	// [1,2,3],
	// [4,5,6],
	// [7,8,9]
	// ],
	//
	// rotate the input matrix in-place such that it becomes:
	// [
	// [7,4,1],
	// [8,5,2],
	// [9,6,3]
	// ]
	// Example 2:
	//
	// Given input matrix =
	// [
	// [ 5, 1, 9,11],
	// [ 2, 4, 8,10],
	// [13, 3, 6, 7],
	// [15,14,12,16]
	// ],
	//
	// rotate the input matrix in-place such that it becomes:
	// [
	// [15,13, 2, 5],
	// [14, 3, 4, 1],
	// [12, 6, 8, 9],
	// [16, 7,10,11]
	// ]

	public void rotate(int[][] matrix) {
		int j = 0;
		for(int n=matrix.length-1;n>1;n--) {
			int k = 0;
			int m = 0;
			
			for (int i = 0; i <= n-j; i++) {
				k = matrix[i+j][n+j];
				matrix[i+j][n+j] = matrix[0+j][i+j];
				
				m = matrix[n+j][n - i+j];
				matrix[n+j][n - i+j] = k;
				
				k = matrix[n - i+j][i+j];
				matrix[n - i+j][i+j] = m;
				
				matrix[0+j][i+j] = k;
			}
			j++;
		}
	}
}
