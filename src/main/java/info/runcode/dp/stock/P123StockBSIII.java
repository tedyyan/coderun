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
//	Design an algorithm to find the maximum profit. You may complete at most two transactions.
//
//	Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
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
//	             engaging multiple transactions at the same time. You must sell before buying again.
//	Example 3:
//
//	Input: [7,6,4,3,1]
//	Output: 0
//	Explanation: In this case, no transaction is done, i.e. max profit = 0.
	public int maxProfit(int[] p) {
		int k=2;
		 
		// 0: ²»Âò²»Âô
		// 1: Âò
		// 2: Âô
		
        int[][][] ran = new int[p.length][k][3];
        for(int l=0;l<k;l++) {
            ran[0][l][0]=0;
            ran[0][l][1]=-p[0];  
            ran[0][l][2]=0;          	
        }     
        int max = 0;   
        for(int i=1;i<p.length;i++)
        {
        	for(int j=1;j<k;j++) {
        		// 0: ²»Âò²»Âô
        		ran[i][j][0] = ran[i-1][j][0];
        		// 1: Âò
        		ran[i][j][1] = ran[i-1][j][1]>ran[i-1][j-1][0]-p[i] ? ran[i-1][j][1] : ran[i-1][j-1][0]-p[i];
        		// 2: Âô
        		ran[i][j][2] = ran[i-1][j][2]>ran[i-1][j-1][1]+p[i] ? ran[i-1][j][2] : ran[i-1][j-1][1]+p[i];
        		max = max(ran[i][j][0],ran[i][j][0],ran[i][j][1]);
        	}
        }
        return max;
    }
	public int max(int i, int j, int k) {
		int tmp = i;
		if (i>j) {
			tmp = i;
		}else {
			tmp = j;
		}
		
		if (tmp > k) {
			return tmp;
		}else {
			return k;
		}
	}
	public static void main(String[] args) {
		P123StockBSIII p = new P123StockBSIII();
		int[] a = {3,3,5,0,0,3,1,4}; // 7,1,5,3,6,4  7,6,4,3,1 20,10,3,13,9
		System.out.print(p.maxProfit(a));
	}
}
