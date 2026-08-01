class Solution {
    

    public static int fun(int i,int[] prices,int n,int flag){
        if(i==n){
            return 0;
        }
        if(flag==1){
            int a=-prices[i]+ fun(i+1,prices,n,0);
            int b=fun(i+1,prices,n,1);
            return Math.max(a,b);

        }
        else{
             int c=prices[i]+ fun(i+1,prices,n,1);
            int d=fun(i+1,prices,n,0);
            return Math.max(c,d);
        }
    }
    public int maxProfit(int[] prices) {
       int n=prices.length;
    //    int buy=prices[0];
    //    profit=-buy
    int[][] dp=new int[n+1][2];
    dp[n][0]=0;
    dp[n][1]=0;
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
        return   dp[0][1];

        }
    }
    
    
