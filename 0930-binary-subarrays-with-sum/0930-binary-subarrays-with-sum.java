class Solution {
    public   int fun(int []  nums,int g){
        if(g<0){
            return 0;
        }
        int l=0;
        int r=0;
        int len=nums.length;
        int sum=0;
        int c=0;
        
        while(r<len){
            sum=sum+nums[r];
            while(sum>g&&l<=r){
                sum=sum-nums[l];
                l++;
            }
            c=c+(r-l+1);
            r++;
        }
        return c;

    }
    public int numSubarraysWithSum(int[] nums, int goal){
            int a = fun(nums,goal);
            int b=fun(nums,goal-1);
            return a-b;
    }
    
}