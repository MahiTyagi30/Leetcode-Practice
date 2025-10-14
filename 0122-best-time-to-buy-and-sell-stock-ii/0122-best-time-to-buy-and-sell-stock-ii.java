class Solution {
    // memoization code

    public int fun(int [] prices,int [][] dp,int n,int buy,int idx){
        if(idx==n){
            return 0;
        }
        int profit=0;
        if(dp[idx][buy]!=-1){
            return dp[idx][buy];
        }
        if(buy==1){
            profit=Math.max(-prices[idx]+fun(prices,dp,n,0,idx+1),0+fun(prices,dp,n,1,idx+1));
        }
        else{
            profit=Math.max(prices[idx]+fun(prices,dp,n,1,idx+1),0+fun(prices,dp,n,0,idx+1));

        }
       return dp[idx][buy]=profit;
        // return dp[idx][buy];


    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp [][]=new int[n][2];
         for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = -1;
        }
        return fun(prices,dp,n,1,0);
        
    }
}