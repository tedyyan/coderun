package info.runcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P89GrayCode {
//	89. Gray Code
//	Medium
//
//	304
//
//	1015
//
//	Favorite
//
//	Share
//	The gray code is a binary numeral system where two successive values differ in only one bit.
//
//	Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
//
//	Example 1:
//
//	Input: 2
//	Output: [0,1,3,2]
//	Explanation:
//	00 - 0
//	01 - 1
//	11 - 3
//	10 - 2
//
//	For a given n, a gray code sequence may not be uniquely defined.
//	For example, [0,2,3,1] is also a valid gray code sequence.
//
//	00 - 0
//	10 - 2
//	11 - 3
//	01 - 1
//	Example 2:
//
//	Input: 0
//	Output: [0]
//	Explanation: We define the gray code sequence to begin with 0.
//	             A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
//	             Therefore, for n = 0 the gray code sequence is [0].
	
	  public List<Integer> grayCode(int n) {
 		  List<Integer> result = new ArrayList<Integer>();
		  if (n==0) {
			  result.add(0);
			  return result;
		  }
		  dfs(n,result);
		  return result;	        
	  }
	  
	  void dfs(int n, List<Integer> result) {
		  if(n==1) {
			  result.add(0);
			  result.add(1);
			  return;
		  }
		  
		  List<Integer> tmp = new ArrayList<Integer>();
		  dfs(n-1,result);
		  int f = 0;
		  for(int i=0;i<result.size();i++) {
			  if (f==0) {
				  Integer p = result.get(i);
				  tmp.add((p<<1)+0);
				  tmp.add((p<<1)+1);
				  f = 1;
			  }else {
				  Integer p = result.get(i);
				  tmp.add((p<<1)+1);
				  tmp.add((p<<1)+0);
				  f = 0;
			  }
		  }
		  result.clear();
		  result.addAll(tmp);
	  }
	  
	  public static void main(String[] args) {
		  P89GrayCode p = new P89GrayCode();
		  int n = 3;
		  List<Integer> result = p.grayCode(n );
		  System.out.println(result);
	  }
}
