class Solution {
    public boolean canDivide(int[] nums,int mid,int h){
        long op=0;
        for(int i=0;i<nums.length;i++){
           int a = (int) Math.ceil((double) nums[i] / mid);
            op=op+a;
            if(op>h){
            return false;
        }
        }
        
        return true;
    }
    public int minimizedMaximum(int m, int[] nums) {
         int n=nums.length;
        int mx=-1;
        for(int i=0;i<n;i++){
            mx=Math.max(mx,nums[i]);
        }
        int l=0;
        int r=mx;
        int res=mx;
        while(l<=r){
           int mid = l + (r - l) / 2;
            if(canDivide(nums,mid,m)){
               res = mid;   // valid, try smaller
                r = mid -1;
            }
            else{
                l=mid+1;
            }
        }
        return res;
        
    }
}