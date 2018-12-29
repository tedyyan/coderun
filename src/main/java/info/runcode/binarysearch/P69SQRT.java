package info.runcode.binarysearch;

public class P69SQRT {
	
//	69. Sqrt(x)
//	Easy
//
//	587
//
//	1082
//
//	Favorite
//
//	Share
//	Implement int sqrt(int x).
//
//	Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
//
//	Since the return type is an integer, the decimal digits are truncated and only the integer 
//	part of the result is returned.
//
//	Example 1:
//
//	Input: 4
//	Output: 2
//	Example 2:
//
//	Input: 8
//	Output: 2
//	Explanation: The square root of 8 is 2.82842..., and since 
//	             the decimal part is truncated, 2 is returned.
	
    public int mySqrt(int x) {
    	
    	int l=0,r=x,m=0;
    	while(l<r) {
    		m = l+(r-l)/2;
    		if (m*m == x) {
    			return m;
    		}else if(m*m > x) {
    			r = r - m;
    		}else {
    			l = l + m;
    		}
    	}
		return m;
        
    }
    
    public double mySqrtWithAcc(int x, double d) {
    	
    	double l=0,r=x,m=0;
    	while(l<r) {
    		m = l+(r-l)/2;
    		if ((m*m > (x - d)) && ((m*m < (x + d)) {
    			return m;
    		}else if(m*m > x) {
    			r = r - m;
    		}else {
    			l = l + m;
    		}
    	}
		return m;
        
    }
 
    public static void main(String[] args) {
    	P69SQRT p = new P69SQRT();
    	double a = p.mySqrtWithAcc(10,0.0001);
    	System.out.println(a);
    	double b = a * a;
    	System.out.println(b);
    }
}
