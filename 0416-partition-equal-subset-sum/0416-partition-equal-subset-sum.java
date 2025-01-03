class Solution {
    public boolean canPartition(int[] nums) {
      int n=nums.length;
      int sum=0;
      for(int i=0;i<n;i++){
        sum=sum+nums[i];
      }
      if(sum%2!=0){
        return false;
      }
      sum=sum/2;
      boolean dp[][]=new boolean[n+1][sum+1];
      for(int i=0;i<n;i++){
        dp[i][0]=true;
      }
      for(int i=1;i<=n;i++){
        for(int j=1;j<=sum;j++){
            boolean nt=dp[i-1][j];
            boolean t=false;
            if(nums[i-1]<=j){
                t=dp[i-1][j-nums[i-1]];
            }
            dp[i][j]=nt|t;
        }
      }
      return dp[n][sum];
        
        
    }
}