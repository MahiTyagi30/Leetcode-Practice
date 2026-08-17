class Solution {
    public static int fun(int i, int j, int[] ar) {
        if (i > j) {
            return 0;
        }

        int maxi = Integer.MIN_VALUE;

        for (int ind = i; ind <= j; ind++) {
            int cost = ar[i - 1] * ar[ind] * ar[j+ 1]
                    + fun(i, ind - 1, ar)
                    + fun(ind + 1, j, ar);

            maxi = Math.max(maxi, cost);
        }

        return maxi;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] ar = new int[n + 2];

        ar[0] = 1;
        ar[n + 1] = 1;

        for (int i = 1; i <= n; i++) {
            ar[i] = nums[i - 1];
        }
   int dp[][]=new int[n+2][n+2];
   for(int i=n;i>=1;i--){
    for(int j=1;j<=n;j++){
        if(i>j){
            continue;
        }
            int maxi = Integer.MIN_VALUE;

        for(int ind=i;ind<=j;ind++){
            int cost=ar[i - 1] * ar[ind] * ar[j+ 1]+dp[i][ind-1]+dp[ind+1][j];
              maxi = Math.max(maxi, cost);

        }
        dp[i][j]=maxi;
    }
   }
        return dp[1][n];
    }
}