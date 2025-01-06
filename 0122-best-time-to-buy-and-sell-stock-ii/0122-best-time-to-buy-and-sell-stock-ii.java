class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
      int dp[][]=new int[n+1][2];
      dp[n][0]=dp[n][1]=0;
      for(int i=n-1;i>=0;i--){
        for(int j=0;j<=1;j++){
            int p=0;
            if(j==1){
                p=Math.max(-prices[i]+dp[i+1][0],0+dp[i+1][1]);
            }
            else{
                p=Math.max(prices[i]+dp[i+1][1],0+dp[i+1][0]);

            }
            dp[i][j]=p;
        }
      }
      return dp[0][1];
    }
}