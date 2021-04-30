package info.runcode.dp.stock;

public class P121BestTimeToBuyAndSellStock {
//	121. Best Time to Buy and Sell Stock
//	Easy
//
//	2015
//
//	101
//
//	Favorite
//
//	Share
//	Say you have an array for which the ith element is the price of a given stock on day i.
//
//	If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), 
//  design an algorithm to find the maximum profit.
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
		if ((p ==null)||(p.length==0)){
			return 0;
		}
		int[] b = new int[p.length];
		
		b[0] = 0;
		int min = p[0];
		for(int i=1; i< p.length;i++) {
			b[i] = b[i-1] > (p[i] - min) ? b[i-1] : (p[i] - min);
			if(min>p[i]) {
				min = p[i];
			}
		}
		return b[p.length-1];        
    }
	
	public static void main(String[] args) {
		P121BestTimeToBuyAndSellStock p = new P121BestTimeToBuyAndSellStock();
		int[] a = {7,1,5,3,6,4}; // 7,1,5,3,6,4  7,6,4,3,1 20,10,3,13,9
		System.out.print(p.maxProfit(a));
	}
}
