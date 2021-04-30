package info.runcode.bit;

public class P231PowerOfTwo {

//	231. Power of Two
//	Easy
//
//	355
//
//	96
//
//	Favorite
//
//	Share
//	Given an integer, write a function to determine if it is a power of two.
//
//	Example 1:
//
//	Input: 1
//	Output: true 
//	Explanation: 20 = 1
//	Example 2:
//
//	Input: 16
//	Output: true
//	Explanation: 24 = 16
//	Example 3:
//
//	Input: 218
//	Output: false
	
	public boolean isPowerOfTwo2(int n) {
		
		return (n>0)&&((n & (-n)) == n);
        
    }
	
	public boolean isPowerOfTwo(int n) {
		
		return (n>0)&&((n&(n-1))==0);
        
    }

	 public static void main(String[] args) {
		 P231PowerOfTwo p = new P231PowerOfTwo();
		 int org = -2147483648;
		 int x = (int) (org);
		 String ab1 = String.format("%X",org);
		 System.out.println(ab1);
		 String ab = String.format("%X",x);
		 System.out.println(ab);
		 System.out.println(p.isPowerOfTwo(x));
		 System.out.println(p.isPowerOfTwo(-8));
		 System.out.println(p.isPowerOfTwo(1));
		 System.out.println(p.isPowerOfTwo(1024));
	 }
}
