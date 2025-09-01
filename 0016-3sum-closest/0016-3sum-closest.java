class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        int sum;
        
         int res=nums[0]+nums[1]+nums[n-1];
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            int s=i+1;int e=n-1;
            while(s<e){
         sum=nums[i]+nums[s]+nums[e];
                if(sum>target){
                    e--;
                }
                else{
                    s++;
                }
                if(Math.abs(sum-target)<Math.abs(res-target)){
                    res=sum;
                    while(s<e&&nums[s]==nums[s+1]){
                        s++;
                    }
                    while(s<e&&nums[e-1]==nums[e]){
                        e--;
                    }
                }
                
              }
        }
        return res;
        
        
    }
}