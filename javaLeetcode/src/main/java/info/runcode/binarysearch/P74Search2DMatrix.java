package info.runcode.binarysearch;

public class P74Search2DMatrix {
//	74. Search a 2D Matrix
//	Medium
//
//	679
//
//	83
//
//	Favorite
//
//	Share
//	Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//	Integers in each row are sorted from left to right.
//	The first integer of each row is greater than the last integer of the previous row.
//	Example 1:
//
//	Input:
//	matrix = [
//	  [1,   3,  5,  7],
//	  [10, 11, 16, 20],
//	  [23, 30, 34, 50]
//	]
//	target = 3
//	Output: true
//	Example 2:
//
//	Input:
//	matrix = [
//	  [1,   3,  5,  7],
//	  [10, 11, 16, 20],
//	  [23, 30, 34, 50]
//	]
//	target = 13
//	Output: false
	
//	Runtime: 4 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
//	Memory Usage: 38.8 MB, less than 100.00% of Java online submissions for Search a 2D Matrix.
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if ((matrix==null)||(matrix.length==0)||(matrix[0]==null)||matrix[0].length==0) {
			return false;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int l = 0;
		int r = m*n-1;
		int i = 0;
		int mm=0,nn=0;
		while (l<=r) {
			i = (l+r)/2;
			mm = i / n;
			nn = i % n;
			if(matrix[mm][nn]==target) {
				return true;
			}else if(matrix[mm][nn]<target) {
				l = i + 1;
			}else {
				r = i - 1;
			}
		}
		return false;
        
    }
	
	public boolean bs(int[] a, int t) {
		int l = 0;
		int r = a.length-1;
		int i = 0;
		while (l<=r) {
			i = (l+r)/2;
			if(a[i]==t) {
				return true;
			}else if(a[i]<t) {
				l = i + 1;
			}else {
				r = i - 1;
			}
		}
		return false;
	}
	
	public static void main1(String[] args) {
		int[] a = new int[] {0,4,11};
		P74Search2DMatrix p = new P74Search2DMatrix();
		System.out.println(p.bs(a, 1));
		System.out.println(p.bs(a, 2));
		System.out.println(p.bs(a, 3));
		System.out.println(p.bs(a, 4));
		System.out.println(p.bs(a, 5));
		System.out.println(p.bs(a, 6));
		System.out.println(p.bs(a, 7));
	}
	
	public static void main(String[] args) {
		int[][] a = new int[][] {{0,1,3},{5,6,7},{7,8,9},{10,11,12}};
		P74Search2DMatrix p = new P74Search2DMatrix();
		System.out.println("-1 "+p.searchMatrix(a, -1));
		System.out.println("0 "+p.searchMatrix(a, 0));
		System.out.println("1 "+p.searchMatrix(a, 1));
		System.out.println("2 "+p.searchMatrix(a, 2));
		System.out.println("3 "+p.searchMatrix(a, 3));
		System.out.println("4 "+p.searchMatrix(a, 4));
		System.out.println("5 "+p.searchMatrix(a, 5));
		System.out.println("6 "+p.searchMatrix(a, 6));
		System.out.println("7 "+p.searchMatrix(a, 7));
		System.out.println("8 "+p.searchMatrix(a, 8));
		System.out.println("9 "+p.searchMatrix(a, 9));
		System.out.println("9 "+p.searchMatrix(a, 19));
	}
}
