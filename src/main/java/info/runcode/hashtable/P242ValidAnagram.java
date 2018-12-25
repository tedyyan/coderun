package info.runcode.hashtable;

import java.util.Hashtable;

public class P242ValidAnagram {
//242. Valid Anagram
	
//	Given two strings s and t , write a function to determine if t is an anagram of s.
//
//	Example 1:
//
//	Input: s = "anagram", t = "nagaram"
//	Output: true
//	Example 2:
//
//	Input: s = "rat", t = "car"
//	Output: false
	
    public boolean isAnagram(String s, String t) {
    	if ((s==null)||(t==null)||s.length()!=t.length())
    	{
    		return false;
    	}
    	int[] ss = new int[26];
    	
    	java.util.Arrays.fill(ss,0);
    	
    	for (int i=0;i<s.length();i++) {    		
    		int t1 = s.charAt(i)-'a';
            if ((t1<0)||(t1>=26)){
                return false;
            }
    		ss[t1]+=1;
    	}
    	
    	for (int i=0;i<t.length();i++) {
    		int t1 = t.charAt(i)-'a';
            if ((t1<0)||(t1>=26)){
                return false;
            }
    		ss[t1]-=1;
    		if (ss[t1]<0) return false;
    	}
    	
    	for (int i=0;i<26;i++) {
    		if (ss[i]!=0)
    			return false;
    	}
    	
		return true;
        
    }
    
    public static void main(String[] args) {
    	P242ValidAnagram p = new P242ValidAnagram();
		 String a = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
		 String b = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
		 System.out.println(p.isAnagram(a,b));
		 
	 }
}
