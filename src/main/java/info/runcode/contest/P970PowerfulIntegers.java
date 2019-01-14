package info.runcode.contest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class P970PowerfulIntegers {
//	970. Powerful Integers
//	User Accepted: 0
//	User Tried: 0
//	Total Accepted: 0
//	Total Submissions: 0
//	Difficulty: Easy
//	Given two non-negative integers x and y, an integer is powerful if it is equal to x^i + y^j for some integers i >= 0 and j >= 0.
//
//	Return a list of all powerful integers that have value less than or equal to bound.
//
//	You may return the answer in any order.  In your answer, each value should occur at most once.
//
//	 
//
//	Example 1:
//
//	Input: x = 2, y = 3, bound = 10
//	Output: [2,3,4,5,7,9,10]
//	Explanation: 
//	2 = 2^0 + 3^0
//	3 = 2^1 + 3^0
//	4 = 2^0 + 3^1
//	5 = 2^1 + 3^1
//	7 = 2^2 + 3^1
//	9 = 2^3 + 3^0
//	10 = 2^0 + 3^2
//	Example 2:
//
//	Input: x = 3, y = 5, bound = 15
//	Output: [2,4,6,8,10,14]
//	 
//
//	Note:
//
//	1 <= x <= 100
//	1 <= y <= 100
//	0 <= bound <= 10^6
	
	 public List<Integer> powerfulIntegers(int x, int y, int bound) {
		
		 
		 Set<Integer> r = new TreeSet<Integer>();
		 if ((x<1)||(y<1)||(bound<1)) {
			 return new ArrayList<Integer>();
		 }
		 Map<Integer,Integer> mapy = new HashMap<Integer,Integer>();
		 int lx = 0;
		 int ly = 0;
		 for(int i=0;(lx + ly)<=bound;i++) {			 
			 lx = (int) Math.pow(x,i);
			 for(int j=0;(lx + ly)<=bound;j++) {
				 if (y==1) {
					 ly = 1;
					 if ((lx + ly)<=bound) {
						 r.add(lx + ly);					 
					 }
					 break;
				 }else {
					 ly = 0;
					 Integer o = mapy.get(j);
					 if (o == null) {
						 ly = (int) Math.pow(y,j);
						 mapy.put(j, ly);
					 }else {
						 ly = o;
					 }
				 }
				 
				 if ((lx + ly)<=bound) {
					 r.add(lx + ly);					 
				 }
			 }
			 if (x==1)
				 break;
			 ly = 0;
		 }
		 Integer[] b = new Integer[r.size()];
		 b = r.toArray(b);
		 return Arrays.asList(b);		 
	 }
	 
	 public static void main(String[] args) {
		 P970PowerfulIntegers p = new P970PowerfulIntegers();
		 System.out.println(p.powerfulIntegers(2, 3, 1000));
	 }
}
