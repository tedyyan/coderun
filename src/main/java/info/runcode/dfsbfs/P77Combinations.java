package info.runcode.dfsbfs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

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
		if (n<k) {
			return new ArrayList<List<Integer>>();
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Stack<Integer> r = new Stack<Integer>();
		dps(1,n,k,r,result);
		return result;        
    }
	
	private void  dps(int start, int n,int k,Stack<Integer> r,List<List<Integer>> result) {
		if(k==0) {
			result.add((List<Integer>) r.clone());
		}
		for(int i=start;i<=n;i++) {
			r.push(i);
			dps(i+1,n,k-1,r,result);
			r.pop();
		}
	}
	
	public static void main(String[] args) {
		P77Combinations p = new P77Combinations();
		int nums = 4;
		int cunt = 2;
		List<List<Integer>> r = p.combine(nums , cunt );
		int i = 0;
		for (List<Integer> element:r) {
			for(Integer ee : element) {
				System.out.print(ee);
				System.out.print(" ");
			}
			System.out.println();
			i++;
		}
		System.out.println(i);
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
