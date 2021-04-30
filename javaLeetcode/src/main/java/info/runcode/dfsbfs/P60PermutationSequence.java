package info.runcode.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class P60PermutationSequence {
//	60. Permutation Sequence
//	Medium
//
//	689
//
//	186
//
//	Favorite
//
//	Share
//	The set [1,2,3,...,n] contains a total of n! unique permutations.
//
//	By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
//
//	"123"
//	"132"
//	"213"
//	"231"
//	"312"
//	"321"
//	Given n and k, return the kth permutation sequence.
//
//	Note:
//
//	Given n will be between 1 and 9 inclusive.
//	Given k will be between 1 and n! inclusive.
//	Example 1:
//
//	Input: n = 3, k = 3
//	Output: "213"
//	Example 2:
//
//	Input: n = 4, k = 9
//	Output: "2314"
	public String getPermutation(int n, int k) {
		
		 k--;
	        int mod = 1;
	        List<Integer> list = new ArrayList<>();
	        for (int i = 1; i <= n; ++i) {
	            list.add(i);
	            mod *= i;
	        }
	        StringBuilder sb = new StringBuilder();
	        for (int i = 1; i <= n; ++i) {
	            mod /= (n-i+1);
	            int idx = k/mod;
	            sb.append(list.remove(idx));
	            k = k % mod;
	        }
	        return sb.toString();
		    
    }
	
	
}
