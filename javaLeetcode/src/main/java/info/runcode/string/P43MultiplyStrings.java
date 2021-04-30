package info.runcode.string;

import java.util.HashMap;
import java.util.Map;
//43. Multiply Strings
//Medium
//
//827
//
//361
//
//Favorite
//
//Share
//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//
//Example 1:
//
//Input: num1 = "2", num2 = "3"
//Output: "6"
//Example 2:
//
//Input: num1 = "123", num2 = "456"
//Output: "56088"
//Note:
//
//The length of both num1 and num2 is < 110.
//Both num1 and num2 contain only digits 0-9.
//Both num1 and num2 do not contain any leading zero, except the number 0 itself.
//You must not use any built-in BigInteger library or convert the inputs to integer directly.
public class P43MultiplyStrings {
	    public String multiply(String num1, String num2) {
	    	 if (num1.isEmpty() || num2.isEmpty() || num1.equals("0") || num2.equals("0")) {
	             return "0";
	         }
	    	String n1="", n2="";
	    	if (num1.length()>num2.length()) {
	    		n1 = num1;
	    		n2 = num2;
	    	}else {
	    		n1 = num2;
	    		n2 = num1;
	    	}
	    	Map<Integer,String> r = new HashMap<Integer,String>();
	 
	    	for(int i=0;i<10;i++) {
	    		r.put(i, mul(n1,i));
	    	}
	    	String bu = "";
	    	String result = "";
	    	for(int i=n2.length()-1;i>=0;i--) {
	    		char p = n2.charAt(i);
	    		Integer tt = Integer.valueOf(p-'0');
	    		String a = r.get(tt) + bu;
	    		bu = bu + "0";
	    		result = add(a,result);
	    	}
	    	
			return result;
	        
	    }
	    
	    
	    public String mul(String A, int count) {
	    	if (count==0) {
	             return "0";
	    	}
	    	byte[] tmp = A.getBytes();
	    	byte[] result = new byte[A.length()+1];
	    	int j = 0;
	    	for(int k=tmp.length-1;k>=0;k--) {
	    		byte b = tmp[k];
	    		int t =  b - '0';
	    		int r = t * count + j;
	    		int g = r%10;
	    		j = r/10;
	    		result[k+1]= (byte) (g + '0');
	    	}
	    	String r1 = "";
	    	if (j!=0) {
	    		result[0] = (byte) (j + '0');
	    		r1 = new String(result);
	    	}else {
	    		result[0] = 0;
	    		r1 = (new String(result)).substring(1,result.length);
	    	}
			return r1;
	    	
	    }
	    
	    public String add(String a, String b) {
	    	if (a.length()==0) {
	    		return b;
	    	}
	    	if (b.length()==0) {
	    		return a;
	    	}
	    	int l = a.length()>b.length()?a.length():b.length();
	    	int j = 0;
	    	byte aa=0,bb=0;
	    	byte[] result = new byte[l + 1];
	    	byte[] abytes = a.getBytes();
	    	byte[] bbytes = b.getBytes();
	    	for(int i=0;i<l;i++) {
	    		if (abytes.length-1-i>=0) {
	    			aa = (byte) (abytes[abytes.length-1-i] - '0');
	    		}else {
	    			aa = 0;
	    		}
	    		if (bbytes.length-1-i>=0) {
	    			bb = (byte) (bbytes[bbytes.length-1-i] - '0');
	    		}else {
	    			bb = 0;
	    		}
	    		int sum = aa + bb + j;
	    		int g = sum%10;
	    		j = sum/10;	
	    		result[result.length-1-i]= (byte) (g + '0');
	    	}
	    	
			String r1 = "";
	    	if (j!=0) {
	    		result[0] = (byte) (j + '0');
	    		r1 = new String(result);
	    	}else {
	    		result[0] = 0;
	    		r1 = (new String(result)).substring(1,result.length);
	    	}
			return r1;
	    }
	    
	    public static void main(String[] args) {
	    	P43MultiplyStrings p = new P43MultiplyStrings();
	    	System.out.print(p.multiply("123", "456"));
	    }
}
