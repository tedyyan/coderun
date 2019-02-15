package info.runcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P212WordSearchII {
	//It same to P79
//	212. Word Search II
//	Hard
//
//	877
//
//	58
//
//	Favorite
//
//	Share
//	Given a 2D board and a list of words from the dictionary, find all words in the board.
//
//	Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
//
//	Example:
//
//	Input: 
//	words = ["oath","pea","eat","rain"] and board =
//	[
//	  ['o','a','a','n'],
//	  ['e','t','a','e'],
//	  ['i','h','k','r'],
//	  ['i','f','l','v']
//	]
//
//	Output: ["eat","oath"]
//	Note:
//	You may assume that all inputs are consist of lowercase letters a-z.
	
//	Runtime: 533 ms, faster than 17.06% of Java online submissions for Word Search II.
//	Memory Usage: 42.6 MB, less than 14.43% of Java online submissions for Word Search II.
	
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
					if(dps(board,word,1,x,y) == true) {
						board[x][y] = firstchar;
						return true;						
					}
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
	
	public List<String> findWords(char[][] board, String[] words) {
		
		List<String> res = new ArrayList<String>();
		Arrays.sort(words);
		String pre = null;
        for(String word:words) {
        	if (pre!=null) {
        		if(pre.equals(word))
        			continue;
        	}
        	
        	if(exist(board,word)) {
        		res.add(word);
        	}
        	pre = word;
        }
		return res;
    }
	
	public static void main(String[] args) {
		char[][] board = new char[][]
		{
			{'A','B','C','E'},
			{'S','F','C','S'},
			{'A','D','E','E'}
		};
		//char[][] board = new char[][] {{'a','a'}};
		String[] words= {"ABCCEES","SEE"};;  //ABCB SEE
		P212WordSearchII p = new P212WordSearchII();
		System.out.println(p.findWords(board, words));
		
	}
	
	//["aaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaab","aaaaaaaaaaaaaaac","aaaaaaaaaaaaaaad","aaaaaaaaaaaaaaae","aaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaab","aaaaaaaaaaaaaaac","aaaaaaaaaaaaaaad","aaaaaaaaaaaaaaae","aaaaaaaaaaaaaabc","aaaaaaaaaaaaaabf","aaaaaaaaaaaaaacb","aaaaaaaaaaaaaacd","aaaaaaaaaaaaaacg","aaaaaaaaaaaaaadc","aaaaaaaaaaaaaade","aaaaaaaaaaaaaadh","aaaaaaaaaaaaaaed","aaaaaaaaaaaaaaei","aaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaab","aaaaaaaaaaaaaaac","aaaaaaaaaaaaaaad","aaaaaaaaaaaaaaae","aaaaaaaaaaaaaabc","aaaaaaaaaaaaaabf","aaaaaaaaaaaaaacb","aaaaaaaaaaaaaacd","aaaaaaaaaaaaaacg","aaaaaaaaaaaaaadc","aaaaaaaaaaaaaade","aaaaaaaaaaaaaadh","aaaaaaaaaaaaaaed","aaaaaaaaaaaaaaei"]
	//["aaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaab","aaaaaaaaaaaaaaac","aaaaaaaaaaaaaaad","aaaaaaaaaaaaaaae","aaaaaaaaaaaaaabc","aaaaaaaaaaaaaabf","aaaaaaaaaaaaaacb","aaaaaaaaaaaaaacd","aaaaaaaaaaaaaacg","aaaaaaaaaaaaaadc","aaaaaaaaaaaaaade","aaaaaaaaaaaaaadh","aaaaaaaaaaaaaaed","aaaaaaaaaaaaaaei"]
}
