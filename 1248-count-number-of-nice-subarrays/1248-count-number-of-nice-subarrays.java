class Solution {
    public int fun(int [] nums,int k){
        int i=0;
        int j=0;
        int l=nums.length;
        int c=0;
        int sum=0;
        while(j<l){
            if(nums[j]%2!=0){
                c++;
            }
            while(c>k){
                if(nums[i]%2!=0){
                    c--;
                }
                i++;
            }
            // if(c==k){
            //     sum++;
            // }
            sum=sum+(j-i+1);
            
            
            j++;
        }
        return  sum;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return fun(nums,k)-fun(nums,k-1);
       
        
    }
}