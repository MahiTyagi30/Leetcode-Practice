import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n + 1][2];

        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j < 2; j++) {

                if(j == 1) {
                    // Buy or skip
                    dp[i][j] = Math.max(
                        -prices[i] + dp[i + 1][0],
                        dp[i + 1][1]
                    );
                } 
                else {
                    // Sell or skip
                    int sell = prices[i];
                    if(i + 2 <= n) {
                        sell += dp[i + 2][1];
                    }

                    int skip = dp[i + 1][0];

                    dp[i][j] = Math.max(sell, skip);
                }
            }
        }

        return dp[0][1];
    }
}