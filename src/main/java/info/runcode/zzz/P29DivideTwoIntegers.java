package info.runcode.zzz;

public class P29DivideTwoIntegers {
//	29. Divide Two Integers
//	Medium
//
//	528
//
//	2527
//
//	Favorite
//
//	Share
//	Given two integers dividend and divisor, divide two integers without using multiplication, 
//	division and mod operator.
//
//	Return the quotient after dividing dividend by divisor.
//
//	The integer division should truncate toward zero.
//
//	Example 1:
//
//	Input: dividend = 10, divisor = 3
//	Output: 3
//	Example 2:
//
//	Input: dividend = 7, divisor = -3
//	Output: -2
//	Note:
//
//	Both dividend and divisor will be 32-bit signed integers.
//	The divisor will never be 0.
//	Assume we are dealing with an environment which could only store integers within the 32-bit signed 
//integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function 
//returns 231 − 1 when the division result overflows.
	
	public int divideOptimize(int dividend, int divisor) {
		int flag = 1;
        if (divisor==-1) {
        	if(dividend== Integer.MIN_VALUE)
        	{
        		return Integer.MAX_VALUE;
        	}
        	return -dividend;
        }
        if (divisor== 1) {
        	return dividend;
        }
        
		if (dividend == 0) {
			return 0;
		}
		
		
		if ((dividend < 0)&&(divisor>0)) {
			divisor = - divisor;
			flag = -1;
		}
		
		if ((dividend > 0)&&(divisor<0)) {
			divisor = - divisor;
			flag = -1;
		}
		
        int i = 0;
        int j = 0;
        int preDividend = dividend;
        while (sameFuhao(preDividend,dividend)) {
        	int divisortmp = divisor;
        	j = 0;
        	int pre = 0;
        	while(Math.abs(dividend)>Math.abs(divisortmp)) {
        		pre = divisortmp;
        		divisortmp = divisortmp<<1;
        		j++;
        		if (!sameFuhao(pre,divisortmp)) {
        			break;
        		}
        	}
        	if (j-1 > 0) {
            	i = i + (1<<(j-1));
            	preDividend = dividend;
        		dividend = dividend - pre;
        	}
        	if (dividend == 0) {
        		break;
        	}
        	preDividend = dividend;
    		dividend = dividend - divisor;
        	if (dividend == 0) {
        		i++;
        		break;
        	}
    		if (sameFuhao(preDividend,dividend)) i++;
        }
        
        return Math.abs(i)*flag;
    }
	
	boolean sameFuhao(int a, int b) {
		a=  ((1<<31)&a) ;
		b = ((1<<31)&b);
		return a==b;
	}
	
	public int divide(int dividend, int divisor) {
        int flag = 1;
		if (((divisor >0)&&( dividend < 0))||((divisor <0)&&( dividend > 0))) {
			flag = -1;
		}
        if (divisor==-1) {
        	if(dividend== Integer.MIN_VALUE)
        	{
        		return Integer.MAX_VALUE;
        	}
        	return -dividend;
        }
		if (dividend == 0) {
			return 0;
		}
		if (dividend < 0) {
			dividend = - dividend;
		}
		if (divisor < 0) {
			divisor = - divisor;
		}
        dividend = dividend - divisor;
        int i = 0;
        while (dividend>=0) {
        	i++;
        	dividend = dividend - divisor;
        }
        
        return i * flag;
    }
	public static void main(String[] args) {
		P29DivideTwoIntegers p = new P29DivideTwoIntegers();
		System.out.println(p.divideOptimize(-2147483648,2));
	}
	public static void main1(String[] args) {
		P29DivideTwoIntegers p = new P29DivideTwoIntegers();
		long t = System.currentTimeMillis();
		System.out.println(p.divide(10, 3));
		System.out.println(p.divide(-7, 3));
		System.out.println(p.divide(-4, -1));
		System.out.println(p.divide(100, -10));
		System.out.println(p.divide(-2147483648, -1));
		System.out.println(p.divide(2147483647,2));
		System.out.println(p.divideOptimize(-2147483648,2));
		long a = t-System.currentTimeMillis();
		System.out.println("--------a------"+a+"--------------");

		t = System.currentTimeMillis();
		System.out.println(p.divideOptimize(10, 3));
		System.out.println(p.divideOptimize(-7, 3));
		System.out.println(p.divideOptimize(-4, -1));
		System.out.println(p.divideOptimize(100, -10));
		System.out.println(p.divideOptimize(-2147483648, -1));
		System.out.println(p.divideOptimize(2147483647,2));
		System.out.println(p.divideOptimize(-2147483648,2));
		a = t-System.currentTimeMillis();
		System.out.println("--------b------"+a+"--------------");
	}
}
