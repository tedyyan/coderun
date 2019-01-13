package info.runcode.dp.stock;

public class P122StockBSII {
//	122. Best Time to Buy and Sell Stock II
//	Easy
//
//	748
//
//	1129
//
//	Favorite
//
//	Share
//	Say you have an array for which the ith element is the price of a given stock on day i.
//
//	Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
//
//	Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
//
//	Example 1:
//
//	Input: [7,1,5,3,6,4]
//	Output: 7
//	Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
//	             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
//	Example 2:
//
//	Input: [1,2,3,4,5]
//	Output: 4
//	Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
//	             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
//	             engaging multiple transactions at the same time. You must sell before buying again.
//	Example 3:
//
//	Input: [7,6,4,3,1]
//	Output: 0
//	Explanation: In this case, no transaction is done, i.e. max profit = 0.
//	Accepted
//	274,800
//	Submissions
//	546,100
	public int maxProfit(int[] p) {

		// 0: ²»Âò²»Âô
		// 1: Âò
		// 2: Âô

		int[][] ran = new int[p.length][3];

		ran[0][0] = 0;
		ran[0][1] = -p[0];
		ran[0][2] = 0;

		int max = 0;
		for (int i = 1; i < p.length; i++) {
			// 0: ²»Âò²»Âô
			ran[i][0] = ran[i - 1][0];
			// 1: Âò
			ran[i][1] = ran[i - 1][1] > ran[i - 1][0] - p[i] ? ran[i - 1][1] : ran[i - 1][0] - p[i];
			// 2: Âô
			ran[i][2] = ran[i - 1][1] + p[i];
			
			max = max(max, ran[i][0], ran[i][1], ran[i][2]);

		}
		
		
		return max;
	}

	public int max(int i, int j, int k, int m) {
		int tmp = i;
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
		P122StockBSII p = new P122StockBSII();
		int[] a = {7,1,5,3,6,4 }; // 7,1,5,3,6,4  7,6,4,3,1 20,10,3,13,9 3,3,5,0,0,3,1,4
		System.out.print(p.maxProfit(a));
	}
}
