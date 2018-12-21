package info.runcode.tree.dfs1bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P22GenerateParentheses{
	
//	22. Generate Parentheses
//	Medium
//
//	2058
//
//	133
//
//	Favorite
//
//	Share
//	Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//	For example, given n = 3, a solution set is:
//
//	[
//	  "((()))",
//	  "(()())",
//	  "(())()",
//	  "()(())",
//	  "()()()"
//	]
	
	public List<String> generateParenthesis(int n) {
		
		List<String> r = new LinkedList<String>();
		String result = "";
		fillin(n,result,0,0,r);
		return r;
        
    }
	
	void fillin(int n,  String result,int left, int right,List<String> r) {
		if ((left==n)&&(right==n)) {
			r.add(result);
			return;
		}
		if (left<n) {
			System.out.println("************left:"+left+" right:"+right+ result);
			fillin(n,result+"(",left+1,right,r);
			System.out.println("after left  left:"+left+" right:"+right+ result);
		}
		if ((left>right)&&(right<n)) {
						
			System.out.println("------------left:"+left+" right:"+right + result);
			fillin(n,result+")",left,right+1,r);
			System.out.println("after right left:"+left+" right:"+right+ result);
		}
	}
	
	public static void main(String[] args) {
		P22GenerateParentheses p = new P22GenerateParentheses();
		 List<String> bb = p.generateParenthesis(3);
		 System.out.println(Arrays.toString(bb.toArray()));
	}
}
