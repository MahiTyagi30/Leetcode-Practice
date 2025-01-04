class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int n = coins.length;
        int dp[][] = new int[n][amount + 1];

        // Initialize the first row
        for (int j = 0; j <= amount; j++) {
            if (j % coins[0] == 0) {
                dp[0][j] = j / coins[0];
            } else {
                dp[0][j] = Integer.MAX_VALUE - 1; // Use Integer.MAX_VALUE - 1 to prevent overflow
            }
        }

        // Fill the DP table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                // Not take the current coin
                int nt = dp[i - 1][j];

                // Take the current coin (if possible)
                int t = Integer.MAX_VALUE - 1;
                if (coins[i] <= j) {
                    t = 1 + dp[i][j - coins[i]];
                }

                dp[i][j] = Math.min(nt, t);
            }
        }

        // Return the result
        return dp[n - 1][amount] >= Integer.MAX_VALUE - 1 ? -1 : dp[n - 1][amount];
    }
}
