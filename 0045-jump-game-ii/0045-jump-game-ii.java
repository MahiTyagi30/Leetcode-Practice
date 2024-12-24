class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
       int r=0;
       int l=0;
       int c=0;
     
       while(r<n-1){
          int far=0;
       for(int i=l;i<=r;i++){
        far=Math.max(far,i+nums[i]);
       }
       l=r+1;
       r=far;
       c++;
        
       }
       return c;
    }
}