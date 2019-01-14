package info.runcode.dp.stock;

public class P188StockBSIV {
	/*
	 * 188. Best Time to Buy and Sell Stock IV Hard
	 * 
	 * 576
	 * 
	 * 43
	 * 
	 * Favorite
	 * 
	 * Share Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete at most k
	 * transactions.
	 * 
	 * Note: You may not engage in multiple transactions at the same time (ie, you
	 * must sell the stock before you buy again).
	 * 
	 * Example 1:
	 * 
	 * Input: [2,4,1], k = 2 Output: 2 Explanation: Buy on day 1 (price = 2) and
	 * sell on day 2 (price = 4), profit = 4-2 = 2. Example 2:
	 * 
	 * Input: [3,2,6,5,0,3], k = 2 Output: 7 Explanation: Buy on day 2 (price = 2)
	 * and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price =
	 * 0) and sell on day 6 (price = 3), profit = 3-0 = 3. Accepted 77,187
	 * Submissions 300,246
	 */
	
	 public int maxProfit(int K, int[] p) {
		
		// 最后一维
			// 0:  卖
			// 1:  买

			long[][][] profit = new long[p.length][K+1][2];

			profit[0][0][0] = 0;
			profit[0][0][1] = -p[0];
			for(int j=1;j<=K;j++) {
				profit[0][j][0] = Integer.MIN_VALUE;
				profit[0][j][1] = Integer.MIN_VALUE;
			}
			for(int j=1;j<p.length;j++)
			{
				for(int kk=0;kk<=K;kk++) {
					profit[j][kk][0] = Integer.MIN_VALUE;  //not exist
					profit[j][kk][1] = Integer.MIN_VALUE;  //not exist
				}
			}
				

			long max = 0;
			for (int i = 1; i < p.length; i++) {
				//中间k的含义
				// 0: 之前没做过交易
				for(int kk=0;kk<=K;kk++) {
					if(kk>0)
					{
						profit[i][kk][0] = max2(profit[i-1][kk][0],profit[i-1][kk-1][1] + p[i]);
					}
					profit[i][kk][1] = max2(profit[i-1][kk][1],profit[i-1][kk][0]-p[i]);
					
					// 1:之前做了一个交易
					//profit[i][1][0] = max2(profit[i-1][1][0],profit[i-1][0][1] + p[i]);
					//profit[i][1][1] = max2(profit[i-1][1][1],profit[i-1][1][0] - p[i]);
					// 2: 之前做了两个交易
					//profit[i][2][0] = max2(profit[i-1][2][0],profit[i-1][1][1] + p[i]);
					//profit[i][2][1] = max2(profit[i-1][2][1],profit[i-1][1][1] - p[i]);
					max = max2(profit[i][kk][0],max);
				}

			}
			//int end = p.length-1;
			//max = (int) max3(profit[end][0][0], profit[end][1][0], profit[end][2][0]);
			return (int) max;
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
			P188StockBSIV p = new P188StockBSIV();
			int[] a = {3,3,5,2,10,18,11,14}; // 7,1,5,3,6,4  7,6,4,3,1 20,10,3,13,9 3,3,5,0,0,3,1,4(2)
			System.out.print(p.maxProfit(2,a));
		}
}
