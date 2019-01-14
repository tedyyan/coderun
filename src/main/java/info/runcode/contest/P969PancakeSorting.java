package info.runcode.contest;

import java.util.ArrayList;
import java.util.List;

public class P969PancakeSorting {
	// 969. Pancake Sorting
	// User Accepted: 262
	// User Tried: 364
	// Total Accepted: 272
	// Total Submissions: 453
	// Difficulty: Medium
	// Given an array A, we can perform a pancake flip: We choose some positive
	// integer k <= A.length, then reverse the order of the first k elements of A.
	// We want to perform zero or more pancake flips (doing them one after another
	// in succession) to sort the array A.
	//
	// Return the k-values corresponding to a sequence of pancake flips that sort A.
	// Any valid answer that sorts the array within 10 * A.length flips will be
	// judged as correct.
	//
	//
	//
	// Example 1:
	//
	// Input: [3,2,4,1]
	// Output: [4,2,4,3]
	// Explanation:
	// We perform 4 pancake flips, with k values 4, 2, 4, and 3.
	// Starting state: A = [3, 2, 4, 1]
	// After 1st flip (k=4): A = [1, 4, 2, 3]
	// After 2nd flip (k=2): A = [4, 1, 2, 3]
	// After 3rd flip (k=4): A = [3, 2, 1, 4]
	// After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted.
	// Example 2:
	//
	// Input: [1,2,3]
	// Output: []
	// Explanation: The input is already sorted, so there is no need to flip
	// anything.
	// Note that other answers, such as [3, 3], would also be accepted.
	//
	//
	// Note:
	//
	// 1 <= A.length <= 100
	// A[i] is a permutation of [1, 2, ..., A.length]
	public List<Integer> pancakeSort(int[] A) {
		List<Integer> r = new ArrayList<Integer>();
		flip(A, A.length-1, r);
		return r;

	}

	public void flip(int[] A, int endi, List<Integer> r) {
		if (endi == 0) {
			return;
		}
		int i = SearchMax(A,endi);
		if (i == endi) {
			
		}else {
			if (i!=0) {
				switchArray(A, 0, i);
				r.add(i+1);
			}	
	
			if ((endi==1)&&(i==1)) {
				return;
			}
			switchArray(A, 0, endi);
			
			r.add(endi+1);
		}
		flip(A, endi - 1, r);
	}

	private void switchArray(int[] A, int i, int i2) {
		for (int j = 0; j <= i2 / 2; j++) {
			int t = A[j];
			A[j] = A[i2 - j];
			A[i2 - j] = t;
		}
		for (int ij=0;ij<A.length;ij++)
			System.out.print(A[ij]);
		System.out.println();
	}

	public int SearchMax(int[] A, int endi) {
		if (A.length == 0) {
			return 0;
		}

		int maxi = 0;
		int max = A[0];
		for(int i=0;i<=endi;i++) {
			if (A[i] > max) {
				maxi = i;
				max = A[i];
			}
		}
		return maxi;
	}
	
	public static void main(String[] args) {
		int[] in = {3,2,4,1}; //3,2,4,1,5 1,2,3
		P969PancakeSorting p = new P969PancakeSorting();
		System.out.println(p.pancakeSort(in));
	}
}
