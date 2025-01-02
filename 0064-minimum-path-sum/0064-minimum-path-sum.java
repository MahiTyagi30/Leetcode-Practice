class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;    // Number of rows
        int n = grid[0].length; // Number of columns

        // Create a DP table to store the minimum path sum at each cell
        int[][] dp = new int[m][n];

        // Fill the DP table
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    // Base case: Starting cell
                    dp[i][j] = grid[i][j];
                } else {
                    int fromTop = (i > 0) ? dp[i - 1][j] : Integer.MAX_VALUE;
                    int fromLeft = (j > 0) ? dp[i][j - 1] : Integer.MAX_VALUE;

                    // Minimum path sum to reach (i, j)
                    dp[i][j] = grid[i][j] + Math.min(fromTop, fromLeft);
                }
            }
        }

        // Return the minimum path sum to reach the bottom-right corner
        return dp[m - 1][n - 1];
    }
}
