package info.runcode.dp;

import java.util.HashMap;
import java.util.Map;

public class P91DecodeWays {
//	91. Decode Ways
//	Medium
//
//	1139
//
//	1343
//
//	Favorite
//
//	Share
//	A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//	'A' -> 1
//	'B' -> 2
//	...
//	'Z' -> 26
//	Given a non-empty string containing only digits, determine the total number of ways to decode it.
//
//	Example 1:
//
//	Input: "12"
//	Output: 2
//	Explanation: It could be decoded as "AB" (1 2) or "L" (12).
//	Example 2:
//
//	Input: "226"
//	Output: 3
//	Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
	
//	Runtime: 2 ms, faster than 68.15% of Java online submissions for Decode Ways.
//	Memory Usage: 34.4 MB, less than 3.09% of Java online submissions for Decode Ways.
	
	public int numDecodings(String s) {
		if ((s==null)||(s.length()<1)||(s.charAt(0)=='0')){
			return 0;
		}
		int index = 0;
		Map<Integer,Integer> c = new HashMap<Integer,Integer>();
		c.put(index, 1);
		index++;
		while(index <s.length()) {
			int value = 0;
			char pre = s.charAt(index-1);
			char cur = s.charAt(index);
			int preprevalue = 0;
			if(index==1) {
				preprevalue = 1;
			}else {
				preprevalue = c.get(index- 2);
			}
			if (cur=='0') {
				if((pre!='1')&&(pre!='2')) {
					return 0;
				}else {
					value = preprevalue;	
				}			
			}else {
				if(((pre!='1')&&(pre!='2')) || ((cur-'0')>6)&& (pre!='1') ) {
					value = c.get(index-1);	
				}else {
					value = c.get(index-1) + preprevalue;	
				}
			}
			c.put(index, value);
			index++;
		}
		return c.get(s.length()-1);
	}
	
	public static void main(String[] args) {
		P91DecodeWays p = new P91DecodeWays();
		String start = "17";
		System.out.println(p.numDecodings(start ));
	}
}
