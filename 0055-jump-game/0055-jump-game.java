class Solution {
    public boolean canJump(int[] nums) {
       int l =nums.length;
       int mx=0;
       for(int i=0;i<l;i++){
        if(i>mx){
            return false;
        }
         mx=Math.max(mx,i+nums[i]);
         if(mx>=l-1){
            return true;
         }
       }
       return true;
    }
}
