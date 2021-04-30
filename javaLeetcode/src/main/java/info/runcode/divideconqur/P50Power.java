package info.runcode.divideconqur;


public class P50Power {
    public double myPow(double x, int n) {
    	double xm = x;
    	long m = n;
    	double p = 1;
    	if (n<0) m = -((long)n);
    	while(m>0) {
    		if ((m & 0x1) == 1) {
    			p = p * xm;
    		}
    		xm = xm * xm;
    		if (xm == Double.POSITIVE_INFINITY) {
    			p = Double.POSITIVE_INFINITY;
    			break;
    		}
    		m=m>>1;
    	}
    	if (n<0) p = 1/p;
		return p;
        
    }
    
    public double bruceS(double x, int n) {
    
    	double r = 1;
    	long m = n;
    	if (n<0) m = -1*((long)n);
		while (m>0) {
    		r =r*x;
    		if (r == Double.POSITIVE_INFINITY) {
    			break;
    		}
    		m=m-1;
    	}
		if (n<0) r = 1/r;
    	return r;
    }
    
    public static void main(String[] args) {
    	P50Power p = new P50Power();
    	double p1 =2;
    	System.out.println(Integer.MIN_VALUE * -1);
		 int p2 = Integer.MIN_VALUE;
		 //int p2 = Integer.MAX_VALUE;
		 System.out.println(p.myPow(p1,p2));
		 System.out.println(p.bruceS(p1,p2));
		 
	 }
}
