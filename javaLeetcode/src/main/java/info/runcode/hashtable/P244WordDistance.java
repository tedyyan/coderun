package info.runcode.hashtable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class P244WordDistance {
//	244. Shortest Word Distance II
//	Medium
//
//	168
//
//	76
//
//	Favorite
//
//	Share
//	Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters. 
//
//	Example:
//	Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
//	Input: word1 = ¡°coding¡±, word2 = ¡°practice¡±
//	Output: 3
//	Input: word1 = "makes", word2 = "coding"
//	Output: 1
//	Note:
//	You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
	 private HashMap<String,TreeSet<Integer>> dis = new HashMap<String,TreeSet<Integer>>();
	    public P244WordDistance(String[] words) {
	        int i = 0;
	        for(String word:words){
	            TreeSet<Integer> cur = null;
	            if(dis.get(word)==null){
	                cur = new TreeSet<Integer>();
	            }else{
	                cur = dis.get(word);
	            }
	            cur.add(i);
	            dis.put(word,cur);
	            i++;
	        }        
	        
	    }
	    
	    public int shortest(String word1, String word2) {
	        TreeSet<Integer> d1 = this.dis.get(word1);
	        TreeSet<Integer> d2 = this.dis.get(word2);
	        if(d1==null || d2==null){
	            return 0;
	        }
	        int min = Integer.MAX_VALUE, tmp = 1;
	            int d11 = 0;
	            int d22 = 0;
	            Iterator<Integer> d1i = d1.iterator();
	            Iterator<Integer> d2i = d2.iterator();
	        d11=d1i.next();
	        d22=d2i.next();
	        //System.out.println(d1);
	        //System.out.println(d2);
	        while(true){
	                //System.out.println(d22+"-"+d11);
	            if (d22>d11){
	                tmp = d22-d11;
	                if(tmp<min) min = tmp;
	                if(!d1i.hasNext())
	                    break;
	                else
	                    d11 = d1i.next();
	            }else{
	                tmp = d11-d22;
	                if(tmp<min) min = tmp;
	                if(!d2i.hasNext())
	                    break;
	                else
	                    d22 = d2i.next();
	            }
	            if(Math.abs(d22-d11)==1){
	                return 1;
	            }
	        }
	        return min;
	    }
}
