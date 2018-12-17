package info.runcode.greedy;

public class P121StockBS {
//	121. Best Time to Buy and Sell Stock
//	Easy
//
//	1915
//
//	94
//
//	Favorite
//
//	Share
//	Say you have an array for which the ith element is the price of a given stock on day i.
//
//	If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
//
//	Note that you cannot sell a stock before you buy one.
//
//	Example 1:
//
//	Input: [7,1,5,3,6,4]
//	Output: 5
//	Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//	             Not 7-1 = 6, as selling price needs to be larger than buying price.
//	Example 2:
//
//	Input: [7,6,4,3,1]
//	Output: 0
//	Explanation: In this case, no transaction is done, i.e. max profit = 0.
	public int maxProfit(int[] p) {
		if ((p==null)||(p.length<2)) {
			return 0;
		}
		int minToNow = p[0];
		int maxv = 0;
		for(int i=0;i<p.length;i++) {
			int t = p[i]-minToNow;
			if (t>maxv) {
				maxv = t;
			}
			if (p[i]<minToNow) {
				minToNow = p[i];
			}
		}
		return maxv;        
    }
	
	 public static void main(String[] args) {
		 P121StockBS p = new P121StockBS();
		 int[] input = new int[] {6,5,3,20,1}; //2,3,1,1,4  3,2,1,0,4 2,7,9,3,1 2,3,2  2,10,1,2,19,2,1
		 System.out.println(p.maxProfit(input));
		 
	 }
}
