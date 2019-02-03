package info.runcode.dfsbfs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class P77Combinations {
//	77. Combinations
//	Medium
//
//	625
//
//	37
//
//	Favorite
//
//	Share
//	Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
//	Example:
//
//	Input: n = 4, k = 2
//	Output:
//	[
//	  [2,4],
//	  [3,4],
//	  [2,3],
//	  [1,2],
//	  [1,3],
//	  [1,4],
//	]
	
	public List<List<Integer>> combine(int n, int k) {
		
		
		return null;        
    }
	
	private List<List<Integer>>  dpsSlow(int n,int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if (k==1) {			
			for(int i=1;i<=n;i++) {
				List<Integer> t = new ArrayList<Integer>();
				t.add(i);
				result.add(t);
			}
			return result;
		}
		List<List<Integer>> r = dpsSlow(n,k-1);
		Iterator<List<Integer>>  it = r.iterator();
		while(it.hasNext()) {
			for(int i=1;i<=n;i++) {
				List<Integer> a = it.next();
				if (-1==a.indexOf(i))
					a.add(i);
			}
		}
		return result;
		
	}
	
	
}
