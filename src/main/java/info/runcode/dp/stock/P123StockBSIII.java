package info.runcode.dp.stock;

public class P123StockBSIII {
//	123. Best Time to Buy and Sell Stock III
//	Hard
//
//	787
//
//	49
//
//	Favorite
//
//	Share
//	Say you have an array for which the ith element is the price of a given stock on day i.
//
//	Design an algorithm to find the maximum profit. You may complete at most two tprofitsactions.
//
//	Note: You may not engage in multiple tprofitsactions at the same time (i.e., you must sell the stock before you buy again).
//
//	Example 1:
//
//	Input: [3,3,5,0,0,3,1,4]
//	Output: 6
//	Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
//	             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
//	Example 2:
//
//	Input: [1,2,3,4,5]
//	Output: 4
//	Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
//	             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
//	             engaging multiple tprofitsactions at the same time. You must sell before buying again.
//	Example 3:
//
//	Input: [7,6,4,3,1]
//	Output: 0
//	Explanation: In this case, no tprofitsaction is done, i.e. max profit = 0.
	public int maxProfit(int[] p) {
		// 最后一维
		// 0:  卖
		// 1:  买

		long[][][] profit = new long[p.length][3][2];

		profit[0][0][0] = 0;
		profit[0][0][1] = -p[0];
		profit[0][1][0] = Integer.MIN_VALUE;  //not exist
		profit[0][1][1] = Integer.MIN_VALUE;  //not exist
		profit[0][2][0] = Integer.MIN_VALUE;  //not exist
		profit[0][2][1] = Integer.MIN_VALUE;  //not exist

		int max = 0;
		for (int i = 1; i < p.length; i++) {
			//中间k的含义
			// 0: 之前没做过交易
			profit[i][0][0] = profit[i-1][0][0];
			profit[i][0][1] = max2(profit[i-1][0][1],profit[i-1][0][0]-p[i]);
			
			// 1:之前做了一个交易
			profit[i][1][0] = max2(profit[i-1][1][0],profit[i-1][0][1] + p[i]);
			profit[i][1][1] = max2(profit[i-1][1][1],profit[i-1][1][0] - p[i]);
			// 2: 之前做了两个交易
			profit[i][2][0] = max2(profit[i-1][2][0],profit[i-1][1][1] + p[i]);
			

		}
		int end = p.length-1;
		max = (int) max3(profit[end][0][0], profit[end][1][0], profit[end][2][0]);
		return max;
	}
	
	public long max2(long i, long j) {
		return i>j?i:j;
	}
	public long max3(long i, long j, long k) {
		long tmp = i;
		if (i > j) {
			tmp = i;
		} else {
			tmp = j;
		}

		if (tmp > k) {

		} else {
			tmp = k;
		}
		return tmp;
	}
	public long max4(long i, long j, long k, long m) {
		long tmp = i;
		if (i > j) {
			tmp = i;
		} else {
			tmp = j;
		}

		if (tmp > k) {

		} else {
			tmp = k;
		}

		if (tmp > m) {
			return tmp;
		} else {
			return m;
		}

	}

	public static void main(String[] args) {
		P123StockBSIII p = new P123StockBSIII();
		int[] a = { 3, 3, 5, 0, 0, 3, 1, 4 }; // 7,1,5,3,6,4 7,6,4,3,1 20,10,3,13,9
		System.out.print(p.maxProfit(a));
	}
}
