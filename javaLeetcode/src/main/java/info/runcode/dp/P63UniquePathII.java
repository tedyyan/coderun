package info.runcode.dp;

public class P63UniquePathII {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m;
		int n;
		if ((obstacleGrid == null) || (obstacleGrid.length == 0) || (obstacleGrid[0].length == 0)) {
			return 0;
		}

		n = obstacleGrid.length;
		m = obstacleGrid[0].length;

		if ((obstacleGrid[0][0] == 1) || (obstacleGrid[n - 1][m - 1] == 1)) {
			return 0;
		}
		if ((n < 1) || (m < 1))
			return 0;
		int[][] matrix = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (obstacleGrid[i][j] == 1) {
					matrix[i][j] = 0;
				} else {
					int p = 0;
					int q = 0;
					if (i - 1 < 0) {
						p = 0;
					} else {
						p = matrix[i - 1][j];
					}

					if (j - 1 < 0) {
						q = 0;
					} else {
						q = matrix[i][j - 1];
					}
					if ((i==0)&&(j==0)) {
						matrix[i][j] = 1;
					}else {
						matrix[i][j] = p + q;
					}
					
				}

			}
		}
		return matrix[n - 1][m - 1];
	}

	public static void main(String[] args) {
		//int[][] tmp = new int[][] { { 0, 0 }, { 1, 1 }, { 0, 0 } };
		int[][] tmp = new int[][] { { 0, 0 ,0},{0,1,0},{0, 0, 0 } };
		P63UniquePathII p = new P63UniquePathII();
		System.out.println(p.uniquePathsWithObstacles(tmp));
	}
}
