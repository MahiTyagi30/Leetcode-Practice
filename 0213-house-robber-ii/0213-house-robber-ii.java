class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        int a=fun(nums,0,n-2);
        int b=fun(nums,1,n-1);
        return Math.max(a,b);
    }
    public int fun(int [] nums,int s,int e){
        if(s==e){
            return nums[s];
        }
        int dp[]=new int[nums.length];
        dp[s]=nums[s];
        // dp[s+1]=Math.max(nums[s+1],nums[s]);
        for(int i=s+1;i<=e;i++){
           int a=Integer.MIN_VALUE;
            if(i-2<s){
                a=nums[i]+0;
            }
            else{
                a=nums[i]+dp[i-2];

            }
             int b=dp[i-1];
    dp[i]=Math.max(a,b);
        }
        return dp[e];
    }
}