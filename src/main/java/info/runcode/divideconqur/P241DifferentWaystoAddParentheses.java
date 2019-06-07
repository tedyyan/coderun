package info.runcode.divideconqur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P241DifferentWaystoAddParentheses {
//	241. Different Ways to Add Parentheses
//	Medium
//
//	778
//
//	39
//
//	Favorite
//
//	Share
//	Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
//
//	Example 1:
//
//	Input: "2-1-1"
//	Output: [0, 2]
//	Explanation: 
//	((2-1)-1) = 0 
//	(2-(1-1)) = 2
//	Example 2:
//
//	Input: "2*3-4*5"
//	Output: [-34, -14, -10, -10, 10]
//	Explanation: 
//	(2*(3-(4*5))) = -34 
//	((2*3)-(4*5)) = -14 
//	((2*(3-4))*5) = -10 
//	(2*((3-4)*5)) = -10 
//	(((2*3)-4)*5) = 10
	 public List<Integer> diffWaysToCompute(String input) {
	        HashMap<String, List<Integer>> mem = new HashMap<>();
	        return cal(input, mem);
	    }
	    
	    public List<Integer> cal(String input, HashMap<String, List<Integer>> mem){
	        if(mem.containsKey(input)){
	            return mem.get(input);
	        }
	        List<Integer> ops = new ArrayList<>();
	        int len = input.length();
	        for(int i=0;i<len;++i){
	            char c = input.charAt(i);
	            if(c=='+' || c=='-' || c=='*' || c=='/'){
	                ops.add(i);
	            }
	        }
	        List<Integer> res = new ArrayList<>();
	        if(ops.size()==0){
	            res.add(Integer.parseInt(input));
	        }
	        for(int p: ops){
	            char op = input.charAt(p);
	            List<Integer> lefts = cal(input.substring(0, p), mem);
	            List<Integer> rights = cal(input.substring(p+1), mem);
	            for(int l: lefts){
	                for(int r: rights){
	                    switch(op){
	                        case '+':
	                            res.add(l+r);
	                            break;
	                        case '-':
	                            res.add(l-r);
	                            break;
	                        case '*':
	                            res.add(l*r);
	                            break;
	                        case '/':
	                            res.add(l/r);
	                            break;
	                    }
	                }
	            }
	        }
	        mem.put(input, res);
	        return res;
	        
	    }
}
