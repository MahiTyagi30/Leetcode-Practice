class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
       int dp[][]=new int[n+1][amount+1];
       for(int i=0;i<=n;i++){
        dp[i][0]=0;
       }
       for(int i=1;i<=amount;i++){
        dp[0][i]=Integer.MAX_VALUE-1;
       }
       for(int i=1;i<=n;i++){
        for(int j=1;j<=amount;j++){
            if(coins[i-1]<=j){
                dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);

            }
            else{
                dp[i][j]=dp[i-1][j];
            }
        }
        
       }
       int res=dp[n][amount];
        return res>=Integer.MAX_VALUE-1?-1:res;
    }
}
