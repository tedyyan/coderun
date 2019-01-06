package info.runcode.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P212WordSearchII {
//	212. Word Search II
//	Hard
//
//	795
//
//	53
//
//	Favorite
//
//	Share
//	Given a 2D board and a list of words from the dictionary, find all words in the board.
//
//	Each word must be constructed from letters of sequentially adjacent cell,
//  where "adjacent" cells are those horizontally or vertically neighboring. 
// 	The same letter cell may not be used more than once in a word.
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
	
	public List<String> findWords(char[][] board, String[] words) {
		List<String> resultList = new ArrayList<String>();
		Set<Point<Integer>> path = new HashSet<Point<Integer>>();
		Trie t = new Trie();
		for(int i=0;i<words.length;i++) {
			t.insert(words[i]);
		}
		
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {	
				String before = ""+board[i][j];
				csearch(t,board,before,i,j,resultList, path);
			}
		}
		return resultList;
        
    }
	
	public void csearch(Trie t,char[][] board, String before,int i1, int j1,List<String> r, Set<Point<Integer>> path) {

		Point<Integer> pos = new Point<Integer>(i1,j1);
		if ((path.contains(pos))) {
			return;
		}
		TrieNode node = t.getNode(before);		
		if (node == null) return;
		if (node.is_end_word) {
			r.add(before);
		}
		if(node.has_sub_word = false) {
			return;
		}

		int ii = 0;
		int jj = 0;
		for (int k=0;k<4;k++) {
			if (k == 0) {
				ii = i1+1;
				jj = j1;
				if (ii<0||jj<0||(ii>=board.length)||(jj >= (board[ii]).length)) continue;
			}
			if (k == 1) {
				ii = i1;
				jj = j1+1;
				if (ii<0||jj<0||(ii>=board.length)||(jj >= (board[ii]).length)) continue;
			}
			if (k == 2) {
				ii = i1-1;
				jj = j1;
				if (ii<0||jj<0||(ii>=board.length)||(jj >= (board[ii]).length)) continue;
			}

			if (k == 3) {
				ii = i1;
				jj = j1-1;
				if (ii<0||jj<0||(ii>=board.length)||(jj >= (board[ii]).length)) continue;
			}
			String str = before + board[ii][jj];

			path.add(pos);
			csearch(t,board,str,ii,jj,r,path);
			path.remove(pos);
				
			
		}
		
		return ;
	}
	
	public static void main(String[] args) {
		String[] words = new String[] {"oath","pea","eat","rain"};
		char[][] board = new char[][]
				{
					{'o','a','a','n'},
					{'e','t','a','e'},
					{'i','h','k','r'},
					{'i','f','l','v'}
				};
		
		P212WordSearchII instance = new P212WordSearchII();
		List<String> r = instance.findWords(board, words);
		
		System.out.println(r);
	}
}
