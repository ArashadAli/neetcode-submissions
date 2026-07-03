class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        int len = prices.length;
        for(int i = 1; i < len; i++) {
            profit = Math.max(profit, prices[i] - buy);
            buy = Math.min(buy, prices[i]);
        }
        return profit;
    }
}
