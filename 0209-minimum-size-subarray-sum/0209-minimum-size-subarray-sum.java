class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=nums.length;
        int sum=0;
        int i=0;
        int minLen=Integer.MAX_VALUE;
        int flag=0;
        for(int j=0;j<l;j++){
              sum=sum+nums[j];

            while(sum>=target){
                minLen=Math.min(minLen,j-i+1);
                sum=sum-nums[i];
                flag=1;
                i++;
            }
          
        }
        if(flag==0){
            return 0;
        }
        return minLen;
        
    }
}