package info.runcode.string;

public class P516LongestPalindromicSubsequence {
//	516. Longest Palindromic Subsequence
//	Medium
//
//	750
//
//	103
//
//	Favorite
//
//	Share
//	Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
//
//	Example 1:
//	Input:
//
//	"bbbab"
//	Output:
//	4
//	One possible longest palindromic subsequence is "bbbb".
//	Example 2:
//	Input:
//
//	"cbbd"
//	Output:
//	2
//	One possible longest palindromic subsequence is "bb".
	
	/*
	 * 
	 * Runtime: 24 ms, faster than 72.38% of Java online submissions for Longest Palindromic Subsequence.
	 * Memory Usage: 35.7 MB, less than 80.95% of Java online submissions for Longest Palindromic Subsequence.
	 * 
	 */
	public int longestPalindromeSubseq(String s) {
		int p[][] = new int[s.length()][s.length()];
		
		for(int i=0;i<s.length();i++) {	
			p[i][i] = 1;
			for(int j=i-1;j>=0;j--) {				
				if(s.charAt(j)==s.charAt(i)) {
					if ((j+1)==i) {
						p[j][i] = p[j][i-1] + 1;
						
					}else {
						p[j][i] = p[j+1][i-1] + 2;
					}					
				}else {
					p[j][i] = p[j+1][i]>p[j][i-1]?p[j+1][i]:p[j][i-1];
				}
			}
		}
		
		return p[0][s.length()-1];
		
        
    }
	/*
	 * 
	 * Runtime: 30 ms, faster than 48.26% of Java online submissions for Longest Palindromic Subsequence.
	 * Memory Usage: 35.6 MB, less than 80.95% of Java online submissions for Longest Palindromic Subsequence.
	 * 
	 */
	 public int longestPalindromeSubseq2(String s) {
	        int p[][] = new int[s.length()][s.length()];
		
			for(int i=0;i<s.length();i++) {	
				for(int j=i;j>=0;j--) {
					if (i==j) {
						p[i][j] = 1;
						continue;
					}
					if(s.charAt(j)==s.charAt(i)) {
						if ((j+1)==i) {
							p[j][i] = p[j][i-1] + 1;
							
						}else {
							p[j][i] = p[j+1][i-1] + 2;
						}					
					}else {
						p[j][i] = p[j+1][i]>p[j][i-1]?p[j+1][i]:p[j][i-1];
					}
				}
			}
			
			return p[0][s.length()-1];
	    }
	
	
	public static void main(String[] args) {
		P516LongestPalindromicSubsequence p = new P516LongestPalindromicSubsequence();
		String in = "cccdbccccd"; //cbbd bbbab cdbccccd cbbdcccd
		System.out.println(p.longestPalindromeSubseq(in));
	}
}
