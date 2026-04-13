class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
      int dp[][]=new int[n][n+1];
      for(int[] row:dp){
        Arrays.fill(row,-1);

      }
      return fun(0,-1,dp,nums,n);


    }
    private int fun(int i,int prev,int[][] dp,int[] nums,int n){
        if(i==n){
            return 0;
        }
        if(dp[i][prev+1]!=-1){
            return dp[i][prev+1];
        }
        
        int len=0+fun(i+1,prev,dp,nums,n);
        if(prev==-1||nums[i]>nums[prev]){
        len=Math.max(len,1+fun(i+1,i,dp,nums,n));
        }


    return   dp[i][prev+1]=len;
    }
   
    }
