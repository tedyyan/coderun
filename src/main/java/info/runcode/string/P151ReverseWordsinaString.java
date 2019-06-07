package info.runcode.string;

public class P151ReverseWordsinaString {
//	151. Reverse Words in a String
//	Medium
//
//	464
//
//	2133
//
//	Favorite
//
//	Share
//	Given an input string, reverse the string word by word.
//
//	 
//
//	Example 1:
//
//	Input: "the sky is blue"
//	Output: "blue is sky the"
//	Example 2:
//
//	Input: "  hello world!  "
//	Output: "world! hello"
//	Explanation: Your reversed string should not contain leading or trailing spaces.
//	Example 3:
//
//	Input: "a good   example"
//	Output: "example good a"
//	Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
	
	public String reverseWords(String s) {
		StringBuffer b = new StringBuffer();
        for(int i=s.length();i>=0;i--){
            b.append(s.charAt(i));  
        }
        int start=-1;
        int end = -1;
        StringBuffer result = new StringBuffer();
        for(int i=0;i<s.length();i++){
        	if((start==-1)&&(b.charAt(i)!=' ')) start = i;
        	if((start!=-1)&&(b.charAt(i)==' ')) end = i-1; 
        	if(b.charAt(i)==0) {
        		start = -1;
        		end = -1;
        	}
        	reverseWord(s,start,end);
        	result.append(b);
        	result.append(" ");
        }
        return result.substring(0, result.length()-1);
    }
	
	private String reverseWord(String w, int s, int end) {
		StringBuffer b = new StringBuffer();
		for(int i=end;i>=s;i--){
            b.append(w.charAt(end));
        }
		return w.substring(0, s) + b.toString() + w.substring(end+1);
	}
}
