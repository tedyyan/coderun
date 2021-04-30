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
    	if (x==1) return 1;
    	long l=0,r=x,m=x;
    	while(l<r) {
    		System.out.println("l:"+l+"r:"+r);
    		m = l+(r-l)/2;
    		if (l == r-1) {
    			return  (int)m;
    		}
    		if (m*m == x) {
    			return (int) m;
    		}else if(m*m > x) {
    			r = r - (r-l)/2;
    		}else {
    			l = l + (r-l)/2;
    		}
    	}
		return  (int)m;
        
    }
    public int mySqrtNB(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int)r;
    }
    public double mySqrtWithAcc(int x, double d) {
    	
    	double l=0,r=x,m=0;
    	while(l<r) {
    		m =  l+ (r-l)/2;
    		if ((m*m > (x - d)) && (m*m < (x + d))) {
    			return m;
    		}else if(m*m > x) {
    			r = r - (r-l)/2;
    		}else {
    			l = l + (r-l)/2;
    		}
    	}
		return m;
        
    }
 
    public static void main(String[] args) {
    	P69SQRT p = new P69SQRT();
    	int la = p.mySqrt(2147395599);
    	System.out.println(la);
    	double a = p.mySqrtWithAcc(5,0.000000001);
    	System.out.println(a);
    	double b = a * a;
    	System.out.println(b);
    }
}
