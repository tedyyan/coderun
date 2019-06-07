package info.runcode.trackback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class P131PalindromePartitioning {
	
	public static void main(String[] args) {
		P131PalindromePartitioning a =new P131PalindromePartitioning();
		System.out.println(a.partition("abccba"));
	}
	
	public List<List<String>> partition(String s) {
		List<List<String>> result = new LinkedList<List<String>>();
		LinkedList<String> rr = new LinkedList<String>();
		helper(s,0,rr,result);
		return  result;
    }

    void helper(String s,int start, LinkedList<String> rr,List<List<String>> result){
        if(start == s.length()){
        	LinkedList<String> a = (new LinkedList<String>(rr));
        	Collections.reverse(a);
            result.add(a);
        }
        for(int i=0;i<s.length()-start;i++){
            if(isPalindromic(s,start,start+i) == 1){
                String tmp = s.substring(start,start+i+1);
				rr.push(tmp);
                helper(s,start+i+1,rr,result);
                rr.pop();
            }
        }
    }

    int isPalindromic(String strm,int start, int end){
        for(int i=start,j=end;i<=j;i++,j--){
            if(strm.charAt(i) != strm.charAt(j)){
                return 0;
            }
        }
        return 1;
    }
}
