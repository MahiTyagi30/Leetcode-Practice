class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
       int sum=0;
       return calc(nums,0,n,target,sum);
    }
    public int calc(int[]nums,int idx,int n,int target,int sum){
       if(idx == n){
    if(sum == target) return 1;
    else return 0;
}
      int add=  calc(nums,idx+1,n,target,sum+nums[idx]);
      int sub=   calc(nums,idx+1,n,target,sum-nums[idx]);
      return add+sub;

    }

   
}