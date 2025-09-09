class Solution {
    public int findMin(int[] nums) {
        int min=nums[0];
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                min=nums[i+1];
                break;
            }
            else{
                continue;
            }
        }
        return min;
        
    }
}