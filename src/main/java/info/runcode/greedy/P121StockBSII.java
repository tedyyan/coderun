package info.runcode.greedy;

public class P121StockBSII {
//	122. Best Time to Buy and Sell Stock II
//	Easy
//
//	711
//
//	1086
//
//	Favorite
//
//	Share
//	Say you have an array for which the ith element is the price of a given stock on day i.
//
//	Design an algorithm to find the maximum profit. You may complete as many transactions as you like
	//(i.e., buy one and sell one share of the stock multiple times).
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
	public int maxProfit(int[] n) {
			if ((n==null)||(n.length<2)) {
				return 0;
			}
			int tm =0;
			int before = n[0];
			int maxToNow = n[0];
			int minToNow = n[0];
			int max = 0;
			for(int i=0;i<n.length;i++) {
				if (max==0) {
					if (n[i]>before) {
						max= n[i] - minToNow;						
						maxToNow = n[i];
					}else {
						minToNow = n[i];
						maxToNow = n[i];
					}
				}else {
					if (n[i]>before) {	
						maxToNow = n[i];
					}else {
						max= maxToNow - minToNow;
						tm = tm + max;
						minToNow = n[i];
						maxToNow = n[i];
						max = 0;
					}
				}
				before = n[i];
			}
			tm += (maxToNow - minToNow);
			return tm;        
		
	}
	 public static void main(String[] args) {
		 P121StockBSII p = new P121StockBSII();
		 int[] input = new int[] {1,200,100,1000}; //9,8,7,6,5  3,2,1,0,4 2,7,9,3,1 2,3,2 2,10,1,2,19,2,1
		 System.out.println(p.maxProfit(input));
		 
	 }
}
