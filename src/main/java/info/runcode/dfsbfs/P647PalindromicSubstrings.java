package info.runcode.dfsbfs;

public class P647PalindromicSubstrings {
	public static void main(String[] args) {
		P647PalindromicSubstrings a =new P647PalindromicSubstrings();
		System.out.println(a.countSubstrings("abccba"));
		System.out.println(a.countSubstrings2("abccba"));
	}

	public int countSubstrings2(String s) {
        int len = s.length();
        //int[][] a = new int[len][len];
        int sum = 0;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                System.out.println(s.substring(i,j+1) + " "+isPalindromic(s,i,j));
                sum+=isPalindromic(s,i,j);
            }
        }
        return sum;
    }
    
    int isPalindromic(String strm,int start, int end){
        
                //System.out.println("start:"+start+"end:"+end);
        for(int i=start,j=end;i<=j;i++,j--){
            if(strm.charAt(i) != strm.charAt(j)){
                return 0;
            }
        }
        return 1;
    }
    
    
    public int countSubstrings(String s) {
    	int sum  = 0;
    	for(int i=0;i<s.length();i++) {
    		sum++;
    		sum+=splitCal(s,i-1,i+1);
    		sum+=splitCal(s,i,i+1);
    	}
    	return sum;
    }
    
    public int splitCal(String s, int start, int end) {
    	int sum=0;
    	while(true)
    	{
        	if(start<0) return sum;
    		if(end>s.length()-1) return sum;
    		if (s.charAt(start) == s.charAt(end)) {
    			sum++;
    		}else {
    			return sum;
    		}
    		start--;end++;
    	}
    	
    }
}
