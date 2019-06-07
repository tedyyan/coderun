package info.runcode.dp;

public class P121BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		int maxbenifit = 0;
		int lowest = prices[0];
		for(int i=1;i<prices.length;i++) {
			int currentbenifit = prices[i]  - lowest;
			if(currentbenifit>maxbenifit) {
				maxbenifit = currentbenifit;
			}
			if(prices[i]<lowest) {
				lowest = prices[i];
			}
		}
		
		
		return maxbenifit;

    }
	
	
}
