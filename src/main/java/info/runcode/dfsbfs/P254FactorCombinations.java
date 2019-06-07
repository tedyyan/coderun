package info.runcode.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class P254FactorCombinations {
//	254. Factor Combinations
//	Medium
//
//	357
//
//	16
//
//	Favorite
//
//	Share
//	Numbers can be regarded as product of its factors. For example,
//
//	8 = 2 x 2 x 2;
//	  = 2 x 4.
//	Write a function that takes an integer n and return all possible combinations of its factors.
//
//	Note:
//
//	You may assume that n is always positive.
//	Factors should be greater than 1 and less than n.
//	Example 1:
//
//	Input: 1
//	Output: []
//	Example 2:
//
//	Input: 37
//	Output:[]
//	Example 3:
//
//	Input: 12
//	Output:
//	[
//	  [2, 6],
//	  [2, 2, 3],
//	  [3, 4]
//	]
//	Example 4:
//
//	Input: 32
//	Output:
//	[
//	  [2, 16],
//	  [2, 2, 8],
//	  [2, 2, 2, 4],
//	  [2, 2, 2, 2, 2],
//	  [2, 4, 4],
//	  [4, 8]
//	]
	
	/*
	 * Details 
Runtime: 1 ms, faster than 88.05% of Java online submissions for Factor Combinations.
Memory Usage: 32.8 MB, less than 100.00% of Java online submissions for Factor Combinations.
Next challenges:
	 */
	public List<List<Integer>> getFactors(int n) {
        ArrayList<Integer> usedfactor = new ArrayList<Integer>();
       
         List<List<Integer>> result = new  ArrayList<List<Integer>> ();
        /*
         for(int i=2;i<=Math.sqrt(n);i++){
             while(n%i==0){
                 n = n / i;
                 factors.add(i);
                 if (n==1) break;
             }
         }
         */
        dfs(2,n,usedfactor,result);
        return result;
         
    }
    
    void dfs(int from,int total,List<Integer> usedfactor,List<List<Integer>> result){
       
        for(int i=from;i*i<=total;i++){
            if(total%i==0){
                List<Integer> res = new ArrayList<Integer>();
                res.addAll(usedfactor);
                res.add(i);
                res.add(total/i);
                result.add(res);
                List<Integer> userfactorcopy = new ArrayList<Integer>();
                for(Integer e:usedfactor) userfactorcopy.add(e);
                userfactorcopy.add(i);
                dfs(i,total/i,userfactorcopy,result);
            }
        }
        return ;
    }
    
    boolean isPrime(int num){

        String aabb="";
        char c='a';
        aabb.indexOf(c);
        
    if (num > 0) {
			int k = (int) Math.sqrt(num);//k为num的正平方根，取整数
			for (int i = 2; i <= k; i++) {
				if (num % i == 0) {
					
                   return false;
				}
			}
		}
        return true;
    }
}
