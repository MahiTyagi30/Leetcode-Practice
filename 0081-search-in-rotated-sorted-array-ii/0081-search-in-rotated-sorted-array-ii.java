class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0 , high = nums.length-1 ;

        while(low<=high){

            int mid = low + (high-low)/2 ;

            if(nums[mid]== target) return true ;

            if(nums[low]==nums[high] && nums[high]==nums[mid]){

                //In this case we actually cant tell which part is sorted 
                low++;
                high--;
                continue ;
            }

            if(nums[low] <= nums[mid]){
                //This means left part  is sorted part 

                if(nums[low]<= target  && target<=nums[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{

                //This means right part is sorted

                if(nums[mid]<= target && target<=nums[high]){
                    low = mid+1 ;
                }
                else{
                    high = mid-1;
                }
            
            }


        }

        return false ;
    }
}