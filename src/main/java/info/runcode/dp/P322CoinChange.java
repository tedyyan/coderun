package info.runcode.dp;

import java.util.Arrays;

public class P322CoinChange {
//	322. Coin Change
//	Medium
//
//	1247
//
//	64
//
//	Favorite
//
//	Share
//	You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
//
//	Example 1:
//
//	Input: coins = [1, 2, 5], amount = 11
//	Output: 3 
//	Explanation: 11 = 5 + 5 + 1
//	Example 2:
//
//	Input: coins = [2], amount = 3
//	Output: -1
//	Note:
//	You may assume that you have an infinite number of each kind of coin.
	public int coinChange(int[] coins, int amount) {
		if (amount <= 0)
			return 0;
		if ((coins == null) || (coins.length == 0)) {
			return 0;
		}
		
		int[] r = new int[amount+1];
		r[0] = 0;
		for(int i=1;i<=amount;i++) {
			int minc = Integer.MAX_VALUE;
			for(int j=0;j<coins.length;j++) {
				int tt = i - coins[j];				
				if ((tt>=0) && r[tt] != -1 && (1 + r[tt] < minc)) {
					minc = 1 + r[tt];
				}
			}
			r[i] = (minc== Integer.MAX_VALUE? -1:minc);
		}
		return r[amount];
        
    }
	
	public static void main(String[] args) {
		P322CoinChange p = new P322CoinChange();
		int[] a = new int[] { 2}; //   1, 2, 5
		int mnt = 3;
		System.out.println(p.coinChange(a,mnt));

	}
}
