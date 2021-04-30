package info.runcode.dfsbfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P127WordLadder {
//	127. Word Ladder
//	Medium
//
//	1170
//
//	750
//
//	Favorite
//
//	Share
//	Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
//
//	Only one letter can be changed at a time.
//	Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
//	Note:
//
//	Return 0 if there is no such transformation sequence.
//	All words have the same length.
//	All words contain only lowercase alphabetic characters.
//	You may assume no duplicates in the word list.
//	You may assume beginWord and endWord are non-empty and are not the same.
//	Example 1:
//
//	Input:
//	beginWord = "hit",
//	endWord = "cog",
//	wordList = ["hot","dot","dog","lot","log","cog"]
//
//	Output: 5
//
//	Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//	return its length 5.
	
//	Runtime: 42 ms, faster than 90.95% of Java online submissions for Word Ladder.
//	Memory Usage: 49.8 MB, less than 8.75% of Java online submissions for Word Ladder.
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String,Integer> result = new HashMap<String,Integer>();
		HashMap<String,List<String>> uncover=new HashMap<String,List<String>>();
		for(String e:wordList) {
			for(int i=0;i<e.length();i++) {
                String tmpE = e.substring(0, i)+"*"+e.substring(i+1);
                List<String> my = uncover.get(tmpE);
                if(my==null){
                    my=new ArrayList<String>();
                }
                my.add(e);
				uncover.put(tmpE,my);
			}
		}
		Queue<String> cover=new LinkedList<String>();
		cover.add(beginWord);
		result.put(beginWord, 1);
		while(!cover.isEmpty()) {
			String tmp = cover.poll();

			if (tmp.equals(endWord))
				return result.get(tmp);
			
			for(int i=0;i<tmp.length();i++) {
				String one = tmp.substring(0, i)+"*"+tmp.substring(i+1);
				List<String> t = uncover.get(one);
                
				if(t!=null) {
                    for(String tt:t){
                        if(result.get(tt)==null) {
                            result.put(tt, result.get(tmp)+1);
                            if (tt.equals(endWord))
                                return result.get(tt);
                            cover.offer(tt);
                        }
                    }
				}
			}			
		}

		Integer res = result.get(endWord);		
		return res==null?0:res.intValue();   
    }
}
