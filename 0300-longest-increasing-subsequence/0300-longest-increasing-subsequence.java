class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return fun(0,-1,nums,n,dp);

    }
    public int fun(int i,int prev,int[] nums,int n,int [][] dp){
        if(i==n){
            return 0;
        }
        if(dp[i][prev+1]!=-1){
                return dp[i][prev+1];
            }
            int len=0+fun(i+1,prev,nums,n,dp);
            if(prev==-1||nums[i]>nums[prev]){
                len=Math.max(len,1+fun(i+1,i,nums,n,dp));
            }
          return   dp[i][prev+1]=len;
        }
    }
