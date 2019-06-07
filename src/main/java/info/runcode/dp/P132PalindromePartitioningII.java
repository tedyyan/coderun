package info.runcode.dp;

public class P132PalindromePartitioningII {
	 private boolean[][] matrix;

	 public static void main(String[] args) {
		 P132PalindromePartitioningII a = new P132PalindromePartitioningII();
		 System.out.println(a.minCut("abaabacbbabb"));
	 }
	public int minCut(String s) {
	        int len = s.length();
	        matrix = new boolean[len ][len];
			ffllMax(s);
			int[] dp = new int[len ];
			int mins = 0;
	        for(int j=0;j<s.length();j++){
	        	mins = j+1;
	            for(int i=j;i>=0;i--) {
	            	if(matrix[i][j]) {
	            		if(i==0) {
	            			mins = 1;
	            		}else
	            			mins = mins < dp[i-1] + 1?mins : dp[i-1] + 1;
	            	}
	            }
	            dp[j] =  mins;
	        }
	        return dp[len-1];
	    }

	    
	    public int ffllMax(String s) {
	        int len = s.length();
	        int sum = 0;
	        for(int i=0;i<len;i++){
	            for(int j=i;j<len;j++){            
	                if (1==isPalindromic(s,i,j)){
	                	matrix[i][j]  =  true;
	                }
	            }
	            /*
	            for(int j=0;j<i-1;j++){            
	            
	                    max[i][j]  =  true;
	                }
	            }
	            */
	        }
	        return sum;
	    }
	    
	    int isPalindromic(String strm,int start, int end) {
	        for(int i=start,j=end;i<=j;i++,j--){
	            if(strm.charAt(i) != strm.charAt(j)){
	                return 0;
	            }
	        }
	        return 1;
	    }
}
