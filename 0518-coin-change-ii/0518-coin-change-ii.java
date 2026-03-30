class Solution {
    public int change(int amount, int[] coins) {
        if(amount==0){
            return 1;
        }
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int j=0;j<=amount;j++){
            if(j%coins[0]==0){
                dp[0][j]=1;
            }
            else{
                dp[0][j]=0;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int nottake=dp[i-1][j];
                int take=0;
                if(coins[i]<=j){
                    take=dp[i][j-coins[i]];
                }
                dp[i][j]=nottake+take;
            }
        }

        // Return the result
        return dp[n - 1][amount];
    }
}
