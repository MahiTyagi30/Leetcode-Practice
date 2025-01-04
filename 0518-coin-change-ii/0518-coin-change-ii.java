class Solution {
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1; // There's 1 way to make amount 0: using no coins
        }

        int n = coins.length;
        int dp[][] = new int[n][amount + 1];

        // Initialize the first row (using only the first coin)
        for (int j = 0; j <= amount; j++) {
            if (j % coins[0] == 0) {
                dp[0][j] = 1; // If the amount `j` is divisible by the first coin, it's valid
            } else {
                dp[0][j] = 0;
            }
        }

        // Fill the DP table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                // Not take the current coin
                int nt = dp[i - 1][j];

                // Take the current coin (if possible)
                int t = 0;
                if (coins[i] <= j) {
                    t = dp[i][j - coins[i]];
                }

                dp[i][j] = nt + t;
            }
        }

        // Return the result
        return dp[n - 1][amount];
    }
}
