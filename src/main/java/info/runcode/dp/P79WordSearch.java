package info.runcode.dp;


public class P79WordSearch {
//	79. Word Search
//	Medium
//
//	1414
//
//	65
//
//	Favorite
//
//	Share
//	Given a 2D board and a word, find if the word exists in the grid.
//
//	The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//	Example:
//
//	board =
//	[
//	  ['A','B','C','E'],
//	  ['S','F','C','S'],
//	  ['A','D','E','E']
//	]
//
//	Given word = "ABCCED", return true.
//	Given word = "SEE", return true.
//	Given word = "ABCB", return false.
	
//	Runtime: 7 ms, faster than 99.62% of Java online submissions for Word Search.
//	Memory Usage: 40.4 MB, less than 5.97% of Java online submissions for Word Search.
	
	public boolean exist(char[][] board, String word) {
		if ((word==null)||(word.length()==0))
			return true;
		if(board==null)
			return false;
		int xmaxlen = board.length;
		if (xmaxlen == 0) return false;
		char firstchar = word.charAt(0);

		for(int x=0;x<xmaxlen;x++) {
			if (board[x].length==0)
				return false;
			for(int y=0;y<board[x].length;y++) {				
				if(board[x][y]==firstchar ) {
					board[x][y] = '\r';
					if(dps(board,word,1,x,y) == true)
						return true;
					board[x][y] = firstchar;
				}				
			}
		}
		return false;
        
    }

	private boolean dps(char[][] board, String word,int index, int x, int y) {
		if (index==word.length()) {
			return true;
		}
		boolean flag = false;
		//up
		int posx = x -1;
		int posy = y;
		flag = poscheck(posx,posy,board,word,index);
		if (true == flag) return true;
		//down
		posx = x + 1;
		posy = y;
		flag = poscheck(posx,posy,board,word,index);
		if (true == flag) return true;
		//left
		posx = x;
		posy = y -1;
		flag = poscheck(posx,posy,board,word,index);
		if (true == flag) return true;
		//up
		posx = x ;
		posy = y + 1;
		flag = poscheck(posx,posy,board,word,index);
		if (true == flag) return true;
		
		return false;
	}
	
	boolean poscheck(int posx, int posy, char[][] board, String word, int index) {
		if ((posx>=0) && (posx<board.length) && (posy>=0) && (posy<board[posx].length)) {
			if (board[posx][posy] == word.charAt(index)) {
//				//copy a board
//				char[][] array2 = new char[board.length][maxylen];			
//				for(int i = 0;i < board.length;i++){
//			        array2[i] = Arrays.copyOf(board[i],board[i].length);
//				}
				
				board[posx][posy] = '\r';
				boolean res =  dps(board,word,index+1,posx,posy);
				board[posx][posy] = word.charAt(index);
				return res;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
//		char[][]  = new char[][]
//		{
//			{'A','B','C','E'},
//			{'S','F','C','S'},
//			{'A','D','E','E'}
//		};
		char[][] board = new char[][] {{'a','a'}};
		String word= "aaa";  //ABCB SEE
		P79WordSearch p = new P79WordSearch();
		System.out.println(p.exist(board, word));
		
	}
}
