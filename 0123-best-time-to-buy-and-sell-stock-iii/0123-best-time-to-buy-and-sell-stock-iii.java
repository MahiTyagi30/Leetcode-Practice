class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n + 1][2][3];
        
        // Initialize base case: dp[n][...][...] = 0
        for (int j = 0; j <= 1; j++) {
            for (int c = 0; c <= 2; c++) {
                dp[n][j][c] = 0;
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                for (int c = 1; c <= 2; c++) {
                    int p = 0;
                    if (j == 1) {
                        // We can buy stock
                        p = Math.max(-prices[i] + dp[i + 1][0][c], 0 + dp[i + 1][1][c]);
                    } else {
                        // We can sell stock
                        p = Math.max(prices[i] + (c > 1 ? dp[i + 1][1][c - 1] : 0), 0 + dp[i + 1][0][c]);
                    }
                    dp[i][j][c] = p;
                }
            }
        }
        return dp[0][1][2];
    }
}
