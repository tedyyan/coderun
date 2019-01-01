package info.runcode.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P212 {
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
				csearch(t,board,"",i,j,resultList, path);
			}
		}
		return null;
        
    }
	
	public void csearch(Trie t,char[][] board, String before,int i, int j,List<String> r, Set<Point<Integer>> path) {
		if (t.search(before)) {
			r.add(before);
			return;
		}
		
		String str;		
		str = before + board[i][j+1];
		if (t.startsWith(str) &&(!path.contains(new Point<Integer>(i,j+1)))) {
			Point<Integer> pos = new Point<Integer>(i,j+1);
			path.add(pos);
			csearch(t,board,str,i,j+1,r,path);
			path.remove(pos);
		}
		str = before + board[i+1][j];
		if (t.startsWith(str) &&(!path.contains(new Point<Integer>(i+1,j)))) {
			Point<Integer> pos = new Point<Integer>(i,j+1);
			path.add(pos);
			csearch(t,board,str,i,j+1,r,path);
			path.remove(pos);
		}
		str = before + board[i][j-1];
		if (t.startsWith(str) &&(!path.contains(new Point<Integer>(i,j-1)))) {
			Point<Integer> pos = new Point<Integer>(i,j+1);
			path.add(pos);
			csearch(t,board,str,i,j+1,r,path);
			path.remove(pos);
		}
		str = before + board[i-1][j];
		if (t.startsWith(str) &&(!path.contains(new Point<Integer>(i-1,j)))) {
			Point<Integer> pos = new Point<Integer>(i,j+1);
			path.add(pos);
			csearch(t,board,str,i,j+1,r,path);
			path.remove(pos);
		}
		return ;
	}
}
