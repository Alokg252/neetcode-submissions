class Solution {
    public int maxProfit(int[] prices) {
        int l = prices.length, maxProfit = 0, small = Integer.MAX_VALUE;

        for (int i=0; i<l; i++) {
            if (prices[i] < small) small = prices[i];
            else {
                int profit = prices[i] - small;
                if (profit > maxProfit) maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
