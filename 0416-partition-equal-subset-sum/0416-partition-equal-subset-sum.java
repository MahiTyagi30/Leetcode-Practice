class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n=arr.length;
        boolean dp[][]=new boolean[n][sum+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=sum;j++){
                boolean nottake=dp[i-1][j];
                boolean take=false;
                if(arr[i]<=j){
                    take=dp[i-1][j-arr[i]];
                    
                }
                dp[i][j]=take||nottake;
                
            }
        }
        return dp[n-1][sum];
    }
    public boolean canPartition(int[] nums) {
     
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        return isSubsetSum(nums,sum/2);
        
    }
}