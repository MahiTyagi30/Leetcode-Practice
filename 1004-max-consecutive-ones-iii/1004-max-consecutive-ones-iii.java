class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=nums.length;
        int m=-1;
        int i=0;
        int j=0;
        int zero=0;
        while(j<l){
            if(nums[j]==0){
                zero++;
            }
            if(zero>k){
                if(nums[i]==0){
                    zero--;
                }
                i++;

            }
            if(zero<=k){
                m=Math.max(m,j-i+1);
                
            }
            j++;
        }
        return m;
        
    }
}