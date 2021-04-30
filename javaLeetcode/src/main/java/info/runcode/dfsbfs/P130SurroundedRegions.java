package info.runcode.dfsbfs;

public class P130SurroundedRegions {
//	130. Surrounded Regions
//	Medium
//
//	639
//
//	388
//
//	Favorite
//
//	Share
//	Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
//
//	A region is captured by flipping all 'O's into 'X's in that surrounded region.
//
//	Example:
//
//	X X X X
//	X O O X
//	X X O X
//	X O X X
//	After running your function, the board should be:
//
//	X X X X
//	X X X X
//	X X X X
//	X O X X
//	Explanation:
//
//	Surrounded regions shouldn¡¯t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
//	Runtime: 4 ms, faster than 96.21% of Java online submissions for Surrounded Regions.
//	Memory Usage: 46.1 MB, less than 5.20% of Java online submissions for Surrounded Regions.
	public void solve(char[][] board) {
		if((board==null)||board.length==0||board[0].length==0)
			return;
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if ((row == 0) || (row == board.length - 1) || (col == 0) || (col == board[0].length - 1)) {
					if (board[row][col] == 'O') {
						color(board, row, col);
					}
				}
			}
		}

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {

				if (board[row][col] == 'O') {
					board[row][col] = 'X';
				}
				if (board[row][col] == 'V') {
					board[row][col] = 'O';
				}
			}
		}
	}

	private void color(char[][] board, int row, int col) {
		board[row][col] = 'V';
		if (row + 1 < board.length) {
			if (board[row + 1][col] == 'O') {
				color(board, row + 1, col);
			}
		}
		if (row - 1 >= 0) {
			if (board[row - 1][col] == 'O') {
				color(board, row - 1, col);
			}
		}
		if (col + 1 < board[0].length) {
			if (board[row][col + 1] == 'O') {
				color(board, row, col + 1);
			}
		}
		if (col - 1 >= 0) {
			if (board[row][col - 1] == 'O') {
				color(board, row, col - 1);
			}
		}
	}
}
