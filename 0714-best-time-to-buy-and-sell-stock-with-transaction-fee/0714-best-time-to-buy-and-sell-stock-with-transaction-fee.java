class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        Integer[][] dp = new Integer[n][2];  // dp[i][buy]
        return dfs(0, 1, prices, fee, dp);
    }

    public int dfs(int i, int buy, int[] prices, int fee, Integer[][] dp) {
        if (i == prices.length) return 0;
        if (dp[i][buy] != null) return dp[i][buy];

        int profit;
        if (buy == 1) {
            // Option 1: Buy
            // Option 2: Skip
            profit = Math.max(-prices[i] + dfs(i + 1, 0, prices, fee, dp),
                              dfs(i + 1, 1, prices, fee, dp));
        } else {
            // Option 1: Sell (subtract fee)
            // Option 2: Skip
            profit = Math.max(prices[i] - fee + dfs(i + 1, 1, prices, fee, dp),
                              dfs(i + 1, 0, prices, fee, dp));
        }

        return dp[i][buy] = profit;
    }
}
