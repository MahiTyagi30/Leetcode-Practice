class Solution {
    public int maxProfit(int[] prices, int fee) {
    int n=prices.length;
    int dp[][]=new int[n][2];
    for(int i=0;i<dp.length;i++){
        dp[i][0]=dp[i][1]=-1;
    }
    return dfs(dp,prices,1,n,fee,0);
       
    }
public static int dfs(int[][] dp,int[] prices,int buy,int n,int fees,int idx)
{
    int maxprofit=0;
    if(idx>=n){
        return 0;
    }
    if(dp[idx][buy]!=-1){
        return dp[idx][buy];
    }
    if(buy==1){
      int a=-prices[idx]-fees+dfs(dp,prices,0,n,fees,idx+1);
      int b=0+dfs(dp,prices,1,n,fees,idx+1);
      maxprofit=Math.max(a,b);
    }
    else{
         int a=prices[idx]+dfs(dp,prices,1,n,fees,idx+1);
      int b=0+dfs(dp,prices,0,n,fees,idx+1);
      maxprofit=Math.max(a,b);

    }
    
    return dp[idx][buy]=maxprofit;
}

 
}
