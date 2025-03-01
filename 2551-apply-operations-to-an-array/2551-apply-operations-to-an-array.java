class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]=nums[i]*2;
                nums[i+1]=0;
            }
        }
        int[] ar=new int[nums.length];
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                ar[k]=nums[i];
                k++;
               
            }
        }
        while(k<nums.length){
            ar[k]=0;
            k++;
        }
        return ar;
        
    }
}