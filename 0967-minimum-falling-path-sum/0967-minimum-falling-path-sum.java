class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int dp[][] = new int[m][n];

        // Initialize the first row of dp with the first row of matrix
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Compute the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int topLeft = (j > 0) ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int top = dp[i - 1][j];
                int topRight = (j < n - 1) ? dp[i - 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(topLeft, Math.min(top, topRight));
            }
        }

        // Find the minimum value in the last row
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[m - 1][j]);
        }

        return min;
    }
}
