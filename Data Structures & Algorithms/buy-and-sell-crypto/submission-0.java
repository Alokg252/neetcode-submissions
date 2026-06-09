class Solution {
    public int maxProfit(int[] prices) {
        int l = prices.length, maxProfit = 0;

        for (int i=0; i<l; i++) {
            for (int j=i+1; j<l; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
